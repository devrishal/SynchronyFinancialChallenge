package com.synchrony.framework.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletContext;

import com.synchrony.framework.common.PropertyUtil;
import com.synchrony.framework.common.SynchronyCommon;
import com.synchrony.framework.exception.ApplicationFatalException;

public abstract class AbstractDataBaseConnectionHandler<T> {
	/**
	 * Method to create,connect and provide the database connection object to
	 * the application.
	 * 
	 * @param context
	 * @return
	 * @throws ApplicationFatalException
	 */
	public Connection getConnection(ServletContext context) throws ApplicationFatalException {

		Connection conn = null;
		try {

			String dbConnectionURL = PropertyUtil.getProperty(SynchronyCommon.DB_CONNECTION_URL, context);
			String dbDriver = PropertyUtil.getProperty(SynchronyCommon.DB_DRIVER, context);
			String dbUser = PropertyUtil.getProperty(SynchronyCommon.DB_USER, context);
			String dbPwd = PropertyUtil.getProperty(SynchronyCommon.DB_PWD, context);
			Class.forName(dbDriver);
			conn = DriverManager.getConnection(dbConnectionURL, dbUser, dbPwd);
			conn.setAutoCommit(false);
			context.setAttribute(SynchronyCommon.DB_CONNECTION, conn);
		} catch (ClassNotFoundException e) {
			throw new ApplicationFatalException(e.getMessage(), e.getCause());
		} catch (SQLException e) {
			throw new ApplicationFatalException(e.getMessage(), e.getCause());
		}
		return conn;
	}

	public void closeConnection(Connection conn) throws ApplicationFatalException {
		try {
			if (null != conn && !conn.isClosed())
				conn.close();
		} catch (SQLException e) {
			throw new ApplicationFatalException(e.getMessage(), e.getCause());
		}
	}

	abstract public List<T> select(ServletContext context) throws ApplicationFatalException;

}

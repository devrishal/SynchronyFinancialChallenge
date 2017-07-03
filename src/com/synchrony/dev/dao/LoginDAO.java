package com.synchrony.dev.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletContext;

import com.synchrony.framework.common.SynchronyCommon;
import com.synchrony.framework.common.util.DateUtil;
import com.synchrony.framework.database.AbstractDataBaseConnectionHandler;
import com.synchrony.framework.exception.ApplicationBusinessException;
import com.synchrony.framework.exception.ApplicationFatalException;
import com.synchrony.rishal.valueobjects.LoginVO;

public class LoginDAO extends AbstractDataBaseConnectionHandler<LoginVO> {
	@Override
	public List<LoginVO> select(ServletContext context) throws ApplicationFatalException {
		Connection conn = null;
		LoginVO loginVO = (LoginVO) context.getAttribute(SynchronyCommon.USER_DETAILS);
		List<LoginVO> temp = new ArrayList<LoginVO>();
		try {
			conn = this.getConnection(context);
			PreparedStatement ps = conn.prepareStatement("select * from USDT where upper(USER_ID)=? and USER_PASSWORD=?");
			ps.setString(1, loginVO.getUserId().toUpperCase());
			ps.setString(2, loginVO.getUserPassword());
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				loginVO.setUserName(rs.getString(1));
				loginVO.setLastLoginTime(new Date());
				temp.add(loginVO);
			}
		} catch (SQLException e) {
			throw new ApplicationFatalException(e.getMessage(), e.getCause());
		} finally {
			if (null != conn)
				this.closeConnection(conn);
		}

		return temp;
	}

	public void update(ServletContext context) throws ApplicationFatalException {
		Connection conn = null;
		try {
			conn = this.getConnection(context);
			PreparedStatement stmt = conn.prepareStatement("update USDT set LAST_LOGIN_TIME = ? where USER_ID=?");
			LoginVO loginVO = (LoginVO) context.getAttribute(SynchronyCommon.USER_DETAILS);
			String userId = loginVO.getUserId();
			stmt.setTimestamp(1, DateUtil.getCurrentTimeStamp());
			stmt.setString(2, userId);
			int result = stmt.executeUpdate();
			if (result == 1)
				System.out.println("Successfully Updated LAST_LOGIN_TIME!");
		} catch (SQLException e) {
			throw new ApplicationFatalException(e.getMessage(), e.getErrorCode(), e.getCause());
		} finally {
			if (null != conn)
				this.closeConnection(conn);
		}

	}

	public void Insert(ServletContext context) throws ApplicationFatalException, ApplicationBusinessException {
		Connection conn = null;
		LoginVO loginVO = null;
		try {
			conn = this.getConnection(context);
			PreparedStatement stmt = conn.prepareStatement(
					"INSERT INTO USDT(USER_NAME,USER_ID,USER_PASSWORD,LAST_LOGIN_TIME) Values(?,?,?,?)");
			loginVO = (LoginVO) context.getAttribute(SynchronyCommon.USER_DETAILS);
			stmt.setString(1, loginVO.getUserName());
			stmt.setString(2, loginVO.getUserId());
			stmt.setString(3, loginVO.getUserPassword());
			stmt.setTimestamp(4, DateUtil.getCurrentTimeStamp());
			int result = stmt.executeUpdate();
			if (result == 1)
				context.setAttribute(SynchronyCommon.APP_MESSAGE,
						"Your user id " + loginVO.getUserId() + " has been registered successfully!");
			else if (result == 0)
				context.setAttribute(SynchronyCommon.ERROR_MESSAGE,
						"Unexpected Error while registering the user. Please contact admin!");
		} catch (SQLException e) {
			if (e.getErrorCode() == 1)
				context.setAttribute(SynchronyCommon.ERROR_MESSAGE,
						loginVO.getUserId() + " already exists. Please provide any other userid/emailid.");
			throw new ApplicationBusinessException(e.getMessage(), e.getCause());
		} finally {
			if (null != conn)
				this.closeConnection(conn);
		}
	}
}

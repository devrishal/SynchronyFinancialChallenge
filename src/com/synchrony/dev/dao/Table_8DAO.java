package com.synchrony.dev.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;

import com.synchrony.framework.common.PropertyUtil;
import com.synchrony.framework.common.SynchronyCommon;
import com.synchrony.framework.database.AbstractDataBaseConnectionHandler;
import com.synchrony.framework.exception.ApplicationFatalException;
import com.synchrony.rishal.valueobjects.Table_8;

public class Table_8DAO extends AbstractDataBaseConnectionHandler<Table_8> {
	public List<Table_8> select(ServletContext context) throws ApplicationFatalException {
		Connection conn = this.getConnection(context);
		List<Table_8> dataFetchedFromDB = new ArrayList<Table_8>();
		try {

			PreparedStatement ps = conn.prepareStatement("select * from Table_8");
			int numberOfRecordsFetchedInOneCall = Integer
					.valueOf(PropertyUtil.getProperty(SynchronyCommon.LIST_OF_RECORDS_IN_PAGINATED, context));
			ps.setFetchSize(numberOfRecordsFetchedInOneCall);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				Table_8 temp = new Table_8();
				temp.setTitle((String) rs.getString(1));
				temp.setPlatform((String) rs.getString(2));
				temp.setScore((double) rs.getDouble(3));
				temp.setGenre((String) rs.getString(4));
				temp.setEditorsChoice((String) rs.getString(5));
				dataFetchedFromDB.add(temp);
			}
		} catch (SQLException e) {
			throw new ApplicationFatalException(e.getMessage(), e.getCause());
		}
		closeConnection(conn);
		return dataFetchedFromDB;
	}
}

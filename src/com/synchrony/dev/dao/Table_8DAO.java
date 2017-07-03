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
			int pageNumber = 1;
			if (null != context.getAttribute(SynchronyCommon.PAGE_NUM)) {
				pageNumber = Integer.parseInt((String) context.getAttribute(SynchronyCommon.PAGE_NUM));
			}
			PreparedStatement ps = conn.prepareStatement(
					"SELECT * FROM(SELECT a.*, rownum r1 FROM(SELECT * FROM Table_8) a WHERE rownum < ((? * ?) + 1 )) WHERE r1 >= (((?-1) * ?) + 1)");
			int numberOfRecordsFetchedInOneCall = Integer
					.valueOf(PropertyUtil.getProperty(SynchronyCommon.LIST_OF_RECORDS_IN_PAGINATED, context));
			ps.setInt(2, numberOfRecordsFetchedInOneCall);
			ps.setInt(4, numberOfRecordsFetchedInOneCall);
			ps.setLong(1, pageNumber);
			ps.setInt(3, pageNumber);
			ResultSet rs = ps.executeQuery();
			if (!rs.isBeforeFirst()) {
				if (pageNumber < 1) {
					pageNumber++;
					ps.setLong(1, pageNumber);
					ps.setInt(3, pageNumber);
					rs = ps.executeQuery();
					context.setAttribute(SynchronyCommon.PAGE_NUM, pageNumber);
					context.setAttribute(SynchronyCommon.ERROR_MESSAGE, "No More records present");
				} else {
					pageNumber--;
					ps.setLong(1, pageNumber - 1);
					ps.setInt(3, pageNumber - 1);
					rs = ps.executeQuery();
					context.setAttribute(SynchronyCommon.PAGE_NUM, pageNumber);
					context.setAttribute(SynchronyCommon.ERROR_MESSAGE, "No More records present");
				}

			} else {
				context.setAttribute(SynchronyCommon.PAGE_NUM, pageNumber);
				context.setAttribute(SynchronyCommon.ERROR_MESSAGE, null);

			}
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
		} finally {
			if (null != conn)
				closeConnection(conn);
		}

		return dataFetchedFromDB;
	}
}

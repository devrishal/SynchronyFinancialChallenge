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
import com.synchrony.framework.database.AbstractDataBaseConnectionHandler;
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
			PreparedStatement ps = conn.prepareStatement("select * from USDT where USER_ID=? and USER_PASSWORD=?");
			ps.setString(1, loginVO.getUserId());
			ps.setString(2, loginVO.getUserPassword());
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				loginVO.setUserName(rs.getString(1));
				loginVO.setLastLoginTime(new Date());
				temp.add(loginVO);
			}
		} catch (SQLException e) {
			throw new ApplicationFatalException(e.getMessage(), e.getCause());
		}
		this.closeConnection(conn);
		return temp;
	}

}

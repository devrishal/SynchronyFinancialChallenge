package com.synchrony.dev.authentication.validators;

import java.util.List;

import javax.servlet.ServletContext;

import com.synchrony.dev.dao.LoginDAO;
import com.synchrony.framework.common.SynchronyCommon;
import com.synchrony.framework.exception.ApplicationFatalException;
import com.synchrony.rishal.valueobjects.LoginVO;

/**
 * @author Rishal_singh
 *
 */
public class AuthenticationDataValidator {
	/**
	 * @param userName
	 * @param password
	 * @param conn
	 * @return
	 * @throws ApplicationFatalException
	 */
	public boolean validate(String userName, String password, ServletContext context) throws ApplicationFatalException {
		boolean status = false;
		LoginVO loginData = new LoginVO();
		loginData.setUserId(userName);
		loginData.setUserPassword(password);
		context.setAttribute(SynchronyCommon.USER_DETAILS, loginData);
		LoginDAO loginDAO = new LoginDAO();
		List<LoginVO> loginVO = loginDAO.select(context);
		if (loginVO.size() != 0) {
			status = true;
			context.setAttribute(SynchronyCommon.USER_DETAILS, loginVO.get(0));
		} else {
			status = false;
		}
		return status;

	}

}

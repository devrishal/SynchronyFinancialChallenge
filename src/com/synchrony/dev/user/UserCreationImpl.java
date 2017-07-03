package com.synchrony.dev.user;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.synchrony.dev.dao.LoginDAO;
import com.synchrony.framework.common.SynchronyCommon;
import com.synchrony.framework.common.util.DateUtil;
import com.synchrony.framework.exception.ApplicationBusinessException;
import com.synchrony.framework.exception.ApplicationFatalException;
import com.synchrony.rishal.valueobjects.LoginVO;

public class UserCreationImpl {

	public void process(HttpServletRequest request, HttpServletResponse response) throws ApplicationFatalException {
		String email = request.getParameter("email");
		String firstName = request.getParameter("firstname");
		String lastName = request.getParameter("lastname");
		String password = request.getParameter("passwd");
		LoginVO login = new LoginVO();
		login.setUserId(email);
		login.setUserName(firstName + " " + lastName);
		login.setUserPassword(password);
		login.setLastLoginTime(DateUtil.getCurrentTimeStamp());
		LoginDAO dao = new LoginDAO();
		ServletContext context = request.getServletContext();
		context.setAttribute(SynchronyCommon.USER_DETAILS, login);

		try {
			dao.Insert(context);
			request.setAttribute(SynchronyCommon.APP_MESSAGE, context.getAttribute(SynchronyCommon.APP_MESSAGE));
		} catch (ApplicationBusinessException e) {
			request.setAttribute(SynchronyCommon.ERROR_MESSAGE, context.getAttribute(SynchronyCommon.ERROR_MESSAGE));
		} catch (ApplicationFatalException e) {
			request.setAttribute(SynchronyCommon.APP_MESSAGE, context.getAttribute(SynchronyCommon.ERROR_MESSAGE));
		}

	}

}

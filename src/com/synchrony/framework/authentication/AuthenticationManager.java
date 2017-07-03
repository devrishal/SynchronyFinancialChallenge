package com.synchrony.framework.authentication;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.synchrony.dev.authentication.validators.AuthenticationDataValidator;
import com.synchrony.dev.dao.LoginDAO;
import com.synchrony.framework.common.SynchronyCommon;
import com.synchrony.framework.exception.ApplicationFatalException;

/**
 * @author Rishal_singh
 *
 */
public class AuthenticationManager {

	/**
	 * This class will be used to get the userName and password from user and validate it.
	 * @param request
	 * @param response
	 * @throws ApplicationFatalException
	 */
	public void process(HttpServletRequest request, HttpServletResponse response) throws ApplicationFatalException {
		ServletContext context = request.getServletContext();
		String userName = (String) request.getParameter("username");
		String userPassword = (String) request.getParameter("password");
		AuthenticationDataValidator authHelper = new AuthenticationDataValidator();
		if (authHelper.validate(userName, userPassword, context))
		{
			LoginDAO login=new LoginDAO();
			login.update(context);
			context.setAttribute("Authentication_status", new Boolean(true));
		}
		else
		{
			context.setAttribute("Authentication_status", new Boolean(false));
		}

	}

}

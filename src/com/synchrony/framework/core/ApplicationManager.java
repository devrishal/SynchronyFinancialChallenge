package com.synchrony.framework.core;

import java.util.ArrayList;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.synchrony.dev.dao.Table_8DAO;
import com.synchrony.framework.common.SynchronyCommon;
import com.synchrony.framework.common.util.DateUtil;
import com.synchrony.framework.exception.ApplicationFatalException;
import com.synchrony.rishal.valueobjects.LoginVO;
import com.synchrony.rishal.valueobjects.Table_8;

/**
 * 
 * @author Rishal_singh
 *
 */
public class ApplicationManager {
	/**
	 * method which will process the request recieved and send the response.
	 * 
	 * @param request
	 * @param response
	 * @throws ApplicationFatalException
	 */
	public void process(HttpServletRequest request, HttpServletResponse response) throws ApplicationFatalException {
		ServletContext context = request.getServletContext();
		Table_8DAO table8dao = new Table_8DAO();
		ArrayList<Table_8> data = (ArrayList<Table_8>) table8dao.select(context);
		LoginVO loginVO = (LoginVO) context.getAttribute(SynchronyCommon.USER_DETAILS);
		StringBuffer responseData = new StringBuffer();
		responseData.append("Welcome " + loginVO.getUserName());
		responseData.append("&nbsp;&nbsp;Time: " + DateUtil.formatDate(loginVO.getLastLoginTime()));
		request.setAttribute("Welcome_Message", responseData);
		request.setAttribute(SynchronyCommon.Application_Data, data);
	}
}

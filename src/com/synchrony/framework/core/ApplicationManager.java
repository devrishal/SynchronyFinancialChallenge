package com.synchrony.framework.core;

import java.util.ArrayList;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.omg.PortableServer.REQUEST_PROCESSING_POLICY_ID;

import com.sun.corba.se.impl.orbutil.concurrent.Sync;
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
		if(null==request.getParameter(SynchronyCommon.Pagination_Direction))
		{
			request.setAttribute(SynchronyCommon.PAGE_NUM, new Integer(1));
		}
		else if(request.getParameter(SynchronyCommon.Pagination_Direction).equals(SynchronyCommon.NEXT_PAGE))
		{
			if(null!=request.getParameter(SynchronyCommon.NEXT_PAGE))
				context.setAttribute(SynchronyCommon.PAGE_NUM, request.getParameter(SynchronyCommon.NEXT_PAGE));
			request.setAttribute(SynchronyCommon.PAGE_NUM, context.getAttribute(SynchronyCommon.PAGE_NUM));
		}
		else if(request.getParameter(SynchronyCommon.Pagination_Direction).equals(SynchronyCommon.PREV_PAGE))
		{
			if(null!=request.getParameter(SynchronyCommon.PREV_PAGE))
				context.setAttribute(SynchronyCommon.PAGE_NUM, request.getParameter(SynchronyCommon.PREV_PAGE));
			request.setAttribute(SynchronyCommon.PAGE_NUM, context.getAttribute(SynchronyCommon.PAGE_NUM));
		}
		
		Table_8DAO table8dao = new Table_8DAO();
		ArrayList<Table_8> data = (ArrayList<Table_8>) table8dao.select(context);
		LoginVO loginVO = (LoginVO) context.getAttribute(SynchronyCommon.USER_DETAILS);
		StringBuffer responseData = new StringBuffer();
		responseData.append("Welcome " + loginVO.getUserName());
		responseData.append("&nbsp;&nbsp;Time: " + DateUtil.formatDate(loginVO.getLastLoginTime()));
		request.setAttribute("Welcome_Message", responseData);
		request.setAttribute(SynchronyCommon.PAGE_NUM, context.getAttribute(SynchronyCommon.PAGE_NUM));
		request.setAttribute(SynchronyCommon.APP_MESSAGE, context.getAttribute(SynchronyCommon.APP_MESSAGE));
		request.setAttribute(SynchronyCommon.ERROR_MESSAGE,context.getAttribute(SynchronyCommon.ERROR_MESSAGE));
		request.setAttribute(SynchronyCommon.Application_Data, data);
	}
}

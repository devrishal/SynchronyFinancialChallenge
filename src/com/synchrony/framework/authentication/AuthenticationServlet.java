package com.synchrony.framework.authentication;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.synchrony.framework.common.ErrorCodes;
import com.synchrony.framework.core.ApplicationManager;
import com.synchrony.framework.exception.ApplicationFatalException;

/**
 * Servlet implementation class AuthenticationServlet
 */
@WebServlet("/AuthenticationServlet")
public class AuthenticationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AuthenticationServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		AuthenticationManager authenticationManager = new AuthenticationManager();
		try {

			authenticationManager.process(request, response);
			boolean result = (boolean) request.getServletContext().getAttribute("Authentication_status");
			PrintWriter out = response.getWriter();
			if (result) {
				ServletContext context = request.getServletContext();
				response.setContentType("text/html");
				ApplicationManager applicationManager = new ApplicationManager();
				applicationManager.process(request, response);
				RequestDispatcher rd = request.getRequestDispatcher("/jsp/DashboardGames.jsp");
				rd.include(request, response);

			} else {
				response.setContentType("text/html");
				String errorMessage = "[" + ErrorCodes.INVALID_USER_DETAILS + "]"
						+ "Invalid Username and Password details. Please try again!";
				RequestDispatcher rd = request.getRequestDispatcher("/jsp/AuthenticationScreen.jsp");
				request.setAttribute("Error_Message", errorMessage);
				rd.include(request, response);
			}
		} catch (ApplicationFatalException e) {
			e.printStackTrace();
		}

	}

}

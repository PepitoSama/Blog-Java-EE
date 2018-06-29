package saimond.etienne.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import saimond.etienne.dao.D_Context;
import saimond.etienne.dao.D_User;
import saimond.etienne.models.M_User;

@WebServlet(urlPatterns = "/login", loadOnStartup = 1)
public class S_Login extends HttpServlet {

	private static final long serialVersionUID = 758132688251718196L;
	public static final String 	VIEW = "/WEB-INF/jsp/userManag/login.jsp";
	public static final String LOGIN_FIELD		= "txtLogin";
	public static final String PASS_FIELD		= "txtPassword";
	public static final String 	ERROR_FIELD		= "txtError";
	public static final String 	RESULT_FIELD	= "txtValid";
	public static final String 	USER_FIELD	= "connectedUser";
	
	
	@Override
	public void init() throws ServletException {
		D_Context.init(this.getServletContext());
		System.out.println("Creating servlet");
	}

	protected void 	doGet(HttpServletRequest request, HttpServletResponse response)
					throws ServletException, IOException {

		System.out.println("In the login doGet");

		// Check if user is already connected
		HttpSession session = request.getSession(true);
		if (session.getAttribute("connectedUser") != null) {
			response.sendRedirect("connected");
			return;
		}
		
		//TODO Remember login typed
		request.setAttribute(LOGIN_FIELD, "");
		request.setAttribute(PASS_FIELD, "");
		request.setAttribute(ERROR_FIELD, "");
		request.getRequestDispatcher(VIEW).forward(request, response);
		return;
	}

	protected 	void doPost(HttpServletRequest request, HttpServletResponse response)
				throws ServletException, IOException {

		System.out.println("In the login doPost");

		String login = request.getParameter(LOGIN_FIELD);
		String password = request.getParameter(PASS_FIELD);
		
		System.out.println(login);
		System.out.println(password);
		
		request.setAttribute(LOGIN_FIELD, login);
		request.setAttribute(PASS_FIELD, password);
		
		if (login == null || password == null){
			request.setAttribute(ERROR_FIELD, "Type your Login and Password");
			request.getRequestDispatcher(VIEW).forward(request, response);
			return;
		}
		
		M_User connectedUser = D_User.isValidLogin(login, password);
		HttpSession session = request.getSession(true);
		if (connectedUser != null) {
			session.setAttribute(USER_FIELD, connectedUser);
			response.sendRedirect("index");
			return;
		} else {
			request.setAttribute(ERROR_FIELD, "Bad Login or Password");
			request.getRequestDispatcher(VIEW).forward(request, response);
			return;
		}

	}
}

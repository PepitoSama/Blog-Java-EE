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

@WebServlet(urlPatterns = "/index", loadOnStartup = 1)
public class S_Index extends HttpServlet {

	private static final long serialVersionUID = 5414340139037347659L;
	public static final String 	VIEW = "/WEB-INF/jsp/index.jsp";
	
	
	@Override
	public void init() throws ServletException {
		D_Context.init(this.getServletContext());
		System.out.println("Creating servlet");
	}

	protected void 	doGet(HttpServletRequest request, HttpServletResponse response)
					throws ServletException, IOException {

		System.out.println("In the index doGet");

		// Check if user is already connected
		HttpSession session = request.getSession(true);
		if (session.getAttribute("connectedUser") == null) {
			response.sendRedirect("login");
			return;
		} else {
			request.getRequestDispatcher(VIEW).forward(request, response);
		}
		
		return;
	}

	protected 	void doPost(HttpServletRequest request, HttpServletResponse response)
				throws ServletException, IOException {

		System.out.println("In the index doPost");

		HttpSession session = request.getSession(true);
		if (session.getAttribute("connectedUser") != null) {
			response.sendRedirect("login");
			return;
		} else {
			request.getRequestDispatcher(VIEW).forward(request, response);
			return;
		}

	}
}

package fr.polytech.oeuvres.controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * This class represents an abstract controller.
 *
 * @author DELORME Loïc
 * @since 1.0.0
 */
public abstract class AbstractController extends HttpServlet {

	/**
	 * The serial version UID.
	 */
	protected static final long serialVersionUID = 1L;

	/**
	 * The action type.
	 */
	protected static final String ACTION_TYPE = "action";

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		handleRequest(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		handleRequest(request, response);
	}

	/**
	 * Handle an incoming request.
	 * 
	 * @param request
	 *            The request.
	 * @param response
	 *            The response.
	 * @throws ServletException
	 *             If a problem occurs.
	 * @throws IOException
	 *             If a problem occurs.
	 */
	public abstract void handleRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;
}
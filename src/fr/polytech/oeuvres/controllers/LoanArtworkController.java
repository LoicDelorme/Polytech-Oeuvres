package fr.polytech.oeuvres.controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.polytech.oeuvres.entities.LoanArtwork;
import fr.polytech.oeuvres.services.LoanArtworkDaoServices;

/**
 * This class represents a loan artwork controller.
 *
 * @author DELORME Loïc
 * @since 1.0.0
 */
@WebServlet("/LoanArtworkController")
public class LoanArtworkController extends AbstractController {

	/**
	 * The serial version UID.
	 */
	protected static final long serialVersionUID = 1L;

	/**
	 * The "overview" URL.
	 */
	private static final String OVERVIEW = "overview";

	/**
	 * The "list" URL.
	 */
	private static final String LIST = "list";

	/**
	 * The "addForm" URL.
	 */
	private static final String ADD_FORM = "addForm";

	/**
	 * The "updateForm" URL.
	 */
	private static final String UPDATE_FORM = "updateForm";

	/**
	 * The "insert" URL.
	 */
	private static final String INSERT = "insert";

	/**
	 * The "update" URL.
	 */
	private static final String UPDATE = "update";

	/**
	 * The "delete" URL.
	 */
	private static final String DELETE = "delete";

	/**
	 * The loan artwork DAO services.
	 */
	private final LoanArtworkDaoServices loanArtworkDaoServices;

	/**
	 * Create a loan artwork controller.
	 */
	public LoanArtworkController() {
		super();

		this.loanArtworkDaoServices = new LoanArtworkDaoServices();
	}

	@Override
	public void handleRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String actionName = request.getParameter(ACTION_TYPE);
		String destinationPage = null;
		switch (actionName) {
			case OVERVIEW:
				request.setAttribute("loanArtwork", this.loanArtworkDaoServices.get(request.getParameter("id")));
				destinationPage = "/pages/loan-artworks/overview.jsp";
				break;
			case LIST:
				request.setAttribute("loanArtworks", this.loanArtworkDaoServices.getAll());
				destinationPage = "/pages/loan-artworks/list.jsp";
				break;
			case ADD_FORM:
				destinationPage = "/pages/loan-artworks/addForm.jsp";
				break;
			case UPDATE_FORM:
				destinationPage = "/pages/loan-artworks/updateForm.jsp";
				break;
			case INSERT:
				LoanArtwork loanArtworkToInsert = new LoanArtwork();
				loanArtworkToInsert.setTitle(request.getParameter("title"));
				loanArtworkToInsert.setDuration(Integer.parseInt(request.getParameter("duration")));
				this.loanArtworkDaoServices.insert(loanArtworkToInsert);
				request.setAttribute("message", "The loan artwork was successfully added!");
				destinationPage = "/index.jsp";
				break;
			case UPDATE:
				LoanArtwork loanArtworkToUpdate = this.loanArtworkDaoServices.get(request.getParameter("id"));
				loanArtworkToUpdate.setTitle(request.getParameter("title"));
				loanArtworkToUpdate.setDuration(Integer.parseInt(request.getParameter("duration")));
				this.loanArtworkDaoServices.update(loanArtworkToUpdate);
				request.setAttribute("message", "The loan artwork was successfully updated!");
				destinationPage = "/index.jsp";
				break;
			case DELETE:
				this.loanArtworkDaoServices.delete(this.loanArtworkDaoServices.get(request.getParameter("id")));
				request.setAttribute("message", "The loan artwork was successfully deleted!");
				destinationPage = "/index.jsp";
				break;
			default:
				destinationPage = "/error.jsp";
				request.setAttribute("message", String.format("[%s] is not a valid action!", actionName));
				break;
		}

		getServletContext().getRequestDispatcher(destinationPage).forward(request, response);
	}
}
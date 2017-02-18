package fr.polytech.oeuvres.controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.polytech.oeuvres.entities.ArtworkState;
import fr.polytech.oeuvres.services.ArtworkStateDaoServices;

/**
 * This class represents an artwork state controller.
 *
 * @author DELORME Loïc
 * @since 1.0.0
 */
@WebServlet("/ArtworkStateController")
public class ArtworkStateController extends AbstractController {

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
	 * The artwork state DAO services.
	 */
	private final ArtworkStateDaoServices artworkStateDaoServices;

	/**
	 * Create an artwork state controller.
	 */
	public ArtworkStateController() {
		super();

		this.artworkStateDaoServices = new ArtworkStateDaoServices();
	}

	@Override
	public void handleRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String actionName = request.getParameter(ACTION_TYPE);
		String destinationPage = null;
		switch (actionName) {
			case OVERVIEW:
				request.setAttribute("artworkState", this.artworkStateDaoServices.get(Integer.parseInt(request.getParameter("id"))));
				destinationPage = "/WEB-INF/pages/artwork-states/overview.jsp";
				break;
			case LIST:
				request.setAttribute("artworkStates", this.artworkStateDaoServices.getAll());
				destinationPage = "/WEB-INF/pages/artwork-states/list.jsp";
				break;
			case ADD_FORM:
				destinationPage = "/WEB-INF/pages/artwork-states/add-form.jsp";
				break;
			case UPDATE_FORM:
				request.setAttribute("artworkState", this.artworkStateDaoServices.get(Integer.parseInt(request.getParameter("id"))));
				destinationPage = "/WEB-INF/pages/artwork-states/update-form.jsp";
				break;
			case INSERT:
				ArtworkState artworkStateToInsert = new ArtworkState();
				artworkStateToInsert.setLabel(request.getParameter("label"));
				this.artworkStateDaoServices.insert(artworkStateToInsert);

				request.setAttribute("message", "The artwork state was successfully added!");
				destinationPage = "/index.jsp";
				break;
			case UPDATE:
				ArtworkState artworkStateToUpdate = this.artworkStateDaoServices.get(Integer.parseInt(request.getParameter("id")));
				artworkStateToUpdate.setLabel(request.getParameter("label"));
				this.artworkStateDaoServices.update(artworkStateToUpdate);

				request.setAttribute("message", "The artwork state was successfully updated!");
				destinationPage = "/index.jsp";
				break;
			case DELETE:
				this.artworkStateDaoServices.delete(this.artworkStateDaoServices.get(Integer.parseInt(request.getParameter("id"))));

				request.setAttribute("message", "The artwork state was successfully deleted!");
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
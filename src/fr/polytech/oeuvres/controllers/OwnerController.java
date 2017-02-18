package fr.polytech.oeuvres.controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.polytech.oeuvres.entities.Owner;
import fr.polytech.oeuvres.services.OwnerDaoServices;

/**
 * This class represents an owner controller.
 *
 * @author DELORME Loïc
 * @since 1.0.0
 */
@WebServlet("/OwnerController")
public class OwnerController extends AbstractController {

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
	 * The owner DAO services.
	 */
	private final OwnerDaoServices ownerDaoServices;

	/**
	 * Create an owner controller.
	 */
	public OwnerController() {
		super();

		this.ownerDaoServices = new OwnerDaoServices();
	}

	@Override
	public void handleRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String actionName = request.getParameter(ACTION_TYPE);
		String destinationPage = null;
		switch (actionName) {
			case OVERVIEW:
				request.setAttribute("owner", this.ownerDaoServices.get(Integer.parseInt(request.getParameter("id"))));
				destinationPage = "/WEB-INF/pages/pages/owners/overview.jsp";
				break;
			case LIST:
				request.setAttribute("owners", this.ownerDaoServices.getAll());
				destinationPage = "/WEB-INF/pages/owners/list.jsp";
				break;
			case ADD_FORM:
				destinationPage = "/WEB-INF/pages/owners/add-form.jsp";
				break;
			case UPDATE_FORM:
				request.setAttribute("owner", this.ownerDaoServices.get(Integer.parseInt(request.getParameter("id"))));
				destinationPage = "/WEB-INF/pages/owners/update-form.jsp";
				break;
			case INSERT:
				Owner ownerToInsert = new Owner();
				ownerToInsert.setLastname(request.getParameter("lastname"));
				ownerToInsert.setFirstname(request.getParameter("firstname"));
				this.ownerDaoServices.insert(ownerToInsert);

				request.setAttribute("message", "The owner was successfully added!");
				destinationPage = "/index.jsp";
				break;
			case UPDATE:
				Owner ownerToUpdate = this.ownerDaoServices.get(Integer.parseInt(request.getParameter("id")));
				ownerToUpdate.setLastname(request.getParameter("lastname"));
				ownerToUpdate.setFirstname(request.getParameter("firstname"));
				this.ownerDaoServices.update(ownerToUpdate);

				request.setAttribute("message", "The owner was successfully updated!");
				destinationPage = "/index.jsp";
				break;
			case DELETE:
				this.ownerDaoServices.delete(this.ownerDaoServices.get(Integer.parseInt(request.getParameter("id"))));

				request.setAttribute("message", "The owner was successfully deleted!");
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
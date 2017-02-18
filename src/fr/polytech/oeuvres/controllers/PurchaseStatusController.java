package fr.polytech.oeuvres.controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.polytech.oeuvres.entities.PurchaseStatus;
import fr.polytech.oeuvres.services.PurchaseStatusDaoServices;

/**
 * This class represents a purchase status controller.
 *
 * @author DELORME Loïc
 * @since 1.0.0
 */
@WebServlet("/ArtworkStateController")
public class PurchaseStatusController extends AbstractController {

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
	 * The purchase status DAO services.
	 */
	private final PurchaseStatusDaoServices purchaseStatusDaoServices;

	/**
	 * Create a purchase status controller.
	 */
	public PurchaseStatusController() {
		super();

		this.purchaseStatusDaoServices = new PurchaseStatusDaoServices();
	}

	@Override
	public void handleRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String actionName = request.getParameter(ACTION_TYPE);
		String destinationPage = null;
		switch (actionName) {
			case OVERVIEW:
				request.setAttribute("purchaseStatus", this.purchaseStatusDaoServices.get(Integer.parseInt(request.getParameter("id"))));
				destinationPage = "/WEB-INF/pages/purchase-status/overview.jsp";
				break;
			case LIST:
				request.setAttribute("purchaseStatus", this.purchaseStatusDaoServices.getAll());
				destinationPage = "/WEB-INF/pages/purchase-status/list.jsp";
				break;
			case ADD_FORM:
				destinationPage = "/WEB-INF/pages/purchase-status/add-form.jsp";
				break;
			case UPDATE_FORM:
				request.setAttribute("purchaseStatus", this.purchaseStatusDaoServices.get(Integer.parseInt(request.getParameter("id"))));
				destinationPage = "/WEB-INF/pages/purchase-status/update-form.jsp";
				break;
			case INSERT:
				PurchaseStatus purchaseStatusToInsert = new PurchaseStatus();
				purchaseStatusToInsert.setLabel(request.getParameter("label"));
				this.purchaseStatusDaoServices.insert(purchaseStatusToInsert);

				request.setAttribute("message", "The purchase status was successfully added!");
				destinationPage = "/index.jsp";
				break;
			case UPDATE:
				PurchaseStatus purchaseStatusToUpdate = this.purchaseStatusDaoServices.get(Integer.parseInt(request.getParameter("id")));
				purchaseStatusToUpdate.setLabel(request.getParameter("label"));
				this.purchaseStatusDaoServices.update(purchaseStatusToUpdate);

				request.setAttribute("message", "The purchase status was successfully updated!");
				destinationPage = "/index.jsp";
				break;
			case DELETE:
				this.purchaseStatusDaoServices.delete(this.purchaseStatusDaoServices.get(Integer.parseInt(request.getParameter("id"))));

				request.setAttribute("message", "The purchase status was successfully deleted!");
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
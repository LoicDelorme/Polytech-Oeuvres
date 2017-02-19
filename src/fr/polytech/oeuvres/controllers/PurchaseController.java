package fr.polytech.oeuvres.controllers;

import java.io.IOException;
import java.time.LocalDate;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.polytech.oeuvres.entities.Purchase;
import fr.polytech.oeuvres.entities.pks.PurchasePK;
import fr.polytech.oeuvres.services.OwnerDaoServices;
import fr.polytech.oeuvres.services.PurchaseDaoServices;
import fr.polytech.oeuvres.services.PurchaseStatusDaoServices;
import fr.polytech.oeuvres.services.SaleArtworkDaoServices;

/**
 * This class represents a purchase controller.
 *
 * @author DELORME Loïc
 * @since 1.0.0
 */
@WebServlet("/PurchaseController")
public class PurchaseController extends AbstractController {

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
	 * The purchase DAO services.
	 */
	private final PurchaseDaoServices purchaseDaoServices;

	/**
	 * The owner DAO services.
	 */
	private final OwnerDaoServices ownerDaoServices;

	/**
	 * The sale artwork DAO services.
	 */
	private final SaleArtworkDaoServices saleArtworkDaoServices;

	/**
	 * The purchase status DAO services.
	 */
	private final PurchaseStatusDaoServices purchaseStatusDaoServices;

	/**
	 * Create a purchase controller.
	 */
	public PurchaseController() {
		super();

		this.purchaseDaoServices = new PurchaseDaoServices();
		this.ownerDaoServices = new OwnerDaoServices();
		this.saleArtworkDaoServices = new SaleArtworkDaoServices();
		this.purchaseStatusDaoServices = new PurchaseStatusDaoServices();
	}

	@Override
	public void handleRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String actionName = request.getParameter(ACTION_TYPE);
		String destinationPage = null;
		switch (actionName) {
			case OVERVIEW:
				PurchasePK purchasePK = new PurchasePK();
				purchasePK.setOwner(this.ownerDaoServices.get(Integer.parseInt(request.getParameter("ownerId"))));
				purchasePK.setSaleArtwork(this.saleArtworkDaoServices.get(Integer.parseInt(request.getParameter("saleArtworkId"))));
				purchasePK.setStatus(this.purchaseStatusDaoServices.get(Integer.parseInt(request.getParameter("purchaseStatusId"))));

				request.setAttribute("purchase", this.purchaseDaoServices.get(purchasePK));
				destinationPage = "/WEB-INF/pages/purchases/overview.jsp";
				break;
			case LIST:
				request.setAttribute("purchases", this.purchaseDaoServices.getAll());
				destinationPage = "/WEB-INF/pages/purchases/list.jsp";
				break;
			case ADD_FORM:
				request.setAttribute("owners", this.ownerDaoServices.getAll());
				request.setAttribute("saleArtworks", this.saleArtworkDaoServices.getAll());
				request.setAttribute("purchaseStatus", this.purchaseStatusDaoServices.getAll());
				destinationPage = "/WEB-INF/pages/purchases/add-form.jsp";
				break;
			case UPDATE_FORM:
				PurchasePK purchasePK_ = new PurchasePK();
				purchasePK_.setOwner(this.ownerDaoServices.get(Integer.parseInt(request.getParameter("ownerId"))));
				purchasePK_.setSaleArtwork(this.saleArtworkDaoServices.get(Integer.parseInt(request.getParameter("saleArtworkId"))));
				purchasePK_.setStatus(this.purchaseStatusDaoServices.get(Integer.parseInt(request.getParameter("purchaseStatusId"))));

				request.setAttribute("purchase", this.purchaseDaoServices.get(purchasePK_));
				request.setAttribute("purchaseStatus", this.purchaseStatusDaoServices.getAll());
				destinationPage = "/WEB-INF/pages/purchases/update-form.jsp";
				break;
			case INSERT:
				Purchase purchaseToInsert = new Purchase();
				purchaseToInsert.setOwner(this.ownerDaoServices.get(Integer.parseInt(request.getParameter("ownerId"))));
				purchaseToInsert.setSaleArtwork(this.saleArtworkDaoServices.get(Integer.parseInt(request.getParameter("saleArtworkId"))));
				purchaseToInsert.setStatus(this.purchaseStatusDaoServices.get(Integer.parseInt(request.getParameter("purchaseStatusId"))));
				purchaseToInsert.setDate(LocalDate.parse(request.getParameter("purchaseDate")));
				this.purchaseDaoServices.insert(purchaseToInsert);

				request.setAttribute("message", "The purchase was successfully added!");
				destinationPage = "/index.jsp";
				break;
			case UPDATE:
				PurchasePK purchasePK__ = new PurchasePK();
				purchasePK__.setOwner(this.ownerDaoServices.get(Integer.parseInt(request.getParameter("ownerId"))));
				purchasePK__.setSaleArtwork(this.saleArtworkDaoServices.get(Integer.parseInt(request.getParameter("saleArtworkId"))));
				purchasePK__.setStatus(this.purchaseStatusDaoServices.get(Integer.parseInt(request.getParameter("oldPurchaseStatusId"))));

				Purchase purchaseToUpdate = this.purchaseDaoServices.get(purchasePK__);
				this.purchaseDaoServices.delete(purchaseToUpdate);

				purchaseToUpdate.setStatus(this.purchaseStatusDaoServices.get(Integer.parseInt(request.getParameter("newPurchaseStatusId"))));
				purchaseToUpdate.setDate(LocalDate.parse(request.getParameter("purchaseDate")));
				this.purchaseDaoServices.insert(purchaseToUpdate);

				request.setAttribute("message", "The purchase was successfully updated!");
				destinationPage = "/index.jsp";
				break;
			case DELETE:
				PurchasePK purchasePK___ = new PurchasePK();
				purchasePK___.setOwner(this.ownerDaoServices.get(Integer.parseInt(request.getParameter("ownerId"))));
				purchasePK___.setSaleArtwork(this.saleArtworkDaoServices.get(Integer.parseInt(request.getParameter("saleArtworkId"))));
				purchasePK___.setStatus(this.purchaseStatusDaoServices.get(Integer.parseInt(request.getParameter("purchaseStatusId"))));

				this.purchaseDaoServices.delete(this.purchaseDaoServices.get(purchasePK___));

				request.setAttribute("message", "The purchase was successfully deleted!");
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
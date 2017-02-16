package fr.polytech.oeuvres.controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.polytech.oeuvres.entities.SaleArtwork;
import fr.polytech.oeuvres.services.ArtworkStateDaoServices;
import fr.polytech.oeuvres.services.SaleArtworkDaoServices;

/**
 * This class represents a sale artwork controller.
 *
 * @author DELORME Loïc
 * @since 1.0.0
 */
@WebServlet("/SaleArtworkController")
public class SaleArtworkController extends AbstractController {

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
	 * The sale artwork DAO services.
	 */
	private final SaleArtworkDaoServices saleArtworkDaoServices;

	/**
	 * The artwork state DAO services.
	 */
	private final ArtworkStateDaoServices artworkStateDaoServices;

	/**
	 * Create a sale artwork controller.
	 */
	public SaleArtworkController() {
		super();

		this.saleArtworkDaoServices = new SaleArtworkDaoServices();
		this.artworkStateDaoServices = new ArtworkStateDaoServices();
	}

	@Override
	public void handleRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String actionName = request.getParameter(ACTION_TYPE);
		String destinationPage = null;
		switch (actionName) {
			case OVERVIEW:
				request.setAttribute("saleArtwork", this.saleArtworkDaoServices.get(request.getParameter("id")));
				destinationPage = "/pages/sale-artworks/overview.jsp";
				break;
			case LIST:
				request.setAttribute("saleArtworks", this.saleArtworkDaoServices.getAll());
				destinationPage = "/pages/sale-artworks/list.jsp";
				break;
			case ADD_FORM:
				destinationPage = "/pages/sale-artworks/addForm.jsp";
				break;
			case UPDATE_FORM:
				destinationPage = "/pages/sale-artworks/updateForm.jsp";
				break;
			case INSERT:
				SaleArtwork saleArtworkToInsert = new SaleArtwork();
				saleArtworkToInsert.setTitle(request.getParameter("title"));
				saleArtworkToInsert.setState(this.artworkStateDaoServices.get(request.getParameter("stateId")));
				saleArtworkToInsert.setPrice(Double.parseDouble(request.getParameter("price")));
				this.saleArtworkDaoServices.insert(saleArtworkToInsert);
				request.setAttribute("message", "The sale artwork was successfully added!");
				destinationPage = "/index.jsp";
				break;
			case UPDATE:
				SaleArtwork saleArtworkToUpdate = this.saleArtworkDaoServices.get(request.getParameter("id"));
				saleArtworkToUpdate.setTitle(request.getParameter("title"));
				saleArtworkToUpdate.setState(this.artworkStateDaoServices.get(request.getParameter("stateId")));
				saleArtworkToUpdate.setPrice(Double.parseDouble(request.getParameter("price")));
				this.saleArtworkDaoServices.update(saleArtworkToUpdate);
				request.setAttribute("message", "The sale artwork was successfully updated!");
				destinationPage = "/index.jsp";
				break;
			case DELETE:
				this.saleArtworkDaoServices.delete(this.saleArtworkDaoServices.get(request.getParameter("id")));
				request.setAttribute("message", "The sale artwork was successfully deleted!");
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
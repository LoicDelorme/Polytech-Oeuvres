package fr.polytech.oeuvres.controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.polytech.oeuvres.entities.Member;
import fr.polytech.oeuvres.services.MemberDaoServices;

/**
 * This class represents a member controller.
 *
 * @author DELORME Loïc
 * @since 1.0.0
 */
@WebServlet("/MemberController")
public class MemberController extends AbstractController {

	/**
	 * The serial version UID.
	 */
	private static final long serialVersionUID = 1L;

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
	 * The member DAO services.
	 */
	private final MemberDaoServices memberDaoServices;

	/**
	 * Create a member controller.
	 */
	public MemberController() {
		super();

		this.memberDaoServices = new MemberDaoServices();
	}

	@Override
	public void handleRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String actionName = request.getParameter(ACTION_TYPE);
		String destinationPage = null;
		switch (actionName) {
			case OVERVIEW:
				request.setAttribute("member", this.memberDaoServices.get(Integer.parseInt(request.getParameter("id"))));
				destinationPage = "/WEB-INF/pages/members/overview.jsp";
				break;
			case LIST:
				request.setAttribute("members", this.memberDaoServices.getAll());
				destinationPage = "/WEB-INF/pages/members/list.jsp";
				break;
			case ADD_FORM:
				destinationPage = "/WEB-INF/pages/members/add-form.jsp";
				break;
			case UPDATE_FORM:
				request.setAttribute("member", this.memberDaoServices.get(Integer.parseInt(request.getParameter("id"))));
				destinationPage = "/WEB-INF/pages/members/update-form.jsp";
				break;
			case INSERT:
				Member memberToInsert = new Member();
				memberToInsert.setLastname(request.getParameter("lastname"));
				memberToInsert.setFirstname(request.getParameter("firstname"));
				memberToInsert.setAddress(request.getParameter("address"));
				memberToInsert.setZipcode(request.getParameter("zipcode"));
				memberToInsert.setCity(request.getParameter("city"));
				this.memberDaoServices.insert(memberToInsert);

				request.setAttribute("message", "The member was successfully added!");
				destinationPage = "/index.jsp";
				break;
			case UPDATE:
				Member memberToUpdate = this.memberDaoServices.get(Integer.parseInt(request.getParameter("id")));
				memberToUpdate.setLastname(request.getParameter("lastname"));
				memberToUpdate.setFirstname(request.getParameter("firstname"));
				memberToUpdate.setAddress(request.getParameter("address"));
				memberToUpdate.setZipcode(request.getParameter("zipcode"));
				memberToUpdate.setCity(request.getParameter("city"));

				this.memberDaoServices.update(memberToUpdate);
				request.setAttribute("message", "The member was successfully updated!");
				destinationPage = "/index.jsp";
				break;
			case DELETE:
				this.memberDaoServices.delete(this.memberDaoServices.get(Integer.parseInt(request.getParameter("id"))));

				request.setAttribute("message", "The member was successfully deleted!");
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
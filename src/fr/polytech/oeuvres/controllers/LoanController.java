package fr.polytech.oeuvres.controllers;

import java.io.IOException;
import java.time.LocalDate;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.polytech.oeuvres.entities.Loan;
import fr.polytech.oeuvres.entities.pks.LoanPK;
import fr.polytech.oeuvres.services.LoanArtworkDaoServices;
import fr.polytech.oeuvres.services.LoanDaoServices;
import fr.polytech.oeuvres.services.MemberDaoServices;

/**
 * This class represents a loan controller.
 *
 * @author DELORME Loïc
 * @since 1.0.0
 */
@WebServlet("/LoanController")
public class LoanController extends AbstractController {

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
	 * The loan DAO services.
	 */
	private final LoanDaoServices loanDaoServices;

	/**
	 * The member DAO services.
	 */
	private final MemberDaoServices memberDaoServices;

	/**
	 * The loan artwork DAO services.
	 */
	private final LoanArtworkDaoServices loanArtworkDaoServices;

	/**
	 * Create a loan controller.
	 */
	public LoanController() {
		super();

		this.loanDaoServices = new LoanDaoServices();
		this.memberDaoServices = new MemberDaoServices();
		this.loanArtworkDaoServices = new LoanArtworkDaoServices();
	}

	@Override
	public void handleRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String actionName = request.getParameter(ACTION_TYPE);
		String destinationPage = null;
		switch (actionName) {
			case OVERVIEW:
				LoanPK loanPK = new LoanPK();
				loanPK.setMember(this.memberDaoServices.get(Integer.parseInt(request.getParameter("memberId"))));
				loanPK.setLoanArtwork(this.loanArtworkDaoServices.get(Integer.parseInt(request.getParameter("loanArtworkId"))));
				loanPK.setDate(LocalDate.parse(request.getParameter("loanDate")));

				request.setAttribute("loan", this.loanDaoServices.get(loanPK));
				destinationPage = "/WEB-INF/pages/loans/overview.jsp";
				break;
			case LIST:
				request.setAttribute("loans", this.loanDaoServices.getAll());
				destinationPage = "/WEB-INF/pages/loans/list.jsp";
				break;
			case ADD_FORM:
				request.setAttribute("members", this.memberDaoServices.getAll());
				request.setAttribute("loanArtworks", this.loanArtworkDaoServices.getAll());
				destinationPage = "/WEB-INF/pages/loans/add-form.jsp";
				break;
			case UPDATE_FORM:
				LoanPK loanPK_ = new LoanPK();
				loanPK_.setMember(this.memberDaoServices.get(Integer.parseInt(request.getParameter("memberId"))));
				loanPK_.setLoanArtwork(this.loanArtworkDaoServices.get(Integer.parseInt(request.getParameter("loanArtworkId"))));
				loanPK_.setDate(LocalDate.parse(request.getParameter("loanDate")));

				request.setAttribute("loan", this.loanDaoServices.get(loanPK_));
				destinationPage = "/WEB-INF/pages/loans/update-form.jsp";
				break;
			case INSERT:
				Loan loanToInsert = new Loan();
				loanToInsert.setMember(this.memberDaoServices.get(Integer.parseInt(request.getParameter("memberId"))));
				loanToInsert.setLoanArtwork(this.loanArtworkDaoServices.get(Integer.parseInt(request.getParameter("loanArtworkId"))));
				loanToInsert.setDate(LocalDate.parse(request.getParameter("loanDate")));
				loanToInsert.setDuration(Integer.parseInt(request.getParameter("duration")));
				this.loanDaoServices.insert(loanToInsert);

				request.setAttribute("message", "The loan was successfully added!");
				destinationPage = "/index.jsp";
				break;
			case UPDATE:
				LoanPK loanPK__ = new LoanPK();
				loanPK__.setMember(this.memberDaoServices.get(Integer.parseInt(request.getParameter("memberId"))));
				loanPK__.setLoanArtwork(this.loanArtworkDaoServices.get(Integer.parseInt(request.getParameter("loanArtworkId"))));
				loanPK__.setDate(LocalDate.parse(request.getParameter("loanDate")));

				Loan loanToUpdate = this.loanDaoServices.get(loanPK__);
				loanToUpdate.setDuration(Integer.parseInt(request.getParameter("duration")));
				this.loanDaoServices.update(loanToUpdate);

				request.setAttribute("message", "The loan was successfully updated!");
				destinationPage = "/index.jsp";
				break;
			case DELETE:
				LoanPK loanPK___ = new LoanPK();
				loanPK___.setMember(this.memberDaoServices.get(Integer.parseInt(request.getParameter("memberId"))));
				loanPK___.setLoanArtwork(this.loanArtworkDaoServices.get(Integer.parseInt(request.getParameter("loanArtworkId"))));
				loanPK___.setDate(LocalDate.parse(request.getParameter("loanDate")));

				this.loanDaoServices.delete(this.loanDaoServices.get(loanPK___));

				request.setAttribute("message", "The loan was successfully deleted!");
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
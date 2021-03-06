package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dao.DiscenteService;
import model.session.Discente;

/**
 * Servlet implementation class CtrlArchivioDiscente
 */
@WebServlet("/CtrlArchivioDiscente")
public class CtrlArchivioDiscente extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static DiscenteService oDis = new DiscenteService();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CtrlArchivioDiscente() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String azione = request.getParameter("cmdAzione");
		if (azione == null) {
			visualizzaElenco(request, response);
		} else if (azione.equals("Home")) {
			getServletContext().getRequestDispatcher("/CtrlMain").forward(request, response);
		} else if (azione.equals("Nuovo")) {
			nuovoDiscente(request, response);
		} else if (azione.equals("Annulla")) {
			visualizzaElenco(request, response);
		} else if (azione.equals("Registra")) {
			salvaDiscente(request, response);
			visualizzaElenco(request, response);
		} else if (azione.equals("Modifica")) {
			modificaDiscente(request, response);
		} else if (azione.equals("Elimina")) {
			eliminaDiscente(request, response);
		} else if (azione.equals("Conferma")) {
			cancellaDiscente(request, response);
			visualizzaElenco(request, response);
		}

	}

	private void cancellaDiscente(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		oDis.delete(((Discente) request.getSession().getAttribute("beanDiscente")).getMatricola());
	}

	private void eliminaDiscente(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Discente oDiscente = oDis.findById(Integer.parseInt(request.getParameter("rdoMatricolaDiscente")));
		request.getSession().setAttribute("beanDiscente", oDiscente);
		getServletContext().getRequestDispatcher("/ArchivioDiscente/PgsArchivioDiscenteElimina.jsp").forward(request, response);
}

	private void modificaDiscente(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Discente oDiscente = oDis.findById(Integer.parseInt(request.getParameter("rdoMatricolaDiscente")));
		request.getSession().setAttribute("beanDiscente", oDiscente);
		getServletContext().getRequestDispatcher("/ArchivioDiscente/PgsArchivioDiscenteNuovoModifica.jsp").forward(request, response);

	}

	private void salvaDiscente(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		((Discente) request.getSession().getAttribute("beanDiscente")).setCognome(request.getParameter("txtCognome"));
		((Discente) request.getSession().getAttribute("beanDiscente")).setNome(request.getParameter("txtNome"));
		if(((Discente) request.getSession().getAttribute("beanDiscente")).getMatricola() == 0)
			oDis.persist(((Discente) request.getSession().getAttribute("beanDiscente"))); 
		else
			oDis.update(((Discente) request.getSession().getAttribute("beanDiscente")));
	
	}

	private void nuovoDiscente(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Discente oDiscente = new Discente();
		request.getSession().setAttribute("beanDiscente", oDiscente);
		getServletContext().getRequestDispatcher("/ArchivioDiscente/PgsArchivioDiscenteNuovoModifica.jsp").forward(request, response);
	
	}

	private void visualizzaElenco(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<Discente> elenco = new DiscenteService().findAll();
		request.setAttribute("elencoDiscenti", elenco);
		getServletContext().getRequestDispatcher("/ArchivioDiscente/PgsArchivioDiscente.jsp").forward(request, response);
		
	}

}
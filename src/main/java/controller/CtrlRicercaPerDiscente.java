package controller;

import java.io.IOException;
import java.util.List;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dao.DiscenteService;
import model.session.Corso;
import model.session.Discente;

/**
 * Servlet implementation class CtrlArchivioDiscente
 */
@WebServlet("/CtrlRicercaPerDiscente")
public class CtrlRicercaPerDiscente extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static DiscenteService oDoc = new DiscenteService();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CtrlRicercaPerDiscente() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
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
		}else if (azione.equals("Visualizza")) {
			visualizza(request, response);
		}
		
	}


	private void visualizza(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Discente oDiscente = oDoc.findById(Integer.parseInt(request.getParameter("rdoIDDiscente")));
		Set<Corso> corsi_discente = (Set<Corso>) oDiscente.getCorsi();
		request.getSession().setAttribute("beanCorsi", corsi_discente);
		getServletContext().getRequestDispatcher("/RicercaPerDiscente/PgsListaCorsi.jsp").forward(request, response);
	}

	private void visualizzaElenco(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<Discente> elenco = new DiscenteService().findAll();
		request.setAttribute("elencoDiscenti", elenco);
		getServletContext().getRequestDispatcher("/RicercaPerDiscente/PgsListaDiscenti.jsp").forward(request, response);
		
	}

}

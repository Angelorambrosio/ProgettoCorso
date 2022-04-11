package controller;

import java.io.IOException;
import java.util.List;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dao.DocenteService;
import model.session.Corso;
import model.session.Docente;

/**
 * Servlet implementation class CtrlArchivioDocente
 */
@WebServlet("/CtrlRicercaPerDocente")
public class CtrlRicercaPerDocente extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static DocenteService oDoc = new DocenteService();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CtrlRicercaPerDocente() {
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
		Docente oDocente = oDoc.findById(Integer.parseInt(request.getParameter("rdoIDDocente")));
		Set<Corso> corsi_docente = (Set<Corso>) oDocente.getCorsi();
		request.getSession().setAttribute("beanCorsi", corsi_docente);
		getServletContext().getRequestDispatcher("/RicercaXDocente/PgsListaCorsi.jsp").forward(request, response);
	}

	private void visualizzaElenco(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<Docente> elenco = new DocenteService().findAll();
		request.setAttribute("elencoDocenti", elenco);
		getServletContext().getRequestDispatcher("/RicercaXDocente/PgsListaDocenti.jsp").forward(request, response);
		
	}

}

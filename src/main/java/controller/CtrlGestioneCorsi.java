package controller;

import java.io.IOException;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.Transactional;

import model.dao.AulaService;
import model.dao.CorsoService;
import model.dao.DiscenteService;
import model.dao.DocenteService;
import model.session.Aula;
import model.session.Corso;
import model.session.Discente;
import model.session.Docente;

/**
 * Servlet implementation class CtrlArchivioDocente
 */
@Transactional
@WebServlet("/CtrlGestioneCorsi")
public class CtrlGestioneCorsi extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static DiscenteService oDisS = new DiscenteService();
	private static DocenteService oDocS = new DocenteService();
	private static AulaService oAulS = new AulaService();
	private static CorsoService oCorS = new CorsoService();
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CtrlGestioneCorsi() {
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
		}else if (azione.equals("Home")) {
			getServletContext().getRequestDispatcher("/CtrlMain").forward(request, response);
		}else if (azione.equals("Nuovo")) {
			nuovoCorso(request, response);
		}else if (azione.equals("Registra")) {
			salvaCorso(request, response);
			visualizzaElenco(request, response);
		}else if (azione.equals("Modifica")) {
			modificaCorso(request, response);
		}else if (azione.equals("TornaGestione")) {
			visualizzaElenco(request, response);
		}else if (azione.equals("Elimina")) {
			eliminaCorso(request, response);
			visualizzaElenco(request, response);
		}else if (azione.equals("Errore")) {
			
			visualizzaErrore(request, response);
		}
		
		
	}
	
	

	private void eliminaCorso(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		Corso oCorso= oCorS.findById(Integer.parseInt(request.getParameter("rdoIDCorso")));
		oCorS.delete(oCorso);
	}
	private void salvaCorso(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			Corso oCorso = new Corso();
			
			LocalDate data_inizio = LocalDate.parse(request.getParameter("data").toString()) ;
			Integer durata = Integer.parseInt((String) request.getParameter("durata"));
			String nome_corso = request.getParameter("nome");
			
			
			String[] matricole =  request.getParameterValues("discenti");
			Set<Discente> partecipanti = new HashSet<Discente>();
			
			for(String mat : matricole) {
				partecipanti.add(new DiscenteService().findById(Integer.parseInt(mat)));
			}
			
			oCorso.setNome(nome_corso);
			oCorso.setData(data_inizio);
			oCorso.setDurata(durata);
			oCorso.setCodAula(oAulS.findById(Integer.parseInt(request.getParameter("cod_aula"))));
			oCorso.setCodDocente(oDocS.findById(Integer.parseInt(request.getParameter("cod_doc"))));
			oCorso.setDiscenti(partecipanti);
			
			if(oCorso.getId() == 0) {
				oCorS.persist(oCorso);
			}else {
				oCorS.update(oCorso);
			}
		} catch (Exception e) {
			// TODO: handle exception
			request.setAttribute("errore", "errore");
			getServletContext().getRequestDispatcher("/CtrlMain").forward(request, response);
			
		}
		
		
		
	}
	/*private void nuovoStep3Discenti(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			String[] matricole =  request.getParameterValues("rdoMatricolaDiscente");
			Set<Discente> partecipanti = new HashSet<Discente>();
			
			
			for(String mat : matricole) {
				partecipanti.add(new DiscenteService().findById(Integer.parseInt(mat)));
			}
			
			Corso oCorso = ((Corso) request.getSession().getAttribute("beanCorso"));
			Aula oAula = ((Aula) request.getSession().getAttribute("beanAula"));
			Docente oDocente = ((Docente) request.getSession().getAttribute("beanDocente"));
			request.getSession().setAttribute("beanCorso", oCorso);
			request.getSession().setAttribute("beanAula", oAula);
			request.getSession().setAttribute("beanDocente", oDocente);
			request.getSession().setAttribute("beanDiscente", partecipanti);
			
			getServletContext().getRequestDispatcher("/GestioneCorso/PgsRiepilogoCorso.jsp").forward(request, response);
		} catch (Exception e) {
			// TODO: handle exception
			request.setAttribute("errore", "errore");
			getServletContext().getRequestDispatcher("/CtrlMain").forward(request, response);
		}
		
		
	}
	private void nuovoStep2Docente(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//
		try {
			Corso oCorso = ((Corso) request.getSession().getAttribute("beanCorso"));
			Aula oAula = ((Aula) request.getSession().getAttribute("beanAula"));
			Docente oDocente = new DocenteService().findById(Integer.parseInt(request.getParameter("rdoIDDocente")));
			request.getSession().setAttribute("beanCorso", oCorso);
			request.getSession().setAttribute("beanAula", oAula);
			request.getSession().setAttribute("beanDocente", oDocente);
			List<Discente> elencoDiscenti= new DiscenteService().findAll();
			request.setAttribute("elencoDiscenti", elencoDiscenti);
			getServletContext().getRequestDispatcher("/GestioneCorso/PgsStep3Discenti.jsp").forward(request, response);
		} catch (Exception e) {
			// TODO: handle exception
			request.setAttribute("errore", "errore");
			getServletContext().getRequestDispatcher("/CtrlMain").forward(request, response);
		}
		
	}
	private void nuovoStep1Aula(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			Corso oCorso = ((Corso) request.getSession().getAttribute("beanCorso"));
			Aula oAula = new AulaService().findById(Integer.parseInt(request.getParameter("rdoIDAula")));
			request.getSession().setAttribute("beanCorso", oCorso);
			request.getSession().setAttribute("beanAula", oAula);
			List<Docente> elencoDocenti = new DocenteService().findAll();
			request.setAttribute("elencoDocenti", elencoDocenti);		
			getServletContext().getRequestDispatcher("/GestioneCorso/PgsStep2Docente.jsp").forward(request, response);
		} catch (Exception e) {
			// TODO: handle exception
			request.setAttribute("errore", "errore");
			getServletContext().getRequestDispatcher("/CtrlMain").forward(request, response);
		}
		
	}
	*/
	private void modificaCorso(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			Corso oCorso= oCorS.findById(Integer.parseInt(request.getParameter("rdoIDCorso")));
		
		request.getSession().setAttribute("beanCorso", oCorso);
		List<Aula> elenco = new AulaService().findAll();
		request.setAttribute("elencoAule", elenco);		
		getServletContext().getRequestDispatcher("/GestioneCorso/PgsStep1Aula.jsp").forward(request, response);
		} catch (Exception e) {
			// TODO: handle exception
			request.setAttribute("errore", "errore");
			getServletContext().getRequestDispatcher("/CtrlMain").forward(request, response);
		}
		
		
	}
	private void nuovoCorso(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Corso oCorso = new Corso();
		request.getSession().setAttribute("beanCorso", oCorso);
		
		List<Aula> elenco = new AulaService().findAll();
		request.setAttribute("elencoAule", elenco);	
		
		List<Docente> docenti = oDocS.findAll(); 
		request.setAttribute("elencoDocenti", docenti);	
		
		List<Discente> discenti = oDisS.findAll(); 
		request.setAttribute("elencoDiscenti", discenti);	
		
		getServletContext().getRequestDispatcher("/ArchivioCorso/PgsArchivioCorsoNuovoModifica.jsp").forward(request, response);
	}
	private void visualizzaElenco(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<Corso> elenco = new CorsoService().findAll();
		request.setAttribute("elencoCorso", elenco);
		getServletContext().getRequestDispatcher("/ArchivioCorso/PgsGestioneCorso.jsp").forward(request, response);
		
	}
	
	private void visualizzaErrore(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		List<Corso> elenco = new CorsoService().findAll();
		request.setAttribute("elencoCorsi", elenco);
		request.setAttribute("errore", "errore");
		getServletContext().getRequestDispatcher("/ArchivioCorso/PgsGestioneCorso.jsp").forward(request, response);
	}
	
}

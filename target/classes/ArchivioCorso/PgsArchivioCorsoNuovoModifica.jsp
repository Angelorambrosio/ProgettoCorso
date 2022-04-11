<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<HTML>
<HEAD>
<%@ page 
language="java"
contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"

import="model.session.Aula"
import="model.dao.AulaService"
import="model.dao.AulaDAO"
import="model.session.Docente"
import="model.dao.DocenteService"
import="model.dao.DocenteDAO"
import="model.session.Discente"
import="model.dao.DiscenteService"
import="model.dao.DiscenteDAO"
import="java.util.ArrayList"
import="java.util.List"

%>

<%

List<Aula> elencoAule = (List<Aula>) request.getAttribute("elencoAule");

List<Docente> elencoDocenti = (List<Docente>) request.getAttribute("elencoDocenti");

List<Discente> elencoDiscenti = (List<Discente>) request.getAttribute("elencoDiscenti");

%>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" 
rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
<META http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<META name="GENERATOR" content="IBM WebSphere Studio">
<TITLE>PgsArchivioCorsoNuovoModifica.jsp</TITLE>
</HEAD>
<BODY style=background-image:url(https://www.teahub.io/photos/full/29-294939_light-grey-material-design.jpg); 
background-size:cover; background-repeat: no-repeat>

<jsp:useBean id="beanCorso" scope="session"
	class="model.session.Corso">
	<jsp:setProperty name="beanCorso" property="*" />
</jsp:useBean>

<P align="center"><FONT size="+5" color="black">Corso</FONT></P>


<FORM method="post" action="/Corso/CtrlGestioneCorsi">

	<div class="container">
		 <div class="form-group">
		    <label for="nomeCorso">Nome Corso</label>
		    <input type="text" class="form-control" id="nomeCorso" name="nome" aria-describedby="nomeCorso" placeholder="Inserire il nome del corso">
		  </div>
		  <div class="form-group">
		    <label for="dataCorso">Data Inizio Corso</label>
		    <input type="date" class="form-control" id="dataCorso" name="data" placeholder="Inserire Data">
		  </div>
		  <div class="form-group">
		    <label for="durataCorso">Durata Corso</label>
		    <input type="number" class="form-control" id="durataCorso" name="durata" aria-describedby="durataCorso" placeholder="Inserire duarata del corso">
		  </div>
	</div>
	
	
	  <div class="dropdown-divider"></div>
	  
		<div class="container">
		 <div class="form-group">
		    <label for="cod_aula">Codice Aula</label>
		    <select name="cod_aula" class="form-select">
		    	<%
		    		int i = 0;
		    		for(i=0;i < elencoAule.size();i++){
		    			
		    		%>
		    		<option value="<%= elencoAule.get(i).getId() %>">  <%=elencoAule.get(i).getId() + " -  "+ elencoAule.get(i).getDescrizione() %></option>	
		    	<%
		    		}
		    		
		    	%>
		    	
		    </select>
		  </div>
		  <div class="form-group">
		    <label for="cod_doc">Docente</label>
		    <select name="cod_doc" class="form-select">
		    	<%
		    		
		    		for(i=0;i < elencoDocenti.size();i++){
		    			
		    		%>
		    		<option value="<%= elencoDocenti.get(i).getId() %>">  <%=elencoDocenti.get(i).getNome() + " -  "+ elencoDocenti.get(i).getCognome() %></option>	
		    	<%
		    		}
		    		
		    	%>
		    	
		    </select>
		  </div>
		  
		  <div class="card" style="margin-top:4%;padding: 3%;box-shadow: -1px 7px 7px -1px black;">
		    <div class="card-title">
		    	Alunni
		    </div>
		  	<div class="card-body">
		  	<%
		    		
		    		for(i=0;i < elencoDiscenti.size();i++){
		    			
		    		%>
		    		<div class="form-check">
		  	 
					  <input class="form-check-input" name="discenti" type="checkbox" value="<%= elencoDiscenti.get(i).getMatricola()%>" id="">
					  <label class="form-check-label" for="flexCheckDefault">
					    <%= elencoDiscenti.get(i).getMatricola() + " - "+ elencoDiscenti.get(i).getNome() + " " + elencoDiscenti.get(i).getCognome()%>
					  </label>
			 	  </div>
		    	<%
		    		}
		    		
		    	%>
		  	
		  	 
		  	</div>
		  	
		  </div>
		  
		  
			
	</div>

<BR/> 
<BR/>
<DIV align="center">

<INPUT class="btn btn-dark" type="submit" name="cmdAzione" value="Registra"> &nbsp;&nbsp;
<INPUT class="btn btn-dark" type="submit" name="cmdAzione" value="Annulla"> <BR>

</DIV></FORM>



</BODY>
</HTML>

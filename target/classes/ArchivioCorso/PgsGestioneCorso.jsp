<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%@page import="model.session.Corso"
import="model.session.Aula"
import="model.session.Docente"
import="model.dao.CorsoService"
import="model.dao.CorsoDAO" %>
<HTML>
<HEAD>
<%@ page
language="java"
contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"
import="java.util.*"
%>
<META http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<META name="GENERATOR" content="IBM WebSphere Studio">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
<TITLE>pgsGestioneCorso.jsp</TITLE>
</HEAD>
<BODY style=background-image:url(https://www.teahub.io/photos/full/29-294939_light-grey-material-design.jpg); background-size:cover; background-repeat: no-repeat>
<FORM method="post" action="/Corso/CtrlGestioneCorsi" name="ArchivioCorso">
<div class="container">
<div class="text">
&nbsp;&nbsp;<input class="btn btn-dark" type="submit" name="cmdAzione" value="Home">
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
<h3 style="text-align: center; color:Black; font-size:45px" >Archivio Corsi </h3>
</div>

<% List<Corso> pgsElenco= (List<Corso>) request.getAttribute("elencoCorso");
   if(pgsElenco.size() > 0){
    int i = 0;
   
%>
<TABLE border="1" class="table table-striped table-dark" >
<thead class="thead-dark">
<TR>
<th scope="col">Id</th>
<th scope="col">Nome</th>     
<th scope="col">Data</th>  
<th scope="col">Durata</th> 
<th scope="col">Aula</th> 
<th scope="col">Docente</th> 
</TR>
</thead>
<TBODY>

<%while(i< pgsElenco.size()){
%>
<TR>
 <th>
 <input type="radio" name="rdoIDCorso" value="<%= ((Corso)pgsElenco.get(i)).getId() %>" > 
 </th>
 <th> <%= ((Corso)pgsElenco.get(i)).getNome() %></th>
 <th> <%= ((Corso)pgsElenco.get(i)).getData() %></th> 
  <th> <%= ((Corso)pgsElenco.get(i)).getDurata() %></th> 
   <th> <% Aula aula = ((Corso)pgsElenco.get(i)).getCodAula(); out.print(aula.getDescrizione()); %></th> 
    <th> <% Docente docente = ((Corso)pgsElenco.get(i)).getCodDoc(); out.print(docente.getNome()); out.print(" "); out.print(docente.getCognome()); %></th> 
 </TR>
<% i++;
} %>
</TBODY>
</TABLE>
<P> </P>
<% } else{%> Non ci sono Corsi<% } %> <BR>


<input class="btn btn-dark" type="submit" name="cmdAzione" value="Nuovo">
&nbsp;&nbsp;&nbsp;<input class="btn btn-dark" type="submit" name="cmdAzione" value="Modifica">
&nbsp;&nbsp;&nbsp;<input class="btn btn-dark" type="submit" name="cmdAzione" value="Elimina">

<br>
</Form>

</BODY>
</HTML>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%@page import="model.session.Docente"
import="model.dao.DocenteService"
import="model.dao.DocenteDAO" %>
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
<TITLE>ArchivioDocente.jps</TITLE>
</HEAD>
<BODY style=background-image:url(https://www.teahub.io/photos/full/29-294939_light-grey-material-design.jpg); background-size:cover; background-repeat: no-repeat>
<FORM method="post" action="/Corso/CtrlArchivioDocente" name="ArchivioDocente">
<div class="container">
<div class="text">
&nbsp;&nbsp;<input class="btn btn-dark" type="submit" name="cmdAzione" value="Home">
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
<h3 style="text-align: center; color:Black; font-size:45px" >Archivio Docenti </h3>
</div>

<% List<Docente> pgsElenco= (List<Docente>) request.getAttribute("elencoDocenti");
   if(pgsElenco.size() > 0){
     int i = 0;
   
%>

<TABLE border="1" class="table table-striped table-dark" >
<thead class="thead-dark">
<TR>
<th scope="col">Id</th>
<th scope="col">Cognome</th>     
<th scope="col">Nome</th>  
</TR>
</thead>
<TBODY>


<%while(i< pgsElenco.size()){
 %>
 <TR>
 <th>
 <input type="radio" name="rdoIDDocente" value="<%= ((Docente)pgsElenco.get(i)).getId() %>" > 
 </th>
 <th> <%= ((Docente)pgsElenco.get(i)).getCognome() %></th>
 <th> <%= ((Docente)pgsElenco.get(i)).getNome() %></th> 
 </TR>
 <% i++;
 } %> 
</TBODY>
</TABLE>
</div>
<% } else{%> Non ci sono Docenti<% } %> <BR>

<div class="container" style="text-align:center">
 <input class="btn btn-dark" type="submit" name="cmdAzione" value="Nuovo">
 &nbsp;&nbsp;&nbsp;<input class="btn btn-dark" type="submit" name="cmdAzione" value="Modifica">
 &nbsp;&nbsp;&nbsp;<input class="btn btn-dark" type="submit" name="cmdAzione" value="Elimina">
</div>

<br>
</Form>

</BODY>
</HTML>

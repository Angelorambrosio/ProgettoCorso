<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<HTML>
<HEAD>
<%@ page 
language="java"
contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"
%>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" 
rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
<META http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<META name="GENERATOR" content="IBM WebSphere Studio">
<TITLE>pgsArchivioAulaNuovoModifica.jsp</TITLE>
</HEAD>
<BODY style=background-image:url(https://www.teahub.io/photos/full/29-294939_light-grey-material-design.jpg); 
background-size:cover; background-repeat: no-repeat>

<jsp:useBean id="beanAula" scope="session"
	class="model.session.Aula">
	<jsp:setProperty name="beanAula" property="*" />
</jsp:useBean>

<P align="center"><FONT size="+5" color="black">Aula</FONT></P>


<FORM method="post" action="/Corso/CtrlArchivioAula">


<TABLE  align="center" >
<tr>

	<td>
	 	Numero Posti:	 
	</td>
	
	<td>
		<INPUT type="number" name="numNumeroPosti" value="<%= beanAula.getNumeroPosti()%>">
	</td>
	
</tr>	

<tr>

	<td>
	&nbsp;
	</td>
	
</tr>

<tr>

	<td>
		Descrizione: 
	</td>
	
	<td>
		 
	<INPUT type="text" name="txtDescrizione" value="<%= beanAula.getDescrizione()%>">
	
	</td>
	
</tr>
</TABLE >
<BR/> 
<BR/>
<DIV align="center">

<INPUT class="btn btn-dark" type="submit" name="cmdAzione" value="Registra"> &nbsp;&nbsp;
<INPUT class="btn btn-dark" type="submit" name="cmdAzione" value="Annulla"> <BR>

</DIV></FORM>



</BODY>
</HTML>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" 
rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
<BODY style=background-image:url(https://www.teahub.io/photos/full/29-294939_light-grey-material-design.jpg); 
background-size:cover; background-repeat: no-repeat>
<title>pgsArchivioDocenteElimina.jsp</title>
</head>
<body>
<jsp:useBean id="beanDocente" scope="session"
	class="model.session.Docente">
	<jsp:setProperty name="beanDocente" property="*" />
</jsp:useBean>

<P align="center"><FONT size="+2" color="Black">Sei sicuro di voler eliminare il Docente?</FONT></P>


<FORM method="post" action="/Corso/CtrlArchivioDocente">

<TABLE  align="center" >
<tr>

	
	
	<td>
		<INPUT class="btn btn-dark" type="submit" name="cmdAzione" value="Conferma">
	</td>
	
</tr>	

<tr>

	<td>
	&nbsp;
	</td>
	
</tr>

<tr>


	
	<td>
		 
		<INPUT class="btn btn-dark" type="submit" name="cmdAzione" value="Annulla">
	
	</td>
	
</tr>
</TABLE >
</FORM>
</body>
</html>
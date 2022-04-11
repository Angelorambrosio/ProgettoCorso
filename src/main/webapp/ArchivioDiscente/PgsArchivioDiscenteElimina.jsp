<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" 
rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
<title>pgsArchivioDiscenteElimina.jsp</title>
</head>
<BODY style=background-image:url(https://www.teahub.io/photos/full/29-294939_light-grey-material-design.jpg); 
background-size:cover; background-repeat: no-repeat>
<jsp:useBean id="beanDiscente" scope="session"
class="model.session.Discente">
<jsp:setProperty name="beanDiscente" property="*" />
</jsp:useBean>

<P align="center"><FONT size="+2" color="green">Sei sicuro di voler eliminare il Discente?</FONT></P>


<FORM method="post" action="/Corso/CtrlArchivioDiscente">

<TABLE  align="center" >
<tr>



<td>
<INPUT class="btn btn-dark" type="submit" name="cmdAzione" value="Conferma" size="20" maxlength="50">
</td>

</tr>

<tr>

<td>
&nbsp;
</td>

</tr>

<tr>



<td>

<INPUT class="btn btn-dark" type="submit" name="cmdAzione" value="Annulla" size="20" maxlength="50">

</td>

</tr>
</TABLE >
</FORM>
</body>
</html>
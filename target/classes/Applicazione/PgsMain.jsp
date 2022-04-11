<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<HTML>
<HEAD>
<%@ page 
language="java"
contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"
%>

<META http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<META name="GENERATOR" content="IBM WebSphere Studio">
<TITLE>pgsMain.jsp</TITLE>
</HEAD>
<BODY style=background-image:url(https://www.teahub.io/photos/full/29-294939_light-grey-material-design.jpg); background-size:cover; background-repeat: no-repeat>

<P align="center"> <FONT size="+30" color="BLACK">Menu</FONT>

<FORM method="post" action="/Corso/CtrlMain">
<DIV align="center">
<TABLE>
 <TBODY>
  <TR>
   <TD><INPUT type="radio" name="rdoScelta" value="0" checked="checked"></TD>
   <TD>Archivio&nbsp;Docente</TD> 
  </TR> 
   
  <TR>
   <TD><INPUT type="radio" name="rdoScelta" value="1" ></TD>
   <TD>Archivio&nbsp;Discente</TD> 
  </TR> 
    <TR>
   <TD><INPUT type="radio" name="rdoScelta" value="2" ></TD>
   <TD>Archivio&nbsp;Aula</TD> 
  </TR>   
  <TR>
   <TD><INPUT type="radio" name="rdoScelta" value="3" ></TD>
   <TD>Gestione&nbsp;Corso</TD> 
  </TR> 
  <TR>
   <TD><INPUT type="radio" name="rdoScelta" value="4" ></TD>
   <TD>Ricerca&nbsp;Corso&nbsp;Per&nbsp;Docente</TD> 
  </TR>   
  <TR>
   <TD><INPUT type="radio" name="rdoScelta" value="5" ></TD>
   <TD>Ricerca&nbsp;Corso&nbsp;Per&nbsp;Discente</TD> 
  </TR>   

 </TBODY>   
    
</TABLE>
<BR>
<INPUT type ="submit" name="cmdInvio" value="Invio"></DIV>
</form>
<DIV ALIGN="center"><br>
</div>

</BODY>
</HTML>
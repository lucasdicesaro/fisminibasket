<%@ page language="java" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-bean" prefix="bean"%> 
<%@ taglib uri="http://jakarta.apache.org/struts/tags-html" prefix="html"%>
 
<html> 
	<head>
		<title>JSP for DynaActionForm form</title>
	</head>
	<body>
		<html:form action="/fichamedica">
			antecedentes : <html:text property="antecedentes"/><html:errors property="antecedentes"/><br/>
			cardiopatias : <html:text property="cardiopatias"/><html:errors property="cardiopatias"/><br/>
			alergias : <html:text property="alergias"/><html:errors property="alergias"/><br/>
			historial : <html:text property="historial"/><html:errors property="historial"/><br/>
			medico : <html:text property="medico"/><html:errors property="medico"/><br/>
			estado : <html:text property="estado"/><html:errors property="estado"/><br/>
			buco : <html:text property="buco"/><html:errors property="buco"/><br/>
			jugador : <html:text property="jugador"/><html:errors property="jugador"/><br/>
			<html:submit/><html:cancel/>
		</html:form>
	</body>
</html>


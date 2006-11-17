<%@ page language="java" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-bean" prefix="bean"%> 
<%@ taglib uri="http://jakarta.apache.org/struts/tags-html" prefix="html"%>
 
<html> 
	<head>
		<title>JSP for DynaActionForm form</title>
	</head>
	<body>
		<html:form action="/aviso">
			fecha : <html:text property="fecha"/><html:errors property="fecha"/><br/>
			aviso : <html:text property="aviso"/><html:errors property="aviso"/><br/>
			estado : <html:text property="estado"/><html:errors property="estado"/><br/>
			tipo : <html:text property="tipo"/><html:errors property="tipo"/><br/>
			jugador : <html:text property="jugador"/><html:errors property="jugador"/><br/>
			<html:submit/><html:cancel/>
		</html:form>
	</body> 
</html>


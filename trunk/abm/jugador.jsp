<%@ page language="java" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-bean" prefix="bean"%> 
<%@ taglib uri="http://jakarta.apache.org/struts/tags-html" prefix="html"%>
 
<html> 
	<head>
		<title>JSP for DynaActionForm form</title>
	</head>
	<body>
		<html:form action="/jugador">
			nombre : <html:text property="nombre"/><html:errors property="nombre"/><br/>
			nacimiento : <html:text property="nacimiento"/><html:errors property="nacimiento"/><br/>
			federacion : <html:text property="federacion"/><html:errors property="federacion"/><br/>
			club : <html:text property="club"/><html:errors property="club"/><br/>
			categoria : <html:text property="categoria"/><html:errors property="categoria"/><br/>
			apellido : <html:text property="apellido"/><html:errors property="apellido"/><br/>
			federado : <html:text property="federado"/><html:errors property="federado"/><br/>
			<html:submit/><html:cancel/>
		</html:form>
	</body>
</html>


<%@ page language="java" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-bean" prefix="bean"%> 
<%@ taglib uri="http://jakarta.apache.org/struts/tags-html" prefix="html"%>
 
<html> 
	<head>
		<title>JSP for DynaActionForm form</title>
	</head>
	<body>
		<html:form action="/club">
			federacion : <html:text property="federacion"/><html:errors property="federacion"/><br/>
			descripcion : <html:text property="descripcion"/><html:errors property="descripcion"/><br/>
			federado : <html:text property="federado"/><html:errors property="federado"/><br/>
			<html:submit/><html:cancel/>
		</html:form>
	</body>
</html>


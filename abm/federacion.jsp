<%@ page language="java" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-bean" prefix="bean"%> 
<%@ taglib uri="http://jakarta.apache.org/struts/tags-html" prefix="html"%>
 
<html> 
	<head>
		<title>JSP for DynaActionForm form</title>
	</head>
	<body>
		<html:form action="/federacion">
			Descripcion : <html:text property="descripcion"/><html:errors property="descripcion"/><br/>
			<html:submit/><html:cancel/>
		</html:form>
	</body>
</html>


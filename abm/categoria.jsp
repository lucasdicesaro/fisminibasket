<%@ page language="java" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-bean" prefix="bean"%> 
<%@ taglib uri="http://jakarta.apache.org/struts/tags-html" prefix="html"%>
 
<html> 
	<head>
		<title>JSP for DynaActionForm form</title>
	</head>
	<body>
		<html:form action="/categoria">
			hasta : <html:text property="hasta"/><html:errors property="hasta"/><br/>
			desde : <html:text property="desde"/><html:errors property="desde"/><br/>
			descripcion : <html:text property="descripcion"/><html:errors property="descripcion"/><br/>
			minimo : <html:text property="minimo"/><html:errors property="minimo"/><br/>
			<html:submit/><html:cancel/>
		</html:form>
	</body>
</html>


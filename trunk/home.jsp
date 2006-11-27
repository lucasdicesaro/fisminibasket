<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>

<%@ page contentType="text/html;charset=ISO-8859-1"%>

<%
    response.setDateHeader("Expires", 0);
    response.setHeader("Cache-Control", "no-cache");
    response.setHeader("Cache-Control", "no-store");
    response.setHeader("Pragma", "no-cache");
%> 


<%@ include file="/log/log.inc"%>

<html:html>
	
	<frameset cols="158,*" frameborder="no" >
	  	<frame noresize="noresize" src="indicehome.jsp" scrolling="no" />
	  	<frame src="index.jsp" name="showframe" />
	</frameset>

</html:html>

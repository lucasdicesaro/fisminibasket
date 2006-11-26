<%@ page language="java" pageEncoding="UTF-8"%>

<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%@ taglib uri="http://displaytag.sf.net" prefix="display"%>

<fieldset><legend>Hoy</legend>

<table align="center" width="90%">

	<tr>
		<td>
			Fichas medicas faltantes:
		</td>
		<td>
			<%=session.getAttribute("fichasFaltantes")%>
		</td>
	</tr>
	<tr>
		<td>
			Avisos faltantes:
		</td>
		<td>
			<%=session.getAttribute("avisosFaltantes")%>
		</td>
	</tr>
		<tr>
		<td>

		</td>
	</tr>
</table>

</fieldset>


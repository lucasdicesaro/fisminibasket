<%@ page language="java" pageEncoding="UTF-8"%>

<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%@ taglib uri="http://displaytag.sf.net" prefix="display"%>

<html:html locale="true">
<head>
<title>Avisos</title>
<html:base />
<link href="../css/displaytag.css" rel="stylesheet" type="text/css">
<META HTTP-EQUIV="Pragma" CONTENT="no-cache">
<META HTTP-EQUIV="Expires" CONTENT="-1">
</head>
<body bgcolor="white">



<fieldset><legend>Avisos</legend>

<table align="center" width="90%">

	<tr>
		<td>
		<display:table name="sessionScope.avisos" pagesize="60" defaultorder="ascending" class="displaytag"
                            export="true" requestURI="/aviso.do">

			<display:column title="Id"      property="aviId"     sortable="true" headerClass="sortable" />

			<display:column title="Jugador" property="jugador"   sortable="true" headerClass="sortable" />

			<display:column title="Estado"  property="aviEstado" sortable="true" headerClass="sortable" />
			
			<display:column title="Fecha"   property="aviFecha"  sortable="true" headerClass="sortable" />

			<display:column title="Tipo"    property="aviTipo"   sortable="true" headerClass="sortable" />


			<display:column title="Modificar" href="../aviso.do?action=setUpdate" paramId="id" paramProperty="avisoId" media="html">
				<div align="center"><img src="../images/icono_editar.gif" width="20" height="10" border="0" /></div>
			</display:column>

			<display:column title="Eliminar"  href="../aviso.do?action=delete"    paramId="id" paramProperty="avisoId" media="html">
				<div align="center"><img src="../images/icono_borrar.gif" width="16" height="9" border="0" /></div>
			</display:column>
		</display:table>
		</td>
	</tr>
	<tr>
		<td colspan="2" align="center">
			<form action="../aviso.do" method="POST">
				<input type="submit" value="Insertar"/>
				<input type="hidden" name="action" value="setInsert" />
			</form>
		</td>
	</tr>
</table>

</fieldset>

</body>
</html:html>

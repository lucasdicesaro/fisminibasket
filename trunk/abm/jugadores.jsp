<%@ page language="java" pageEncoding="UTF-8"%>

<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%@ taglib uri="http://displaytag.sf.net" prefix="display"%>

<html:html locale="true">
<head>
<title>Jugadores</title>
<html:base />
<link href="../css/displaytag.css" rel="stylesheet" type="text/css">
<META HTTP-EQUIV="Pragma" CONTENT="no-cache">
<META HTTP-EQUIV="Expires" CONTENT="-1">
</head>
<body bgcolor="white">



<fieldset><legend>Jugadores</legend>

<table align="center" width="90%">

	<tr>
		<td>
		<display:table name="sessionScope.jugadores" pagesize="60" defaultorder="ascending" class="displaytag"
                            export="true" requestURI="/jugador.do">

			<display:column title="Id"        property="jugId"           sortable="true" headerClass="sortable" />

			<display:column title="Club"      property="club.id.clubId"  sortable="true" headerClass="sortable" />

			<display:column title="Categoria" property="categoria.catId" sortable="true" headerClass="sortable" />
			
			<display:column title="Federado"  property="jugFederado"     sortable="true" headerClass="sortable" />
			
			<display:column title="Nombre"    property="jugNombre"       sortable="true" headerClass="sortable" />
			
			<display:column title="Apellido"  property="jugApellido"     sortable="true" headerClass="sortable" />
			
			<display:column title="Fecha de Nacimiento"    property="jugFechaNac"    sortable="true" headerClass="sortable" />
			
			<display:column title="Modificar" href="../jugador.do?action=setUpdate" paramId="id" paramProperty="jugId" media="html">
				<div align="center"><img src="../images/icono_editar.gif" width="20" height="10" border="0" /></div>
			</display:column>

			<display:column title="Eliminar"  href="../jugador.do?action=delete"  paramId="id" paramProperty="jugId" media="html">
				<div align="center"><img src="../images/icono_borrar.gif" width="16" height="9" border="0" /></div>
			</display:column>
		</display:table>
		</td>
	</tr>
	<tr>
		<td colspan="2" align="center">
			<form action="../jugador.do" method="POST">
				<input type="submit" value="Insertar"/>
				<input type="hidden" name="action" value="setInsert" />
			</form>
		</td>
	</tr>
</table>

</fieldset>

</body>
</html:html>

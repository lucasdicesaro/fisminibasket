<%@ page language="java" pageEncoding="UTF-8"%>

<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%@ taglib uri="http://displaytag.sf.net" prefix="display"%>

<html:html locale="true">
<head>
<title>Permisos</title>
<html:base />
<link href="../css/displaytag.css" rel="stylesheet" type="text/css">
<META HTTP-EQUIV="Pragma" CONTENT="no-cache">
<META HTTP-EQUIV="Expires" CONTENT="-1">
</head>
<body bgcolor="white">



<fieldset><legend>Permisos</legend>

<table align="center" width="90%">

	<tr>
		<td>
		<display:table name="sessionScope.permisos" pagesize="60" defaultorder="ascending" class="displaytag"
                            export="true" requestURI="/permiso.do">

			<display:column title="Id"      property="perId"     sortable="true" headerClass="sortable" />

			<display:column title="Descripcion" property="perDescripcion"   sortable="true" headerClass="sortable" />


			<display:column title="Modificar" href="../permiso.do?action=setUpdate" paramId="id" paramProperty="perId" media="html">
				<div align="center"><img src="../images/icono_editar.gif" width="20" height="10" border="0" /></div>
			</display:column>

			<display:column title="Eliminar"  href="../permiso.do?action=delete"    paramId="id" paramProperty="perId" media="html">
				<div align="center"><img src="../images/icono_borrar.gif" width="16" height="9" border="0" /></div>
			</display:column>
		</display:table>
		</td>
	</tr>
	<tr>
		<td colspan="2" align="center">
			<form action="../per.do" method="POST">
				<input type="submit" value="Insertar"/>
				<input type="hidden" name="action" value="setInsert" />
			</form>
		</td>
	</tr>
</table>

</fieldset>

</body>
</html:html>

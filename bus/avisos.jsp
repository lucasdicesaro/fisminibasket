<%@ page language="java" pageEncoding="UTF-8"%>

<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%@ taglib uri="http://displaytag.sf.net" prefix="display"%>

<html:html locale="true">
<head>
<title>Avisos Faltantes</title>
<html:base />
<link href="../css/displaytag.css" rel="stylesheet" type="text/css">
<META HTTP-EQUIV="Pragma" CONTENT="no-cache">
<META HTTP-EQUIV="Expires" CONTENT="-1">
</head>
<body bgcolor="white">



<fieldset><legend>Avisos Faltantes</legend>

<table align="center" width="90%">

	<tr>
		<td>
		<display:table name="sessionScope.avisosFaltantes" pagesize="60" defaultorder="ascending" class="displaytag"
                            export="true" requestURI="/today.do">

			<display:column title="Id"        property="jugId"           sortable="true" headerClass="sortable" />

			<display:column title="Club"      property="club.cluDescripcion"  sortable="true" headerClass="sortable"
							href="../club.do?action=listOne"
							paramId="id" paramProperty="club.id.clubId"/>

			<display:column title="Categoria" property="categoria.catDescripcion" sortable="true" headerClass="sortable"
							href="../categoria.do?action=listOne"
							paramId="id" paramProperty="categoria.catId"/>
			
			<display:column title="Federado"  property="jugFederado"     sortable="true" headerClass="sortable" />
			
			<display:column title="Nombre"    property="jugNombre"       sortable="true" headerClass="sortable" />
			
			<display:column title="Apellido"  property="jugApellido"     sortable="true" headerClass="sortable" />
			
			<display:column title="Fecha de Nacimiento"    property="jugFechaNac"    sortable="true" headerClass="sortable" />
			
			<display:column title="Crear Aviso" href="../aviso.do?action=setInsert" paramId="jugador" paramProperty="jugId" media="html">
				<div align="center"><img src="../images/icono_editar.gif" width="20" height="10" border="0" /></div>
			</display:column>

		</display:table>
		</td>
	</tr>
</table>

</fieldset>

</body>
</html:html>

<%@ page language="java" pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%@ page import="net.fis.hibernate.*" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%@ taglib uri="http://displaytag.sf.net" prefix="display"%>

<%
				ArrayList permisos = (ArrayList)session.getAttribute("rolpermisos");
				Iterator it = null;
				RolPermiso rolPermiso = null;
%>

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

			<%
				it = permisos.iterator();
				while(it.hasNext())
				{
					rolPermiso = (RolPermiso)it.next();
					if(rolPermiso.getId().getPermiso().getPerDescripcion().equals("Modificar Jugador"))
					{
			%>
			<display:column title="Modificar" href="../jugador.do?action=setUpdate" paramId="id" paramProperty="jugId" media="html">
				<div align="center"><img src="../images/icono_editar.gif" width="20" height="10" border="0" /></div>
			</display:column>
			<%
					}
					if(rolPermiso.getId().getPermiso().getPerDescripcion().equals("Borrar Jugador"))
					{
				
			%>
			<display:column title="Eliminar"  href="../jugador.do?action=delete"  paramId="id" paramProperty="jugId" media="html">
				<div align="center"><img src="../images/icono_borrar.gif" width="16" height="9" border="0" /></div>
			</display:column>
			<%
					}
				}
			%>
		</display:table>
		</td>
	</tr>
			<%
				it = permisos.iterator();
				while(it.hasNext())
				{
					rolPermiso = (RolPermiso)it.next();
					if(rolPermiso.getId().getPermiso().getPerDescripcion().equals("Modificar Jugador"))
					{
			%>
	<tr>
		<td colspan="2" align="center">
			<form action="../jugador.do" method="POST">
				<input type="submit" value="Insertar"/>
				<input type="hidden" name="action" value="setInsert" />
			</form>
		</td>
	</tr>
			<%
					}
				}
			%>
</table>

</fieldset>

</body>
</html:html>

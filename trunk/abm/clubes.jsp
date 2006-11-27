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
<title>Clubes</title>
<html:base />
<link href="../css/displaytag.css" rel="stylesheet" type="text/css">
<META HTTP-EQUIV="Pragma" CONTENT="no-cache">
<META HTTP-EQUIV="Expires" CONTENT="-1">
</head>
<body bgcolor="white">



<fieldset><legend>Clubes</legend>

<table align="center" width="90%">

	<tr>
		<td>
		<display:table name="sessionScope.clubes" pagesize="60" defaultorder="ascending" class="displaytag"
                            export="true" requestURI="/club.do">

			<display:column title="Id"          property="id.clubId"       sortable="true" headerClass="sortable" />

			<display:column title="Federacion"  property="id.federacion.fedDescripcion"   sortable="true" headerClass="sortable"
							href="../federacion.do?action=listOne"
							paramId="id" paramProperty="id.federacion.federacionId"/>

			<display:column title="Descripcion" property="cluDescripcion" sortable="true" headerClass="sortable" />
			
			<display:column title="Federado"    property="cluFederado"    sortable="true" headerClass="sortable" />

			<%
				it = permisos.iterator();
				while(it.hasNext())
				{
					rolPermiso = (RolPermiso)it.next();
					if(rolPermiso.getId().getPermiso().getPerDescripcion().equals("Modificar Club"))
					{
			%>
			<display:column title="Modificar" href="../club.do?action=setUpdate" paramId="id" paramProperty="id.clubId" media="html">
				<div align="center"><img src="../images/icono_editar.gif" width="20" height="10" border="0" /></div>
			</display:column>
			<%
					}
					if(rolPermiso.getId().getPermiso().getPerDescripcion().equals("Borrar Club"))
					{
				
			%>
			<display:column title="Eliminar"  href="../club.do?action=delete"  paramId="id" paramProperty="id.clubId" media="html">
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
					if(rolPermiso.getId().getPermiso().getPerDescripcion().equals("Insertar Club"))
					{
			%>
	<tr>
		<td colspan="2" align="center">
			<form action="../aviso.do" method="POST">
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

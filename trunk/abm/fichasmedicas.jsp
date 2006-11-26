<%@ page language="java" pageEncoding="UTF-8"%>

<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%@ taglib uri="http://displaytag.sf.net" prefix="display"%>

<html:html locale="true">
<head>
<title>Fichas Medicas</title>
<html:base />
<link href="../css/displaytag.css" rel="stylesheet" type="text/css">
<META HTTP-EQUIV="Pragma" CONTENT="no-cache">
<META HTTP-EQUIV="Expires" CONTENT="-1">
</head>
<body bgcolor="white">



<fieldset><legend>Fichas Medicas</legend>

<table align="center" width="90%">

	<tr>
		<td>
		<display:table name="sessionScope.fichasMedicas" pagesize="60" defaultorder="ascending" class="displaytag"
                            export="true" requestURI="/club.do">

			<display:column title="Id"          property="fmId"       sortable="true" headerClass="sortable" />

			<display:column title="Medico"  property="medico.medApellido"   sortable="true" headerClass="sortable"
							href="../medico.do?action=listOne"
							paramId="id" paramProperty="medico.medId"/>

			<display:column title="Jugador" property="jugador.jugApellido" sortable="true" headerClass="sortable"
							href="../jugador.do?action=listOne"
							paramId="id" paramProperty="jugador.jugId"/>

			<display:column title="Estado"    property="fmEstado"    sortable="true" headerClass="sortable" />
			
			<display:column title="Alergias"    property="fmAlergias"    sortable="true" headerClass="sortable" />
			
			<display:column title="Cardiopatias"    property="fmCardiopatias"    sortable="true" headerClass="sortable" />
			
			<display:column title="Antecedentes"    property="fmAntecedentes"    sortable="true" headerClass="sortable" />
			
			<display:column title="Historial"    property="fmHistorial"    sortable="true" headerClass="sortable" />
			
			<display:column title="Buco Dental"    property="fmBucoDen"    sortable="true" headerClass="sortable" />


			<display:column title="Modificar" href="../fichamedica.do?action=setUpdate" paramId="id" paramProperty="fmId" media="html">
				<div align="center"><img src="../images/icono_editar.gif" width="20" height="10" border="0" /></div>
			</display:column>

			<display:column title="Eliminar"  href="../fichamedica.do?action=delete"  paramId="id" paramProperty="fmId" media="html">
				<div align="center"><img src="../images/icono_borrar.gif" width="16" height="9" border="0" /></div>
			</display:column>
		</display:table>
		</td>
	</tr>
	<tr>
		<td colspan="2" align="center">
			<form action="../fichamedica.do" method="POST">
				<input type="submit" value="Insertar"/>
				<input type="hidden" name="action" value="setInsert" />
			</form>
		</td>
	</tr>
</table>

</fieldset>

</body>
</html:html>

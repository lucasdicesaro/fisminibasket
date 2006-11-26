<%@ page language="java" pageEncoding="UTF-8"%>

<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>

<html:html locale="true">
<head>
	<title>
		<logic:equal name="JugadorBean" property="metodo" value="alta">Crear</logic:equal>
		<logic:equal name="JugadorBean" property="metodo" value="modificacion">Modificar</logic:equal>
	</title>
	<html:base />

	<link type="text/css" rel="stylesheet" href="../css/displaytag.css">

	<script type='text/javascript' language="javascript">
	// <![CDATA[

        function validar()
        {
			document.JugadorBean.nacimiento.value = document.JugadorBean.mical.value;

	    	return true;
    	}

	// ]]>
	</script>
	
	<script language="javascript" src="../js/datetimepicker.js" />

	<META HTTP-EQUIV="Pragma" CONTENT="no-cache">
	<META HTTP-EQUIV="Expires" CONTENT="-1">

</head>
<body bgcolor="white">

	<fieldset>
		<logic:equal name="JugadorBean" property="metodo" value="alta">
			<legend>
				Alta
			</legend>
		</logic:equal>
		<logic:equal name="JugadorBean" property="metodo" value="modificacion">
			<legend>
				Modificar
			</legend>
		</logic:equal>

		<html:form action="/jugador" method="POST" onsubmit="return validar();"
			target="_self">
			<table>
				<tr>
					<td>
						Id:
					</td>
					<td>
						<html:hidden property="id" />
						<bean:write name="JugadorBean" property="id" />
					</td>
				</tr>
				<tr>
					<td>
						Nombre:
					</td>
					<td>
						<html:text property="nombre" name="JugadorBean"/>
						<html:errors property="nombre" />
					</td>
				</tr>

				<tr>
					<td>
						Apellido:
					</td>
					<td>
						<html:text property="apellido" name="JugadorBean"/>
						<html:errors property="apellido" />
					</td>
				</tr>

				<tr>
					<td>
						Fecha de Nacimiento:
					</td>
					<td>
						<html:hidden property="nacimiento" name="JugadorBean"/>
						<html:errors property="nacimiento" />
						<input name="mical" id="mical" type="text" size="25" disabled value="<bean:write name="JugadorBean" property="nacimiento" />" />
        				<a href="javascript:NewCal('mical','ddmmyyyy',true,24)">
							<img src="../images/cal.gif" width="16" height="16" border="0" alt="Seleccione una fecha" />
						</a>
					</td>
				</tr>

				<tr>
					<td>
						Federado:
					</td>
					<td>
						<html:select property="federado" name="JugadorBean" >
							<html:option value="S">Si</html:option>
							<html:option value="N">No</html:option>
						</html:select>
						<html:errors property="federado" />
					</td>
				</tr>

				<tr>
					<td>
						Categoria:
					</td>
					<td>
						<html:select property="categoria" >
							<html:optionsCollection name="categorias" value="catId" label="catDescripcion"/>
						</html:select>
						<html:errors property="categoria" />
					</td>
				</tr>

				<tr>
					<td>
						Club:
					</td>
					<td>
						<html:hidden property="federacion" name="JugadorBean" />
						<html:select property="club" >
							<html:optionsCollection name="clubes" value="id.clubId" label="cluDescripcion"/>
						</html:select>
						<html:errors property="club" />
					</td>
				</tr>


				<tr>
					<td colspan="2">
						<center>
							<logic:equal name="JugadorBean" property="metodo" value="alta">
								<html:hidden property="action" value="insert" />
								<html:cancel value="Cancelar" />
								<html:reset value="Resetear" />
								<html:submit value="Crear" />
							</logic:equal>
							<logic:equal name="JugadorBean" property="metodo"
								value="modificacion">
								<html:hidden property="action" value="update" />
								<input type="submit" value="Modificar" />
							</logic:equal>
						</center>
					<td>
				</tr>
			</table>
		</html:form>

	</fieldset>

</body>
</html:html>

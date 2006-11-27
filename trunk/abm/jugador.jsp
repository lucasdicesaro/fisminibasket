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

	<link type="text/css" rel="stylesheet" href="../css/displaytag.css" />

	<script type='text/javascript' language="javascript">
	// <![CDATA[

        function validar()
        {
			document.JugadorBean.nacimiento.value = document.JugadorBean.mical.value;
			nombre     = document.JugadorBean.nombre.value;
			apellido   = document.JugadorBean.apellido.value;
			nacimiento = document.JugadorBean.nacimiento.value;
			federado   = document.JugadorBean.federado.value;
			categoria  = document.JugadorBean.categoria.value;
			club       = document.JugadorBean.club.value;

			if(nombre == "")
			{
				alert("Complete el campo Nombre");
				return false;
			}
			if(apellido == "")
			{
				alert("Complete el campo Apellido");
				return false;
			}
			if(nacimiento == "")
			{
				alert("Complete el campo Nacimiento");
				return false;
			}
			if(federado == "")
			{
				alert("Complete el campo Federado");
				return false;
			}
			if(categoria == "")
			{
				alert("Complete el campo Categoria");
				return false;
			}
			if(club == "")
			{
				alert("Complete el campo Club");
				return false;
			}

	    	return true;
    	}

	// ]]>
	</script>
	
	<script language="javascript">
	// <![CDATA[
		function modificar()
		{
			document.forms[0].action.value = "setUpdate";
			document.forms[0].submit();
		}
		function borrar(form)
		{
			document.forms[0].action.value = "delete";
			document.forms[0].submit();
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
		<logic:equal name="JugadorBean" property="metodo" value="mostrar">
			<legend>
				Mostrar
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
						<logic:notEqual name="JugadorBean" property="metodo" value="mostrar">
							<html:text property="nombre" name="JugadorBean"/>
							<html:errors property="nombre" />
						</logic:notEqual>
						<logic:equal name="JugadorBean" property="metodo" value="mostrar">
							<bean:write property="nombre" name="JugadorBean"/>
						</logic:equal>
					</td>
				</tr>

				<tr>
					<td>
						Apellido:
					</td>
					<td>
						<logic:notEqual name="JugadorBean" property="metodo" value="mostrar">
							<html:text property="apellido" name="JugadorBean"/>
							<html:errors property="apellido" />
						</logic:notEqual>
						<logic:equal name="JugadorBean" property="metodo" value="mostrar">
							<bean:write property="apellido" name="JugadorBean"/>
						</logic:equal>
					</td>
				</tr>

				<tr>
					<td>
						Fecha de Nacimiento:
					</td>
					<td>
						<logic:notEqual name="JugadorBean" property="metodo" value="mostrar">
							<html:hidden property="nacimiento" name="JugadorBean"/>
							<html:errors property="nacimiento" />
							<input name="mical" id="mical" type="text" size="25" disabled value='<bean:write name="JugadorBean" property="nacimiento" />' />
        					<a href="javascript:NewCal('mical','ddmmyyyy',true,24)">
								<img src="../images/cal.gif" width="16" height="16" border="0" alt="Seleccione una fecha" />
							</a>
						</logic:notEqual>
						<logic:equal name="JugadorBean" property="metodo" value="mostrar">
							<bean:write property="nacimiento" name="JugadorBean"/>
						</logic:equal>
					</td>
				</tr>

				<tr>
					<td>
						Federado:
					</td>
					<td>
						<logic:notEqual name="JugadorBean" property="metodo" value="mostrar">
						<html:select property="federado" name="JugadorBean" >
							<html:option value="S">Si</html:option>
							<html:option value="N">No</html:option>
						</html:select>
						<html:errors property="federado" />
						</logic:notEqual>
						<logic:equal name="JugadorBean" property="metodo" value="mostrar">
							<bean:write property="federado" name="JugadorBean"/>
						</logic:equal>
					</td>
				</tr>

				<tr>
					<td>
						Categoria:
					</td>
					<td>
						<logic:notEqual name="JugadorBean" property="metodo" value="mostrar">
							<html:select property="categoria" >
								<html:optionsCollection name="categorias" value="catId" label="catDescripcion"/>
							</html:select>
							<html:errors property="categoria" />
						</logic:notEqual>
						<logic:equal name="JugadorBean" property="metodo" value="mostrar">
							<bean:write property="categoria" name="JugadorBean"/>
						</logic:equal>
					</td>
				</tr>

				<tr>
					<td>
						Club:
					</td>
					<td>
						<logic:notEqual name="JugadorBean" property="metodo" value="mostrar">
						<html:hidden property="federacion" name="JugadorBean" />
						<html:select property="club" >
							<html:optionsCollection name="clubes" value="id.clubId" label="cluDescripcion"/>
						</html:select>
						<html:errors property="club" />
						</logic:notEqual>
						<logic:equal name="JugadorBean" property="metodo" value="mostrar">
							<bean:write property="club" name="JugadorBean"/>
						</logic:equal>
					</td>
				</tr>


				<tr>
					<td colspan="2">
						<center>
							<logic:equal name="JugadorBean" property="metodo" value="alta">
								<html:hidden property="action" value="insert" />
								<html:cancel value="Cancelar" />
								<html:reset  value="Resetear" />
								<html:submit value="Crear" />
							</logic:equal>
							<logic:equal name="JugadorBean" property="metodo" value="modificacion">
								<html:hidden property="action" value="update" />
								<input type="submit" value="Modificar" />
							</logic:equal>
							<logic:equal name="JugadorBean" property="metodo" value="mostrar">
								<input type="button" onClick="javascript:borrar()"    value="Borrar">
								<input type="button" onClick="javascript:modificar()" value="Modificar">
								<input type="hidden" name="action" value=""/>
							</logic:equal>
						</center>
					<td>
				</tr>
			</table>
		</html:form>

	</fieldset>

</body>
</html:html>

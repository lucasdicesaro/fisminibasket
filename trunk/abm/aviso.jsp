<%@ page language="java" pageEncoding="UTF-8"%>

<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>

<html:html locale="true">
<head>
	<title>
		<logic:equal name="AvisoBean" property="metodo" value="alta">Crear</logic:equal>
		<logic:equal name="AvisoBean" property="metodo" value="modificacion">Modificar</logic:equal>
	</title>
	<html:base />

	<link type="text/css" rel="stylesheet" href="../css/displaytag.css">

	<script type='text/javascript' language="javascript">
	// <![CDATA[

        function validar()
        {
			fecha       = document.AvisoBean.fecha.value;
			estado      = document.AvisoBean.estado.value;
			tipo        = document.AvisoBean.tipo.value;
			jugador     = document.AvisoBean.jugador.value;

			if(fecha == "")
			{
				alert("Complete el campo Fecha");
				return false;
			}
			if(estado == "")
			{
				alert("Complete el campo Estado");
				return false;
			}
			if(tipo == "")
			{
				alert("Complete el campo Tipo");
				return false;
			}
			if(jugador == "")
			{
				alert("Complete el campo Jugador");
				return false;
			}
	    	return true;
    	}

	// ]]>
	</script>

	<META HTTP-EQUIV="Pragma" CONTENT="no-cache">
	<META HTTP-EQUIV="Expires" CONTENT="-1">

</head>
<body bgcolor="white">

	<fieldset>
		<logic:equal name="AvisoBean" property="metodo" value="alta">
			<legend>
				Alta
			</legend>
		</logic:equal>
		<logic:equal name="AvisoBean" property="metodo" value="modificacion">
			<legend>
				Modificar
			</legend>
		</logic:equal>
		<logic:equal name="AvisoBean" property="metodo" value="modificacion">
			<legend>
				Mostrar
			</legend>
		</logic:equal>

		<html:form action="/aviso" method="POST" onsubmit="return validar();"
			target="_self">
			<table>
				<tr>
					<td>
						Id:
					</td>
					<td>
						<html:hidden property="id" />
						<bean:write name="AvisoBean" property="id" />
					</td>
				</tr>
				<tr>
					<td>
						Fecha:
					</td>
					<td>
						<html:text property="fecha" name="AvisoBean"/>
						<html:errors property="fecha" />
					</td>
				</tr>

				<tr>
					<td>
						Estado:
					</td>
					<td>
						<html:text property="estado" name="AvisoBean"/>
						<html:errors property="estado" />
					</td>
				</tr>

				<tr>
					<td>
						Tipo:
					</td>
					<td>
						<html:text property="tipo" name="AvisoBean" />
						<html:errors property="tipo" />
					</td>
				</tr>

				<tr>
					<td>
						Jugador:
					</td>
					<td>
						<html:text property="jugador" name="AvisoBean" />
						<html:errors property="jugador" />
					</td>
				</tr>

				<tr>
					<td colspan="2">
						<center>
							<logic:equal name="AvisoBean" property="metodo" value="alta">
								<html:hidden property="action" value="insert" />
								<html:cancel value="Cancelar" />
								<html:reset value="Resetear" />
								<html:submit value="Crear" />
							</logic:equal>
							<logic:equal name="AvisoBean" property="metodo"
								value="modificacion">
								<html:hidden property="action" value="update" />
								<input type="submit" value="Modificar" />
							</logic:equal>
							<logic:equal name="AvisoBean" property="metodo" value="mostrar">
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


<%@ page language="java" pageEncoding="UTF-8"%>

<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>

<html:html locale="true">
<head>
	<title>
		<logic:equal name="FichaMedicaBean" property="metodo" value="alta">Crear</logic:equal>
		<logic:equal name="FichaMedicaBean" property="metodo" value="modificacion">Modificar</logic:equal>
	</title>
	<html:base />

	<link type="text/css" rel="stylesheet" href="../css/displaytag.css">

	<script type='text/javascript' language="javascript">
	// <![CDATA[

        function validar()
        {
			atn       = document.FichaMedicaBean.antecedentes.value;
			car       = document.FichaMedicaBean.cardiopatias.value;
			ale       = document.FichaMedicaBean.alergias.value;
			his       = document.FichaMedicaBean.historial.value;
			est       = document.FichaMedicaBean.estado.value;
			med       = document.FichaMedicaBean.medico.value;
			jug       = document.FichaMedicaBean.jugador.value;

			if(atn == "")
			{
				alert("Complete el campo Antecedentes");
				return false;
			}
			if(car == "")
			{
				alert("Complete el campo Cardiopatias");
				return false;
			}
			if(ale == "")
			{
				alert("Complete el campo Alergias");
				return false;
			}
			if(his == "")
			{
				alert("Complete el campo Historial");
				return false;
			}
			if(est == "")
			{
				alert("Complete el campo Estado");
				return false;
			}
			if(med == "")
			{
				alert("Complete el campo Medico");
				return false;
			}
			if(jug == "")
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
		<logic:equal name="FichaMedicaBean" property="metodo" value="alta">
			<legend>
				Alta
			</legend>
		</logic:equal>
		<logic:equal name="FichaMedicaBean" property="metodo" value="modificacion">
			<legend>
				Modificar
			</legend>
		</logic:equal>

		<html:form action="/fichamedica" method="POST" onsubmit="return validar();"
			target="_self">
			<table>
				<tr>
					<td>
						Id:
					</td>
					<td>
						<html:hidden property="id" />
						<bean:write name="FichaMedicaBean" property="id" />
					</td>
				</tr>
				<tr>
					<td>
						Anecedentes:
					</td>
					<td>
						<html:text property="antecedentes" name="FichaMedicaBean"/>
						<html:errors property="antecedentes" />
					</td>
				</tr>

				<tr>
					<td>
						Cardiopatias:
					</td>
					<td>
						<html:text property="cardiopatias" name="FichaMedicaBean"/>
						<html:errors property="cardiopatias" />
					</td>
				</tr>

				<tr>
					<td>
						Alergias:
					</td>
					<td>
						<html:text property="alergias" name="FichaMedicaBean" />
						<html:errors property="alergias" />
					</td>
				</tr>


				<tr>
					<td>
						Historial:
					</td>
					<td>
						<html:text property="historial" name="FichaMedicaBean" />
						<html:errors property="historial" />
					</td>
				</tr>


				<tr>
					<td>
						Estado:
					</td>
					<td>
						<html:text property="estado" name="FichaMedicaBean" />
						<html:errors property="estado" />
					</td>
				</tr>


				<tr>
					<td>
						Medico:
					</td>
					<td>
						<html:text property="medico" name="FichaMedicaBean" />
						<html:errors property="medico" />
					</td>
				</tr>


				<tr>
					<td>
						Jugador:
					</td>
					<td>
						<html:text property="jugador" name="FichaMedicaBean" />
						<html:errors property="jugador" />
					</td>
				</tr>

				<tr>
					<td colspan="2">
						<center>
							<logic:equal name="FichaMedicaBean" property="metodo" value="alta">
								<html:hidden property="action" value="insert" />
								<html:cancel value="Cancelar" />
								<html:reset value="Resetear" />
								<html:submit value="Crear" />
							</logic:equal>
							<logic:equal name="FichaMedicaBean" property="metodo"
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

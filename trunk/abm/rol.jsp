<%@ page language="java" pageEncoding="UTF-8"%>

<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>

<html:html locale="true">
<head>
	<title>
		<logic:equal name="RolBean" property="metodo" value="alta">Crear</logic:equal>
		<logic:equal name="RolBean" property="metodo" value="modificacion">Modificar</logic:equal>
	</title>
	<html:base />

	<link type="text/css" rel="stylesheet" href="../css/displaytag.css">

	<script type='text/javascript' language="javascript">
	// <![CDATA[

        function validar()
        {
			desc       = document.RolBean.descripcion.value;

			if(desc == "")
			{
				alert("Complete el campo Descripcion");
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

	<META HTTP-EQUIV="Pragma" CONTENT="no-cache">
	<META HTTP-EQUIV="Expires" CONTENT="-1">

</head>
<body bgcolor="white">

	<fieldset>
		<logic:equal name="RolBean" property="metodo" value="alta">
			<legend>
				Alta
			</legend>
		</logic:equal>
		<logic:equal name="RolBean" property="metodo" value="modificacion">
			<legend>
				Modificar
			</legend>
		</logic:equal>
		<logic:equal name="RolBean" property="metodo" value="mostrar">
			<legend>
				Mostrar
			</legend>
		</logic:equal>


		<html:form action="/rol" method="POST" onsubmit="return validar();"
			target="_self">
			<table>
				<tr>
					<td>
						Id:
					</td>
					<td>
						<html:hidden property="id" />
						<bean:write name="RolBean" property="id" />
					</td>
				</tr>
				<tr>
					<td>
						Descripcion:
					</td>
					<td>
						<logic:notEqual name="RolBean" property="metodo" value="mostrar">
							<html:text property="descripcion" name="RolBean"/>
							<html:errors property="descripcion" />
						</logic:notEqual>
						<logic:equal name="RolBean" property="metodo" value="mostrar">
							<bean:write name="RolBean" property="descripcion" />
						</logic:equal>
					</td>
				</tr>

				<tr>
					<td colspan="2">
						<center>
							<logic:equal name="RolBean" property="metodo" value="alta">
								<html:hidden property="action" value="insert" />
								<html:cancel value="Cancelar" />
								<html:reset value="Resetear" />
								<html:submit value="Crear" />
							</logic:equal>
							<logic:equal name="RolBean" property="metodo"
								value="modificacion">
								<html:hidden property="action" value="update" />
								<input type="submit" value="Modificar" />
							</logic:equal>
							<logic:equal name="RolBean" property="metodo" value="mostrar">
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

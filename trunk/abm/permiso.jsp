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
			desc       = document.FederacionBean.descripcion.value;

			if(desc == "")
			{
				alert("Complete el campo Descripcion");
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
		<logic:equal name="PermisoBean" property="metodo" value="alta">
			<legend>
				Alta
			</legend>
		</logic:equal>
		<logic:equal name="PermisoBean" property="metodo" value="modificacion">
			<legend>
				Modificar
			</legend>
		</logic:equal>

		<html:form action="/permiso" method="POST" onsubmit="return validar();"
			target="_self">
			<table>
				<tr>
					<td>
						Id:
					</td>
					<td>
						<html:hidden property="id" />
						<bean:write name="PermisoBean" property="id" />
					</td>
				</tr>
				<tr>
					<td>
						Descripcion:
					</td>
					<td>
						<html:text property="descripcion" name="PermisoBean"/>
						<html:errors property="descripcion" />
					</td>
				</tr>

				<tr>
					<td colspan="2">
						<center>
							<logic:equal name="PermisoBean" property="metodo" value="alta">
								<html:hidden property="action" value="insert" />
								<html:cancel value="Cancelar" />
								<html:reset value="Resetear" />
								<html:submit value="Crear" />
							</logic:equal>
							<logic:equal name="PermisoBean" property="metodo"
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

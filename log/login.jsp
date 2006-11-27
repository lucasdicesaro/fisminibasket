<%@ page language="java" pageEncoding="UTF-8"%>

<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>


<html:html locale="true">
<head>
	<title>Login</title>
	<html:base />

	<script type='text/javascript' language="javascript">
	// <![CDATA[

        function validar()
        {
			id       = document.UsuarioBean.id.value;
			password = document.UsuarioBean.password.value;

			if(id == "")
			{
				alert("Complete el campo Id");
				return false;
			}
			if(password == "")
			{
				alert("Complete el campo Password");
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
		<legend>
			Login
		</legend>

		<br>
		<html:form action="/usuario" method="POST" onsubmit="return validar();" target="_self">
			<table>
				<tr>
					<td>
						Identificador:
						<br>
					</td>
					<td>
						<html:text property="id" />
						<br>
					</td>
				</tr>
				<tr>
					<td>
						Password:
						<br>
					</td>
					<td>
						<html:password property="password" />
						<html:messages id="msg" message="true" property="password" >
							<bean:write name="msg"/><br>
						</html:messages>
						<br>
					</td>
				</tr>


				<tr>
					<td colspan="2">
						<center>
							<html:hidden property="action" value="validar" />
							<html:cancel value="Cancelar" />
							<html:reset value="Resetear" />
							<html:submit value="Ingresar" />
						</center>
					</td>
				</tr>
			</table>
		</html:form>
	</fieldset>

</body>
</html:html>

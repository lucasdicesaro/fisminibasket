<%@ page language="java" pageEncoding="UTF-8"%>

<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>


<html:html locale="true">
<head>
	<title>Login</title>
	<html:base />
	<link rel="stylesheet" href="../css/form.css" type="text/css" media="screen, print"/>
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
<body bgcolor="#666666">

	<html:form action="/usuario" method="POST" onsubmit="return validar();" target="_self">
		
		<table align="center" width="760" border="0" cellpadding="0" cellspacing="0" style="border-collapse: collapse">
		    <tr align="right" valign="bottom">
		      <td colspan="10" height="69" background="../images/encabezado.gif">&nbsp;</td>
		    </tr>
		</table>		
	    <table width="760" border="0" cellspacing="0" cellpadding="0" bgcolor="#B2B296" align="center">
			<tr>
				<td>

				<table height="100" border="0" align="center" cellpadding="3" cellspacing="1" bgcolor="#CCCCCC" class="texto3">
				
					<tr>
						<td class="formNombre" >User Id:</td>
						<td class="formDato">
							<html:text property="id" />
							<br>
						</td>
					</tr>
					<tr>
						<td class="formNombre" >Password:</td>
						<td>
							<html:password property="password" />
						</td>
					</tr>
					<logic:notEmpty name="msg">
					<tr>
						<td class="formNombre" >Mensaje: </td>
						<td class="formDato">
							<html:messages id="msg" message="true" property="password" >
								<bean:write name="msg"/><br>
							</html:messages>
						</td>
					</tr>
					</logic:notEmpty>
					<tr>
						<td colspan="2" class="formAreaBotones">
							<center>
								<html:hidden property="action" value="validar" />
								<html:submit styleClass="formBoton" value="Ingresar" tabindex="0"/>
								<html:cancel styleClass="formBoton" value="Cancelar" />
								<html:reset styleClass="formBoton" value="Resetear" />
							</center>
						</td>
					</tr>
				</table>
				
				</td>
			</tr>
		</table>
	</html:form>
</body>
</html:html>

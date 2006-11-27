package net.fis.struts;


/*
 * Generated by MyEclipse Struts
 * Template path: templates/java/JavaClass.vtl
 */
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.fis.hibernate.Rol;
import net.fis.hibernate.RolDAO;
import net.fis.hibernate.Usuario;
import net.fis.hibernate.UsuarioDAO;

import org.apache.commons.beanutils.PropertyUtils;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;
import org.apache.struts.action.DynaActionForm;
import org.apache.struts.actions.DispatchAction;


/**
 * MyEclipse Struts Creation date: 11-16-2006
 * 
 * XDoclet definition:
 * 
 * @struts.action input="/abm/aviso.jsp" validate="true"
 */
public class UsuarioAction extends DispatchAction
{

    /**
     * 
     * @param newMessage
     * @param request
     */
    public void setActionMessages(String key, String newMessage, HttpServletRequest request)
    {

        ActionMessages messages = new ActionMessages();
        ActionMessage message = new ActionMessage(newMessage);

        messages.add(key, message);
        saveMessages(request, messages);
    }

    /**
     * 
     * @param mapping
     * @param form
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    public ActionForward listAll(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception
    {

        HttpSession session = request.getSession();

        UsuarioDAO usuarioDAO = new UsuarioDAO();

        List resultados = usuarioDAO.findAll(" order by usuId");

        session.setAttribute("usuarios", resultados);
        ActionForward forward = mapping.findForward("usuarios");

        return forward;

    }

    /**
     * 
     * @param mapping
     * @param form
     * @param request
     * @param response
     * @throws Exception
     */
    public void show(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception
    {

        UsuarioDAO usuarioDAO = new UsuarioDAO();
        DynaActionForm daf = (DynaActionForm) form;
        Usuario usuario = usuarioDAO.findById(new Integer((String) daf.getString("id")));

        daf.set("id",       String.valueOf(usuario.getUsuId()));
        daf.set("rol",      String.valueOf(usuario.getRol().getRolId()));
        daf.set("nombre",   usuario.getUsuNombre());
        daf.set("apellido", usuario.getUsuApellido());
        daf.set("password", usuario.getUsuPassword());

    }

    /**
     * 
     * @param mapping
     * @param form
     * @param request
     * @param response
     * @throws Exception
     */
    public ActionForward validar(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        HttpSession session = request.getSession();
        ActionForward forward = null;
        
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        DynaActionForm daf = (DynaActionForm) form;
        Usuario usuario = usuarioDAO.findById(new Integer((String) daf.getString("id")));

        String password = (String) daf.getString("password");
        
        if(password.equals(usuario.getUsuPassword()))
        {
            session.setAttribute("usuario", usuario.getUsuId());
            forward = mapping.findForward("valido");
        }
        else
        {
            forward = mapping.findForward("invalido");
            setActionMessages("password", "usuario.passwordError", request);
        }
        
        return forward;
    }

    /**
     * 
     * @param mapping
     * @param form
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    public ActionForward listOne(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception
    {

        show(mapping, form, request, response);

        DynaActionForm daf = (DynaActionForm) form;

        daf.set("metodo", "mostrar");
        ActionForward forward = mapping.findForward("select");

        return forward;
    }

    /**
     * 
     * @param mapping
     * @param form
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    public ActionForward setInsert(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception
    {

        DynaActionForm daf = (DynaActionForm) form;
        daf.set("metodo", "alta");

        ActionForward forward = mapping.findForward("create");

        return forward;
    }

    /**
     * 
     * @param mapping
     * @param form
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    public ActionForward insert(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception
    {

        Usuario usuario = new Usuario();
        RolDAO rolDAO = new RolDAO();
        Rol rol = rolDAO.findById(new Integer((String) PropertyUtils.getSimpleProperty(form, "rol")));
        usuario.setRol(rol);
        usuario.setUsuApellido((String) PropertyUtils.getSimpleProperty(form, "apellido"));
        usuario.setUsuNombre((String) PropertyUtils.getSimpleProperty(form, "nombre"));
        usuario.setUsuPassword((String) PropertyUtils.getSimpleProperty(form, "password"));

        UsuarioDAO usuarioDAO = new UsuarioDAO();
        usuarioDAO.save(usuario);

        ActionForward forward = mapping.findForward("success");

        return forward;
    }

    /**
     * 
     * @param mapping
     * @param form
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    public ActionForward delete(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception
    {

        Usuario usuario = new Usuario();
        usuario.setUsuId(new Integer((String) PropertyUtils.getSimpleProperty(form, "id")));

        UsuarioDAO usuarioDAO = new UsuarioDAO();
        usuarioDAO.delete(usuario);

        ActionForward forward = mapping.findForward("success");

        return forward;
    }

    /**
     * 
     * @param mapping
     * @param form
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    public ActionForward setUpdate(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception
    {

        show(mapping, form, request, response);

        DynaActionForm daf = (DynaActionForm) form;

        daf.set("metodo", "modificacion");
        ActionForward forward = mapping.findForward("update");

        return forward;
    }

    /**
     * 
     * @param mapping
     * @param form
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    public ActionForward update(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception
    {

        Usuario usuario = new Usuario();
        usuario.setUsuId(new Integer((String) PropertyUtils.getSimpleProperty(form, "id")));
        RolDAO rolDAO = new RolDAO();
        Rol rol = rolDAO.findById(new Integer((String) PropertyUtils.getSimpleProperty(form, "rol")));
        usuario.setRol(rol);
        usuario.setUsuApellido((String) PropertyUtils.getSimpleProperty(form, "apellido"));
        usuario.setUsuNombre((String) PropertyUtils.getSimpleProperty(form, "nombre"));
        usuario.setUsuPassword((String) PropertyUtils.getSimpleProperty(form, "password"));

        UsuarioDAO usuarioDAO = new UsuarioDAO();
        usuarioDAO.update(usuario);

        ActionForward forward = mapping.findForward("success");

        return forward;
    }

    /**
     * 
     * @param mapping
     * @param form
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    public ActionForward unespecified(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception
    {

        return (mapping.findForward("error"));
    }

}
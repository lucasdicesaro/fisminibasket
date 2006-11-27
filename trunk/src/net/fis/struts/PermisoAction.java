package net.fis.struts;


/*
 * Generated by MyEclipse Struts
 * Template path: templates/java/JavaClass.vtl
 */
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.fis.hibernate.Permiso;
import net.fis.hibernate.PermisoDAO;

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
public class PermisoAction extends DispatchAction
{

    /**
     * 
     * @param newMessage
     * @param request
     */
    public void setActionMessages(String newMessage, HttpServletRequest request)
    {

        ActionMessages messages = new ActionMessages();
        ActionMessage message = new ActionMessage(newMessage);

        messages.add(ActionMessages.GLOBAL_MESSAGE, message);
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

        PermisoDAO permisoDAO = new PermisoDAO();

        List resultados = permisoDAO.findAll(" order by perId");

        session.setAttribute("permisos", resultados);
        ActionForward forward = mapping.findForward("permisos");

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

        PermisoDAO permisoDAO = new PermisoDAO();
        DynaActionForm daf = (DynaActionForm) form;
        Permiso permiso = permisoDAO.findById(new Integer((String) daf.getString("id")));

        daf.set("id", String.valueOf(permiso.getPerId()));
        daf.set("descripcion", String.valueOf(permiso.getPerDescripcion()));
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

        Permiso permiso = new Permiso();
        permiso.setPerDescripcion((String) PropertyUtils.getSimpleProperty(form, "descripcion"));

        PermisoDAO permisoDAO = new PermisoDAO();
        permisoDAO.save(permiso);

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

        Permiso permiso = new Permiso();
        permiso.setPerId(new Integer((String) PropertyUtils.getSimpleProperty(form, "id")));

        PermisoDAO permisoDAO = new PermisoDAO();
        permisoDAO.delete(permiso);

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

        Permiso permiso = new Permiso();
        permiso.setPerId(new Integer((String) PropertyUtils.getSimpleProperty(form, "id")));
        permiso.setPerDescripcion((String) PropertyUtils.getSimpleProperty(form, "descripcion"));

        PermisoDAO permisoDAO = new PermisoDAO();
        permisoDAO.update(permiso);

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

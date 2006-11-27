package net.fis.struts;


/*
 * Generated by MyEclipse Struts
 * Template path: templates/java/JavaClass.vtl
 */
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.fis.hibernate.Federacion;
import net.fis.hibernate.FederacionDAO;

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
 * @struts.action input="/federacion" validate="true"
 */
public class FederacionAction extends DispatchAction
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

        FederacionDAO federacionDAO = new FederacionDAO();

        List resultados = federacionDAO.findAll(" order by federacionId");

        session.setAttribute("federaciones", resultados);
        ActionForward forward = mapping.findForward("federaciones");

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

        FederacionDAO federacionDAO = new FederacionDAO();
        DynaActionForm daf = (DynaActionForm) form;
        Federacion federacion = federacionDAO.findById(new Integer((String) daf.getString("id")));

        daf.set("id", String.valueOf(federacion.getFederacionId()));
        daf.set("descripcion", federacion.getFedDescripcion());
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

        Federacion federacion = new Federacion();
        federacion.setFedDescripcion((String) PropertyUtils.getSimpleProperty(form, "descripcion"));

        FederacionDAO federacionDAO = new FederacionDAO();
        federacionDAO.save(federacion);

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

        FederacionDAO federacionDAO = new FederacionDAO();
        Federacion federacion = federacionDAO.findById(new Integer((String) PropertyUtils.getSimpleProperty(form, "id")));
        federacionDAO.delete(federacion);

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

        Federacion federacion = new Federacion();
        federacion.setFederacionId(new Integer((String) PropertyUtils.getSimpleProperty(form, "id")));
        federacion.setFedDescripcion((String) PropertyUtils.getSimpleProperty(form, "descripcion"));

        FederacionDAO federacionDAO = new FederacionDAO();
        federacionDAO.update(federacion);

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
        return listAll(mapping, form, request, response);
    }

}

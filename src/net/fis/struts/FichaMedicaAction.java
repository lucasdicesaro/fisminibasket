package net.fis.struts;


/*
 * Generated by MyEclipse Struts
 * Template path: templates/java/JavaClass.vtl
 */
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.fis.hibernate.FichaMedica;
import net.fis.hibernate.FichaMedicaDAO;
import net.fis.hibernate.JugadorDAO;
import net.fis.hibernate.MedicoDAO;

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
 * @struts.action input="/abm/fichamedica.jsp" validate="true"
 */
public class FichaMedicaAction extends DispatchAction
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

        FichaMedicaDAO fichaMedicaDAO = new FichaMedicaDAO();

        List resultados = fichaMedicaDAO.findAll(" order by fmId");

        session.setAttribute("fichaMedicaes", resultados);
        ActionForward forward = mapping.findForward("fichaMedicaes");

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

        FichaMedicaDAO fichaMedicaDAO = new FichaMedicaDAO();
        DynaActionForm daf = (DynaActionForm) form;
        FichaMedica fichaMedica = fichaMedicaDAO.findById(new Integer((String) daf.getString("id")));

        daf.set("antecedentes", String.valueOf(fichaMedica.getFmAntecedentes()));
        daf.set("cardiopatias", String.valueOf(fichaMedica.getFmCardiopatias()));
        daf.set("alergias", String.valueOf(fichaMedica.getFmAlergias()));
        daf.set("historial", String.valueOf(fichaMedica.getFmHistorial()));
        daf.set("medico", String.valueOf(fichaMedica.getMedico().getMedId()));
        daf.set("estado", String.valueOf(fichaMedica.getFmEstado()));
        daf.set("buco", String.valueOf(fichaMedica.getFmBucoDen()));
        daf.set("jugador", String.valueOf(fichaMedica.getJugador().getJugId()));
        daf.set("id", String.valueOf(fichaMedica.getFmId()));
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

        FichaMedica fichaMedica = new FichaMedica();
        fichaMedica.setFmAntecedentes((String) PropertyUtils.getSimpleProperty(form, "antecedentes"));
        fichaMedica.setFmCardiopatias((String) PropertyUtils.getSimpleProperty(form, "cardiopatias"));
        fichaMedica.setFmAlergias((String) PropertyUtils.getSimpleProperty(form, "alergias"));
        fichaMedica.setFmHistorial((String) PropertyUtils.getSimpleProperty(form, "historial"));
        MedicoDAO medicoDAO = new MedicoDAO();
        fichaMedica.setMedico(medicoDAO.findById(new Integer((String) PropertyUtils.getSimpleProperty(form, "medico"))));
        fichaMedica.setFmEstado((String) PropertyUtils.getSimpleProperty(form, "estado"));
        fichaMedica.setFmBucoDen((String) PropertyUtils.getSimpleProperty(form, "buco"));
        JugadorDAO jugadorDAO = new JugadorDAO();
        fichaMedica.setJugador(jugadorDAO.findById(new Integer((String) PropertyUtils.getSimpleProperty(form, "jugador"))));

        FichaMedicaDAO fichaMedicaDAO = new FichaMedicaDAO();
        fichaMedicaDAO.save(fichaMedica);

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

        FichaMedica fichaMedica = new FichaMedica();
        fichaMedica.setFmId(new Integer((String) PropertyUtils.getSimpleProperty(form, "id")));

        FichaMedicaDAO fichaMedicaDAO = new FichaMedicaDAO();
        fichaMedicaDAO.delete(fichaMedica);

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

        FichaMedica fichaMedica = new FichaMedica();
        fichaMedica.setFmId(new Integer((String) PropertyUtils.getSimpleProperty(form, "id")));
        fichaMedica.setFmAntecedentes((String) PropertyUtils.getSimpleProperty(form, "antecedentes"));
        fichaMedica.setFmCardiopatias((String) PropertyUtils.getSimpleProperty(form, "cardiopatias"));
        fichaMedica.setFmAlergias((String) PropertyUtils.getSimpleProperty(form, "alergias"));
        fichaMedica.setFmHistorial((String) PropertyUtils.getSimpleProperty(form, "historial"));
        MedicoDAO medicoDAO = new MedicoDAO();
        fichaMedica.setMedico(medicoDAO.findById(new Integer((String) PropertyUtils.getSimpleProperty(form, "medico"))));
        fichaMedica.setFmEstado((String) PropertyUtils.getSimpleProperty(form, "estado"));
        fichaMedica.setFmBucoDen((String) PropertyUtils.getSimpleProperty(form, "buco"));
        JugadorDAO jugadorDAO = new JugadorDAO();
        fichaMedica.setJugador(jugadorDAO.findById(new Integer((String) PropertyUtils.getSimpleProperty(form, "jugador"))));

        FichaMedicaDAO fichaMedicaDAO = new FichaMedicaDAO();
        fichaMedicaDAO.update(fichaMedica);

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

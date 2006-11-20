package net.fis.struts;


import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.fis.hibernate.CategoriaDAO;
import net.fis.hibernate.ClubDAO;
import net.fis.hibernate.ClubId;
import net.fis.hibernate.FederacionDAO;
import net.fis.hibernate.Jugador;
import net.fis.hibernate.JugadorDAO;

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
 * @struts.action input="/abm/jugador.jsp" validate="true"
 */
public class JugadorAction extends DispatchAction
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

        JugadorDAO jugadorDAO = new JugadorDAO();

        List resultados = jugadorDAO.findAll(" order by jugId");

        session.setAttribute("jugadores", resultados);
        ActionForward forward = mapping.findForward("jugadores");

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

        JugadorDAO jugadorDAO = new JugadorDAO();
        DynaActionForm daf = (DynaActionForm) form;
        Jugador jugador = jugadorDAO.findById(new Integer((String) daf.getString("id")));

        daf.set("nombre", String.valueOf(jugador.getJugNombre()));
        daf.set("nacimiento", String.valueOf(jugador.getJugFechaNac()));
        daf.set("club", String.valueOf(jugador.getClub().getId().getClubId()));
        daf.set("categoria", String.valueOf(jugador.getCategoria().getCatId()));
        daf.set("apellido", String.valueOf(jugador.getJugApellido()));
        daf.set("federado", String.valueOf(jugador.getJugFederado()));
        daf.set("id", String.valueOf(jugador.getJugId()));

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

        Jugador jugador = new Jugador();
        jugador.setJugNombre((String) PropertyUtils.getSimpleProperty(form, "nombre"));
        // jugador.setJugFechaNac((String) PropertyUtils.getSimpleProperty(form, "nacimiento"));
        ClubDAO clubDAO = new ClubDAO();
        jugador.setClub(clubDAO.findByClubId(new Integer((String) PropertyUtils.getSimpleProperty(form, "club"))));
        CategoriaDAO categoriaDAO = new CategoriaDAO();
        jugador.setCategoria(categoriaDAO.findById(new Integer((String) PropertyUtils.getSimpleProperty(form, "categoria"))));
        jugador.setJugApellido((String) PropertyUtils.getSimpleProperty(form, "apellido"));
        jugador.setJugFederado((String) PropertyUtils.getSimpleProperty(form, "federado"));

        JugadorDAO jugadorDAO = new JugadorDAO();
        jugadorDAO.save(jugador);

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

        Jugador jugador = new Jugador();
        jugador.setJugId(new Integer((String) PropertyUtils.getSimpleProperty(form, "id")));

        JugadorDAO jugadorDAO = new JugadorDAO();
        jugadorDAO.delete(jugador);

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

        Jugador jugador = new Jugador();
        jugador.setJugId(new Integer((String) PropertyUtils.getSimpleProperty(form, "id")));
        jugador.setJugNombre((String) PropertyUtils.getSimpleProperty(form, "nombre"));
        // jugador.setJugFechaNac((String) PropertyUtils.getSimpleProperty(form, "nacimiento"));
        ClubDAO clubDAO = new ClubDAO();
        FederacionDAO federacionDAO = new FederacionDAO();
        ClubId clubId = new ClubId(new Integer((String) PropertyUtils.getSimpleProperty(form, "club")), federacionDAO.findById(new Integer(
                (String) PropertyUtils.getSimpleProperty(form, "federacion"))));
        jugador.setClub(clubDAO.findById(clubId));
        CategoriaDAO categoriaDAO = new CategoriaDAO();
        jugador.setCategoria(categoriaDAO.findById(new Integer((String) PropertyUtils.getSimpleProperty(form, "categoria"))));
        jugador.setJugApellido((String) PropertyUtils.getSimpleProperty(form, "apellido"));
        jugador.setJugFederado((String) PropertyUtils.getSimpleProperty(form, "federado"));

        JugadorDAO jugadorDAO = new JugadorDAO();
        jugadorDAO.update(jugador);

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

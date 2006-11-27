package net.fis.hibernate;


import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Query;


public class TodayDAO extends BaseHibernateDAO
{

    private static final Log log = LogFactory.getLog(MedicoDAO.class);

    public List findFichasMedicasFaltantes()
    {
        log.debug("finding Today instance by FichasMedicas");
        try
        {
            Query query = getSession().createQuery("from Jugador where jugId not in ( select jugador.jugId from FichaMedica where fmEstado = 'OK' ) ");
            List result = query.list();
            return result;
        }
        catch (RuntimeException re)
        {
            log.error("find all failed", re);
            throw re;
        }
    }

    public List findAvisosFaltantes()
    {
        log.debug("finding Today instance by Avisos Faltantes");
        try
        {
            Query query = getSession()
                    .createQuery(
                            "from Jugador where jugId not in ( select jugador.jugId from FichaMedica where fmEstado = 'OK' ) and jugId not in ( select jugador.jugId from Aviso)");
            List result = query.list();
            return result;
        }
        catch (RuntimeException re)
        {
            log.error("find all failed", re);
            throw re;
        }
    }

}

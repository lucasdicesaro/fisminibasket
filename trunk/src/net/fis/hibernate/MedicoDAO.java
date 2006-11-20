package net.fis.hibernate;


import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Query;
import org.hibernate.Transaction;


/**
 * Data access object (DAO) for domain model class Medico.
 * 
 * @see net.fis.hibernate.Medico
 * @author MyEclipse - Hibernate Tools
 */
public class MedicoDAO extends BaseHibernateDAO
{

    private static final Log   log           = LogFactory.getLog(MedicoDAO.class);

    // property constants
    public static final String MED_NOMBRE    = "medNombre";

    public static final String MED_APELLIDO  = "medApellido";

    public static final String MED_MATRICULA = "medMatricula";

    public void save(Medico transientInstance)
    {
        log.debug("saving Medico instance");
        try
        {
            Transaction tx = getSession().beginTransaction();
            getSession().save(transientInstance);
            getSession().flush();
            tx.commit();
            log.debug("save successful");
        }
        catch (RuntimeException re)
        {
            log.error("save failed", re);
            throw re;
        }
    }

    public void delete(Medico persistentInstance)
    {
        log.debug("deleting Medico instance");
        try
        {
            Transaction tx = getSession().beginTransaction();
            getSession().delete(persistentInstance);
            getSession().flush();
            tx.commit();
            log.debug("delete successful");
        }
        catch (RuntimeException re)
        {
            log.error("delete failed", re);
            throw re;
        }
    }

    public Medico findById(java.lang.Integer id)
    {
        log.debug("getting Medico instance with id: " + id);
        try
        {
            Medico instance = (Medico) getSession().get("net.fis.hibernate.Medico", id);
            return instance;
        }
        catch (RuntimeException re)
        {
            log.error("get failed", re);
            throw re;
        }
    }

    public List findAll(String order)
    {
        log.debug("finding Medico instance by example");
        try
        {
            Query query = getSession().createQuery("from Medico " + order);
            List result = query.list();
            return result;
        }
        catch (RuntimeException re)
        {
            log.error("find all failed", re);
            throw re;
        }
    }

    public Medico update(Medico detachedInstance)
    {
        log.debug("updating Medico instance");
        try
        {
            Transaction tx = getSession().beginTransaction();
            Medico result = (Medico) getSession().merge(detachedInstance);
            getSession().flush();
            tx.commit();
            log.debug("merge successful");
            return result;
        }
        catch (RuntimeException re)
        {
            log.error("merge failed", re);
            throw re;
        }
    }
}

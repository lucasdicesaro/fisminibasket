package net.fis.hibernate;


import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Query;
import org.hibernate.Transaction;


/**
 * Data access object (DAO) for domain model class Aviso.
 * 
 * @see net.fis.hibernate.Aviso
 * @author MyEclipse - Hibernate Tools
 */
public class AvisoDAO extends BaseHibernateDAO
{

    private static final Log   log        = LogFactory.getLog(AvisoDAO.class);

    // property constants
    public static final String AVI_ESTADO = "aviEstado";

    public static final String AVI_TIPO   = "aviTipo";

    public void save(Aviso transientInstance)
    {
        log.debug("saving Aviso instance");
        try
        {
            getSession().save(transientInstance);
            log.debug("save successful");
        }
        catch (RuntimeException re)
        {
            log.error("save failed", re);
            throw re;
        }
    }

    public void delete(Aviso persistentInstance)
    {
        log.debug("deleting Aviso instance");
        try
        {
            getSession().delete(persistentInstance);
            log.debug("delete successful");
        }
        catch (RuntimeException re)
        {
            log.error("delete failed", re);
            throw re;
        }
    }

    public Aviso findById(java.lang.Integer id)
    {
        log.debug("getting Aviso instance with id: " + id);
        try
        {
            Aviso instance = (Aviso) getSession().get("net.fis.hibernate.Aviso", id);
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
        log.debug("finding Aviso instance by example");
        try
        {
            Query query = getSession().createQuery("from Aviso " + order);
            List result = query.list();
            return result;
        }
        catch (RuntimeException re)
        {
            log.error("find all failed", re);
            throw re;
        }
    }

    public Aviso update(Aviso detachedInstance)
    {
        log.debug("updating Aviso instance");
        try
        {
            Transaction tx = getSession().beginTransaction();
            Aviso result = (Aviso) getSession().merge(detachedInstance);
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

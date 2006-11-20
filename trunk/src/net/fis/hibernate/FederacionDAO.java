package net.fis.hibernate;


import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Query;
import org.hibernate.Transaction;


/**
 * Data access object (DAO) for domain model class Federacion.
 * 
 * @see net.fis.hibernate.Federacion
 * @author MyEclipse - Hibernate Tools
 */
public class FederacionDAO extends BaseHibernateDAO
{

    private static final Log   log             = LogFactory.getLog(FederacionDAO.class);

    // property constants
    public static final String FED_DESCRIPCION = "fedDescripcion";

    public void save(Federacion transientInstance)
    {
        log.debug("saving Federacion instance");
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

    public void delete(Federacion persistentInstance)
    {
        log.debug("deleting Federacion instance");
        try
        {
            Transaction tx = getSession().beginTransaction();
            getSession().delete(findById(persistentInstance.getFederacionId()));
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

    public Federacion findById(java.lang.Integer id)
    {
        log.debug("getting Federacion instance with id: " + id);
        try
        {
            Federacion instance = (Federacion) getSession().get("net.fis.hibernate.Federacion", id);
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
        log.debug("finding Federacion instance by example");
        try
        {
            Query query = getSession().createQuery("from Federacion " + order);
            List result = query.list();
            return result;
        }
        catch (RuntimeException re)
        {
            log.error("find all failed", re);
            throw re;
        }
    }

    public Federacion update(Federacion detachedInstance)
    {
        log.debug("updating Federacion instance");
        try
        {
            Transaction tx = getSession().beginTransaction();
            Federacion result = (Federacion) getSession().merge(detachedInstance);
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

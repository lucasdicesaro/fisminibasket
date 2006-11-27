package net.fis.hibernate;


import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Query;
import org.hibernate.Transaction;


/**
 * Data access object (DAO) for domain model class Permiso.
 * 
 * @see net.fis.hibernate.Permiso
 * @author MyEclipse - Hibernate Tools
 */
public class PermisoDAO extends BaseHibernateDAO
{

    private static final Log log = LogFactory.getLog(PermisoDAO.class);

    public void save(Permiso transientInstance)
    {
        log.debug("saving Permiso instance");
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

    public void delete(Permiso persistentInstance)
    {
        log.debug("deleting Permiso instance");
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

    public Permiso findById(java.lang.Integer id)
    {
        log.debug("getting Permiso instance with id: " + id);
        try
        {
            Permiso instance = (Permiso) getSession().get("net.fis.hibernate.Permiso", id);
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
        log.debug("finding Permiso instance by example");
        try
        {
            Query query = getSession().createQuery("from Permiso " + order);
            List result = query.list();
            return result;
        }
        catch (RuntimeException re)
        {
            log.error("find all failed", re);
            throw re;
        }
    }

    public Permiso update(Permiso detachedInstance)
    {
        log.debug("updating Permiso instance");
        try
        {
            Transaction tx = getSession().beginTransaction();
            Permiso result = (Permiso) getSession().merge(detachedInstance);
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

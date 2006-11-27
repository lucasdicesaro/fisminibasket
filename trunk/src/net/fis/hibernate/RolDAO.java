package net.fis.hibernate;


import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Query;
import org.hibernate.Transaction;


/**
 * Data access object (DAO) for domain model class Rol.
 * 
 * @see net.fis.hibernate.Rol
 * @author MyEclipse - Hibernate Tools
 */
public class RolDAO extends BaseHibernateDAO
{

    private static final Log log = LogFactory.getLog(RolDAO.class);

    public void save(Rol transientInstance)
    {
        log.debug("saving Rol instance");
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

    public void delete(Rol persistentInstance)
    {
        log.debug("deleting Rol instance");
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

    public Rol findById(java.lang.Integer id)
    {
        log.debug("getting Rol instance with id: " + id);
        try
        {
            Rol instance = (Rol) getSession().get("net.fis.hibernate.Rol", id);
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
        log.debug("finding Rol instance by example");
        try
        {
            Query query = getSession().createQuery("from Rol " + order);
            List result = query.list();
            return result;
        }
        catch (RuntimeException re)
        {
            log.error("find all failed", re);
            throw re;
        }
    }

    public Rol update(Rol detachedInstance)
    {
        log.debug("updating Rol instance");
        try
        {
            Transaction tx = getSession().beginTransaction();
            Rol result = (Rol) getSession().merge(detachedInstance);
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

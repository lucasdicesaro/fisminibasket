package net.fis.hibernate;


import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Query;
import org.hibernate.Transaction;


/**
 * Data access object (DAO) for domain model class RolPermiso.
 * 
 * @see net.fis.hibernate.RolPermiso
 * @author MyEclipse - Hibernate Tools
 */
public class RolPermisoDAO extends BaseHibernateDAO
{

    private static final Log log = LogFactory.getLog(RolPermisoDAO.class);

    // property constants

    public void save(RolPermiso transientInstance)
    {
        log.debug("saving RolPermiso instance");
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

    public void delete(RolPermiso persistentInstance)
    {
        log.debug("deleting RolPermiso instance");
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

    public RolPermiso findById(net.fis.hibernate.RolPermisoId id)
    {
        log.debug("getting RolPermiso instance with id: " + id);
        try
        {
            RolPermiso instance = (RolPermiso) getSession().get("net.fis.hibernate.RolPermiso", id);
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
        log.debug("finding RolPermiso instance by example");
        try
        {
            Query query = getSession().createQuery("from RolPermiso " + order);
            List result = query.list();
            return result;
        }
        catch (RuntimeException re)
        {
            log.error("find all failed", re);
            throw re;
        }
    }

    public RolPermiso update(RolPermiso detachedInstance)
    {
        log.debug("updating RolPermiso instance");
        try
        {
            Transaction tx = getSession().beginTransaction();
            RolPermiso result = (RolPermiso) getSession().merge(detachedInstance);
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

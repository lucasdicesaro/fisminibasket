package net.fis.hibernate;


import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Query;
import org.hibernate.Transaction;


/**
 * Data access object (DAO) for domain model class Categoria.
 * 
 * @see net.fis.hibernate.Categoria
 * @author MyEclipse - Hibernate Tools
 */
public class CategoriaDAO extends BaseHibernateDAO
{

    private static final Log log = LogFactory.getLog(CategoriaDAO.class);

    public void save(Categoria transientInstance)
    {
        log.debug("saving Categoria instance");
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

    public void delete(Categoria persistentInstance)
    {
        log.debug("deleting Categoria instance");
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

    public Categoria findById(java.lang.Integer id)
    {
        log.debug("getting Categoria instance with id: " + id);
        try
        {
            Categoria instance = (Categoria) getSession().get("net.fis.hibernate.Categoria", id);
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
        log.debug("finding Categoria instance by example");
        try
        {
            Query query = getSession().createQuery("from Categoria " + order);
            List result = query.list();
            return result;
        }
        catch (RuntimeException re)
        {
            log.error("find all failed", re);
            throw re;
        }
    }

    public Categoria update(Categoria detachedInstance)
    {
        log.debug("updating Categoria instance");
        try
        {
            Transaction tx = getSession().beginTransaction();
            Categoria result = (Categoria) getSession().merge(detachedInstance);
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

package net.fis.hibernate;


import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Query;
import org.hibernate.Transaction;


/**
 * Data access object (DAO) for domain model class Usuario.
 * 
 * @see net.fis.hibernate.Usuario
 * @author MyEclipse - Hibernate Tools
 */
public class UsuarioDAO extends BaseHibernateDAO
{

    private static final Log log = LogFactory.getLog(UsuarioDAO.class);

    public void save(Usuario transientInstance)
    {
        log.debug("saving Usuario instance");
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

    public void delete(Usuario persistentInstance)
    {
        log.debug("deleting Usuario instance");
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

    public Usuario findById(java.lang.Integer id)
    {
        log.debug("getting Usuario instance with id: " + id);
        try
        {
            Usuario instance = (Usuario) getSession().get("net.fis.hibernate.Usuario", id);
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
        log.debug("finding Usuario instance by example");
        try
        {
            Query query = getSession().createQuery("from Usuario " + order);
            List result = query.list();
            return result;
        }
        catch (RuntimeException re)
        {
            log.error("find all failed", re);
            throw re;
        }
    }

    public Usuario update(Usuario detachedInstance)
    {
        log.debug("updating Usuario instance");
        try
        {
            Transaction tx = getSession().beginTransaction();
            Usuario result = (Usuario) getSession().merge(detachedInstance);
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

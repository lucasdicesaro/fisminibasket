package net.fis.hibernate;


import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Query;
import org.hibernate.Transaction;


/**
 * Data access object (DAO) for domain model class Jugador.
 * 
 * @see net.fis.hibernate.Jugador
 * @author MyEclipse - Hibernate Tools
 */
public class JugadorDAO extends BaseHibernateDAO
{

    private static final Log log = LogFactory.getLog(JugadorDAO.class);

    public void save(Jugador transientInstance)
    {
        log.debug("saving Jugador instance");
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

    public void delete(Jugador persistentInstance)
    {
        log.debug("deleting Jugador instance");
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

    public Jugador findById(java.lang.Integer id)
    {
        log.debug("getting Jugador instance with id: " + id);
        try
        {
            Jugador instance = (Jugador) getSession().get("net.fis.hibernate.Jugador", id);
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
        log.debug("finding Jugador instance by example");
        try
        {
            Query query = getSession().createQuery("from Jugador " + order);
            List result = query.list();
            return result;
        }
        catch (RuntimeException re)
        {
            log.error("find all failed", re);
            throw re;
        }
    }

    public Jugador update(Jugador detachedInstance)
    {
        log.debug("updating Jugador instance");
        try
        {
            Transaction tx = getSession().beginTransaction();
            Jugador result = (Jugador) getSession().merge(detachedInstance);
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

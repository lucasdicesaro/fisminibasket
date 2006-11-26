package net.fis.hibernate;


import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Query;
import org.hibernate.Transaction;


/**
 * Data access object (DAO) for domain model class Club.
 * 
 * @see net.fis.hibernate.Club
 * @author MyEclipse - Hibernate Tools
 */
public class ClubDAO extends BaseHibernateDAO
{

    private static final Log log = LogFactory.getLog(ClubDAO.class);

    public Integer findMax()
    {
        log.debug("finding Club instance by max id");
        try
        {
            Query query = getSession().createQuery("select max(id.clubId) from Club ");
            List result = query.list();
            Object objeto = result.get(0);
            if (objeto == null)
            {
                return new Integer(0);
            }
            else
            {
                return (Integer) objeto;
            }
        }
        catch (RuntimeException re)
        {
            log.error("find all failed", re);
            throw re;
        }
    }

    public void save(Club transientInstance)
    {
        log.debug("saving Club instance");
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

    public void delete(Club persistentInstance)
    {
        log.debug("deleting Club instance");
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

    public Club findById(net.fis.hibernate.ClubId id)
    {
        log.debug("getting Club instance with id: " + id);
        try
        {
            Club instance = (Club) getSession().get("net.fis.hibernate.Club", id);
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
        log.debug("finding Club instance by example");
        try
        {
            Query query = getSession().createQuery("from Club " + order);
            List result = query.list();
            return result;
        }
        catch (RuntimeException re)
        {
            log.error("find all failed", re);
            throw re;
        }
    }

    public Club update(Club detachedInstance)
    {
        log.debug("updating Club instance");
        try
        {
            Transaction tx = getSession().beginTransaction();
            Club result = (Club) getSession().merge(detachedInstance);
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

    public Club findByClubId(Integer integer)
    {
        log.debug("finding Club instance by example");
        try
        {
            Query query = getSession().createQuery("from Club where id.clubId = " + integer.toString());
            List result = query.list();
            return (Club) result.get(0);
        }
        catch (RuntimeException re)
        {
            log.error("find all failed", re);
            throw re;
        }
    }
}

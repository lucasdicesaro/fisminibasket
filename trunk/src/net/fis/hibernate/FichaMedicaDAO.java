package net.fis.hibernate;


import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Query;
import org.hibernate.Transaction;


/**
 * Data access object (DAO) for domain model class FichaMedica.
 * 
 * @see net.fis.hibernate.FichaMedica
 * @author MyEclipse - Hibernate Tools
 */
public class FichaMedicaDAO extends BaseHibernateDAO
{

    private static final Log   log             = LogFactory.getLog(FichaMedicaDAO.class);

    // property constants
    public static final String FM_ESTADO       = "fmEstado";

    public static final String FM_ALERGIAS     = "fmAlergias";

    public static final String FM_CARDIOPATIAS = "fmCardiopatias";

    public static final String FM_ANTECEDENTES = "fmAntecedentes";

    public static final String FM_HISTORIAL    = "fmHistorial";

    public static final String FM_BUCO_DEN     = "fmBucoDen";

    public void save(FichaMedica transientInstance)
    {
        log.debug("saving FichaMedica instance");
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

    public void delete(FichaMedica persistentInstance)
    {
        log.debug("deleting FichaMedica instance");
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

    public FichaMedica findById(java.lang.Integer id)
    {
        log.debug("getting FichaMedica instance with id: " + id);
        try
        {
            FichaMedica instance = (FichaMedica) getSession().get("net.fis.hibernate.FichaMedica", id);
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
        log.debug("finding FichaMedica instance by example");
        try
        {
            Query query = getSession().createQuery("from FichaMedica " + order);
            List result = query.list();
            return result;
        }
        catch (RuntimeException re)
        {
            log.error("find all failed", re);
            throw re;
        }
    }

    public FichaMedica update(FichaMedica detachedInstance)
    {
        log.debug("updating FichaMedica instance");
        try
        {
            Transaction tx = getSession().beginTransaction();
            FichaMedica result = (FichaMedica) getSession().merge(detachedInstance);
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

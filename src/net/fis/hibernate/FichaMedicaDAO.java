package net.fis.hibernate;

import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.criterion.Example;

/**
 * Data access object (DAO) for domain model class FichaMedica.
 * @see net.fis.hibernate.FichaMedica
 * @author MyEclipse - Hibernate Tools
 */
public class FichaMedicaDAO extends BaseHibernateDAO {

    private static final Log log = LogFactory.getLog(FichaMedicaDAO.class);

	//property constants
	public static final String FM_ESTADO = "fmEstado";
	public static final String FM_ALERGIAS = "fmAlergias";
	public static final String FM_CARDIOPATIAS = "fmCardiopatias";
	public static final String FM_ANTECEDENTES = "fmAntecedentes";
	public static final String FM_HISTORIAL = "fmHistorial";
	public static final String FM_BUCO_DEN = "fmBucoDen";

    
    public void save(FichaMedica transientInstance) {
        log.debug("saving FichaMedica instance");
        try {
            getSession().save(transientInstance);
            log.debug("save successful");
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }
    
	public void delete(FichaMedica persistentInstance) {
        log.debug("deleting FichaMedica instance");
        try {
            getSession().delete(persistentInstance);
            log.debug("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }
    
    public FichaMedica findById( java.lang.Integer id) {
        log.debug("getting FichaMedica instance with id: " + id);
        try {
            FichaMedica instance = (FichaMedica) getSession()
                    .get("net.fis.hibernate.FichaMedica", id);
            return instance;
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }
    
    
    public List findByExample(FichaMedica instance) {
        log.debug("finding FichaMedica instance by example");
        try {
            List results = getSession()
                    .createCriteria("net.fis.hibernate.FichaMedica")
                    .add(Example.create(instance))
            .list();
            log.debug("find by example successful, result size: " + results.size());
            return results;
        } catch (RuntimeException re) {
            log.error("find by example failed", re);
            throw re;
        }
    }    
    
    public List findByProperty(String propertyName, Object value) {
      log.debug("finding FichaMedica instance with property: " + propertyName
            + ", value: " + value);
      try {
         String queryString = "from FichaMedica as model where model." 
         						+ propertyName + "= ?";
         Query queryObject = getSession().createQuery(queryString);
		 queryObject.setParameter(0, value);
		 return queryObject.list();
      } catch (RuntimeException re) {
         log.error("find by property name failed", re);
         throw re;
      }
	}

	public List findByFmEstado(Object fmEstado) {
		return findByProperty(FM_ESTADO, fmEstado);
	}
	
	public List findByFmAlergias(Object fmAlergias) {
		return findByProperty(FM_ALERGIAS, fmAlergias);
	}
	
	public List findByFmCardiopatias(Object fmCardiopatias) {
		return findByProperty(FM_CARDIOPATIAS, fmCardiopatias);
	}
	
	public List findByFmAntecedentes(Object fmAntecedentes) {
		return findByProperty(FM_ANTECEDENTES, fmAntecedentes);
	}
	
	public List findByFmHistorial(Object fmHistorial) {
		return findByProperty(FM_HISTORIAL, fmHistorial);
	}
	
	public List findByFmBucoDen(Object fmBucoDen) {
		return findByProperty(FM_BUCO_DEN, fmBucoDen);
	}
	
    public FichaMedica merge(FichaMedica detachedInstance) {
        log.debug("merging FichaMedica instance");
        try {
            FichaMedica result = (FichaMedica) getSession()
                    .merge(detachedInstance);
            log.debug("merge successful");
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }

    public void attachDirty(FichaMedica instance) {
        log.debug("attaching dirty FichaMedica instance");
        try {
            getSession().saveOrUpdate(instance);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public void attachClean(FichaMedica instance) {
        log.debug("attaching clean FichaMedica instance");
        try {
            getSession().lock(instance, LockMode.NONE);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
}
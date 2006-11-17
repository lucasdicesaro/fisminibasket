package net.fis.hibernate;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.criterion.Example;

/**
 * Data access object (DAO) for domain model class Aviso.
 * 
 * @see net.fis.hibernate.Aviso
 * @author MyEclipse - Hibernate Tools
 */
public class AvisoDAO extends BaseHibernateDAO {

	private static final Log log = LogFactory.getLog(AvisoDAO.class);

	// property constants
	public static final String AVI_ESTADO = "aviEstado";

	public static final String AVI_TIPO = "aviTipo";

	public void save(Aviso transientInstance) {
		log.debug("saving Aviso instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Aviso persistentInstance) {
		log.debug("deleting Aviso instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Aviso findById(java.lang.Integer id) {
		log.debug("getting Aviso instance with id: " + id);
		try {
			Aviso instance = (Aviso) getSession().get(
					"net.fis.hibernate.Aviso", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Aviso instance) {
		log.debug("finding Aviso instance by example");
		try {
			List results = getSession().createCriteria(
					"net.fis.hibernate.Aviso").add(Example.create(instance))
					.list();
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value) {
		log.debug("finding Aviso instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Aviso as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByAviEstado(Object aviEstado) {
		return findByProperty(AVI_ESTADO, aviEstado);
	}

	public List findByAviTipo(Object aviTipo) {
		return findByProperty(AVI_TIPO, aviTipo);
	}

	public Aviso merge(Aviso detachedInstance) {
		log.debug("merging Aviso instance");
		try {
			Aviso result = (Aviso) getSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Aviso instance) {
		log.debug("attaching dirty Aviso instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Aviso instance) {
		log.debug("attaching clean Aviso instance");
		try {
			getSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}
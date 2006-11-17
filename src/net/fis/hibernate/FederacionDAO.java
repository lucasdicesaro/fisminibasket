package net.fis.hibernate;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.criterion.Example;

/**
 * Data access object (DAO) for domain model class Federacion.
 * 
 * @see net.fis.hibernate.Federacion
 * @author MyEclipse - Hibernate Tools
 */
public class FederacionDAO extends BaseHibernateDAO {

	private static final Log log = LogFactory.getLog(FederacionDAO.class);

	// property constants
	public static final String FED_DESCRIPCION = "fedDescripcion";

	public void save(Federacion transientInstance) {
		log.debug("saving Federacion instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Federacion persistentInstance) {
		log.debug("deleting Federacion instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Federacion findById(java.lang.Integer id) {
		log.debug("getting Federacion instance with id: " + id);
		try {
			Federacion instance = (Federacion) getSession().get(
					"net.fis.hibernate.Federacion", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Federacion instance) {
		log.debug("finding Federacion instance by example");
		try {
			List results = getSession().createCriteria(
					"net.fis.hibernate.Federacion").add(
					Example.create(instance)).list();
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value) {
		log.debug("finding Federacion instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Federacion as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByFedDescripcion(Object fedDescripcion) {
		return findByProperty(FED_DESCRIPCION, fedDescripcion);
	}

	public Federacion merge(Federacion detachedInstance) {
		log.debug("merging Federacion instance");
		try {
			Federacion result = (Federacion) getSession().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Federacion instance) {
		log.debug("attaching dirty Federacion instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Federacion instance) {
		log.debug("attaching clean Federacion instance");
		try {
			getSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}
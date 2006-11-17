package net.fis.hibernate;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.criterion.Example;

/**
 * Data access object (DAO) for domain model class Club.
 * 
 * @see net.fis.hibernate.Club
 * @author MyEclipse - Hibernate Tools
 */
public class ClubDAO extends BaseHibernateDAO {

	private static final Log log = LogFactory.getLog(ClubDAO.class);

	// property constants
	public static final String CLU_DESCRIPCION = "cluDescripcion";

	public static final String CLU_FEDERADO = "cluFederado";

	public void save(Club transientInstance) {
		log.debug("saving Club instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Club persistentInstance) {
		log.debug("deleting Club instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Club findById(net.fis.hibernate.ClubId id) {
		log.debug("getting Club instance with id: " + id);
		try {
			Club instance = (Club) getSession().get("net.fis.hibernate.Club",
					id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Club instance) {
		log.debug("finding Club instance by example");
		try {
			List results = getSession()
					.createCriteria("net.fis.hibernate.Club").add(
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
		log.debug("finding Club instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Club as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByCluDescripcion(Object cluDescripcion) {
		return findByProperty(CLU_DESCRIPCION, cluDescripcion);
	}

	public List findByCluFederado(Object cluFederado) {
		return findByProperty(CLU_FEDERADO, cluFederado);
	}

	public Club merge(Club detachedInstance) {
		log.debug("merging Club instance");
		try {
			Club result = (Club) getSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Club instance) {
		log.debug("attaching dirty Club instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Club instance) {
		log.debug("attaching clean Club instance");
		try {
			getSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}
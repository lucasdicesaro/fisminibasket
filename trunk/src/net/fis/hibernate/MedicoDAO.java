package net.fis.hibernate;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.criterion.Example;

/**
 * Data access object (DAO) for domain model class Medico.
 * 
 * @see net.fis.hibernate.Medico
 * @author MyEclipse - Hibernate Tools
 */
public class MedicoDAO extends BaseHibernateDAO {

	private static final Log log = LogFactory.getLog(MedicoDAO.class);

	// property constants
	public static final String MED_NOMBRE = "medNombre";

	public static final String MED_APELLIDO = "medApellido";

	public static final String MED_MATRICULA = "medMatricula";

	public void save(Medico transientInstance) {
		log.debug("saving Medico instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Medico persistentInstance) {
		log.debug("deleting Medico instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Medico findById(java.lang.Integer id) {
		log.debug("getting Medico instance with id: " + id);
		try {
			Medico instance = (Medico) getSession().get(
					"net.fis.hibernate.Medico", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Medico instance) {
		log.debug("finding Medico instance by example");
		try {
			List results = getSession().createCriteria(
					"net.fis.hibernate.Medico").add(Example.create(instance))
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
		log.debug("finding Medico instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Medico as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByMedNombre(Object medNombre) {
		return findByProperty(MED_NOMBRE, medNombre);
	}

	public List findByMedApellido(Object medApellido) {
		return findByProperty(MED_APELLIDO, medApellido);
	}

	public List findByMedMatricula(Object medMatricula) {
		return findByProperty(MED_MATRICULA, medMatricula);
	}

	public Medico merge(Medico detachedInstance) {
		log.debug("merging Medico instance");
		try {
			Medico result = (Medico) getSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Medico instance) {
		log.debug("attaching dirty Medico instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Medico instance) {
		log.debug("attaching clean Medico instance");
		try {
			getSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}
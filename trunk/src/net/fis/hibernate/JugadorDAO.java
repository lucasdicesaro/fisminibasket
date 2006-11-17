package net.fis.hibernate;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.criterion.Example;

/**
 * Data access object (DAO) for domain model class Jugador.
 * 
 * @see net.fis.hibernate.Jugador
 * @author MyEclipse - Hibernate Tools
 */
public class JugadorDAO extends BaseHibernateDAO {

	private static final Log log = LogFactory.getLog(JugadorDAO.class);

	// property constants
	public static final String JUG_FEDERADO = "jugFederado";

	public static final String JUG_NOMBRE = "jugNombre";

	public static final String JUG_APELLIDO = "jugApellido";

	public void save(Jugador transientInstance) {
		log.debug("saving Jugador instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Jugador persistentInstance) {
		log.debug("deleting Jugador instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Jugador findById(java.lang.Integer id) {
		log.debug("getting Jugador instance with id: " + id);
		try {
			Jugador instance = (Jugador) getSession().get(
					"net.fis.hibernate.Jugador", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Jugador instance) {
		log.debug("finding Jugador instance by example");
		try {
			List results = getSession().createCriteria(
					"net.fis.hibernate.Jugador").add(Example.create(instance))
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
		log.debug("finding Jugador instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Jugador as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByJugFederado(Object jugFederado) {
		return findByProperty(JUG_FEDERADO, jugFederado);
	}

	public List findByJugNombre(Object jugNombre) {
		return findByProperty(JUG_NOMBRE, jugNombre);
	}

	public List findByJugApellido(Object jugApellido) {
		return findByProperty(JUG_APELLIDO, jugApellido);
	}

	public Jugador merge(Jugador detachedInstance) {
		log.debug("merging Jugador instance");
		try {
			Jugador result = (Jugador) getSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Jugador instance) {
		log.debug("attaching dirty Jugador instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Jugador instance) {
		log.debug("attaching clean Jugador instance");
		try {
			getSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}
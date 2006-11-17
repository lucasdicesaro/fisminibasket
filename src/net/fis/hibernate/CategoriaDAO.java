package net.fis.hibernate;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.criterion.Example;

/**
 * Data access object (DAO) for domain model class Categoria.
 * 
 * @see net.fis.hibernate.Categoria
 * @author MyEclipse - Hibernate Tools
 */
public class CategoriaDAO extends BaseHibernateDAO {

	private static final Log log = LogFactory.getLog(CategoriaDAO.class);

	// property constants
	public static final String CAT_DESCRIPCION = "catDescripcion";

	public static final String CAT_MIN_JUG = "catMinJug";

	public void save(Categoria transientInstance) {
		log.debug("saving Categoria instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Categoria persistentInstance) {
		log.debug("deleting Categoria instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Categoria findById(java.lang.Integer id) {
		log.debug("getting Categoria instance with id: " + id);
		try {
			Categoria instance = (Categoria) getSession().get(
					"net.fis.hibernate.Categoria", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Categoria instance) {
		log.debug("finding Categoria instance by example");
		try {
			List results = getSession().createCriteria(
					"net.fis.hibernate.Categoria")
					.add(Example.create(instance)).list();
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value) {
		log.debug("finding Categoria instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Categoria as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByCatDescripcion(Object catDescripcion) {
		return findByProperty(CAT_DESCRIPCION, catDescripcion);
	}

	public List findByCatMinJug(Object catMinJug) {
		return findByProperty(CAT_MIN_JUG, catMinJug);
	}

	public Categoria merge(Categoria detachedInstance) {
		log.debug("merging Categoria instance");
		try {
			Categoria result = (Categoria) getSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Categoria instance) {
		log.debug("attaching dirty Categoria instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Categoria instance) {
		log.debug("attaching clean Categoria instance");
		try {
			getSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}
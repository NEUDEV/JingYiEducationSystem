package com.JES.dao;

import java.util.List;

import org.hibernate.LockOptions;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.transaction.annotation.Transactional;

import com.JES.model.Agent;

/**
 * A data access object (DAO) providing persistence and search support for Agent
 * entities. Transaction control of the save(), update() and delete() operations
 * can directly support Spring container-managed transactions or they can be
 * augmented to handle user-managed Spring transactions. Each of these methods
 * provides additional information for how to configure it for the desired type
 * of transaction control.
 * 
 * @see com.JES.model.Agent
 * @author MyEclipse Persistence Tools
 */
@Transactional
public class AgentDAO {
	private static final Logger log = LoggerFactory.getLogger(AgentDAO.class);
	// property constants
	public static final String ANAME = "aname";
	public static final String NAME = "name";
	public static final String PHONE = "phone";
	public static final String QQ = "qq";
	public static final String PASSWORD = "password";
	public static final String AID = "aid";
	public static final String IDCARD = "idcard";
	public static final String CNAME = "cname";
	public static final String BANK = "bank";
	public static final String ACCOUNT = "account";
	public static final String ROLE = "role";
	public static final String MANNAGER = "mannager";

	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	private Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}

	protected void initDao() {
		// do nothing
	}

	public void save(Agent transientInstance) {
		log.debug("saving Agent instance");
		try {
			getCurrentSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Agent persistentInstance) {
		log.debug("deleting Agent instance");
		try {
			getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Agent findById(java.lang.String id) {
		log.debug("getting Agent instance with id: " + id);
		try {
			Agent instance = (Agent) getCurrentSession().get(
					"com.JES.model.Agent", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Agent instance) {
		log.debug("finding Agent instance by example");
		try {
			List results = getCurrentSession()
					.createCriteria("com.JES.model.Agent")
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
		log.debug("finding Agent instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Agent as model where model."
					+ propertyName + "= ?";
			Query queryObject = getCurrentSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByAname(Object aname) {
		return findByProperty(ANAME, aname);
	}

	public List findByName(Object name) {
		return findByProperty(NAME, name);
	}

	public List findByPhone(Object phone) {
		return findByProperty(PHONE, phone);
	}

	public List findByQq(Object qq) {
		return findByProperty(QQ, qq);
	}

	public List findByPassword(Object password) {
		return findByProperty(PASSWORD, password);
	}

	public List findByAid(Object aid) {
		return findByProperty(AID, aid);
	}

	public List findByIdcard(Object idcard) {
		return findByProperty(IDCARD, idcard);
	}

	public List findByCname(Object cname) {
		return findByProperty(CNAME, cname);
	}

	public List findByBank(Object bank) {
		return findByProperty(BANK, bank);
	}

	public List findByAccount(Object account) {
		return findByProperty(ACCOUNT, account);
	}

	public List findByRole(Object role) {
		return findByProperty(ROLE, role);
	}

	public List findByMannager(Object mannager) {
		return findByProperty(MANNAGER, mannager);
	}

	public List findAll() {
		log.debug("finding all Agent instances");
		try {
			String queryString = "from Agent";
			Query queryObject = getCurrentSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Agent merge(Agent detachedInstance) {
		log.debug("merging Agent instance");
		try {
			Agent result = (Agent) getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Agent instance) {
		log.debug("attaching dirty Agent instance");
		try {
			getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Agent instance) {
		log.debug("attaching clean Agent instance");
		try {
			getCurrentSession().buildLockRequest(LockOptions.NONE).lock(
					instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static AgentDAO getFromApplicationContext(ApplicationContext ctx) {
		return (AgentDAO) ctx.getBean("AgentDAO");
	}
}
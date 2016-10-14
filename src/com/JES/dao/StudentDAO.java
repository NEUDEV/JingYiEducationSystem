package com.JES.dao;

import java.util.Date;
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

import com.JES.model.Student;

/**
 	* A data access object (DAO) providing persistence and search support for Student entities.
 			* Transaction control of the save(), update() and delete() operations 
		can directly support Spring container-managed transactions or they can be augmented	to handle user-managed Spring transactions. 
		Each of these methods provides additional information for how to configure it for the desired type of transaction control. 	
	 * @see com.JES.model.Student
  * @author MyEclipse Persistence Tools 
 */
    @Transactional   
public class StudentDAO  {
	     private static final Logger log = LoggerFactory.getLogger(StudentDAO.class);
		//property constants
	public static final String UNAME = "uname";
	public static final String NAME = "name";
	public static final String PHONE = "phone";
	public static final String QQ = "qq";
	public static final String WEIXIN = "weixin";
	public static final String MID = "mid";
	public static final String SIGN = "sign";
	public static final String STUID = "stuid";
	public static final String FROM = "from";
	public static final String MARK = "mark";



    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory){
       this.sessionFactory = sessionFactory;
    }

    private Session getCurrentSession(){
     return sessionFactory.getCurrentSession(); 
    }
	protected void initDao() {
		//do nothing
	}
    
    public void save(Student transientInstance) {
        try {
            getCurrentSession().save(transientInstance);
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }
    
	public void delete(Student persistentInstance) {
        try {
            getCurrentSession().delete(persistentInstance);
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }
    
    public Student findById( java.lang.String id) {
        try {
            Student instance = (Student) getCurrentSession()
                    .get("com.JES.model.Student", id);
            return instance;
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }
    
    
    public List findByExample(Student instance) {
        try {
            List results = getCurrentSession().createCriteria("com.JES.model.Student") .add(Example.create(instance)).list();
            return results;
        } catch (RuntimeException re) {
            log.error("find by example failed", re);
            throw re;
        }
    }    
    
    public List findByProperty(String propertyName, Object value) {
      try {
         String queryString = "from Student as model where model." 
         						+ propertyName + "= ?";
         Query queryObject = getCurrentSession().createQuery(queryString);
		 queryObject.setParameter(0, value);
		 return queryObject.list();
      } catch (RuntimeException re) {
         log.error("find by property name failed", re);
         throw re;
      }
	}

	public List findByUname(Object uname
	) {
		return findByProperty(UNAME, uname
		);
	}
	
	public List findByName(Object name
	) {
		return findByProperty(NAME, name
		);
	}
	
	public List findByPhone(Object phone
	) {
		return findByProperty(PHONE, phone
		);
	}
	
	public List findByQq(Object qq
	) {
		return findByProperty(QQ, qq
		);
	}
	
	public List findByWeixin(Object weixin
	) {
		return findByProperty(WEIXIN, weixin
		);
	}
	
	public List findByMid(Object mid
	) {
		return findByProperty(MID, mid
		);
	}
	
	public List findBySign(Object sign
	) {
		return findByProperty(SIGN, sign
		);
	}
	
	public List findByStuid(Object stuid
	) {
		return findByProperty(STUID, stuid
		);
	}
	
	public List findByFrom(Object from
	) {
		return findByProperty(FROM, from
		);
	}
	
	public List findByMark(Object mark
	) {
		return findByProperty(MARK, mark
		);
	}
	

	public List findAll() {
		try {
			String queryString = "from Student";
	         Query queryObject = getCurrentSession().createQuery(queryString);
			 return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
    public Student merge(Student detachedInstance) {
        try {
            Student result = (Student) getCurrentSession()
                    .merge(detachedInstance);
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }

    public void attachDirty(Student instance) {
        try {
            getCurrentSession().saveOrUpdate(instance);
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public void attachClean(Student instance) {
        try {
                      	getCurrentSession().buildLockRequest(LockOptions.NONE).lock(instance);
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }

	public static StudentDAO getFromApplicationContext(ApplicationContext ctx) {
    	return (StudentDAO) ctx.getBean("StudentDAO");
	}
}
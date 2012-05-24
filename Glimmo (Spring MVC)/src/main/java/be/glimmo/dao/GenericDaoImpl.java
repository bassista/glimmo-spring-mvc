package be.glimmo.dao;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanPostProcessor;

public abstract class GenericDaoImpl <T, ID extends Serializable> implements BeanPostProcessor, GenericDao<T, ID>{
	@Autowired(required=true)
	private SessionFactory sessionFactory;
	private Session currentSession;
	// TODO set attribute value at bean construction
	private Class<T> persistentClass;
	
	public void save(T entity) {
		getSession().save(entity);
	}
	
	public void saveOrUpdate(T entity) {
		getSession().saveOrUpdate(entity);
	}
	
	public long countAll(){
		Query query = getSession().createQuery("count(e) FROM " + getPersistentClass().getName() + " e ");
		return (Long) query.uniqueResult();
	}
	
	
	public List<T> findPage(int pageStart, int pageSize){
		// TODO complete
		return null;
	}
	
	public List<T> findAll(){
		// TODO complete
				return null;
	}
	
	public T findById(Serializable id) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public void delete(Serializable id) {
		// TODO Auto-generated method stub
	}
	
	public void delete(T entity) {
		
	}
	
	/* ------------------------- GETTER + SETTER ------------------------- */
	public Session getSession(){
		if(currentSession == null){
			currentSession = sessionFactory.getCurrentSession();
		}
		
		return currentSession;
	}
	
	public void setSession(Session session){
		currentSession = session;
	}
	
	public Class<T> getPersistentClass(){
		return this.persistentClass;
	}
	
	/* -------------------- Bean creation hook methods ------------------- */
	@SuppressWarnings("unchecked")
	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
		ParameterizedType paramType = (ParameterizedType) getClass().getGenericSuperclass();
		this.persistentClass = (Class<T>) paramType.getActualTypeArguments()[0];
		
		return this;
	}
	
	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
		return this;
	}
}

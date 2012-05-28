package be.glimmo.dao;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.persistence.Entity;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;


public abstract class GenericDaoImpl <T, ID extends Serializable> implements GenericDao<T, ID>{
	@Autowired(required=true)
	private SessionFactory sessionFactory;
	private String entityName;
	
	public GenericDaoImpl(){
		initializeEntityName();
	}
	
	public void save(T entity) {
		getSession().save(entity);
	}
	
	public void saveOrUpdate(T entity) {
		getSession().saveOrUpdate(entity);
	}
	
	public long countAll(){
		Query query = getSession().createQuery("count(e) FROM " + getEntityName() + " e ");
		return (Long) query.uniqueResult();
	}
	
	
	@SuppressWarnings("unchecked")
	public List<T> findPage(int pageStart, int pageSize){
		Query query = getSession().createQuery("FROM " + getEntityName() + " e");
		query.setFirstResult(pageStart);
		query.setMaxResults(pageSize);
		return query.list();
	}
	
	@SuppressWarnings("unchecked")
	public List<T> findAll(){
		Query query = getSession().createQuery("FROM " + getEntityName() + " e ");
		return query.list();
	}
	
	@SuppressWarnings("unchecked")
	public T findById(Serializable id) {
		return (T) getSession().get(getEntityName(), id);
	}
	
	
	public void delete(T entity) {
		getSession().delete(entity);
	}
	
	@SuppressWarnings("unchecked")
	public void delete(ID id) {
		T entity = (T) getSession().get(getEntityName(), id);
		
		if(entity != null){
			getSession().delete(entity);
		}
	}
	
	/* ------------------------- GETTER + SETTER ------------------------- */
	public Session getSession(){
		return sessionFactory.getCurrentSession();
	}
	
	public final String getEntityName() {
		return entityName;
	}
	
	/*------------------------ Convenience methods ----------------------- */
	@SuppressWarnings("unchecked")
	public void initializeEntityName(){
		ParameterizedType paramType = (ParameterizedType) getClass().getGenericSuperclass();
		Class<T> persistentClass =  (Class<T>) paramType.getActualTypeArguments()[0];
		this.entityName = persistentClass.getAnnotation(Entity.class).name();
		
		if(this.entityName == null){
			this.entityName = persistentClass.getName();
		}
	}
}

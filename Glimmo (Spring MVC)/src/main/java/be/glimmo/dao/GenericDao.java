package be.glimmo.dao;

import java.io.Serializable;
import java.util.List;

/**
 * This interface exposes the most generic methods that each concrete DAO within the same hierarchy should provide
 * @author kar.hoo.yiu
 *
 * @param <T>
 * @param <ID>
 */
public interface GenericDao <T, ID extends Serializable>{
	public void save(T entity);
	public void saveOrUpdate(T entity);
	
	public long countAll();
	public List<T> findPage(int pageStart, int pageSize);
	public List<T> findAll();
	public T findById(ID id);
	
	public void delete(T entity);
	public void delete(ID id);
}

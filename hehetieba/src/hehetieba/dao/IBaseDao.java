package hehetieba.dao;

import hehetieba.basic.Pager;

import java.util.List;
import java.util.Map;

import org.hibernate.Query;

public interface IBaseDao<T> {
	public void save(T t);
	
	public void delete(Integer id);
	
	public void update(T t);
	
	public T load(Integer id);
	
	public T get(Integer id);
	
	public Object queryObject(String hql);
	
	public Object queryObject(String hql, Object arg);
	
	public Object queryObject(String hql, Object[] args);
	
	public Object queryObjectByAlias(String hql, Map<String, Object> alias);

	public Object queryObject(String hql, Object[] args,
			Map<String, Object> alias);
	
	/**
	 * 批量查询
	 */
	public List<T> list(String hql);
	
	public List<T> list(String hql, Object arg);
	
	public List<T> list(String hql, Object[] args);
	
	public List<T> listByAlias(String hql, Map<String, Object> alias);
	
	public List<T> list(String hql, Object[] args, Map<String, Object> alias);

	/*********************
	 * 分页相关
	 */
	public Pager<T> find(String hql,int index,int size);
	
	public Pager<T> find(String hql,int index,int size, Object arg);
	
	public Pager<T> find(String hql,int index,int size, Object[] args);
	
	public Pager<T> findByAlias(String hql,int index,int size,Map<String, Object> alias);
	
	public Pager<T> find(String hql,int index,int size, Object[] args, Map<String, Object> alias);
	
}

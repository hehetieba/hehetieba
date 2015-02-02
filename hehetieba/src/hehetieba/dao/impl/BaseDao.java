package hehetieba.dao.impl;

import java.lang.reflect.ParameterizedType;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.aspectj.org.eclipse.jdt.core.dom.ThisExpression;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import hehetieba.basic.Pager;
import hehetieba.dao.IBaseDao;

public class BaseDao<T> implements IBaseDao<T> {
	private SessionFactory sessionFactory;
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	/**
	 * 创建一个Class的对象来获取泛型的class
	 */
	private Class<?> clz;
	public Class<?> getClz() {
		if(clz==null) {
			//获取泛型的Class对象
			clz = ((Class<?>)
					(((ParameterizedType)(this.getClass().getGenericSuperclass())).getActualTypeArguments()[0]));
		}
		return clz;
	}
	
	public Session getSession() {
		return sessionFactory.getCurrentSession();
	}
	
	private void setParameter(Query query,Object[] args) {
		if(args!=null&&args.length>0) {
			int index = 0;
			for(Object arg:args) {
				query.setParameter(index++, arg);
			}
		}
	}
	
	private void setAliasParameter(Query query,Map<String,Object> alias) {
		if(alias!=null) {
			Set<String> keys = alias.keySet();
			for(String key:keys) {
				Object val = alias.get(key);
				if(val instanceof Collection) {
					//查询条件是列表
					query.setParameterList(key, (Collection)val);
				} else {
					query.setParameter(key, val);
				}
			}
		}
	}

	@Override
	public void save(T t) {
		this.getSession().save(t);
	}

	@Override
	public void delete(Integer id) {
		this.getSession().delete(this.load(id));
	}

	@Override
	public void update(T t) {
		this.getSession().update(t);
	}

	@Override
	public T load(Integer id) {
		return (T)this.getSession().load(this.getClz(), id);
	}
	

	@Override
	public T get(Integer id) {
		return (T)this.getSession().get(this.getClz(), id);
	}
	
	/**
	 * 查询一个对象
	 */
	
	public Object queryObject(String hql) {
		return this.queryObject(hql,null);
	}
	
	public Object queryObject(String hql, Object arg) {
		return this.queryObject(hql, new Object[]{arg});
	}
	
	public Object queryObject(String hql, Object[] args) {
		return this.queryObject(hql, args,null);
	}
	
	public Object queryObjectByAlias(String hql, Map<String, Object> alias) {
		return this.queryObject(hql,null,alias);
	}

	public Object queryObject(String hql, Object[] args,
			Map<String, Object> alias) {
		Query query = getSession().createQuery(hql);
		setAliasParameter(query, alias);
		setParameter(query, args);
		return query.setMaxResults(1).uniqueResult();
	}
	
	public List<T> list(String hql) {
		return this.list(hql,null);
	}
	
	public List<T> list(String hql, Object arg) {
		return this.list(hql, new Object[]{arg});
	}
	
	public List<T> list(String hql, Object[] args) {
		return this.list(hql, args, null);
	}
	
	public List<T> listByAlias(String hql, Map<String, Object> alias) {
		return this.list(hql, null, alias);
	}
	
	public List<T> list(String hql, Object[] args, Map<String, Object> alias) {
		Query query = getSession().createQuery(hql);
		setAliasParameter(query, alias);
		setParameter(query, args);
		return query.list();
	}

	/*********************
	 * 分页相关
	 */
	public Pager<T> find(String hql,int index,int size) {
		return this.find(hql,index,size,null);
	}
	
	public Pager<T> find(String hql,int index,int size, Object arg) {
		return this.find(hql,index,size, new Object[]{arg});
	}
	
	public Pager<T> find(String hql,int index,int size, Object[] args) {
		return this.find(hql,index,size,args,null);
	}
	
	public Pager<T> findByAlias(String hql,int index,int size,Map<String, Object> alias) {
		return this.find(hql,index,size,null,alias);
	}
	
	public Pager<T> find(String hql,int index,int size, Object[] args, Map<String, Object> alias) {
		if(index<=0) {
			index=1;
		}
		String cq = getCountHql(hql);
		Query cquery = getSession().createQuery(cq);
		Query query = getSession().createQuery(hql);
		//设置别名参数
		setAliasParameter(query, alias);
		setAliasParameter(cquery, alias);
		//设置参数
		setParameter(query, args);
		setParameter(cquery, args);
		//设置Pager
		Pager<T> pages = new Pager<T>();
		pages.setIndex(index);
		setPagers(query,pages,index,size);
		List<T> datas = query.list();
		pages.setDatas(datas);
		int totalRecord = (int)cquery.uniqueResult();
		pages.setTotalRecord(totalRecord);
		pages.setTotalPage(totalRecord%size==0 ? totalRecord/size : (totalRecord/size)+1);
		return pages;
	}
	
	private void setPagers(Query query,Pager pages,int index,int size) {
		int beginRow = (index-1)*size;
		pages.setBeginRow(beginRow);
		pages.setSize(size);
		query.setFirstResult(beginRow).setMaxResults(size);
	}
	
	private String getCountHql(String hql) {
		String e = hql.substring(hql.indexOf("from"));
		String c = "select count(*) "+e;
		c = c.replaceAll("fetch", "");
		return c;
	}

	
}

















package hehetieba.dao;

public interface IBaseDao<T> {
	public void save(T t);
	
	public void delete(Integer id);
	
	public void update(T t);
	
	public T load(Integer id);
}

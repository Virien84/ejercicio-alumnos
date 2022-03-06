package business.dao;

import java.util.List;

public interface RepositoryDAO<T> {
	T insert(T t);

	void remove(T t);
	
	void update(T t);

	T findById(Long id);

	List<T> findAll();

}

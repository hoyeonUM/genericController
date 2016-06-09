package web.common.service;

import java.io.Serializable;

public interface CrudRepository<T, ID extends Serializable>{
	<S extends T> 
	
	S save(S entity);

	T findOne(ID primaryKey);

	Iterable<T> findAll();

	Long count();

	void delete(ID id);

	boolean exists(ID primaryKey);
	// ¡¦ more functionality omitted.
}
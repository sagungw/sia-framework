package com.sia.main.service.services;

import java.util.List;
import java.util.UUID;

public interface GenericService<T> {

	public T insert(T object);
	
	public T update(T object);
	
	public T delete(T object);
	
	public T getById(UUID id);
	
	public List<T> getAll();
	
	public List<T> getByParam(String queryParam);
	
}

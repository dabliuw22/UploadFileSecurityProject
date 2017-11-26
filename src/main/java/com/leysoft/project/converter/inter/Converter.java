package com.leysoft.project.converter.inter;

import java.util.List;

public interface Converter<T1, T2> {
	
	public T1 modelToEntity(T2 model);
	
	public T2 entityToModel(T1 entity);
	
	public List<T2> entityToModel(List<T1> entitys);
}
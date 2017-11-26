package com.leysoft.project.repository.inter;

import java.util.List;

import com.leysoft.project.entity.Noticia;

public interface NoticiaRepository {
	
	public void save(Noticia noticia);
	
	public Noticia findById(Integer id);
	
	public List<Noticia> findAll();
	
	public void update(Noticia noticia);
	
	public void delete(Integer id);
}
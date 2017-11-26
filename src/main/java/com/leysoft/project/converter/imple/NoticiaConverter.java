package com.leysoft.project.converter.imple;

import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

import org.springframework.stereotype.Component;

import com.leysoft.project.converter.inter.Converter;
import com.leysoft.project.entity.Noticia;
import com.leysoft.project.model.NoticiaModel;

@Component("noticiaConverter")
public class NoticiaConverter implements Converter<Noticia, NoticiaModel> {

	@Override
	public Noticia modelToEntity(NoticiaModel model) {
		Noticia noticia = new Noticia();
		noticia.setId(model.getId());
		noticia.setTitulo(model.getTitulo());
		noticia.setContenido(model.getContenido());
		noticia.setImagen(model.getImagen().getBytes());
		return noticia;
	}

	@Override
	public NoticiaModel entityToModel(Noticia entity) {
		return new NoticiaModel(entity.getId(), entity.getTitulo(),entity.getContenido(), 
				entity.getImagen() != null?Base64.getEncoder().encodeToString(entity.getImagen()): "");
	}

	@Override
	public List<NoticiaModel> entityToModel(List<Noticia> entitys) {
		List<NoticiaModel> models = new ArrayList<>();
		entitys.forEach(e -> models.add(entityToModel(e)));
		return models;
	}
}
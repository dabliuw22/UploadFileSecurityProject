package com.leysoft.project.service.imple;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.leysoft.project.entity.Noticia;
import com.leysoft.project.repository.inter.NoticiaRepository;
import com.leysoft.project.service.inter.NoticiaService;

@Service("noticiaService")
public class NoticiaServiceImp implements NoticiaService {
	
	@Autowired @Qualifier("noticiaRepository")
	NoticiaRepository noticiaRepository;
	
	@Override
	public void save(Noticia noticia) {
		noticiaRepository.save(noticia);
	}

	@Override
	public Noticia findById(Integer id) {
		return noticiaRepository.findById(id);
	}

	@Override
	public List<Noticia> findAll() {
		return noticiaRepository.findAll();
	}

	@Override
	public void update(Noticia noticia) {
		noticiaRepository.update(noticia);
	}

	@Override
	public void delete(Integer id) {
		noticiaRepository.delete(id);
	}
}
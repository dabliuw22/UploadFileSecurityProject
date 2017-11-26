package com.leysoft.project.repository.imple;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.leysoft.project.entity.Noticia;
import com.leysoft.project.repository.inter.NoticiaRepository;

@Repository("noticiaRepository") @Transactional
public class NoticiaRepositoryImp implements NoticiaRepository {

	@Autowired
	SessionFactory sessionFactory;
	
	@Transactional
	@Override
	public void save(Noticia noticia) {
		sessionFactory.getCurrentSession().saveOrUpdate(noticia);
	}

	@Transactional(readOnly = true)
	@Override
	public Noticia findById(Integer id) {
		return (Noticia) sessionFactory.getCurrentSession().get(Noticia.class, id);
	}

	@SuppressWarnings("unchecked")
	@Transactional(readOnly = true)
	@Override
	public List<Noticia> findAll() {
		return sessionFactory.getCurrentSession().createCriteria(Noticia.class).list();
	}

	@Transactional
	@Override
	public void update(Noticia noticia) {
		sessionFactory.getCurrentSession().update(noticia);
	}

	@Transactional
	@Override
	public void delete(Integer id) {
		Noticia noticia = findById(id);
		if(noticia != null) {
			sessionFactory.getCurrentSession().delete(noticia);
		}
	}
}
package com.carros.dao.implementacion;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.StaleStateException;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import com.carros.dao.CarrosDAO;
import com.carros.model.Carro;
import com.carros.persistence.NewHibernateUtil;

@Repository
public class PostgresCarroDAO implements CarrosDAO {

	Session session;

	public PostgresCarroDAO() {
		if (session == null){
			session = new NewHibernateUtil().getSession();
		}
	}
	
	@Override
	public void insertar(Carro carro) {
		Transaction tr = session.beginTransaction();
		session.save(carro);
		session.getTransaction().commit();
		session.close();
	}

	@Override
	public void cambiar(Carro carro) {
		
		Transaction tr = session.beginTransaction();
		Carro carroLoadPersistence = (Carro) session.load(Carro.class, carro.getIdcodigo());

		try{
			if(session.contains(carroLoadPersistence)){
				session.update(carro);	
			}
			tr.commit();
			
		} catch (StaleStateException e){
			tr.rollback();
		}

	}

	@Override
	public void eliminar(Carro carro) {
		
		Transaction tr = session.beginTransaction();
		Carro carroLoadPersistence = (Carro) session.load(Carro.class, carro.getIdcodigo());

		try{
			if(session.contains(carroLoadPersistence)){
				session.delete(carroLoadPersistence);	
			}
			tr.commit();
			
		} catch (StaleStateException e){
			tr.rollback();
		}
		
	}

	@Override
	public List<Carro> listarTodos() {

		Query query = session.createQuery("from Carro");
		
		return (List<Carro>)query.list();
	}

}

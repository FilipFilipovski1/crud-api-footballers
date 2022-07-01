package springboot.crudapifootballers.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import springboot.crudapifootballers.model.Footballer;


@Repository
public class FootballerDaoImpl implements FootballerDao {

	@Autowired
	private EntityManager entityManager;
	@Override
	public List<Footballer> getAllFootballers() {
		Session currentSession=entityManager.unwrap(Session.class);
		Query<Footballer> query=currentSession.createQuery("from Footballer", Footballer.class);
		List<Footballer> list=query.getResultList();
				return list;
		
	}

	@Override
	public Footballer getFootballer(int id) {
		Session currentSession=entityManager.unwrap(Session.class);
		Footballer footballer=currentSession.get(Footballer.class, id);
		return footballer;
	}

	@Override
	public void deleteFootballer(int id) {
		Session currentSession=entityManager.unwrap(Session.class);
		Footballer footballer=currentSession.get(Footballer.class, id);
		currentSession.delete(footballer);
	}

	@Override
	public void saveFootballer(Footballer footballer) {
		Session currentSession=entityManager.unwrap(Session.class);
		currentSession.saveOrUpdate(footballer);
		
	}

}

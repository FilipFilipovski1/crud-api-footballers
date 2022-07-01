package springboot.crudapifootballers.service;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import springboot.crudapifootballers.dao.FootballerDao;
import springboot.crudapifootballers.model.Footballer;

@Service
public class FootballerServiceImpl implements FootballerService {
	
	@Autowired
	private FootballerDao footballerDao;
	
	@Transactional
	@Override
	public List<Footballer> getAllFootballers() {
		// TODO Auto-generated method stub
		return footballerDao.getAllFootballers();
	}
	@Transactional
	@Override
	public Footballer getFootballer(int id) {
		return footballerDao.getFootballer(id);
	}
	@Transactional
	@Override
	public void deleteFootballer(int id) {
		footballerDao.deleteFootballer(id);
		
	}
	@Transactional
	@Override
	public void saveFootballer(Footballer footballer) {
		footballerDao.saveFootballer(footballer);
	}

}

package springboot.crudapifootballers.dao;

import java.util.List;

import springboot.crudapifootballers.model.Footballer;

public interface FootballerDao {

	List<Footballer> getAllFootballers();
	Footballer getFootballer(int id);
	void deleteFootballer(int id);
	void saveFootballer(Footballer footballer);
	
}

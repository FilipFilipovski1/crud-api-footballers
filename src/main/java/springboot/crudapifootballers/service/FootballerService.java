package springboot.crudapifootballers.service;

import java.util.List;

import springboot.crudapifootballers.model.Footballer;

public interface FootballerService {
	List<Footballer> getAllFootballers();
	Footballer getFootballer(int id);
	void deleteFootballer(int id);
	void saveFootballer(Footballer footballer);
}

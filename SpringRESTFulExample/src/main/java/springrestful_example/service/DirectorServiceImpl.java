package springrestful_example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import springrestful_example.dao.DirectorDao;
import springrestful_example.model.Director;

@Service
public class DirectorServiceImpl implements DirectorService {

	DirectorDao directorDao;

	@Autowired
	public void setDirectorDao(DirectorDao directorDao) {
		this.directorDao = directorDao;
	}

	public List<Director> listAllDirector() {
		return directorDao.listAllDirector();
	}

	public void addDirector(Director director) {
		directorDao.addDirector(director);
	}

	public void delete(Director director) {
		directorDao.delete(director);
	}

	public void updateDirector(Director director) {
		directorDao.updateDirector(director);
	}

	public Director findDirectorById(Director director) {
		return directorDao.findDirectorById(director);
	}
}

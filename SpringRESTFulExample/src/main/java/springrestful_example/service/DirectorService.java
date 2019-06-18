package springrestful_example.service;

import java.util.List;

import springrestful_example.model.Director;

public interface DirectorService {
	public List<Director> listAllDirector();

	public void addDirector(Director director);

	public void updateDirector(Director director);

	public void delete(Director director);

	public Director findDirectorById(Director director);
}

package springrestful_example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import springrestful_example.service.DirectorService;
import springrestful_example.model.Director;

@RestController
public class DirectorController {
	@Autowired
	DirectorService directorService;

	@RequestMapping(value = "/director/", method = RequestMethod.GET, headers = "Accept=application/json")
	public ResponseEntity<List<Director>> listAllDirector() {
		List<Director> list = directorService.listAllDirector();

		if (list.size() == 0) {
			return new ResponseEntity<List<Director>>(HttpStatus.NO_CONTENT);
		}

		return new ResponseEntity<List<Director>>(list, HttpStatus.OK);
	}

	@RequestMapping(value = "/add/", method = RequestMethod.POST, headers = "Accept=application/json")
	public ResponseEntity<Void> add(@RequestBody Director director) {
		directorService.addDirector(director);

		HttpHeaders headers = new HttpHeaders();
		return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}

	@RequestMapping(value = "/update/{Directors_Id_PK}", method = RequestMethod.PUT, headers = "Accept=application/json")
	public ResponseEntity<Void> update(@PathVariable("Directors_Id_PK") int directors_Id_PK,
			@RequestBody Director director) {
		director.setDirectors_Id_PK(directors_Id_PK);
		directorService.updateDirector(director);

		HttpHeaders headers = new HttpHeaders();
		return new ResponseEntity<Void>(headers, HttpStatus.OK);
	}

	@RequestMapping(value = "/delete/{Directors_Id_PK}", method = RequestMethod.DELETE, headers = "Accept=application/json")
	public ResponseEntity<Void> delete(@PathVariable("Directors_Id_PK") int directors_Id_PK, @RequestBody Director director) {
		director.setDirectors_Id_PK(directors_Id_PK);
		directorService.delete(director);

		HttpHeaders headers = new HttpHeaders();
		return new ResponseEntity<Void>(headers, HttpStatus.NO_CONTENT);
	}
}

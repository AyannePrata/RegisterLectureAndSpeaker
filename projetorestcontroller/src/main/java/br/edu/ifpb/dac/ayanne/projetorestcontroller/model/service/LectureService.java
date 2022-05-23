package br.edu.ifpb.dac.ayanne.projetorestcontroller.model.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.ifpb.dac.ayanne.projetorestcontroller.exception.MissingFieldException;
import br.edu.ifpb.dac.ayanne.projetorestcontroller.exception.ObjectAlreadyExistsException;
import br.edu.ifpb.dac.ayanne.projetorestcontroller.exception.ObjectNotFoundException;
import br.edu.ifpb.dac.ayanne.projetorestcontroller.model.dao.LectureRepository;
import br.edu.ifpb.dac.ayanne.projetorestcontroller.model.entity.Lecture;


@Service
public class LectureService {
	
	@Autowired
	private LectureRepository lectureRepository;
	
	public List<Lecture> findAll() {
		return lectureRepository.findAll();
	}
	
	public boolean existsById(Integer id) {
		return lectureRepository.existsById(id);
	}
	
	public boolean existsByTitle(String title) {
		return lectureRepository.existsByTitle(title);
	}
	
	public Lecture findById(Integer id) throws Exception {
		if (id == null) {
			throw new MissingFieldException("id");
		}
		
		if (!existsById(id)) {
			throw new ObjectNotFoundException("Lecture", "id", id);
		}
		return lectureRepository.getById(id);
	}
	
	public Optional<Lecture> findByTitle(String title) throws Exception {
		if (title == null || title.isBlank()) {
			throw new MissingFieldException("title");
		}
		
		if (!existsByTitle(title)) {
			throw new ObjectNotFoundException("Lecture", "title", title);
		}
		return lectureRepository.findByTitle(title);
	}
	
	public Lecture save(Lecture lecture) throws Exception {
		if (lecture.getTitle() == null || lecture.getTitle().isBlank()) {
			throw new MissingFieldException("title", "save");
		}
		
		if (existsByTitle(lecture.getTitle())) {
			throw new ObjectAlreadyExistsException("A lecture with title " + lecture.getTitle() + " already exists!");
		}
		
		return lectureRepository.save(lecture);
	}
	
	public Lecture update(Lecture lecture) throws Exception {
		if (lecture.getTitle() == null || lecture.getTitle().isBlank()) {
			throw new MissingFieldException("title", "update");
		}
		
		if (lecture.getId() == null) {
			throw new MissingFieldException("id", "update");
		} else if (!existsById(lecture.getId())) {
			throw new ObjectNotFoundException("Lecture", "id", lecture.getId());
		} 
		
		if (existsByTitle(lecture.getTitle())) {
			Lecture lectureSaved = findByTitle(lecture.getTitle()).get();
			if (lectureSaved.getId() != lecture.getId()) {
				throw new ObjectAlreadyExistsException("A lecture with title " + lecture.getTitle() + " already exists!");
			}
		}

		return lectureRepository.save(lecture);
	}
	
	public void delete(Lecture lecture) throws Exception {
		if (lecture.getId() == null) {
			throw new MissingFieldException("id", "delete");
		} else if (!existsById(lecture.getId())) {
			throw new ObjectNotFoundException("Lecture", "id", lecture.getId());
		}
		
		lectureRepository.delete(lecture);
	}
	
	public void deleteById(Integer id) throws Exception {
		if (id == null) {
			throw new MissingFieldException("id", "delete");
		} else if (!existsById(id)) {
			throw new ObjectNotFoundException("Lecture", "id", id);
		}
		
		lectureRepository.deleteById(id);
	}

}

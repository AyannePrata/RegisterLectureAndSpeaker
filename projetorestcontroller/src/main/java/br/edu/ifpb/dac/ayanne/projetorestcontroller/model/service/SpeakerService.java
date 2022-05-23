package br.edu.ifpb.dac.ayanne.projetorestcontroller.model.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.ifpb.dac.ayanne.projetorestcontroller.exception.MissingFieldException;
import br.edu.ifpb.dac.ayanne.projetorestcontroller.exception.ObjectAlreadyExistsException;
import br.edu.ifpb.dac.ayanne.projetorestcontroller.exception.ObjectNotFoundException;
import br.edu.ifpb.dac.ayanne.projetorestcontroller.model.dao.SpeakerRepository;
import br.edu.ifpb.dac.ayanne.projetorestcontroller.model.entity.Speaker;



@Service
public class SpeakerService {
	
	@Autowired
	private SpeakerRepository speakerRepository;
	
	public List<Speaker> findAll() {
		return speakerRepository.findAll();
	}
	
	public boolean existsById(Integer id) {
		return speakerRepository.existsById(id);
	}
	
	public boolean existsByName(String name) {
		return speakerRepository.existsByName(name);
	}
	
	public Speaker findById(Integer id) throws Exception {
		if (id == null) {
			throw new MissingFieldException("id");
		}
		
		if (!existsById(id)) {
			throw new ObjectNotFoundException("Speaker", "id", id);
		}
		return speakerRepository.getById(id);
	}
	
	public Optional<Speaker> findByName(String name) throws Exception {
		if (name == null || name.isBlank()) {
			throw new MissingFieldException("name");
		}
		
		if (!existsByName(name)) {
			throw new ObjectNotFoundException("Speaker", "name", name);
		}
		return speakerRepository.findByName(name);
	}
	
	public Speaker save(Speaker speaker) throws Exception {
		if (speaker.getName() == null || speaker.getName().isBlank()) {
			throw new MissingFieldException("name", "save");
		}
		
		if (existsByName(speaker.getName())) {
			throw new ObjectAlreadyExistsException("A speaker with name " + speaker.getName() + " already exists!");
		}
		
		return speakerRepository.save(speaker);
	}
	
	public Speaker update(Speaker speaker) throws Exception {
		if (speaker.getName() == null || speaker.getName().isBlank()) {
			throw new MissingFieldException("name", "update");
		}
		
		if (speaker.getId() == null) {
			throw new MissingFieldException("id", "update");
		} else if (!existsById(speaker.getId())) {
			throw new ObjectNotFoundException("Speaker", "id", speaker.getId());
		} 
		
		if (existsByName(speaker.getName())) {
			Speaker speakerSaved = findByName(speaker.getName()).get();
			if (speakerSaved.getId() != speaker.getId()) {
				throw new ObjectAlreadyExistsException("A speaker with name " + speaker.getName() + " already exists!");
			}
		}

		return speakerRepository.save(speaker);
	}
	
	public void delete(Speaker speaker) throws Exception {
		if (speaker.getId() == null) {
			throw new MissingFieldException("id", "delete");
		} else if (!existsById(speaker.getId())) {
			throw new ObjectNotFoundException("Speaker", "id", speaker.getId());
		}
		
		speakerRepository.delete(speaker);
	}
	
	public void deleteById(Integer id) throws Exception {
		if (id == null) {
			throw new MissingFieldException("id", "delete");
		} else if (!existsById(id)) {
			throw new ObjectNotFoundException("Place", "id", id);
		}
		
		speakerRepository.deleteById(id);
	}

}

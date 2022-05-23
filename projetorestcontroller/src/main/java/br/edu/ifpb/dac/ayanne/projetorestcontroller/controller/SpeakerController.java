package br.edu.ifpb.dac.ayanne.projetorestcontroller.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.ifpb.dac.ayanne.projetorestcontroller.model.dto.SpeakerDTO;
import br.edu.ifpb.dac.ayanne.projetorestcontroller.model.entity.Speaker;
import br.edu.ifpb.dac.ayanne.projetorestcontroller.model.service.SpeakerConverterService;
import br.edu.ifpb.dac.ayanne.projetorestcontroller.model.service.SpeakerService;




@RestController
@RequestMapping("/api/speaker")
public class SpeakerController {
	
	
	@Autowired
	private SpeakerService speakerService;
	@Autowired
	private SpeakerConverterService converterService;
	
	
	@GetMapping
	public ResponseEntity getAll() {
		
		try {
			List<Speaker> entityList = speakerService.findAll();
			
			List<SpeakerDTO> dtoList = converterService.speakersToDtos(entityList);
			
			return ResponseEntity.ok().body(dtoList);

		} catch (Exception e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}

	}
	
	@GetMapping("/{id}")
	public ResponseEntity findById(@PathVariable Integer id) {
		
		try {
			Speaker entity = speakerService.findById(id);
			SpeakerDTO dto = converterService.speakerToDto(entity);
			
			return ResponseEntity.ok().body(dto);
		
		} catch (Exception e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}
	
	@PostMapping
	public ResponseEntity save(@RequestBody SpeakerDTO dto) {
		
		try {
			Speaker entity = converterService.dtoToSpeaker(dto);
			entity = speakerService.save(entity);
			dto = converterService.speakerToDto(entity);
			
			return new ResponseEntity(dto, HttpStatus.CREATED);
			
		} catch (Exception e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}
	
	@PutMapping("/{id}")
	public ResponseEntity update(@PathVariable Integer id, @RequestBody SpeakerDTO dto) {
		
		try {
			dto.setId(id);
			Speaker entity = converterService.dtoToSpeaker(dto);
			entity = speakerService.update(entity);
			dto = converterService.speakerToDto(entity);
			
			return ResponseEntity.ok().body(dto);
			
		} catch (Exception e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity delete(@PathVariable Integer id) {
		
		try {
			speakerService.deleteById(id);
			
			return ResponseEntity.noContent().build();
			
		} catch (Exception e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}
	
	

}

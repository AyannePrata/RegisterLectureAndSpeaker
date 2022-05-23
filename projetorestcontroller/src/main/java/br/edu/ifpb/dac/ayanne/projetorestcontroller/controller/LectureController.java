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

import br.edu.ifpb.dac.ayanne.projetorestcontroller.model.dto.LectureDTO;
import br.edu.ifpb.dac.ayanne.projetorestcontroller.model.entity.Lecture;
import br.edu.ifpb.dac.ayanne.projetorestcontroller.model.service.LectureConverterService;
import br.edu.ifpb.dac.ayanne.projetorestcontroller.model.service.LectureService;



@RestController
@RequestMapping("/api/lecture")
public class LectureController {
	
	@Autowired
	private LectureService lectureService;
	@Autowired
	private LectureConverterService converterService;
	
	
	@GetMapping
	public ResponseEntity getAll() {
		List<Lecture> entityList = lectureService.findAll();
		
		List<LectureDTO> dtoList = converterService.lecturesToDtos(entityList);
		
		return ResponseEntity.ok().body(dtoList);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity findById(@PathVariable Integer id) {
		
		try {
			Lecture entity = lectureService.findById(id);
			LectureDTO dto = converterService.lectureToDto(entity);
			
			return ResponseEntity.ok().body(dto);
		
		} catch (Exception e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}
	
	@PostMapping
	public ResponseEntity save(@RequestBody LectureDTO dto) {
		
		try {
			Lecture entity = converterService.dtoToLecture(dto);
			entity = lectureService.save(entity);
			dto = converterService.lectureToDto(entity);
			
			return new ResponseEntity(dto, HttpStatus.CREATED);
			
		} catch (Exception e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}
	
	@PutMapping("/{id}")
	public ResponseEntity update(@PathVariable Integer id, @RequestBody LectureDTO dto) {
		
		try {
			dto.setId(id);
			Lecture entity = converterService.dtoToLecture(dto);
			entity = lectureService.update(entity);
			dto = converterService.lectureToDto(entity);
			
			return ResponseEntity.ok().body(dto);
			
		} catch (Exception e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity delete(@PathVariable Integer id) {
		
		try {
			lectureService.deleteById(id);
			
			return ResponseEntity.noContent().build();
			
		} catch (Exception e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}

}

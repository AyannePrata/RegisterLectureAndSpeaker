package br.edu.ifpb.dac.ayanne.projetorestcontroller.model.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import br.edu.ifpb.dac.ayanne.projetorestcontroller.model.dto.LectureDTO;
import br.edu.ifpb.dac.ayanne.projetorestcontroller.model.entity.Lecture;


@Service
public class LectureConverterService {
	
	public Lecture dtoToLecture(LectureDTO dto) {
		if (dto != null) {
			
			Lecture entity = new Lecture();
			entity.setId(dto.getId());
			entity.setTitle(dto.getTitle());
			
			return entity;
		}
		
		throw new IllegalArgumentException("Could not convert because object is null");
	}
	
	public LectureDTO lectureToDto(Lecture entity) {
		if (entity != null) {
			
			LectureDTO dto = new LectureDTO();
			dto.setId(entity.getId());
			dto.setTitle(entity.getTitle());
			
			return dto;
		}
		
		throw new IllegalArgumentException("Could not convert because object is null");
	}

	public List<Lecture> dtosToLectures(List<LectureDTO> dtoList) {
		
		if (dtoList != null) {
			List<Lecture> entityList = new ArrayList<>();
			
			Lecture entity = null;
			
			if (!dtoList.isEmpty()) {
				for (LectureDTO dto: dtoList) {
					entity = dtoToLecture(dto);
					entityList.add(entity);
				}
			}
			
			return entityList;
		}
		
		throw new IllegalArgumentException("Could not convert because object is null");
	}
	
	public List<LectureDTO> lecturesToDtos(List<Lecture> entityList) {
		if (entityList != null) {
			List<LectureDTO> dtoList = new ArrayList<>();
			
			LectureDTO dto = null;
			
			if (!entityList.isEmpty()) {
				for (Lecture lecture: entityList) {
					dto = lectureToDto(lecture);
					dtoList.add(dto);
				}
			}
			
			return dtoList;
		}
		
		throw new IllegalArgumentException("Could not convert because object is null");
	}

}

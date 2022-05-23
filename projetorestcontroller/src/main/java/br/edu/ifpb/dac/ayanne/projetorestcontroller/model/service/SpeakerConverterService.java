package br.edu.ifpb.dac.ayanne.projetorestcontroller.model.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.ifpb.dac.ayanne.projetorestcontroller.model.dto.SpeakerDTO;
import br.edu.ifpb.dac.ayanne.projetorestcontroller.model.entity.Speaker;



@Service
public class SpeakerConverterService {
	
	@Autowired
	private LectureService lectureService;
	
	public Speaker dtoToSpeaker(SpeakerDTO dto) throws Exception  {
		if (dto != null) {
			
			Speaker entity = new Speaker();
			entity.setId(dto.getId());
			entity.setName(dto.getName());
			entity.setProfession(dto.getProfession());
			entity.setLecture(dto.getLecture());
			
			return entity;
		}
		
		throw new IllegalArgumentException("Could not convert because object is null");
	}
	
	public SpeakerDTO speakerToDto(Speaker entity) throws Exception {
		if (entity != null) {
			
			SpeakerDTO dto = new SpeakerDTO();
			dto.setId(entity.getId());
			dto.setName(entity.getName());
			dto.setProfession(entity.getProfession());
			dto.setLecture(entity.getLecture());
			
			return dto;
		}
		
		throw new IllegalArgumentException("Could not convert because object is null");
	}

	public List<Speaker> dtosToSpeakers(List<SpeakerDTO> dtoList) throws Exception{
		
		if (dtoList != null) {
			List<Speaker> entityList = new ArrayList<>();
			
			Speaker entity = null;
			
			if (!dtoList.isEmpty()) {
				for (SpeakerDTO dto: dtoList) {
					entity = dtoToSpeaker(dto);
					entityList.add(entity);
				}
			}
			
			return entityList;
		}
		
		throw new IllegalArgumentException("Could not convert because object is null");
	}
	
	public List<SpeakerDTO> speakersToDtos(List<Speaker> entityList) throws Exception {
		if (entityList != null) {
			List<SpeakerDTO> dtoList = new ArrayList<>();
			
			SpeakerDTO dto = null;
			
			if (!entityList.isEmpty()) {
				for (Speaker speaker: entityList) {
					dto = speakerToDto(speaker);
					dtoList.add(dto);
				}
			}
			
			return dtoList;
		}
		
		throw new IllegalArgumentException("Could not convert because object is null");
	}

}

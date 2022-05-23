package br.edu.ifpb.dac.ayanne.projetorestcontroller.model.dto;

public class SpeakerDTO {
	
	private Integer id;
	private String name;
	private String profession;
	private String lecture;
	
	public SpeakerDTO() {
		
	}


	public SpeakerDTO(String name, String profession, String lecture) {
		this.name = name;
		this.profession = profession;
		this.lecture = lecture;
	}
	
	
	public SpeakerDTO(Integer id, String name, String profession, String lecture) {
		this.id = id;
		this.name = name;
		this.profession = profession;
		this.lecture = lecture;
	}


	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	

	public String getProfession() {
		return profession;
	}


	public void setProfession(String profession) {
		this.profession = profession;
	}


	public String getLecture() {
		return lecture;
	}

	public void setLecture(String lecture) {
		this.lecture = lecture;
	}
	
	
}

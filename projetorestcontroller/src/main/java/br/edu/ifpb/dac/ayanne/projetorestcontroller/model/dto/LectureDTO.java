package br.edu.ifpb.dac.ayanne.projetorestcontroller.model.dto;

public class LectureDTO {
	
	private Integer id;
	private String title;


	public LectureDTO() {
		
	}
	
	public LectureDTO(String title) {
		this.title = title;
	}
	
	public LectureDTO(Integer id, String title) {
		this.id = id;
		this.title = title;
	}


	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}

}

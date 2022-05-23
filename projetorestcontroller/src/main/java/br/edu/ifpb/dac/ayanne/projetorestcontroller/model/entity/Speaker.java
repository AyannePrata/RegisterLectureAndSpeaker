package br.edu.ifpb.dac.ayanne.projetorestcontroller.model.entity;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Table(name = "SPEAKER")
@Entity
public class Speaker implements Serializable {
	
private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "SPEAKER_ID")
	private Integer id;
	
	@Column(name = "SPEAKER_NAME", nullable = false)
	private String name;
	
	@Column(name = "SPEAKER_PROFESSION")
	private String profession;
	
	@Column(name = "SPEAKER_LECTURE")
	private String lecture;;

	public Speaker() {
		
	}


	public Speaker(Integer id, String name, String profession, String lecture) {
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

	public String getProfession() {
		return profession;
	}


	public void setProfession(String profession) {
		this.profession = profession;
	}


	public void setName(String name) {
		this.name = name;
	}
	
	

	public String getLecture() {
		return lecture;
	}

	public void setLecture(String lecture) {
		this.lecture = lecture;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Speaker other = (Speaker) obj;
		return Objects.equals(id, other.id);
	}
	
	
	

}

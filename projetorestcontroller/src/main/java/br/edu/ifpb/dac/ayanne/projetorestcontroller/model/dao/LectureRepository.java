package br.edu.ifpb.dac.ayanne.projetorestcontroller.model.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.edu.ifpb.dac.ayanne.projetorestcontroller.model.entity.Lecture;


@Repository
public interface LectureRepository extends JpaRepository<Lecture, Integer> {
	
	public Optional<Lecture> findByTitle(String title);
	public boolean existsByTitle(String title);

}

package br.edu.ifpb.dac.ayanne.projetorestcontroller.model.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.edu.ifpb.dac.ayanne.projetorestcontroller.model.entity.Speaker;

@Repository
public interface SpeakerRepository  extends JpaRepository<Speaker, Integer> {
	
	public Optional<Speaker> findByName(String name);
	public boolean existsByName(String name);

}

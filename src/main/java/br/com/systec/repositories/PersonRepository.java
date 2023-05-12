package br.com.systec.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.systec.model.Person;

@Repository
public interface PersonRepository  extends JpaRepository<Person, Long>{}

package com.pokebattle.pokebattleapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pokebattle.pokebattleapi.model.Attributes;

@Repository
public interface AttributesRepository extends JpaRepository<Attributes, Long> {
    
}

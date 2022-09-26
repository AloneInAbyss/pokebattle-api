package com.pokebattle.pokebattleapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pokebattle.pokebattleapi.model.Team;

@Repository
public interface TeamRepository extends JpaRepository<Team, Long> {
    
}

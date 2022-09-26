package com.pokebattle.pokebattleapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pokebattle.pokebattleapi.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}

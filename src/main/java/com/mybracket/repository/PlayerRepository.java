package com.mybracket.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mybracket.entity.Player;

@Repository
public interface PlayerRepository extends JpaRepository<Player, String> {

	Optional<Player> getByEmail(String email);
//
//	Optional<Player> login(String username, String password);

}

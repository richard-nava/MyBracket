package com.mybracket.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.mybracket.entity.Player;

@Repository
public interface PlayerRepository extends JpaRepository<Player, String> {
	
	// for searching by email
	Optional<Player> getByEmail(String email);

	// login query
	@Query("FROM Player WHERE username=?1 AND password=?2")
	Optional<Player> login(String username, String password);

}

package com.mybracket.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mybracket.entity.Tournament;

@Repository
public interface TournamentRepository extends JpaRepository<Tournament, Long> {

}

package com.mybracket.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mybracket.entity.Bracket;

@Repository
public interface BracketRepository extends JpaRepository<Bracket, Long> {

}

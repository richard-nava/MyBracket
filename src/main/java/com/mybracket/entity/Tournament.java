package com.mybracket.entity;

import java.util.ArrayList;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tournament")
public class Tournament {
	
	@Id
	@Column(name="id")
	private Long id;
	
	@Column(name="tournament_name")
	private String name;
	
	@Column(name="guest_tournament")
	private boolean guest = false;
	
	
	

	
	// ********** constructors **********
	public Tournament() {}
	
	
	
	// ********** functions **********
	
	// Take in String of temp players and sort them as players
	public static ArrayList<TempPlayer> generateTournament(String namesAsString) {
		
		ArrayList<TempPlayer> tempTorunamentPlayers = new ArrayList<>();
		
		String[] playerNames = namesAsString.split(",");
		
		for(String var : playerNames) {
			
			TempPlayer player = new TempPlayer(var);
			tempTorunamentPlayers.add(player);
		}
		
		
		return tempTorunamentPlayers;
	}
	
	
	
	// ********** Getters/Setters **********
	public String getName() {
		return name;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public boolean isGuest() {
		return guest;
	}

	public void setGuest(boolean guest) {
		this.guest = guest;
	}

	public void setName(String name) {
		this.name = name;
	}


}

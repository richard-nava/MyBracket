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
	
	
	
//	private ArrayList<Player> players;
//	
//	Bracket bracket = new Bracket();
//	
	
	
	
	
	public String getName() {
		return name;
	}





	public void setName(String name) {
		this.name = name;
	}





//	public ArrayList<Player> getPlayers() {
//		return players;
//	}
//
//
//
//
//
//	public void setPlayers(ArrayList<Player> players) {
//		this.players = players;
//	}
//
//
//
//
//
//	public Bracket getBracket() {
//		return bracket;
//	}
//
//
//
//
//
//	public void setBracket(Bracket bracket) {
//		this.bracket = bracket;
//	}





//	public void createTempPlayers(String str){
//		
//		String[] players = str.split(", ");
//		
//		for(String var: players) {
//			
//			TempPlayer newPlayer = new TempPlayer();
//			newPlayer.setName(var);
//			bracket.activeTempPlayers.add(newPlayer);
//			
//			
//		}
//	}

}

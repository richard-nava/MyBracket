package com.mybracket.entity;

import java.util.ArrayList;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="brackets")
public class Bracket {
	
	@Id
	@Column(name="ID")
	private Long id;
	
	
	@Column(name="bracket_name")
	private String name;
	ArrayList<Player> totalPlayers = new ArrayList<>();
	ArrayList<Player> activePlayers = new ArrayList<>();
	ArrayList<TempPlayer> totalTempPlayers = new ArrayList<>();
	ArrayList<TempPlayer> activeTempPlayers = new ArrayList<>();
	

	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
//
//	public ArrayList<Player> getTotalPlayers() {
//		return totalPlayers;
//	}
//
//	public void setTotalPlayers(ArrayList<Player> totalPlayers) {
//		this.totalPlayers = totalPlayers;
//	}
//
//	public ArrayList<Player> getActivePlayers() {
//		return activePlayers;
//	}
//
//	public void setActivePlayers(ArrayList<Player> activePlayers) {
//		this.activePlayers = activePlayers;
//	}
//
//	public ArrayList<TempPlayer> getTotalTempPlayers() {
//		return totalTempPlayers;
//	}
//
//	public void setTotalTempPlayers(ArrayList<TempPlayer> totalTempPlayers) {
//		this.totalTempPlayers = totalTempPlayers;
//	}
//
//	public ArrayList<TempPlayer> getActiveTempPlayers() {
//		return activeTempPlayers;
//	}
//
//	public void setActiveTempPlayers(ArrayList<TempPlayer> activeTempPlayers) {
//		this.activeTempPlayers = activeTempPlayers;
//	}




}

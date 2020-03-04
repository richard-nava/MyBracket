package com.mybracket.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="temporary_players")
public class TempPlayer {
	
	@Id
	@Column(name="Name")
	private String name;
	
	public TempPlayer() {}
	
	public TempPlayer(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}

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
	public ArrayList<Player> totalPlayers = new ArrayList<>();
	public ArrayList<Player> activePlayers = new ArrayList<>();
	public ArrayList<TempPlayer> totalTempPlayers = new ArrayList<>();
	public ArrayList<TempPlayer> activeTempPlayers = new ArrayList<>();
	public ArrayList<Match> matches = new ArrayList<>();
	public ArrayList<TempMatch> tempMatches = new ArrayList<>();
	int currentRound;
	int totalRounds;
	

	
	
	// ************* Methods *****************
	
	// determine # of matches
	
	
	
	// to create bracket
	public static void createBracket(ArrayList<Player> players) {
		
		int playerCount = players.size();
		
		
		
	}
	
	
	// to determine total # of rounds in a bracket
	public static int totalRounds(ArrayList<Player> activePlayers) {
		
		int totalRounds = 0;
		double playerNum = activePlayers.size();
		
		do {
			playerNum /= 2; 
			totalRounds++;
			
		}while(playerNum > 1);
		
		return totalRounds;
	}
	
	public int totalTempRounds(ArrayList<TempPlayer> activePlayers) {
		
		int totalRounds = 0;
		double playerNum = activePlayers.size();
		
		do {
			playerNum /= 2; 
			totalRounds++;
			
		}while(playerNum > 1);
		
		return totalRounds;
	}


	// to generate the current round of matches
	public ArrayList<TempMatch> generateTempMatches(ArrayList<TempPlayer> activePlayers){
		
		ArrayList<TempMatch> matches = new ArrayList<TempMatch>();
		
		for(int i=0;i<activePlayers.size()-1;i++) {
			
			TempPlayer current = activePlayers.get(i);
			
			TempPlayer following = activePlayers.get(i+1);
		
			if(current.isInMatch() == false) {
				

				TempMatch match = new TempMatch();
			
				// assign players to a match and adjust their inMatch bool to true
				match.player1 = current;
				match.player2 = following;
				current.setInMatch(true);
				following.setInMatch(true);
				
				// add the match to the bracket list
				matches.add(match);
				
				
			}
			
		}
		
		return matches;
	}
	
	
	
	// ************* Bracket ****************

	public Bracket() {}
	

	// ************* Getters/Setters ****************
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

	public ArrayList<Player> getTotalPlayers() {
		return totalPlayers;
	}

	public void setTotalPlayers(ArrayList<Player> totalPlayers) {
		this.totalPlayers = totalPlayers;
	}

	public ArrayList<Player> getActivePlayers() {
		return activePlayers;
	}

	public void setActivePlayers(ArrayList<Player> activePlayers) {
		this.activePlayers = activePlayers;
	}

	public ArrayList<TempPlayer> getTotalTempPlayers() {
		return totalTempPlayers;
	}

	public void setTotalTempPlayers(ArrayList<TempPlayer> totalTempPlayers) {
		this.totalTempPlayers = totalTempPlayers;
	}

	public ArrayList<TempPlayer> getActiveTempPlayers() {
		return activeTempPlayers;
	}

	public void setActiveTempPlayers(ArrayList<TempPlayer> activeTempPlayers) {
		this.activeTempPlayers = activeTempPlayers;
	}

	public ArrayList<Match> getMatches() {
		return matches;
	}


	public void setMatches(ArrayList<Match> matches) {
		this.matches = matches;
	}


	public ArrayList<TempMatch> getTempMatches() {
		return tempMatches;
	}


	public void setTempMatches(ArrayList<TempMatch> tempMatches) {
		this.tempMatches = tempMatches;
	}


	public int getCurrentRound() {
		return currentRound;
	}


	public void setCurrentRound(int currentRound) {
		this.currentRound = currentRound;
	}


	public int getTotalRounds() {
		return totalRounds;
	}


	public void setTotalRounds(int totalRounds) {
		this.totalRounds = totalRounds;
	}


	

}

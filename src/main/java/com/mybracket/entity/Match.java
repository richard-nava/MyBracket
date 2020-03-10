package com.mybracket.entity;

import java.util.ArrayList;

public class Match {
	
	public Player player1;
	public Player player2;
	private Player[] match = {player1, player2};
	int matchRound;
	
	
	// ************* Methods *****************

	
	
	
	
	
	// ************* Getters/Setters ****************
	
	
	public Player getPlayer1() {
		return player1;
	}
	public int getMatchRound() {
		return matchRound;
	}
	public void setMatchRound(int matchRound) {
		this.matchRound = matchRound;
	}
	public void setPlayer1(Player player1) {
		this.player1 = player1;
	}
	public Player getPlayer2() {
		return player2;
	}
	public void setPlayer2(Player player2) {
		this.player2 = player2;
	}
	public Player[] getMatch() {
		return match;
	}
	public void setMatch(Player[] match) {
		this.match = match;
	}
	
	

}

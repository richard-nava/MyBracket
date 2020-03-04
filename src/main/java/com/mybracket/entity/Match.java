package com.mybracket.entity;

public class Match {
	
	private Player player1;
	private Player player2;
	private Player[] match = {player1, player2};
	
	public Player getPlayer1() {
		return player1;
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

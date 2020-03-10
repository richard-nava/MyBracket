package com.mybracket.entity;

import java.util.ArrayList;
import java.util.Arrays;

public class TempMatch {
	
	public TempPlayer player1;
	public TempPlayer player2;
	private TempPlayer[] match = {player1, player2};
	int matchRound;
	
	
	
	
	
	public static void createTempMatch(ArrayList<TempPlayer> players, int currentRound) {
		if(players.size() % 2 == 0) {
			
			System.out.println("in player count section");
			
			// create the Matches and place in the bracket
			try {
				for(int i=0;i<players.size() -1; i++) {
					
					
					
					TempPlayer current = players.get(i);
					
					TempPlayer following = players.get(i+1);
				
					if(current.isInMatch() == false) {
						

						TempMatch match = new TempMatch();
					
						// assign players to a match and adjust their inMatch bool to true
						match.player1 = current;
						match.player2 = following;
						current.setInMatch(true);
						following.setInMatch(true);
						
						// set the match round to the current round. 
						match.setMatchRound(currentRound);
						
						// add the match to the bracket list
					//FIX THIS	bracket.matches.add(match);
						
					}
					
				
				}
			}catch(IndexOutOfBoundsException e){
				System.out.println("out of bounds?");
			}
		
		// if theres an odd number of players, there will be a bye	
		}else{
			
			TempPlayer bye = players.get(0);
			
			for(int i=1;i<players.size() -1; i++) {
				
				TempPlayer current = players.get(i);
				
				TempPlayer following = players.get(i+1);
			
				if(current.isInMatch() == false) {
					

					TempMatch match = new TempMatch();
				
					// assign players to a match and adjust their inMatch bool to true
					match.player1 = current;
					match.player2 = following;
					current.setInMatch(true);
					following.setInMatch(true);
					
					// add the match to the bracket list
				//FIX THIS	bracket.matches.add(match);
					
				}

			}
					
		}
		
	}

	
	public String getP1name() {
		return player1.getName();
	}
	

	public String getP2name() {
		return player2.getName();
	}

	public TempPlayer getPlayer1() {
		return player1;
	}


	public void setPlayer1(TempPlayer player1) {
		this.player1 = player1;
	}


	public TempPlayer getPlayer2() {
		return player2;
	}


	public void setPlayer2(TempPlayer player2) {
		this.player2 = player2;
	}


	public TempPlayer[] getMatch() {
		return match;
	}


	public void setMatch(TempPlayer[] match) {
		this.match = match;
	}


	public int getMatchRound() {
		return matchRound;
	}


	public void setMatchRound(int matchRound) {
		this.matchRound = matchRound;
	}


	@Override
	public String toString() {
		return "TempMatch [player1=" + player1 + ", player2=" + player2 + ", match=" + Arrays.toString(match)
				+ ", matchRound=" + matchRound + "]";
	}


	
	

}

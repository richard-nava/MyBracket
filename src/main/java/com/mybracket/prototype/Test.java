package com.mybracket.prototype;

import java.util.ArrayList;

import com.mybracket.entity.Bracket;
import com.mybracket.entity.Match;
import com.mybracket.entity.Player;
import com.mybracket.entity.TempMatch;
import com.mybracket.entity.TempPlayer;

public class Test {
	
	public static int dtr(Player[] activePlayers) {
		
		int totalRounds = 0;
		double playerNum = activePlayers.length;
		
		do {
			playerNum /= 2; 
			totalRounds++;
			
		}while(playerNum > 1);
		
		return totalRounds;
	}
	
	public static int numMatch(int totalRounds, Player[] players) {
		
		int numMatches = 0;
		double playerCount = players.length;
		
		for(int i = 0; i<=totalRounds;i++) {
			
			do {
				
				numMatches += playerCount / 2;
				playerCount/=2; 
				
			}while(playerCount > 1);
			
		}
		
		
		
		
		return numMatches;
	}
	
	
	public static void fillBracket(ArrayList<TempPlayer> active, int rounds, ArrayList<TempMatch> matches) {
		
		int num = active.size()/2;
		
			for(int i=1;i<=rounds;i++){
			
			int matchesNeededForRound = num;
			
				for(int j=1;j<=matchesNeededForRound;j++) {
					TempMatch match = new TempMatch();
					match.setMatchRound(i);
					matches.add(match);
				}
				
			num /= 2;
			
			}
		
		
	}
	
	public static void generateTempMatches(ArrayList<TempPlayer> activePlayers){
		
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
	}
	
	
	public static void assignPlayers(ArrayList<TempPlayer> active, int currentRound, ArrayList<TempMatch> matches) {
		
		// look at each match
		for(TempMatch var: matches) {
			
			// if the match's round equal the current round
			if(var.getMatchRound() == currentRound){
				
				for(int i=0;i<active.size()-1;i++) {
				
					TempPlayer current = active.get(i);
					TempPlayer following = active.get(i+1);
					
					if(current.isInMatch() == false) {
							
						// assign players to the match and adjust their inMatch bool to true
						var.player1 = current;
						var.player2 = following;
						current.setInMatch(true);
						following.setInMatch(true);	
						break;
					}
				}
			}
		}
	}
	

	public static void main(String[] args) {
		
		ArrayList<TempPlayer> active = new ArrayList<>();
		
		for(int i=0;i<8;i++) {
			TempPlayer player = new TempPlayer();
			player.setName("player "+ i);
			active.add(player);
			
		}
		
		for(int i=0;i<active.size();i++) {
			
			System.out.println("Player name: " + active.get(i).getName());
		}
		
		ArrayList<TempMatch> matches = new ArrayList<>();
		
		
		fillBracket(active, Bracket.totalTempRounds(active), matches);
		
		
		
		for(int i=0;i<matches.size();i++) {
			
			System.out.println(matches.get(i).getMatchRound());
			
		}
		
		assignPlayers(active,1,matches);
		
		for(TempMatch var:matches) {
			System.out.println(var);
		}
		
		
	}
	
	
}

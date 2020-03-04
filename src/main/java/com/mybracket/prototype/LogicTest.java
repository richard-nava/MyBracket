package com.mybracket.prototype;

import java.util.ArrayList;
import java.util.Scanner;

import com.mybracket.entity.Bracket;
import com.mybracket.entity.Match;
import com.mybracket.entity.Player;

/* 
 * This is based (copy/pasted) off my initial prototype of tournament bracket logic 
 * and therefore is not operational in this application. Classes include methods 
 * and parameters not specified in this program.
 */



public class LogicTest {

ArrayList<Player> players = new ArrayList<Player>();
	
	static Bracket bracket = new Bracket();
	
	static Player player = new Player();
	
	static Match match = new Match();
	
	
	public static void main(String[] args) {
		
		// Get players for tournament
		System.out.println("Enter players separated by commas + space: ");
		Scanner in = new Scanner(System.in);
		
		String playerEntries = in.nextLine();
		
		// Create bracket + split names into array of strings
		
		String[] playersNameArray = playerEntries.split(", ");
		
		
		// create the bracket
		for(int i=0;i<playersNameArray.length;i++) {
		
			Player player = new Player();
			player.setFname(playersNameArray[i]);
			bracket.totalPlayers.add(player);
			
		}
		
		// copy totalPlayers into activePlayers
		bracket.activePlayers.addAll(bracket.totalPlayers);
		
		
		
		
		// if theres an even number of players, everyone plays a game
		if(bracket.totalPlayers.size() % 2 == 0) {
			
			System.out.println("in player count section");
			
			// create the Matches and place in the bracket
			try {
				for(int i=0;i<bracket.totalPlayers.size() -1; i++) {
					
					
					
					Player current = bracket.totalPlayers.get(i);
					
					Player following = bracket.totalPlayers.get(i+1);
				
					if(current.inMatch == false) {
						

						Match match = new Match();
					
						// assign players to a match and adjust their inMatch bool to true
						match.player1 = current;
						match.player2 = following;
						current.setInMatch(true);
						following.setInMatch(true);
						
						// add the match to the bracket list
						bracket.matches.add(match);
						
					}
					
				
				}
			}catch(IndexOutOfBoundsException e){
				System.out.println("out of bounds?");
			}
		
		// if theres an odd number of players, there will be a bye	
		}else{
			
			Player bye = bracket.totalPlayers.get(0);
			
			for(int i=1;i<bracket.totalPlayers.size() -1; i++) {
				
				Player current = bracket.totalPlayers.get(i);
				
				Player following = bracket.totalPlayers.get(i+1);
			
				if(current.inMatch == false) {
					

					Match match = new Match();
				
					// assign players to a match and adjust their inMatch bool to true
					match.player1 = current;
					match.player2 = following;
					current.setInMatch(true);
					following.setInMatch(true);
					
					// add the match to the bracket list
					bracket.matches.add(match);
					
				}

			}
					
		}
		
		// ------------Match Winners---------------------
		
		
		// determine match winners
		for(Match var:bracket.matches) {
			System.out.println("Who won this match: " + var);
			String playerName = in.next();
			
			if(var.player1.getFname().equals(playerName)) {
				
				var.matchWinner(var.player1);
				bracket.activePlayers.remove(var.player2);
			}else {
				var.matchWinner(var.player2);
				bracket.activePlayers.remove(var.player1);
			}
			
		}
		
		bracket.matches.removeAll(bracket.matches);
		
		// go to next round:
		for(int i=0;i<bracket.activePlayers.size() -1; i++) {
			
			Player current = bracket.activePlayers.get(i);
			Player following = bracket.activePlayers.get(i+1);
			

			if(current.inMatch == false) {
				

				Match match = new Match();
			
				// assign players to a match and adjust their inMatch bool to true
				match.player1 = current;
				match.player2 = following;
				current.setInMatch(true);
				following.setInMatch(true);
				
				// add the match to the bracket list
				bracket.matches.add(match);
				
				
			}
		}
		
		for(Match var:bracket.matches) {
			System.out.println("Who won this match: " + var);
			String playerName = in.next();
			
			if(var.player1.getFname().equals(playerName)) {
				
				var.matchWinner(var.player1);
				bracket.activePlayers.remove(var.player2);
			}else {
				var.matchWinner(var.player2);
				bracket.activePlayers.remove(var.player1);
			}
			
		}
		
		if(bracket.activePlayers.size() == 1) {
			
			System.out.println("The winner is " + bracket.activePlayers.toString());
		}
	}

}

package com.mybracket.prototype;

import java.util.ArrayList;

import com.mybracket.entity.Player;

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

	public static void main(String[] args) {
		
		
		Player[] test = new Player[7];
		
		int totalRounds = dtr(test);
		
		
		System.out.println(totalRounds);

	}

}

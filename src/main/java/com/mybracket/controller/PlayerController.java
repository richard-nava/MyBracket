package com.mybracket.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.mybracket.entity.Bracket;
import com.mybracket.entity.Player;
import com.mybracket.entity.TempPlayer;
import com.mybracket.entity.TempMatch;
import com.mybracket.entity.Tournament;
import com.mybracket.repository.PlayerRepository;

@CrossOrigin
@Controller
@SessionAttributes({"loggedInUser","tournamentBracket"})
public class PlayerController {
	
	@Autowired
	PlayerRepository playerRepo;
	
	
	// ***************** Login/Logout *****************
	@GetMapping("login")
	String login() {
		return "login";
	}
	
	@PostMapping("login")
	String login(@RequestParam String username,
				 @RequestParam String password, Model model) {
		
		Optional<Player>  usr = playerRepo.login(username,password);
		if(usr.isPresent()) {
			
			model.addAttribute("msg", "Welcome to MyBracket!");
			model.addAttribute("loggedInUser", usr.get());
			return "profile";
		}
		
		model.addAttribute("error", "Invalid credentials");
		return "login";
	}
	
	@GetMapping("logout")
	String logout(SessionStatus status, Model model) {
		
		status.setComplete();
		model.addAttribute("loggedInUser", "");
		model.addAttribute("msg", "Farewell!");
		return "login";
	}
	
	
	
	// ***************** Sign up *****************
	@GetMapping("signup")
	String signup(Model model) {
		model.addAttribute("player", new Player());
		return "signup";
	}
	
	@PostMapping("signup")
	String signup(@ModelAttribute Player player, RedirectAttributes redirect) {
		
		try {
			Optional<Player> usr = playerRepo.getByEmail(player.getEmail());
			if(usr.isPresent()) {
				
				redirect.addFlashAttribute("error", "User already exists");
				return "redirect:/signup";
			}
			playerRepo.save(player);
			System.out.println("********************player saved********************");
			redirect.addFlashAttribute("msg", "Registration Successful");
		}catch(Exception e) {
			
		}
		
	return "redirect:/login";
	}
	
	
	// ***************** Guest Tournaments (Tournaments that aren't saved) ***********
	@GetMapping("guest-tournament")
	String guestTourney(Model model) {
		model.addAttribute("bracket", new Bracket());
		return "guest-tournament";
	}
	
	
	@PostMapping("guestTournamentCreate")
	String createGuestTournament(@RequestParam String names,@RequestParam String bracketName, Model model) {
		Bracket bracket = new Bracket();
		int currentRound = 1;
		ArrayList<TempPlayer> players = Tournament.generateTournament(names);
		ArrayList<TempPlayer> activePlayers = new ArrayList<>();
		activePlayers.addAll(players);
		bracket.setTotalRounds(bracket.totalTempRounds(activePlayers));
		int totalRounds = bracket.getTotalRounds();
		int totalMatches = activePlayers.size() - 1;


		
		// make it so this method also takes in current round and applies it to the match
		ArrayList<TempMatch> matches = bracket.generateTempMatches(activePlayers);		
		ArrayList<TempMatch> allMatches = new ArrayList<>();
		
		
		
		model.addAttribute("players", players);
		model.addAttribute("activePlayers", activePlayers);
		model.addAttribute("matches", matches);
		model.addAttribute("allMatches", allMatches);
		model.addAttribute("bracket", bracket);
		model.addAttribute("totalRounds", totalRounds);
		model.addAttribute("currentRound", currentRound);
		
		
		
		
		return "your-tournament";
	}
	
	
	@PostMapping("guestTournamentCreate2")
	String createGuestTournament2(@RequestParam String names,@ModelAttribute Bracket bracket, String bracketName, Model model) {
		
		
		model.addAttribute("tournamentBracket", bracket);

		int currentRound = 1;
		ArrayList<TempPlayer> players = Tournament.generateTournament(names);
		
		ArrayList<TempPlayer> activePlayers = new ArrayList<>();
		activePlayers.addAll(players);
		bracket.setTotalRounds(bracket.totalTempRounds(activePlayers));
		int totalRounds = bracket.getTotalRounds();


		
		// make it so this method also takes in current round and applies it to the match
		//ArrayList<TempMatch> matches = bracket.generateTempMatches(activePlayers, currentRound);		
		ArrayList<TempMatch> matches = new ArrayList<TempMatch>();
		bracket.setTempMatches(matches);
		Bracket.fillTempBracket(activePlayers, totalRounds, matches);
		Bracket.assignPlayers(activePlayers, currentRound, matches);
		
		
		
		bracket.setName(bracketName);
		bracket.setActiveTempPlayers(activePlayers);
		bracket.setTotalTempPlayers(players);
		bracket.setTotalRounds(totalRounds);
		bracket.setCurrentRound(currentRound);
		
		
		
		return "your-tournament";
	}
	
	
	/*
	 *  pushing the "update" button will update the 
	 *	tournament bracket
	 */ 
	
	@RequestMapping(value="updateGuestTournament", method=RequestMethod.GET)
	String updateGuestTournament(@RequestParam int currentRound, @RequestParam ArrayList<TempPlayer> players,
								 @RequestParam ArrayList<TempPlayer> activePlayers, @RequestParam TempPlayer winner,
								 @RequestParam ArrayList<TempMatch> matches, @RequestParam Bracket bracket, Model model){
		System.out.println("**********" + winner + "**********");

		// pump current round ++ 
		int newCurrentRound = currentRound + 1;
		
		
		// take in winners
		
		
		
		// subtract losing players from active players
		
		
		
		// matchup active players
		model.addAttribute("currentRound", newCurrentRound);
		
		
		
		return "index";
	}
	
	
	
	@GetMapping("profile")
	String profile() {
		return "profile";
	}
	
	
	@GetMapping(value={"/","index"})
	String index() {
		return "index";
	}
	
	
	// ***************** Tests for Postman *****************

	@RequestMapping(value="/playerSearch", 
			produces=MediaType.APPLICATION_JSON_VALUE,
			method=RequestMethod.GET)
	@ResponseBody
	private ResponseEntity<Optional<Player>> findPlayer(String username) {
		
		Optional<Player> player = playerRepo.findById(username);
		
		return new ResponseEntity<>(player, HttpStatus.OK);
		
	}
	
	@RequestMapping(value="/viewAll", 
			produces=MediaType.APPLICATION_JSON_VALUE,
			method=RequestMethod.GET)
	@ResponseBody
	private ResponseEntity<List<Player>> viewAll() {
		
		List<Player> players = playerRepo.findAll();
		
		return new ResponseEntity<>(players, HttpStatus.OK);
		
	}
	

}

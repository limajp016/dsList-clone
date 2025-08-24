package br.com.jplima.dslist.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.jplima.dslist.dtos.GameListDTO;
import br.com.jplima.dslist.dtos.GameMinDTO;
import br.com.jplima.dslist.dtos.ReplacementDTO;
import br.com.jplima.dslist.services.GameListService;
import br.com.jplima.dslist.services.GameService;

@RestController
@RequestMapping(value = "/lists")
public class GameListController {
	
	@Autowired
	private GameListService gameListService;
	@Autowired
	private GameService gameService;
	
	@GetMapping
	public List<GameListDTO> findAll(){
		var resultado = gameListService.findAll();
		return resultado;
	}

	@GetMapping(value = "/{listId}/games")
	public List<GameMinDTO> findByList(@PathVariable Long listId){
		var resultado = gameService.findByList(listId);
		return resultado;
	}
	
	@PostMapping(value = "/{listId}/replacement")
	public void move(@PathVariable Long listId, @RequestBody ReplacementDTO body ){
		gameListService.move(listId, body.getSourceIndex(), body.getDestinationIndex());
	}


}

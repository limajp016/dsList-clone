package br.com.jplima.dslist.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;

import br.com.jplima.dslist.dtos.GameDTO;
import br.com.jplima.dslist.dtos.GameMinDTO;
import br.com.jplima.dslist.entities.Game;
import br.com.jplima.dslist.repostories.GameRepository;

@Service
public class GameService {
	
	@Autowired
	private GameRepository gameRepository;
	
	@Transactional(readOnly = true)
	public GameDTO findById(@PathVariable Long id) {
		Game resultado = gameRepository.findById(id).get();
		// criar um tratamento de exceção para depois, para IDs inexistentes
		GameDTO dto = new GameDTO(resultado);
		return dto;
	}
	
	public List<GameMinDTO> findAll() {
		List<Game> resultado = gameRepository.findAll();
		List<GameMinDTO> listaDto = resultado.stream().map(x -> new GameMinDTO(x)).toList();		
		return listaDto;
	}

}

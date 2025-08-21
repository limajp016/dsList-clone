package br.com.jplima.dslist.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.jplima.dslist.dtos.GameMinDTO;
import br.com.jplima.dslist.entities.Game;
import br.com.jplima.dslist.repostories.GameRepository;

@Service
public class GameService {
	
	@Autowired
	private GameRepository gameRepository;
	
	public List<GameMinDTO> findAll() {
		List<Game> resultado = gameRepository.findAll();
		List<GameMinDTO> listaDto = resultado.stream().map(x -> new GameMinDTO(x)).toList();		
		return listaDto;
	}

}

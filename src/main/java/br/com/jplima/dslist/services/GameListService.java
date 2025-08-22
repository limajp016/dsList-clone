package br.com.jplima.dslist.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.jplima.dslist.dtos.GameListDTO;
import br.com.jplima.dslist.entities.GameList;
import br.com.jplima.dslist.repostories.GameListRepository;

@Service
public class GameListService {
	
	@Autowired
	private GameListRepository gameListRepository;
	
	public List<GameListDTO> findAll() {
		List<GameList> resultado = gameListRepository.findAll();
		List<GameListDTO> listaDto = resultado.stream().map(x -> new GameListDTO(x)).toList();		
		return listaDto;
	}

}

package br.com.jplima.dslist.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.jplima.dslist.dtos.GameListDTO;
import br.com.jplima.dslist.entities.GameList;
import br.com.jplima.dslist.projections.GameMinProjection;
import br.com.jplima.dslist.repostories.GameListRepository;
import br.com.jplima.dslist.repostories.GameRepository;
import jakarta.transaction.Transactional;

@Service
public class GameListService {
	
	@Autowired
	private GameListRepository gameListRepository;
	
	@Autowired
	private GameRepository gameRepository;
	
	public List<GameListDTO> findAll() {
		List<GameList> resultado = gameListRepository.findAll();
		List<GameListDTO> listaDto = resultado.stream().map(x -> new GameListDTO(x)).toList();		
		return listaDto;
	}
	
	@Transactional
	public void move(Long listId, int sourceIndex, int destinationIndex) {
		List<GameMinProjection> lista = gameRepository.searchByList(listId);
		
		GameMinProjection obj = lista.remove(sourceIndex);
		lista.add(destinationIndex, obj);
		
		int min = sourceIndex < destinationIndex ? sourceIndex : destinationIndex;
		int max = sourceIndex < destinationIndex ? destinationIndex : sourceIndex;
		
		for (int i = min; i <= max; i++) {
			gameListRepository.updateBelongingPosition(listId, lista.get(i).getId(), i);
		}
	}

}

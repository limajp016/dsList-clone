package br.com.jplima.dslist.repostories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import br.com.jplima.dslist.entities.GameList;

public interface GameListRepository extends JpaRepository<GameList, Long> {
	
	@Modifying
	@Query(nativeQuery = true, value = "UPDATE belonging SET belonging_position = :newPosition WHERE list_id = :listId AND game_id = :gameId")
	void updateBelongingPosition(Long listId, Long gameId, Integer newPosition);

}

package br.com.jplima.dslist.repostories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.jplima.dslist.entities.Game;
import br.com.jplima.dslist.projections.GameMinProjection;

public interface GameRepository extends JpaRepository<Game, Long> {
	
	@Query(nativeQuery = true, value = """
			SELECT game.game_id AS id, game.game_title AS title, game.game_year AS "year", game.game_image AS image, 
			game.game_short_description AS shortDescription, belonging.belonging_position AS position
			FROM game
			INNER JOIN belonging ON game.game_id = belonging.game_id
			WHERE belonging.list_id = :listId
			ORDER BY belonging.belonging_position
				""")
	List<GameMinProjection> searchByList(Long listId);

}

package br.com.jplima.dslist.repostories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.jplima.dslist.entities.GameList;

public interface GameListRepository extends JpaRepository<GameList, Long> {

}

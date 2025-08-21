package br.com.jplima.dslist.repostories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.jplima.dslist.entities.Game;

public interface GameRepository extends JpaRepository<Game, Long> {

}

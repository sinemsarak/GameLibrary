package com.example.GameLibrary.dataAccess;

import com.example.GameLibrary.entities.Game;
import com.example.GameLibrary.entities.Genre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface GameRepo extends JpaRepository<Game,Long> {

    List<Game> findAllBygenreId(Long genreId);
    Optional<Game> findByName(String name);
}

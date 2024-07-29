package com.example.GameLibrary.dataAccess;

import com.example.GameLibrary.entities.Genre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface GenreRepo extends JpaRepository<Genre,Long> {

    Optional<Genre> findByName(String name);
}

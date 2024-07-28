package com.example.GameLibrary.dataAccess;

import com.example.GameLibrary.entities.Genre;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GenreRepo extends JpaRepository<Genre,Long> {
}

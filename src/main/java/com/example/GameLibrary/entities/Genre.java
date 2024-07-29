package com.example.GameLibrary.entities;

import com.example.GameLibrary.aop.annotations.GenreNameMustBeUnique;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "Genres")
@Getter
@Setter

@NoArgsConstructor
@AllArgsConstructor
public class Genre {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "genre_id")
    private Long id;

    @Column(name = "genre_name")
    @NotEmpty
    private String name;

    @OneToMany(mappedBy = "genre", fetch = FetchType.LAZY)
    private List<Game> games;
    //20 temmuz videosunda yazılan querye benzer bir şey işimize yarayabilir
    //burada da yarayabilir

    private int gameCount;



}

package com.example.GameLibrary.entities;

import com.example.GameLibrary.aop.annotations.GenreNameMustBeUnique;
import com.example.GameLibrary.enums.InputDevice;
import com.example.GameLibrary.enums.Players;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity
@Table(name = "Games")
@Getter
@Setter

@NoArgsConstructor
@AllArgsConstructor
public class Game {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "game_id")
    private Long id;

    @Column(name = "game_name")
    @NotEmpty

    private String name;


    @ManyToOne(targetEntity = Genre.class)
    @JoinColumn(name = "genre_id",referencedColumnName = "genre_id")
    private Genre genre;

    @Column
    private String overview;

    @Column(name = "release_date")
    private Date releaseDate;

    @Column
    private float price;

    @Column(name = "input_devices")
    @Enumerated(EnumType.STRING)
    //private HashSet<InputDevice> inputDevices;
    private InputDevice inputDevices;

    @Column
    @Enumerated(EnumType.STRING)
    private Players players;


}

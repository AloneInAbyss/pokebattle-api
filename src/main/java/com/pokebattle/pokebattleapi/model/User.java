package com.pokebattle.pokebattleapi.model;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotBlank @Size(min = 1, max = 20)
    private String username;
    
    @Column(name = "last_draw")
    @PastOrPresent
    private LocalDateTime lastDraw;
    
    @ManyToMany
    @JoinTable(
        name = "users_pokemons", 
        joinColumns = @JoinColumn(name = "users_id"),
        inverseJoinColumns = @JoinColumn(name = "pokemons_id"))
    @NotNull
    private List<Pokemon> pokemons;
    
    @OneToOne(cascade = CascadeType.ALL, optional = false)
    @MapsId
    @NotNull
    private Team team;

}

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
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@NoArgsConstructor
@Entity
@Table(name = "users")
public class User {

    public User(String username, List<Pokemon> pokemons) {
        this.username = username;
        this.pokemons = pokemons;
        this.lastDraw = LocalDateTime.now();
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonIgnore
    private long id;

    @Column(unique = true)
    @Pattern(regexp="^[a-z]*$", message = "Must contain only lowercase letters and no special symbols")
    @NotBlank(message = "Must not be blank")
    @Size(min = 1, max = 20, message = "Must be 1-20 characters long")
    private String username;
    
    @Column(name = "last_draw")
    @PastOrPresent
    @Setter
    private LocalDateTime lastDraw;
    
    @ManyToMany
    @JoinTable(
        name = "users_pokemons", 
        joinColumns = @JoinColumn(name = "users_id"),
        inverseJoinColumns = @JoinColumn(name = "pokemons_id"))
    @NotNull
    private List<Pokemon> pokemons;
    
    @OneToOne(cascade = CascadeType.ALL, optional = true)
    @Setter
    private Team team;

}

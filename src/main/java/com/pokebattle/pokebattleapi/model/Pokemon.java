package com.pokebattle.pokebattleapi.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@Entity
@Table(name = "pokemons")
public class Pokemon {

    public Pokemon(String name, Attributes attributes) {
        this.name = name;
        this.attributes = attributes;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String name;
    
    @ManyToMany(mappedBy = "pokemons")
    private List<User> users;
    
    @OneToOne(cascade = CascadeType.ALL, optional = false)
    @NotNull
    private Attributes attributes;

}

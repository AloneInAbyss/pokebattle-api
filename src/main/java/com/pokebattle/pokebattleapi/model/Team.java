package com.pokebattle.pokebattleapi.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@Entity
@Table(name = "teams")
public class Team {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(cascade = CascadeType.ALL, optional = false)
    @NotNull
    private Pokemon slotOne;
    
    @OneToOne(cascade = CascadeType.ALL, optional = false)
    @NotNull
    private Pokemon slotTwo;
    
    @OneToOne(cascade = CascadeType.ALL, optional = false)
    @NotNull
    private Pokemon slotThree;

}

package com.pokebattle.pokebattleapi.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
@Entity
@Table(name = "teams")
public class Team {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(cascade = CascadeType.ALL)
    @MapsId
    private Pokemon slotOne;
    
    @OneToOne(cascade = CascadeType.ALL)
    @MapsId
    private Pokemon slotTwo;
    
    @OneToOne(cascade = CascadeType.ALL)
    @MapsId
    private Pokemon slotThree;

}

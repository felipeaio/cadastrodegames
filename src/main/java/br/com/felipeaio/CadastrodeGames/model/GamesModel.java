package br.com.felipeaio.CadastrodeGames.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "games")
@NoArgsConstructor
@AllArgsConstructor

public class GamesModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    @Setter
    private long id;

    @Column( nullable = false, length = 40)
    @Getter
    @Setter
    private String nome;

    @Column(nullable = false, length = 40)
    @Getter
    @Setter
    private String empresa;
}
package br.com.felipeaio.CadastrodeGames.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.hateoas.RepresentationModel;

import javax.persistence.*;
import java.io.Serializable;

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

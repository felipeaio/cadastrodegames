package br.com.felipeaio.CadastrodeGames.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.hateoas.RepresentationModel;

import javax.persistence.Column;
import java.io.Serializable;

public class CategoryModel extends RepresentationModel implements Serializable {
    @Column(nullable = false, length = 40)
    @Getter
    @Setter
    private String category;
}
package br.com.felipeaio.CadastrodeGames.repository;

import br.com.felipeaio.CadastrodeGames.model.GamesModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface GameRepository extends JpaRepository<GamesModel, Long> {
    public Optional<GamesModel> findById(long id);
}

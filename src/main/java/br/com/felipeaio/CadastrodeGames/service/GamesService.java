package br.com.felipeaio.CadastrodeGames.service;

import br.com.felipeaio.CadastrodeGames.model.GamesModel;
import br.com.felipeaio.CadastrodeGames.repository.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GamesService {

    @Autowired
    GameRepository repository;
    public GamesModel save(GamesModel game){
        return repository.save(game);
    }
    public Optional<GamesModel> findById(long id){
        return repository.findById(id);
    }
    public List<GamesModel> findAll(){
        return repository.findAll();
    }
    public GamesModel update(GamesModel game) {
        Optional<GamesModel> p = repository.findById(game.getId());
        if(p.isPresent()) {
            p.get().setNome(game.getNome());
            p.get().setEmpresa(game.getEmpresa());
            return repository.save(p.get());
        } else {
            return null;
        }
    }
    public void delete(Long id) {
        Optional<GamesModel> p = repository.findById(id);
        if(p.isPresent()){
            repository.delete(p.get());
        }
    }
}


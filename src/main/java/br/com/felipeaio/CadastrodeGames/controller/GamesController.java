package br.com.felipeaio.CadastrodeGames.controller;

import br.com.felipeaio.CadastrodeGames.model.GamesModel;
import br.com.felipeaio.CadastrodeGames.service.GamesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/games")
public class GamesController {

    @Autowired
    private GamesService service;
    @PostMapping
    public GamesModel save(@RequestBody GamesModel game){
        return service.save(game);
    }
    @GetMapping("/{id}")
    public Optional<GamesModel> findById(@PathVariable("id") long id) {
        return service.findById(id);
    }
    @GetMapping
    public List<GamesModel> findAll(){
        return service.findAll();
    }
    @PutMapping
    public GamesModel update(@RequestBody GamesModel game){
        return service.update(game);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") long id){
        service.delete(id);
        return ResponseEntity.ok().build();
    }
}
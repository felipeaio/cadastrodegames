package br.com.felipeaio.CadastrodeGames.controller;

import br.com.felipeaio.CadastrodeGames.model.CategoryModel;
import br.com.felipeaio.CadastrodeGames.model.GamesModel;
import br.com.felipeaio.CadastrodeGames.service.GamesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

public class CategoryController {

    @Autowired
    private GamesService service;

    @PostMapping(produces = { "application/xml", "application/json", "application/x-yaml", MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE }, consumes = {"application/xml", "application/json", "application/x-yaml"} )
    public GamesModel save(@RequestBody GamesModel game){
        return service.save(game);

    }

    @GetMapping(value = "/{id}", produces = {"application/json","application/xml"})
    public CategoryModel findById(@PathVariable long id){
        Optional<GamesModel> model = service.findById(id);

        buildEntityLink(model);
        return model;
    }


    @GetMapping
    public List<GamesModel> findAll(){
        return service.findAll();
    }

    @PutMapping(produces = { "application/xml", "application/json", "application/x-yaml", MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE }, consumes = {"application/xml", "application/json", "application/x-yaml", "application/json", "application/xml"})
    public GamesModel update(@RequestBody GamesModel game){
        return service.update(game);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") long id){
        service.delete(id);
        return ResponseEntity.ok().build();
    }

    private void buildEntityLink(CategoryModel category){
        category.add(
                WebMvcLinkBuilder.linkTo(
                        WebMvcLinkBuilder.methodOn(
                                CategoryController.class).findById(category.getId())
                ).withSelfRel()
        );
    }
}

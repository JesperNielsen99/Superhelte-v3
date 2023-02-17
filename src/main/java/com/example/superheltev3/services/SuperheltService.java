package com.example.superheltev3.services;

import com.example.superheltev3.models.Superhelt;
import com.example.superheltev3.repositories.SuperheltRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SuperheltService {
    private final SuperheltRepository repository;

    public SuperheltService() {
        repository = new SuperheltRepository();
    }

    public Superhelt addSuperhero(Superhelt superhelt) {
        return repository.addSuperhero(superhelt);
    }

    public Superhelt createSuperhero(String name) {
        return repository.createSuperhero(name);
    }

    public Superhelt editSuperhero(Superhelt superhelt) {
        return repository.editSuperhero(superhelt);
    }

    public Superhelt deleteSuperhero(String name) {
        return repository.deleteSuperhero(name);
    }

    public Superhelt searchHeroName(String name) {
        return repository.searchHeroName(name);
    }

    public List<Superhelt> getHelte() {
        return repository.getSuperheroes();
    }

    public SuperheltRepository getRepository() {
        return repository;
    }
}

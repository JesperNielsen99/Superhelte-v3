package com.example.superheltev3.repositories;

import com.example.superheltev3.models.Superhelt;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class SuperheltRepository {
    private List<Superhelt> superheltList = new ArrayList<>(List.of(
            new Superhelt("Bøv", "Børge"),
            new Superhelt("Batman", "Bruce Wayne"),
            new Superhelt("Superman", "Clark kent")
    ));
    private Superhelt currentHero;

    public SuperheltRepository() {
    }

    public Superhelt deleteSuperhero(String heroName) {
        for (Superhelt superhelt : superheltList) {
            if (superhelt.getHeroName().equalsIgnoreCase(superhelt.getHeroName())) {
                currentHero = superhelt;
                superheltList.remove(superhelt);
                return currentHero;
            }
        }
        return null;
    }

    public Superhelt editSuperhero(Superhelt superhelt) {
        int index = superheltList.indexOf(searchHeroName(superhelt.getHeroName()));
        superheltList.set(index, superhelt);
        return superhelt;
    }

    public Superhelt searchHeroName(String heroName) {
        for (Superhelt superhelt : superheltList) {
            if (superhelt.getHeroName().equalsIgnoreCase(heroName)) {
                currentHero = superhelt;
            }
        }
        return currentHero;
    }

    public Superhelt createSuperhero(String name) {
        currentHero = new Superhelt(name);
        superheltList.add(currentHero);
        return currentHero;
    }

    public Superhelt addSuperhero(Superhelt superhelt) {
        superheltList.add(superhelt);
        return superhelt;
    }

    public List<Superhelt> getSuperheroes() {
        return superheltList;
    }

    public String toString() {
        if (superheltList.size() > 0) {
            StringBuilder databaseString = new StringBuilder();
            for (Superhelt superhelt : superheltList) {
                databaseString.append(superhelt.toString());
            }
            return ("\nList of Superheroes: \n-----------------\n" + databaseString);
        } else {
            return "The database is empty.";
        }
    }
}

package org.example.repository;

import org.example.utils.Pokemon;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class MainPokemonRepository implements PokemonRepository{

    public List<Pokemon> pokemons = new ArrayList<Pokemon>();

    @Override
    public List<Pokemon> getPokemons() {
        return pokemons;
    }

    public void addPokemon() {
        pokemons.add(new Pokemon("navizasur", 12, 40, 35));
    }

    @Override
    public Pokemon getPokemonById(int id) {
        pokemons.add(new Pokemon("navizasur", 12, 40, 35));
        pokemons.add(new Pokemon("pikachu", 13, 45, 32));

        List<Pokemon> resultList = pokemons.stream().filter(new Predicate<Pokemon>() {
            @Override
            public boolean test(Pokemon pokemon) {
                return pokemon.id() == id;
            }
        }).toList();
        return resultList.getFirst();
    }

    @Override
    public void deletePokemonById(Integer id) {
        throw new UnsupportedOperationException();
    }
}

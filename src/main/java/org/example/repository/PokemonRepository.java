package org.example.repository;

import org.example.utils.Pokemon;

import java.util.ArrayList;
import java.util.List;

public interface PokemonRepository {
    public List<Pokemon> getPokemons();

    public List<Pokemon> pokemons = new ArrayList<>();

    public void addPokemon();

    public Pokemon getPokemonById (int id);

    public void deletePokemonById(Integer id);
}

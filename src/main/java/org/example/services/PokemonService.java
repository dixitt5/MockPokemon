package org.example.services;

import org.example.repository.PokemonRepository;
import org.example.utils.Pokemon;
import org.example.utils.Statistics;

import java.util.List;

public class PokemonService {

    private final PokemonRepository pokemonRepo;
    private final Statistics statistics;

    public PokemonService(PokemonRepository pokemonRepo, Statistics statistics) {
        this.pokemonRepo = pokemonRepo;
        this.statistics = statistics;
    }

    public List<Pokemon> getAll() {
        return pokemonRepo.getPokemons();
    }

    public void addPokemon() {
        pokemonRepo.addPokemon();
        statistics.called();
    }

    public Pokemon fetchPokemonById(int id) {
        return pokemonRepo.getPokemonById(id);
    }

    public void deletePokemonById() {
        pokemonRepo.deletePokemonById(1);
    }
}

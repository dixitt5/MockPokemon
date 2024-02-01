package org.example.services;

import org.example.repository.MainPokemonRepository;
import org.example.utils.Pokemon;
import org.example.utils.Statistics;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Set;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class PokemonServiceShould {

    @Mock
    MainPokemonRepository mainPokemonRepository;
    @Mock
    Statistics statistics;
    @Captor
    ArgumentCaptor<Integer> integerArgumentCaptor;
    @InjectMocks
    PokemonService pokemonService;

    @Test
    void get_all_pokemons() {
        when(mainPokemonRepository.getPokemons()).thenReturn(List.of(new Pokemon("dixitsaur", 1, 100, 100)));

        List<Pokemon> allPokemons = pokemonService.getAll();

        verify(mainPokemonRepository).getPokemons();

        assertThat(allPokemons).isEqualTo(List.of(new Pokemon("dixitsaur", 1, 100, 100)));
    }

    @Test
    void add_one_pokemon() {
        when(mainPokemonRepository.getPokemons()).thenReturn(List.of(new Pokemon("navizasur", 12, 40, 35)));

        pokemonService.addPokemon();

        verify(mainPokemonRepository).addPokemon();

        assertThat(mainPokemonRepository.getPokemons()).isEqualTo(List.of(new Pokemon("navizasur", 12, 40, 35)));

    }

    @Test
    void get_one_pokemon_by_id() {
        int index = 12;
        when(mainPokemonRepository.getPokemonById(index)).thenReturn(new Pokemon("navizasur", 12, 40, 35));

        pokemonService.fetchPokemonById(index);

        verify(mainPokemonRepository).getPokemonById(index);

        assertThat(mainPokemonRepository.getPokemonById(index)).isEqualTo(new Pokemon("navizasur", 12, 40, 35));
    }

    @Test
    void interact_with_stats() {
        pokemonService.addPokemon();
        verify(statistics).called();

    }

    @Test
    void delete_pokemon_details_by_id(){
        pokemonService.deletePokemonById();
        verify(mainPokemonRepository).deletePokemonById(integerArgumentCaptor.capture());
        Integer id = integerArgumentCaptor.getValue();
        assertThat(id).isEqualTo(1);}

}
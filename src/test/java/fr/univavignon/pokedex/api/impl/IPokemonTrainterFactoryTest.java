package fr.univavignon.pokedex.api.impl;

import fr.univavignon.pokedex.api.IPokemonTrainerFactory;
import fr.univavignon.pokedex.api.IPokemonTrainerFactoryTest;

import static fr.univavignon.pokedex.api.impl.PokedexFactory.pokedexFactory;
import static fr.univavignon.pokedex.api.impl.PokemonTrainerFactory.pokemonTrainterFactory;

import org.junit.Before;

public class IPokemonTrainterFactoryTest extends IPokemonTrainerFactoryTest{
	@Override
    public IPokemonTrainerFactory getProvider() {
        return pokemonTrainterFactory();
    }
	
	
    @Override
    @Before
    public void setUp() {
        this.setPokdexFactory(pokedexFactory());
    }
}

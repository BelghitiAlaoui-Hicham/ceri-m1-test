package fr.univavignon.pokedex.api.impl;

import org.junit.Before;

import fr.univavignon.pokedex.api.IPokedexFactoryTest;

public class PokemonFactoryTest extends IPokedexFactoryTest{
	@Before
	public void setUp() {
		iPokemonFactory = new PokemonFactory();
		
	}
}

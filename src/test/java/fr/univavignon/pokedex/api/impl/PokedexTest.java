package fr.univavignon.pokedex.api.impl;

import java.io.IOException;

import org.junit.Before;

import fr.univavignon.pokedex.api.IPokedexTest;

public class PokedexTest extends IPokedexTest{
	@Before
	public void setUp() throws IOException {
		iPokedex = new Pokedex(new PokemonMetadataProvider(), new PokemonFactory());
	}
}

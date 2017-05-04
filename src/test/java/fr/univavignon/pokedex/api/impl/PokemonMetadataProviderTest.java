package fr.univavignon.pokedex.api.impl;

import java.io.IOException;

import fr.univavignon.pokedex.api.IPokemonMetadataProviderTest;
import fr.univavignon.pokedex.api.PokedexException;

public class PokemonMetadataProviderTest extends IPokemonMetadataProviderTest{

	@Override
	public void setUp() throws PokedexException, IOException {
		pokemonMetadataProvider = new PokemonMetadataProvider() ;
	}
	

}

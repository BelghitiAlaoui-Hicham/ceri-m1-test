package fr.univavignon.pokedex.api.impl;

import java.io.IOException;

import fr.univavignon.pokedex.api.IPokemonMetadataProvider;
import fr.univavignon.pokedex.api.IPokemonMetadataProviderTest;
import fr.univavignon.pokedex.api.PokedexException;
import static fr.univavignon.pokedex.api.impl.PokemonMetadataProvider.pokemonMetadataProvider;

public class PokemonMetadataProviderTest extends IPokemonMetadataProviderTest{

	@Override
    public IPokemonMetadataProvider getProvider() throws IOException {
        return pokemonMetadataProvider();
    }
	

}

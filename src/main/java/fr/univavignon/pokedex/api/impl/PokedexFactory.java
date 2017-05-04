package main.java.fr.univavignon.pokedex.api.impl;

import java.io.IOException;

import main.java.fr.univavignon.pokedex.api.IPokedex;
import main.java.fr.univavignon.pokedex.api.IPokedexFactory;
import main.java.fr.univavignon.pokedex.api.IPokemonFactory;
import main.java.fr.univavignon.pokedex.api.IPokemonMetadataProvider;

public class PokedexFactory implements IPokedexFactory {
	private static PokedexFactory instance = null;
	
	public static PokedexFactory pokedexFactory() {
        if (instance == null) instance = new PokedexFactory();
        return instance;
    }
	
	@Override
    public IPokedex createPokedex(IPokemonMetadataProvider metadataProvider, IPokemonFactory pokemonFactory) throws IOException {
        return new Pokedex(metadataProvider, pokemonFactory);
    }
}

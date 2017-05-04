package fr.univavignon.pokedex.api.impl;

import java.io.IOException;

import fr.univavignon.pokedex.api.IPokedexFactory;
import fr.univavignon.pokedex.api.IPokemonTrainerFactory;
import fr.univavignon.pokedex.api.PokemonTrainer;
import fr.univavignon.pokedex.api.Team;
import static fr.univavignon.pokedex.api.impl.PokemonFactory.pokemonFactory;
import static fr.univavignon.pokedex.api.impl.PokemonMetadataProvider.pokemonMetadataProvider;
public class PokemonTrainerFactory implements IPokemonTrainerFactory {

	  	private static PokemonTrainerFactory instance = null;

	    private PokemonTrainerFactory() {

	    }

	    public static synchronized PokemonTrainerFactory pokemonTrainterFactory() {
	        if (instance == null) instance = new PokemonTrainerFactory();
	        return instance;
	    }

	    @Override
	    public PokemonTrainer createTrainer(String name, Team team, IPokedexFactory pokedexFactory) throws IOException {
	        return new PokemonTrainer(name, team, pokedexFactory.createPokedex(pokemonMetadataProvider(), pokemonFactory()));
	    }
}

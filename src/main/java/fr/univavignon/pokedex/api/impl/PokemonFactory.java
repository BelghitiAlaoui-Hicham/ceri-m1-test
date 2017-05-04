package fr.univavignon.pokedex.api.impl;

import fr.univavignon.pokedex.api.IPokemonFactory;
import fr.univavignon.pokedex.api.PokedexException;
import fr.univavignon.pokedex.api.Pokemon;
import fr.univavignon.pokedex.api.PokemonMetadata;
import static fr.univavignon.pokedex.api.impl.PokemonMetadataProvider.pokemonMetadataProvider;

import java.io.IOException;

public class PokemonFactory implements IPokemonFactory {
	 
	private static PokemonFactory instance = null;

	    public static synchronized  PokemonFactory pokemonFactory() {
	        if (instance == null) {
	            instance = new PokemonFactory();
	        }
	        return instance;
	    }
	    
	    
	    
	    
	@Override
	public Pokemon createPokemon(int index, int cp, int hp, int dust, int candy) throws PokedexException, IOException{
		    PokemonMetadata tmp = pokemonMetadataProvider().getPokemonMetadata(index);
			int tmp_iv = new CalculatorIV().calculateIV(tmp.getName(), cp, hp, dust);

	        return new Pokemon(index,
	                tmp.getName(),
	                tmp.getAttack(),
	                tmp.getDefense(),
	                tmp.getStamina(),
	                cp,
	                hp,
	                dust,
	                candy,
	                tmp_iv
	        );
		
	        
	}

}

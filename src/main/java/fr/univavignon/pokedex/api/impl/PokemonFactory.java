package main.java.fr.univavignon.pokedex.api.impl;

import main.java.fr.univavignon.pokedex.api.IPokemonFactory;
import main.java.fr.univavignon.pokedex.api.PokedexException;
import main.java.fr.univavignon.pokedex.api.Pokemon;
import main.java.fr.univavignon.pokedex.api.PokemonMetadata;
import static main.java.fr.univavignon.pokedex.api.impl.PokemonMetadataProvider.pokemonMetadataProvider;

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
	public Pokemon createPokemon(int index, int cp, int hp, int dust, int candy){
		   PokemonMetadata tmp;
		try {
			tmp = pokemonMetadataProvider().getPokemonMetadata(index);
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
		} catch (PokedexException e) {
			e.printStackTrace();
			return null;
		} catch (IOException e) {
			e.printStackTrace();
			return null;
			
		}
	        
	}

}

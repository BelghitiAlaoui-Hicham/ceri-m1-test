package main.java.fr.univavignon.pokedex.api.impl;

import java.util.Comparator;
import java.util.List;

import main.java.fr.univavignon.pokedex.api.IPokedex;
import main.java.fr.univavignon.pokedex.api.PokedexException;
import main.java.fr.univavignon.pokedex.api.Pokemon;
import main.java.fr.univavignon.pokedex.api.PokemonMetadata;

public class Pokedex implements IPokedex {

	@Override
	public PokemonMetadata getPokemonMetadata(int index) throws PokedexException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Pokemon createPokemon(int index, int cp, int hp, int dust, int candy) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int addPokemon(Pokemon pokemon) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Pokemon getPokemon(int id) throws PokedexException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Pokemon> getPokemons() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Pokemon> getPokemons(Comparator<Pokemon> order) {
		// TODO Auto-generated method stub
		return null;
	}

}

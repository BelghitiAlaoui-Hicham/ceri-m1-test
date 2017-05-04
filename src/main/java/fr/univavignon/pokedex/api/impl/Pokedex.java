package fr.univavignon.pokedex.api.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import fr.univavignon.pokedex.api.IPokedex;
import fr.univavignon.pokedex.api.IPokemonFactory;
import fr.univavignon.pokedex.api.IPokemonMetadataProvider;
import fr.univavignon.pokedex.api.PokedexException;
import fr.univavignon.pokedex.api.Pokemon;
import fr.univavignon.pokedex.api.PokemonMetadata;

import static fr.univavignon.pokedex.api.impl.PokemonFactory.pokemonFactory;
import static fr.univavignon.pokedex.api.impl.PokemonMetadataProvider.pokemonMetadataProvider;

public class Pokedex implements IPokedex {
	
	
    private IPokemonFactory pkmFactory;
    private IPokemonMetadataProvider provider;
    private List<Pokemon> listOfpokemon;
    
    public Pokedex() throws IOException {
        this.setListOfpokemon(new ArrayList<Pokemon>(151));
        this.setPokemonfactory(pokemonFactory());
        this.setProvider(pokemonMetadataProvider());
    }

    public Pokedex(IPokemonMetadataProvider metadataProvider, IPokemonFactory pokemonfactory) throws IOException {
        this.setListOfpokemon(new ArrayList<Pokemon>(151));
        this.setPokemonfactory(pokemonfactory);
        this.setProvider(metadataProvider);
    }
    
    

	public IPokemonFactory getPokemonfactory() {
		return pkmFactory;
	}


	public void setPokemonfactory(IPokemonFactory pokemonfactory) {
		this.pkmFactory = pokemonfactory;
	}


	public IPokemonMetadataProvider getProvider() {
		return provider;
	}






	public void setProvider(IPokemonMetadataProvider provider) {
		this.provider = provider;
	}






	public List<Pokemon> getListOfpokemon() {
		return listOfpokemon;
	}






	public void setListOfpokemon(List<Pokemon> listOfpokemon) {
		this.listOfpokemon = listOfpokemon;
	}


	@Override
	public PokemonMetadata getPokemonMetadata(int index) throws PokedexException {
		return this.getProvider().getPokemonMetadata(index);
	}

	@Override
	public Pokemon createPokemon(int index, int cp, int hp, int dust, int candy) throws PokedexException, IOException {
		return this.getPokemonfactory().createPokemon(index, cp, hp, dust, candy);
	}

	@Override
	public int size() {
		return this.getPokemons().size();
	}

	@Override
	public int addPokemon(Pokemon pokemon) throws PokedexException{
        if (this.size() == 151) {
            throw new PokedexException("Pokedex pleins");
        }
        this.getPokemons().add(pokemon);
        return this.getPokemons().indexOf(pokemon);
	}

	@Override
	public Pokemon getPokemon(int id) throws PokedexException {
		if (id > this.getPokemons().size() || id < 0) {
            throw new PokedexException("Vous tentez de recupperer un pokemon inexistant, index => "+id);
        } else {
            return this.getPokemons().get(id);
        }
	}

	@Override
	public List<Pokemon> getPokemons() {
		return this.getListOfpokemon();
	}

	@Override
	public List<Pokemon> getPokemons(Comparator<Pokemon> order) {
        List<Pokemon> newList = new ArrayList<Pokemon>(this.getPokemons());
        Collections.sort(newList, order);
        return Collections.unmodifiableList(newList);
	}

}

package fr.univavignon.pokedex.api.impl;


import fr.univavignon.pokedex.api.IPokemonFactory;
import fr.univavignon.pokedex.api.IPokemonFactoryTest;

import static fr.univavignon.pokedex.api.impl.PokemonFactory.pokemonFactory;
import java.io.IOException;


public class PokemonFactoryTest extends IPokemonFactoryTest{
	@Override
    public IPokemonFactory getProvider() throws IOException {
        return pokemonFactory();
    }
}

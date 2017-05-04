package fr.univavignon.pokedex.api.impl;

import fr.univavignon.pokedex.api.IPokedexFactory;
import static fr.univavignon.pokedex.api.impl.PokedexFactory.pokedexFactory;

import org.junit.Before;
public class PokedexFactoryTest extends fr.univavignon.pokedex.api.IPokedexFactoryTest{
		
	@Override
    public IPokedexFactory getProvider() {
        return pokedexFactory();
    }
}

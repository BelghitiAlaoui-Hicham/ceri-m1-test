package fr.univavignon.pokedex.api.impl;

import java.io.IOException;

import org.junit.Before;

import fr.univavignon.pokedex.api.IPokedex;
import fr.univavignon.pokedex.api.IPokedexTest;

public class PokedexTest extends IPokedexTest{
	
	private static Pokedex instance;
   
	@Override
    @Before
    public void setUp() {
         instance = null;
    };


    @Override
    public IPokedex getProvider() throws IOException {
        if (instance == null) instance = new Pokedex();
        return instance;
    }
}

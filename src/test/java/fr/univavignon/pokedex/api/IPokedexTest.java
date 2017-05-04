package fr.univavignon.pokedex.api;

import java.io.IOException;
import java.util.Arrays;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import fr.univavignon.pokedex.api.IPokedex;
import fr.univavignon.pokedex.api.IPokedexFactory;
import fr.univavignon.pokedex.api.IPokemonFactory;
import fr.univavignon.pokedex.api.IPokemonMetadataProvider;
import fr.univavignon.pokedex.api.PokedexException;
import fr.univavignon.pokedex.api.Pokemon;
import fr.univavignon.pokedex.api.PokemonComparators;
import fr.univavignon.pokedex.api.PokemonMetadata;

public class IPokedexTest {
	
	private Pokemon pokemon = new Pokemon(0, "Bulbasaur", 126, 126, 90, 613, 64, 4000, 4, 56);
	
	@Mock
	private IPokedexFactory iPokedexFactory;
	
	@Mock
	private IPokemonMetadataProvider pokemonMetadataProvider;
	
	@Mock
	private IPokemonFactory iPokemonFactory;
	
	@Mock
	protected IPokedex iPokedex;
	
	@Rule
	public MockitoRule mockitoRule = MockitoJUnit.rule();
	
	@Before
	public void setUp() throws PokedexException, IOException {
		Mockito.when(iPokedex.size()).thenAnswer(a -> 1);
		Mockito.when(iPokedex.addPokemon(null)).thenAnswer(a -> 0);
		Mockito.when(iPokedex.getPokemon(0)).thenAnswer(a -> pokemon);
		Mockito.when(iPokedex.getPokemons()).thenAnswer(a -> Arrays.asList(new Pokemon[] {pokemon} ));
		Mockito.when(iPokedex.getPokemons(null)).thenAnswer(a -> Arrays.asList(new Pokemon[] {pokemon}  ));
		Mockito.when(iPokedex.getPokemons(PokemonComparators.INDEX)).thenAnswer(a -> Arrays.asList(new Pokemon[] {pokemon}));
		Mockito.when(iPokedexFactory.createPokedex(pokemonMetadataProvider, iPokemonFactory)).thenAnswer(a -> iPokedex);
	}
	
	@Test
	public void testCreatePokedex() {
		try {
			IPokedex px = iPokedexFactory.createPokedex(pokemonMetadataProvider, iPokemonFactory);
			Assert.assertEquals(1, px.size());
			Assert.assertEquals(0, px.addPokemon(pokemon));
			Assert.assertEquals("Bulbasaur", px.getPokemon(0).getName());
			
			Assert.assertEquals("Bulbasaur", px.getPokemons().get(0).getName());
			Assert.assertEquals("Bulbasaur", px.getPokemons(null).get(0).getName());
			
			Assert.assertEquals("Bulbasaur", px.getPokemons(PokemonComparators.INDEX).get(0).getName());
		}
		catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}

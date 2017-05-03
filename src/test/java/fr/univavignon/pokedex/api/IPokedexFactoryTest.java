package test.java.fr.univavignon.pokedex.api;

import java.util.Arrays;
import java.util.Comparator;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import main.java.fr.univavignon.pokedex.api.IPokedex;
import main.java.fr.univavignon.pokedex.api.IPokedexFactory;
import main.java.fr.univavignon.pokedex.api.IPokemonFactory;
import main.java.fr.univavignon.pokedex.api.IPokemonMetadataProvider;
import main.java.fr.univavignon.pokedex.api.PokedexException;
import main.java.fr.univavignon.pokedex.api.Pokemon;
import main.java.fr.univavignon.pokedex.api.PokemonMetadata;
public class IPokedexFactoryTest {
	
	private Pokemon pokemon = new Pokemon(0, "Bulbizarre", 126, 126, 90, 613, 64, 4000, 4, 56);
	private Comparator<Pokemon> ordre = new Comparator<Pokemon>() {
		
		@Override
		public int compare(Pokemon o1, Pokemon o2) {
			return o1.getIndex() - o2.getIndex();
		}
	};
	@Mock
	private IPokedexFactory pokedexFactory;
	
	@Mock
	private IPokemonMetadataProvider metadataProvider;
	
	@Mock
	private IPokemonFactory iPokemonFactory;
	
	@Mock
	private IPokedex iPokedex;
	
	@Rule
	public MockitoRule mockitoRule = MockitoJUnit.rule();
	
	
	@Before
	public void setUp() throws PokedexException {
		Mockito.when(metadataProvider.getPokemonMetadata(0)).thenAnswer(a -> {
			return new PokemonMetadata(0, "Bulbizarre", 126, 126, 90);
		});
		
		Mockito.when(iPokemonFactory.createPokemon(0, 613, 64, 4000, 4)).thenAnswer(a -> {
			return new Pokemon(0, "Bulbizarre", 126, 126, 90, 613, 64, 4000, 4, 56);
		});
		
		Mockito.when(iPokedex.size()).thenAnswer(a -> 1);
		Mockito.when(iPokedex.addPokemon(null)).thenAnswer(a -> 0);
		Mockito.when(iPokedex.getPokemon(0)).thenAnswer(a -> pokemon);
		Mockito.when(iPokedex.getPokemons()).thenAnswer(a -> Arrays.asList(new Pokemon[] {pokemon} ));
		Mockito.when(iPokedex.getPokemons(null)).thenAnswer(a -> Arrays.asList(new Pokemon[] {pokemon}  ));
		Mockito.when(iPokedex.getPokemons(ordre)).thenAnswer(a -> Arrays.asList(new Pokemon[] {pokemon}));
		Mockito.when(pokedexFactory.createPokedex(metadataProvider, iPokemonFactory)).thenAnswer(a -> iPokedex);
	}
	
	@Test
	public void testCreatePokedex() {
		try {
			IPokedex px = pokedexFactory.createPokedex(metadataProvider, iPokemonFactory);
			Assert.assertEquals(0, px.addPokemon(pokemon));
			Assert.assertEquals(1, px.size());
			Assert.assertEquals("Bulbizarre", px.getPokemons().get(0).getName());
			Assert.assertEquals("Bulbizarre", px.getPokemons(ordre).get(0).getName());
			Assert.assertEquals("Bulbizarre", px.getPokemon(0).getName());
			Assert.assertEquals("Bulbizarre", px.getPokemons(null).get(0).getName());	
		}
		catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}
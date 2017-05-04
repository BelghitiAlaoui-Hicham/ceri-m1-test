package fr.univavignon.pokedex.api;

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

import fr.univavignon.pokedex.api.IPokedex;
import fr.univavignon.pokedex.api.IPokedexFactory;
import fr.univavignon.pokedex.api.IPokemonFactory;
import fr.univavignon.pokedex.api.IPokemonMetadataProvider;
import fr.univavignon.pokedex.api.IPokemonTrainerFactory;
import fr.univavignon.pokedex.api.Pokemon;
import fr.univavignon.pokedex.api.PokemonMetadata;
import fr.univavignon.pokedex.api.PokemonTrainer;
import fr.univavignon.pokedex.api.Team;

public class IPokemonTrainerFactoryTest {

	private Pokemon pokemon = new Pokemon(0, "Bulbizarre", 126, 126, 90, 613, 64, 4000, 4, 56);
	private Comparator<Pokemon> ordre = new Comparator<Pokemon>() {
		@Override
		public int compare(Pokemon o1, Pokemon o2) {
			return o1.getIndex() - o2.getIndex();
		}
	};
	
	@Mock
	private static IPokedexFactory pokedexFactory;
	
	@Mock
	private static IPokemonMetadataProvider pokemonMetadataProvider;
	
	@Mock
	private static IPokemonFactory iPokemonFactory;
	
	@Mock
	private static IPokedex iPokedex;
	
	@Mock
	private static IPokemonTrainerFactory iTrainerFactory;
	
	@Rule
	public MockitoRule mockitoRule = MockitoJUnit.rule();
	

	
	@Before
	public void setUp() throws Exception {
		Mockito.when(pokemonMetadataProvider.getPokemonMetadata(0)).thenAnswer(a -> {
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
		Mockito.when(pokedexFactory.createPokedex(pokemonMetadataProvider, iPokemonFactory)).thenAnswer(a -> iPokedex);

		Mockito.when(iTrainerFactory.createTrainer("hicham", Team.MYSTIC, pokedexFactory)).thenAnswer(a -> {
			return new PokemonTrainer("hicham", Team.MYSTIC, iPokedex);
		});
	}
	
	
	@Test
	public void testCreateTrainer() {
		PokemonTrainer trainer = iTrainerFactory.createTrainer("hicham", Team.MYSTIC, pokedexFactory);
		Assert.assertEquals("hicham", trainer.getName());
		Assert.assertEquals(Team.MYSTIC, trainer.getTeam());
	}
}

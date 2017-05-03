package test.java.fr.univavignon.pokedex.api;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import main.java.fr.univavignon.pokedex.api.IPokemonFactory;
import main.java.fr.univavignon.pokedex.api.PokedexException;
import main.java.fr.univavignon.pokedex.api.Pokemon;

public class IPokemonFactoryTest {
	@Mock
	private static IPokemonFactory iPokemonFactory;
	
	@Rule 
	public MockitoRule mockitoRule = MockitoJUnit.rule();
	
	@Before
	public void setUp() throws PokedexException {
		Mockito.when(iPokemonFactory.createPokemon(0, 613, 64, 4000, 4)).thenAnswer(a -> {
			return new Pokemon(0, "Bulbizarre", 126, 126, 90, 613, 64, 4000, 4, 56);
		});
	}
	
	@Test
	public void testGetPokemonMetadata() {
		Pokemon pokemon = iPokemonFactory.createPokemon(0, 613, 64, 4000, 4);	
		/** Teste de Pokemon index. **/
		Assert.assertEquals(0, pokemon.getIndex());
		
		/** Teste de Pokemon name. **/
		Assert.assertEquals("Bulbizarre", pokemon.getName());
		
		/** Teste de Pokemon attack level. **/
		Assert.assertEquals(126, pokemon.getAttack());
		
		/** Teste de Pokemon defense level. **/
		Assert.assertEquals(126, pokemon.getDefense());
		
		/** Teste de Pokemon stamina level. **/
		Assert.assertEquals(90, pokemon.getStamina());
		
		/** Combat Point of the pokemon. **/
		Assert.assertEquals(613, pokemon.getCp());
		
		/** HP of the pokemon. **/
		Assert.assertEquals(64, pokemon.getHp());
		
		/** Required dust for upgrading this pokemon. **/
		Assert.assertEquals(4000, pokemon.getDust());
		
		/** Required candy for upgrading this pokemon. **/
		Assert.assertEquals(4, pokemon.getCandy());
		
		/** IV perfection percentage. **/
		Assert.assertEquals(56, pokemon.getIv(), 0);

	}
}

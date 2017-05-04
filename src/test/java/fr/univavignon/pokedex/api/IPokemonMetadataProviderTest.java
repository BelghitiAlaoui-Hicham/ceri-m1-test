package fr.univavignon.pokedex.api;

import java.io.IOException;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import fr.univavignon.pokedex.api.IPokemonMetadataProvider;
import fr.univavignon.pokedex.api.PokedexException;
import fr.univavignon.pokedex.api.PokemonMetadata;

public class IPokemonMetadataProviderTest {

	@Mock
	protected
	static IPokemonMetadataProvider pokemonMetadataProvider;
	
	@Rule 
	public MockitoRule mockitoRule = MockitoJUnit.rule();
	
	@Before
	public void setUp() throws PokedexException, IOException {
		Mockito.when(pokemonMetadataProvider.getPokemonMetadata(0)).thenAnswer(a -> {
			return new PokemonMetadata(0, "Bulbasaur", 126, 126, 90);
		});
	}
	
	
	@Test
	public void testGetPokemonMetadata() {
		try {
			PokemonMetadata metadata = pokemonMetadataProvider.getPokemonMetadata(0);	
			/** Teste de Pokemon index. **/
			Assert.assertEquals(0, metadata.getIndex());
			
			/** Teste de Pokemon name. **/
			Assert.assertEquals("Bulbasaur", metadata.getName());
			
			/** Teste de Pokemon attack level. **/
			Assert.assertEquals(126, metadata.getAttack());
			
			/** Teste de Pokemon defense level. **/
			Assert.assertEquals(126, metadata.getDefense());
			
			/** Teste de Pokemon stamina level. **/
			Assert.assertEquals(90, metadata.getStamina());
		}
		catch (PokedexException ex) {
			ex.printStackTrace();
		}
	}
	
	
}

package fr.univavignon.pokedex.api.impl;

import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.net.URL;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import fr.univavignon.pokedex.api.IPokemonMetadataProvider;
import fr.univavignon.pokedex.api.PokedexException;
import fr.univavignon.pokedex.api.PokemonMetadata;
import org.apache.commons.io.IOUtils;
public class PokemonMetadataProvider implements IPokemonMetadataProvider, Serializable {
	
    private final String DATA_PATH = "https://raw.githubusercontent.com/PokemonGo-Enhanced/node-pokemongo-data/master/data.json";
    private JSONArray data;
    private final String NAME = "Identifier";
    private  final String ATTAQUE = "BaseAttack";
    private final String DEFENSE = "BaseDefense";
    private final String STAMINIA = "BaseStamina";
	
    private static PokemonMetadataProvider instance = null;
    
    private static final long serialVersionUID = -2091104239439721760L;
    
    public static synchronized PokemonMetadataProvider pokemonMetadataProvider() throws IOException {
        if (instance == null) {
            instance = new PokemonMetadataProvider();
        }
        return instance;
    }

    private void getData() throws IOException {
        try (InputStream is = new URL(DATA_PATH).openStream()){
            data = new JSONArray(IOUtils.toString(is, "UTF-8"));
        } catch (JSONException e) {
			e.printStackTrace();
		}
    }
	
    private PokemonMetadataProvider() throws IOException {
        this.getData();
    }
    
    @Override
    public PokemonMetadata getPokemonMetadata(int index) throws PokedexException {
        if (index < 0 || index > 150) {
            throw new PokedexException("Index out of Bounds");
        }
        try {
            JSONObject tmp = data.getJSONObject(index);
            if (tmp != null) {
                return new PokemonMetadata(index, tmp.getString(NAME), tmp.getInt(ATTAQUE), tmp.getInt(DEFENSE), tmp.getInt(STAMINIA));
            }
        } catch (JSONException e) {
            return null;
        }

        return null;
    }
}

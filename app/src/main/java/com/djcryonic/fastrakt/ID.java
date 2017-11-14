package com.djcryonic.fastrakt;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

/**
 * Created by cody on 7/9/17.
 */

public class ID {

	private int trakt;
	private String slug;
	private int tvdb;
	private String imdb;
	private int tmdb;
	private int tvRage;

	ID(JsonElement element) {
		final JsonObject ids = element.getAsJsonObject();

		trakt = ids.get("trakt").getAsInt();
		slug = ids.get("slug").getAsString();
//		tvdb = ids.get("tvdb").getAsInt();
		imdb = ids.get("imdb").getAsString();
		tmdb = ids.get("tmdb").getAsInt();
//		tvRage = ids.get("tvRage").getAsInt();
	}
}

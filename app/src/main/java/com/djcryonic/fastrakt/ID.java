package com.djcryonic.fastrakt;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

/**
 * Created by cody on 7/9/17.
 */

public class ID {

	private Integer trakt;
	private String slug;
	private int tvdb;
	private String imdb;
	private int tmdb;
	private int tvRage;

	ID(JsonElement element) {
		final JsonObject ids = element.getAsJsonObject();

		if (ids.has("trakt")) trakt = ids.get("trakt").getAsInt();
		if (ids.has("slug")) slug = ids.get("slug").getAsString();
		if (ids.has("tvdb")) tvdb = ids.get("tvdb").getAsInt();
		if (ids.has("imdb")) imdb = ids.get("imdb").getAsString();
		if (ids.has("tmdb")) tmdb = ids.get("tmdb").getAsInt();
		if (ids.has("tvRage")) tvRage = ids.get("tvRage").getAsInt();
	}
}

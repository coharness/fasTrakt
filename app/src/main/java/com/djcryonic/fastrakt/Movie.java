package com.djcryonic.fastrakt;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import java.net.URL;
import java.util.ArrayList;
import java.util.Date;

/**
 * Created by cody on 7/9/17.
 */

public class Movie extends StandardMediaObject {

	private String tagline;
	private String overview;
	private Date released;
	private int runtime;
	private URL trailer;
	private URL homepage;
	private Double rating;
	private int votes;
	private Date updatedAt;
	private String language;
	private ArrayList<String> availableTranslations;
	private ArrayList<String> genres;
	private String certification;

	Movie(JsonElement element) {
		super(element);

		final JsonObject movie = element.getAsJsonObject().get("movie").getAsJsonObject();

		title = movie.get("title").getAsString();
		year = movie.get("year").getAsInt();
		id = new ID(movie.get("ids").getAsJsonObject());
	}
}

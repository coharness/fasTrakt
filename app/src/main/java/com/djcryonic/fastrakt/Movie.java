package com.djcryonic.fastrakt;

import com.google.gson.JsonElement;

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

	Movie(JsonElement jsonElement) {
		super(jsonElement.getAsJsonObject(), "movie");

		if (mediaObject.has("tagline")) tagline = mediaObject.get("tagline").getAsString();
		if (mediaObject.has("overview")) overview = mediaObject.get("overview").getAsString();
		if (mediaObject.has("released")) released = getDate("released");
		if (mediaObject.has("runtime")) runtime = mediaObject.get("runtime").getAsInt();
		if (mediaObject.has("trailer")) trailer = getUrl("trailer");
		if (mediaObject.has("homepage")) homepage = getUrl("homepage");
		if (mediaObject.has("rating")) rating = mediaObject.get("rating").getAsDouble();
		if (mediaObject.has("votes")) votes = mediaObject.get("votes").getAsInt();
		if (mediaObject.has("updatedAt")) updatedAt = getDate("updatedAt");
		if (mediaObject.has("language")) language = mediaObject.get("language").getAsString();
//		if (mediaObject.has("availableTranslations")) availableTranslations = mediaObject.get("availableTranslations").getAsJsonObject();
//		if (mediaObject.has("genres")) genres = mediaObject.get("genres").getAsJsonObject();
		if (mediaObject.has("certification")) certification = mediaObject.get("certification").getAsString();
	}
}

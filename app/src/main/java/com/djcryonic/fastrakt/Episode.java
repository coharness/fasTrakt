package com.djcryonic.fastrakt;

import com.google.gson.JsonElement;

import java.net.URL;
import java.util.ArrayList;
import java.util.Date;

/**
 * Created by cody on 7/9/17.
 */

public class Episode extends StandardMediaObject {

	private String overview;
	private Date firstAired;
//	private RawJSON airs;
	private int runtime;
	private String certification;
	private String network;
	private String country;
	private URL trailer;
	private URL homepage;
	private String status;
	private Double rating;
	private int votes;
	private Date updatedAt;
	private String language;
	private ArrayList<String> availableTranslations;
	private ArrayList<String> genres;
	private int airedEpisodes;

	Episode(JsonElement element) {
		super(element.getAsJsonObject(), "episode");

		if (mediaObject.has("overview")) overview = mediaObject.get("overview").getAsString();
//		if (mediaObject.has("firstAired")) firstAired = mediaObject.get("firstAired").getAsDate();
		if (mediaObject.has("runtime")) runtime = mediaObject.get("runtime").getAsInt();
		if (mediaObject.has("certification")) certification = mediaObject.get("certification").getAsString();
		if (mediaObject.has("network")) network = mediaObject.get("network").getAsString();
		if (mediaObject.has("country")) country = mediaObject.get("country").getAsString();
//		if (mediaObject.has("trailer")) trailer = mediaObject.get("trailer").getAsURL();
//		if (mediaObject.has("homepage")) homepage = mediaObject.get("homepage").getAsURL();
		if (mediaObject.has("status")) status = mediaObject.get("status").getAsString();
		if (mediaObject.has("rating")) rating = mediaObject.get("rating").getAsDouble();
		if (mediaObject.has("votes")) votes = mediaObject.get("votes").getAsInt();
//		if (mediaObject.has("updatedAt")) updatedAt = mediaObject.get("updatedAt").getAsDate();
		if (mediaObject.has("language")) language = mediaObject.get("language").getAsString();
//		if (mediaObject.has("availableTranslations")) availableTranslations = mediaObject.get("availableTranslations").getAsArrayList<String>();
//		if (mediaObject.has("genres")) genres = mediaObject.get("genres").getAsArrayList<String>();
		if (mediaObject.has("airedEpisodes")) airedEpisodes = mediaObject.get("airedEpisodes").getAsInt();
	}
}

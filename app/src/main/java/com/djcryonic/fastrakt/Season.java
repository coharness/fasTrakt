package com.djcryonic.fastrakt;

import com.google.gson.JsonElement;

import java.util.ArrayList;
import java.util.Date;

/**
 * Created by cody on 7/9/17.
 */

public class Season extends StandardMediaObject {

	private int number;
	private double rating;
	private int votes;
	private int episodeCount;
	private int airedEpisodes;
	private String overview;
	private Date firstAired;
	private ArrayList<Episode> episodes;

	Season(JsonElement element) {
		super(element.getAsJsonObject(), "season");

		if (mediaObject.has("episodes")) {
			episodes = new ArrayList<>();

			for (JsonElement e : mediaObject.get("episodes").getAsJsonArray()) {
				episodes.add(new Episode(e));
			}
		}
	}
}

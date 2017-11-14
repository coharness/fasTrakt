package com.djcryonic.fastrakt;

import com.google.gson.JsonElement;

import java.util.ArrayList;

/**
 * Created by charness on 11/14/17.
 */

public class Show extends StandardMediaObject {

	private ArrayList<Season> seasons;

	Show(JsonElement element) {
		super(element.getAsJsonObject(), "show");

		if (mediaObject.has("seasons")) {
			seasons = new ArrayList<>();

			for (JsonElement e : mediaObject.get("seasons").getAsJsonArray()) {
				seasons.add(new Season(e));
			}
		}
	}
}

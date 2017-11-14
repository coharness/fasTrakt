package com.djcryonic.fastrakt;

import com.google.gson.JsonObject;

import java.util.Date;

/**
 * Created by cody on 7/9/17.
 * The standard properties each media object has in common.
 */

abstract class StandardMediaObject {

	private String title;
	private int year;
	private ID id;
	private int plays;
	private Date lastWatchedAt;

	JsonObject mediaObject;

	StandardMediaObject(JsonObject jsonObject, String objectKey) {
		mediaObject = jsonObject.get(objectKey).getAsJsonObject();

		if (mediaObject.has("title")) title = mediaObject.get("title").getAsString();
		if (mediaObject.has("year")) year = mediaObject.get("year").getAsInt();
		if (mediaObject.has("ids")) id = new ID(mediaObject.get("ids").getAsJsonObject());
		if (mediaObject.has("plays")) plays = mediaObject.get("plays").getAsInt();
//		if (mediaObject.has("last_watched_at")) lastWatchedAt = mediaObject.get("last_watched_at").getAsDate();
	}

	final String getTitle() {
		return title;
	}

	final int getYear() {
		return year;
	}

	final ID getId() {
		return id;
	}

	final int getPlays() {
		return plays;
	}

	final Date getLastWatchedAt() {
		return lastWatchedAt;
	}
}

package com.djcryonic.fastrakt;

import com.google.gson.JsonObject;

import java.net.MalformedURLException;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

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

	// A DateFormat that will be used across some children.
	protected SimpleDateFormat dateFormat;

	protected JsonObject mediaObject;

	StandardMediaObject(JsonObject jsonObject, String memberName) {
		dateFormat = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());

		mediaObject = jsonObject.get(memberName).getAsJsonObject();

		if (mediaObject.has("title")) title = mediaObject.get("title").getAsString();
		if (mediaObject.has("year")) year = mediaObject.get("year").getAsInt();
		if (mediaObject.has("ids")) id = new ID(mediaObject.get("ids").getAsJsonObject());
		if (mediaObject.has("plays")) plays = mediaObject.get("plays").getAsInt();
		if (mediaObject.has("last_watched_at")) lastWatchedAt = getDate("last_watched_at");
	}

	protected Date getDate(String memberName) {
		try {
			return dateFormat.parse(mediaObject.get(memberName).getAsString());
		} catch (ParseException exc) {
			return null;
		}
	}

	protected URL getUrl(String memberName) {
		try {
			return new URL(mediaObject.get(memberName).getAsString());
		} catch (MalformedURLException exc) {
			return null;
		}
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

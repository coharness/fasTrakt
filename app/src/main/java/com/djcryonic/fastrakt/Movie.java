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

	Movie(JsonElement element) {
		super(element);
	}
}

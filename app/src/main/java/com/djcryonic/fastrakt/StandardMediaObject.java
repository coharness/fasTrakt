package com.djcryonic.fastrakt;

import com.google.gson.JsonElement;

/**
 * Created by cody on 7/9/17.
 */

abstract class StandardMediaObject {

	String title;
	int year;
	ID id;

	StandardMediaObject(JsonElement element) {

	}
}

package com.djcryonic.fastrakt;

import android.os.AsyncTask;
import android.util.Log;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;

/**
 * Created by cody on 4/8/17.
 * Handles calls to the Trakt API.
 */

class TraktInteractions extends AsyncTask<String, Void, String> {

void attempt() {
	execute("https://api.trakt.tv/users/guardian1691");
}

	@Override
	protected String doInBackground(String... params) {
		try {
			URL url = new URL(params[0]);
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();

			connection.setRequestMethod("GET");
			connection.setRequestProperty("Content-Type", "application/json");
			connection.setRequestProperty("trakt-api-key", "185b7215323eb6cfae4c55fed9f6319cbf2d9bdc0d0972b6939c9d30e124e097");
			connection.setRequestProperty("trakt-api-version", "2");

			BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));

			final String line = reader.readLine();

			if (line != null) {
				JsonObject jsonObject = (new JsonParser().parse(line)).getAsJsonObject();

				for (Map.Entry<String, JsonElement> entry : jsonObject.entrySet()) {
					checkType(entry);
				}
			}
		} catch (Exception exc) {
			exc.printStackTrace();
		}

		return "idk";
	}

	private void checkType(Map.Entry<String, JsonElement> entry) {
		if (entry.getValue().isJsonPrimitive()) {
			checkPrimitiveType(entry.getKey(), entry.getValue());
		} else if (entry.getValue().isJsonObject()) {
			final JsonObject internalObject = entry.getValue().getAsJsonObject();

			checkType(internalObject.as);
		} else if (entry.getValue().isJsonArray()) {
			for (JsonElement element : entry.getValue().getAsJsonArray()) {
				checkPrimitiveType(entry.getKey(), element);
			}
		}
	}

	// TODO This will check the primitive type of each element.
	private void checkPrimitiveType(final String key, JsonElement element) {
		if (element.getAsJsonPrimitive().isBoolean()) {
			Log.v(key, String.valueOf(element.getAsBoolean()));
		} else if (element.getAsJsonPrimitive().isNumber()) {
			Log.v(key, String.valueOf(element.getAsNumber()));
		} else if (element.getAsJsonPrimitive().isString()) {
			Log.v(key, element.getAsString());
		}
	}
}

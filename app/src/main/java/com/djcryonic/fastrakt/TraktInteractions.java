package com.djcryonic.fastrakt;

import android.content.Context;
import android.os.AsyncTask;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Map;

/**
 * Created by cody on 4/8/17.
 * Handles calls to the Trakt API.
 */

class TraktInteractions extends AsyncTask<String, Void, ArrayList<String>> {

	private final static String BASE_PATH = "https://api.trakt.tv/users/guardian1691";

	private Context context;
	private LinearLayout linearLayout;

	void attempt(LinearLayout linearLayout, Context context, String action) {
		this.context = context;
		this.linearLayout = linearLayout;

		this.linearLayout.removeAllViews();

		execute(String.format("%s/%s", BASE_PATH, action));
	}

	@Override
	protected ArrayList<String> doInBackground(String... params) {
		ArrayList<String> strings = new ArrayList<>();

		try {
			URL url = new URL(params[0]);
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();

			connection.setRequestMethod("GET");
			connection.setRequestProperty("Content-Type", "application/json");
			connection.setRequestProperty("trakt-api-key", "185b7215323eb6cfae4c55fed9f6319cbf2d9bdc0d0972b6939c9d30e124e097");
			connection.setRequestProperty("trakt-api-version", "2");

			BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));

			final String line = reader.readLine();

			if (line != null) strings = readElement(new JsonParser().parse(line));
		} catch (Exception exc) {
			exc.printStackTrace();
		}

		return strings;
	}

	@Override
	protected void onPostExecute(ArrayList<String> strings) {
		super.onPostExecute(strings);

		for (String string : strings) {
			TextView textView = new TextView(context);
			textView.setText(string);

			linearLayout.addView(textView);
		}
	}

	private ArrayList<String> readElement(JsonElement element) {
		ArrayList<String> strings = new ArrayList<>();

		if (element.isJsonObject()) {
			for (Map.Entry<String, JsonElement> entry : element.getAsJsonObject().entrySet()) {
				strings.add(String.format("%s\n%s", entry.getKey(), checkType(entry)));
			}
		} else if (element.isJsonArray())
			for (JsonElement innerElement : element.getAsJsonArray()) {
				strings.addAll(readElement(innerElement));
			}

		return strings;
	}

	private ArrayList<String> checkType(Map.Entry<String, JsonElement> entry) {
		ArrayList<String> strings = new ArrayList<>();

		if (entry.getValue().isJsonPrimitive()) {
			strings.add(checkPrimitiveType(entry.getKey(), entry.getValue()));
		} else if (entry.getValue().isJsonObject()) {
			strings.addAll(readElement(entry.getValue()));
		} else if (entry.getValue().isJsonArray()) {
			strings.addAll(readElement(entry.getValue()));
		}

		return strings;
	}

	private String checkPrimitiveType(final String key, JsonElement element) {
		String string = "";

		if (element.getAsJsonPrimitive().isBoolean()) {
			string = String.format("\"%s\" : %b", key, element.getAsBoolean());
		} else if (element.getAsJsonPrimitive().isNumber()) {
			string = String.format("\"%s\" : %s", key, element.getAsNumber().toString());
		} else if (element.getAsJsonPrimitive().isString()) {
			string = String.format("\"%s\" : \"%s\"", key, element.getAsString());
		}

		return string;
	}
}

package com.djcryonic.fastrakt;

import android.content.Context;
import android.os.AsyncTask;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

/**
 * Created by cody on 4/8/17.
 * Handles calls to the Trakt API.
 */

class TraktInteractions extends AsyncTask<String, Void, ArrayList<StandardMediaObject>> {

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
	protected ArrayList<StandardMediaObject> doInBackground(String... params) {
		ArrayList<StandardMediaObject> objects = new ArrayList<>();

		try {
			URL url = new URL(params[0]);
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();

			connection.setRequestMethod("GET");
			connection.setRequestProperty("Content-Type", "application/json");
			connection.setRequestProperty("trakt-api-key", "185b7215323eb6cfae4c55fed9f6319cbf2d9bdc0d0972b6939c9d30e124e097");
			connection.setRequestProperty("trakt-api-version", "2");

			BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));

			final String line = reader.readLine();

			if (line != null) objects = readElement(new JsonParser().parse(line));
		} catch (Exception exc) {
			exc.printStackTrace();
		}

		return objects;
	}

	@Override
	protected void onPostExecute(ArrayList<StandardMediaObject> objects) {
		super.onPostExecute(objects);

		for (StandardMediaObject object : objects) {
			TextView textView = new TextView(context);
			textView.setText(object.toString());

			linearLayout.addView(textView);
		}
	}

	private ArrayList<StandardMediaObject> readElement(JsonElement element) {
		final ArrayList<StandardMediaObject> objects = new ArrayList<>();

		for (JsonElement e : element.getAsJsonArray()) {
			final JsonObject object = e.getAsJsonObject();

			if (object.has("movie")) objects.add(new Movie(e));
		}

		return objects;
	}
}

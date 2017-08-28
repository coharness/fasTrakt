package com.djcryonic.fastrakt;

import com.google.gson.JsonElement;

/**
 * Created by cody on 7/9/17.
 */

public class Season extends StandardMediaObject {

	Season(JsonElement element) {
		super(element);
	}
	// Extended: Min
	//	public let number: Int
	//	public let ids: SeasonId
	//	public let rating: Double
	//	public let votes: Int
	//	public let episodeCount: Int
	//	public let airedEpisodes: Int
	//	public let overview: String?
	//	public let firstAired: Date?
	//
	//	// Extended: Full
	//	public let episodes: [TraktEpisode]
}

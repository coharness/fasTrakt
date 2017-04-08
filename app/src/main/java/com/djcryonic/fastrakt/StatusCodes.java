package com.djcryonic.fastrakt;

/**
 * Created by cody on 4/8/17.
 * Status codes used by Trakt.tv
 */

public class StatusCodes {

	static String getDescription(int statusCode) {
		switch (statusCode) {
			case 200:
				return "Success";
			case 201:
				return "Success - new resource created (POST)";
			case 204:
				return "Success - no content to return (DELETE)";
			case 400:
				return "Bad Request - request couldn't be parsed";
			case 401:
				return "Unauthorized - OAuth must be provided";
			case 403:
				return "Forbidden - invalid API key or unapproved app";
			case 404:
				return "Not Found - method exists, but no record found";
			case 405:
				return "Method Not Found - method doesn't exist";
			case 409:
				return "Conflict - resource already created";
			case 412:
				return "Precondition Failed - use application/json content type";
			case 422:
				return "Unprocessible Entity - validation errors";
			case 429:
				return "Rate Limit Exceeded";
			case 500:
				return "Server Error";
			case 503:
				return "Service Unavailable - server overloaded (try again in 30s)";
			case 504:
				return "Service Unavailable - server overloaded (try again in 30s)";
			case 520:
				return "Service Unavailable - Cloudflare error";
			case 521:
				return "Service Unavailable - Cloudflare error";
			case 522:
				return "Service Unavailable - Cloudflare error";
			default:
				return "";
		}
	}
}

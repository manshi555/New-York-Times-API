package com.yasht.newyorktimes.utils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

import com.yasht.newyorktimes.model.NewsDetails;

public class Utilities {

	public static List<NewsDetails> parseNews(JSONArray array) {
		List<NewsDetails> results = new ArrayList<NewsDetails>();
		System.out.println("Size of array "+array.length());
		for(int i = 0; i < array.length(); i++) {
			NewsDetails newsDetails = new NewsDetails();
			JSONObject jsonObject = array.getJSONObject(i);
			newsDetails.setSection(jsonObject.getString("section"));
			newsDetails.setTitle(jsonObject.getString("title"));
			newsDetails.setAbstract_(jsonObject.getString("abstract"));
			newsDetails.setByLine(jsonObject.getString("byline"));
		    newsDetails.setUrl(jsonObject.getString("url"));
		    newsDetails.setPublishedDate(parseTime(jsonObject.getString("published_date")));
			results.add(newsDetails);
		}
		return results;
	}
	
	private static LocalDateTime parseTime(String date) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss");
//		utcFormat.setTimeZone(TimeZone.getTimeZone("UTC"));

		LocalDateTime dateTime = LocalDateTime.parse(date.substring(0, 19), formatter);
		return dateTime;
	}
}

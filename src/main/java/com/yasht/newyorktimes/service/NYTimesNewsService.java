package com.yasht.newyorktimes.service;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import com.yasht.newyorktimes.exception.model.SectionNotFoundException;
import com.yasht.newyorktimes.model.NewsDetails;
import com.yasht.newyorktimes.utils.Utilities;

@Service
public class NYTimesNewsService {

	@Autowired
	RestTemplate restTemplate;

	@Value("${nytimes.api.key}")
	private String apiKey;

	private static String url = "https://api.nytimes.com/svc/topstories/v2/";

	public List<NewsDetails> getTopStory(String topic) throws SectionNotFoundException {
		List<NewsDetails> newsDetails = new ArrayList<NewsDetails>();
		ResponseEntity<String> response;
		url = url + topic + ".json?api-key=" + apiKey;
		System.out.println("URL<><><><><><><><><><><><><><><><><><><><><> " + url);
		HttpMethod method = HttpMethod.GET;
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<String> requestEntity = new HttpEntity<String>(headers);
		try {
			response = restTemplate.exchange(url, method, requestEntity, String.class);
		} catch (HttpClientErrorException e) {
			throw new SectionNotFoundException(topic + " is not a valid news section");
		}
		JSONObject jsonResponse = new JSONObject(response.getBody());
		JSONArray jsonArray = jsonResponse.getJSONArray("results");
		newsDetails = Utilities.parseNews(jsonArray);
		return newsDetails;
	}
}

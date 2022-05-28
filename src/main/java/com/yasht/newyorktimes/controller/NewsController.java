package com.yasht.newyorktimes.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yasht.newyorktimes.exception.CustomExceptionHandler;
import com.yasht.newyorktimes.exception.model.SectionNotFoundException;
import com.yasht.newyorktimes.model.NewsDetails;
import com.yasht.newyorktimes.service.NYTimesNewsService;

@RestController
@RequestMapping("/news")
public class NewsController extends CustomExceptionHandler {

	@Autowired
	NYTimesNewsService newsService;
	
	@SuppressWarnings("null")
	@GetMapping("/topStories/{topic}")
	public ResponseEntity<List<NewsDetails>> getTopStories(@PathVariable("topic") String topic) throws SectionNotFoundException {
		List<NewsDetails> topStory = newsService.getTopStory(topic);
		if(topStory != null || !topStory.isEmpty()) 
			return new ResponseEntity<List<NewsDetails>>(topStory, HttpStatus.OK);
		else
			return new ResponseEntity<List<NewsDetails>>(HttpStatus.BAD_REQUEST);
	}
}

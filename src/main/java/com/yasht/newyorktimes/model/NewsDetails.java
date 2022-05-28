package com.yasht.newyorktimes.model;

import java.time.LocalDateTime;

public class NewsDetails {

	private String section;
	private String byLine;
	private String title;
	private String abstract_;
	private String url;
	private LocalDateTime publishedDate;
	
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getSection() {
		return section;
	}
	public void setSection(String section) {
		this.section = section;
	}
	public String getByLine() {
		return byLine;
	}
	public void setByLine(String byLine) {
		this.byLine = byLine;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAbstract_() {
		return abstract_;
	}
	public void setAbstract_(String abstract_) {
		this.abstract_ = abstract_;
	}
	public LocalDateTime getPublishedDate() {
		return publishedDate;
	}
	public void setPublishedDate(LocalDateTime publishedDate) {
		this.publishedDate = publishedDate;
	}
}

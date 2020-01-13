package com.shorturl.Controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.shorturl.ShortenUrl.ShortenUrlUtils;
import com.shorturl.URLEntity.URLEntity;
import com.shorturl.URLService.URLService;

@Controller
public class URLController {
	
	@Autowired
	public URLService urlService;
	
	@Autowired 
	public ShortenUrlUtils shortenUrlUtiles;
	
	@RequestMapping(value="/{shorturl}",method=RequestMethod.GET)
	public String shorturl(@PathVariable("shorturl") String shorturl) {
		URLEntity url=urlService.findURLEntityByShortURL(shorturl);
		return url.getUrl();
	}
	
	@RequestMapping(value="/create",method=RequestMethod.POST)
	public URLEntity saveurl(@Valid URLEntity url) {
		URLEntity existed=urlService.findURLEntityByURL(url.getUrl());
		if(existed!=null)
			return existed;
		else {
			url.setShorturl(shortenUrlUtiles.generateShortURL(url.getId()));
			url=urlService.save(url);
			return url;
		}
		
	}
	
	@RequestMapping(value="/{shortURL}")
	public String generateShortURL(@PathVariable("url") String url,@PathVariable("id") int id) {
		String shorturl=shortenUrlUtiles.generateShortURL(id);
		return shorturl;
	}

	@RequestMapping(value="/delete")
	public void deleteURL(@PathVariable("url") URLEntity url) {
		urlService.delete(url);
	}
	
}

package com.shorturl.URLService;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shorturl.URLDao.URLDao;
import com.shorturl.URLEntity.URLEntity;

@Service
public class URLService {
	
	@Autowired
	URLDao urlDao;
	
	public URLEntity findURLEntityByURL(String url) {
		return urlDao.findByURL(url);
	}
	
	public URLEntity findURLEntityByShortURL(String shorturl) {
		return urlDao.findByShortURL(shorturl);
	}

	public URLEntity save(URLEntity url) {
		// TODO Auto-generated method stub
		return urlDao.save(url);
	}
	
	public void delete(URLEntity url) {
		urlDao.delete(url);
	}
	
}

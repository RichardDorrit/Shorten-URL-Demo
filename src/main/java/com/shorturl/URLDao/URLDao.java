package com.shorturl.URLDao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shorturl.URLEntity.URLEntity;

public interface URLDao extends JpaRepository<URLEntity,Long>{

	public URLEntity findByShortURL(String shorturl);
	
	public URLEntity findByURL(String url);
}

package tn.dari.spring.service;

import java.io.InputStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.flickr4java.flickr.FlickrException;

import lombok.extern.slf4j.Slf4j;
import tn.dari.spring.entity.Ads;
import tn.dari.spring.repository.AdsRepository;

@Service
@Slf4j
public class SaveAdsPhotoServiceImpl implements SaveAdsPhotoService<Ads>{

	@Autowired
	private FlickrService flickrService;
	@Autowired
	private AdsService adsService;
	
	@Override
	public Ads savePhoto(Long id, InputStream media, String titre) throws FlickrException {
		Ads ads= adsService.retrieveById(id);
	String urlPhoto =flickrService.saveMedia(media, titre);
	if(StringUtils.hasLength(urlPhoto)) {
	//	throw new InvalidOperationException("",ErrorCodes.UPDATE_MEDIA_EXCEPTION);
	}
		ads.setMedia(urlPhoto);
	return adsService.addAds(ads);
	}

}

package com.app.Service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.Exception.ResourseNotFoundException;
import com.app.dao.VideoRepository;
import com.app.entity.Video;

@Service
public class VideoService implements VideoInterface {
	@Autowired
	VideoRepository videorepository;

	@Override
	public Video createPost(Video videoentity) {

		try {
			Video video = videorepository.save(videoentity);
			return video;

		} catch (Exception e) {
			throw new ResourseNotFoundException(false, "Something Went Wrong");
		}

	}

	@Override
	public Video getVideoById(Integer id) {
		Video video = videorepository.findById(id)
				.orElseThrow(() -> new ResourseNotFoundException(false, "Video Id not found"));
		return video;
	}

	@Override
	public Video updatePost(Video videos, Integer id) {
		Video video = videorepository.findById(id)
				.orElseThrow(() -> new ResourseNotFoundException(false, "Video id not found"));

		Video updateVideo = videorepository.save(video);
		return updateVideo;
	}

	@Override
	public Video deleteVideos(Integer Id) {
		// TODO Auto-generated method stub
		return null;
	}

}

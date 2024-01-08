package com.app.Service;

import com.app.Utils.VideoUtils;
import com.app.dao.ModulesRepository;
import com.app.entity.ModuleEntity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
public class ModuleService {

	@Autowired
	private ModulesRepository moduleRepository;

	public List<ModuleEntity> getVideosWithId() {
		return moduleRepository.findAll();
	}

	public List<byte[]> getVideosWithoutId() {
		return moduleRepository.findVideosWithoutId();
	}

	public Optional<ModuleEntity> getVideoById(int videoId) {
		return moduleRepository.findById(videoId);
	}

	public String uploadVideo(MultipartFile file) throws IOException {
		ModuleEntity videosEntity = new ModuleEntity();
		videosEntity.setVideo(VideoUtils.compressVideo(file.getBytes()));
		ModuleEntity savedEntity = moduleRepository.save(videosEntity);

		if (savedEntity != null) {
			return "Video uploaded successfully: " + file.getOriginalFilename();
		}
		return null;
	}

	public String deleteVideo(int videoId) {
		Optional<ModuleEntity> optionalVideo = moduleRepository.findById(videoId);

		if (optionalVideo.isPresent()) {
			ModuleEntity videosEntity = optionalVideo.get();
			moduleRepository.delete(videosEntity);
			return "Video deleted successfully with ID: " + videoId;
		} else {
			return "Video not found with ID: " + videoId;
		}
	}

	public List<Object[]> myLearningDetails() {
		return moduleRepository.myLearningsData();
	}
}

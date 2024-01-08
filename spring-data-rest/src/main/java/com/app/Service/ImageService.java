package com.app.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.app.Utils.ImageUtils;
import com.app.dao.ImagesRepository;
import com.app.entity.ImagesEntity;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
public class ImageService {

	 @Autowired
	    private ImagesRepository imagesRepository;
	 
	 
	    public List<ImagesEntity> getImageWithId(){
	    	return imagesRepository.findAll();
	    }
	    
	    
	    public List<byte[]> getImageWithOutId(){
	    	return imagesRepository.getImageWithoutId();
	    }
	    

	    public String uploadImage(MultipartFile file) throws IOException {
	        ImagesEntity imagesEntity = new ImagesEntity();
	        imagesEntity.setImage(ImageUtils.compressImage(file.getBytes()));

	        ImagesEntity savedEntity = imagesRepository.save(imagesEntity);

	        if (savedEntity != null) {
	            return "File uploaded successfully: " + file.getOriginalFilename();
	        }
	        return null;
	    }
    
    
    
    public String deleteImage(int imageId) {
        Optional<ImagesEntity> optionalImage = imagesRepository.findById(imageId);

        if (optionalImage.isPresent()) {
            ImagesEntity imagesEntity = optionalImage.get();
            imagesRepository.delete(imagesEntity);
            return "File deleted successfully with ID: " + imageId;
        } else {
            return "File not found with ID: " + imageId;
        }
    }
}

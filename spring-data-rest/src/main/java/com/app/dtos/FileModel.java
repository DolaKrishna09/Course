package com.app.dtos;

public class FileModel {

public String VideoFileName;

public String getVideoFileName() {
	return VideoFileName;
}

public void setVideoFileName(String videoFileName) {
	VideoFileName = videoFileName;
}

public FileModel(String videoFileName) {
	super();
	VideoFileName = videoFileName;
}

public FileModel() {
	
}



}

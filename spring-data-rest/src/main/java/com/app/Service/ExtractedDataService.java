package com.app.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dao.ExtractedDataRepository;
import com.app.entity.ExtractedData;

import java.util.List;
import java.util.Optional;

@Service
public class ExtractedDataService {

    @Autowired
    private ExtractedDataRepository extractedDataRepository;

    public void saveExtractedData(String data) {
        ExtractedData extractedData = new ExtractedData();
        extractedData.setData(data);
        extractedDataRepository.save(extractedData);
    }

    public List<ExtractedData> getAllExtractedData() {
        return extractedDataRepository.findAll();
    }

    public Optional<ExtractedData> getExtractedDataById(Long id) {
        return extractedDataRepository.findById(id);
    }

    public void updateExtractedData(Long id, String newData) {
        Optional<ExtractedData> optionalExtractedData = extractedDataRepository.findById(id);
        if (optionalExtractedData.isPresent()) {
            ExtractedData extractedData = optionalExtractedData.get();
            extractedData.setData(newData);
            extractedDataRepository.save(extractedData);
        }
    }

    public void deleteExtractedData(Long id) {
        extractedDataRepository.deleteById(id);
    }
}

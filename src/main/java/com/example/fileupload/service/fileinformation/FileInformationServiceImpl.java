package com.example.fileupload.service.fileinformation;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.File;

@Service
public class FileInformationServiceImpl implements FileInformationService {
    @Value("${app.common.baseDirPath}")
    private String baseDirPath;

    @Override
    public String[] getAllFileName() {
        // returning all name of files from a specific folder
        String[] fileNames = new File(baseDirPath).list();
        return fileNames;
    }
}

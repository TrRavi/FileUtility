package com.example.fileupload.service.fileoperation;

import com.example.fileupload.exceptions.derived.InvalidOperationException;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;

@Service
public class FileOperationServiceImpl implements FileOperationService {
    @Value("${app.common.baseDirPath}")
    private String baseDirPath;

    @Override
    public File getFile(String fileName) {
        File file = new File(baseDirPath+fileName);
        return  file;
    }

    @Override
    public String copyFile(String fileName) {
       try {
            File file = new File(baseDirPath+fileName);
            String newFileName = fileName.split("\\.")[0];
            String extension = fileName.split("\\.")[1];
           newFileName = newFileName+"_copied."+extension;
           System.out.println("new  "+newFileName);
           File newFile = new File(baseDirPath+newFileName);
            FileUtils.copyFile(file, newFile);
        } catch (IndexOutOfBoundsException  | IOException e  ) {
            e.printStackTrace();
            return "Can not copy, check filename.  error= "+e.getMessage();
        }
        return "Successfully copied";
    }

    @Override
    public String deletFile(String fileName) {
        File file = new File(baseDirPath+fileName);
        return file.delete() ? "Successfully deleted" : "File could not delete";
    }


}

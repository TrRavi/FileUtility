package com.example.fileupload.service.fileoperation;

import java.io.File;

public interface FileOperationService {

   File getFile(String fileName);
   String copyFile(String fileName);
   String deletFile(String fileName);
}

package com.example.fileupload.controller;
import com.example.fileupload.service.fileinformation.FileInformationService;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.io.File;

@Controller
public class Index {

    private static final Logger log = LoggerFactory.getLogger(Index.class);

    @Autowired
    private FileInformationService fileInformationService;

    @ApiOperation(value = "For Loading all file names in index page")
    @GetMapping("/")
    public ModelAndView index(){
        ModelAndView modelAndView = new ModelAndView();
        String [] fileNames = fileInformationService.getAllFileName();
        modelAndView.addObject("fileNames",fileNames);
        modelAndView.setViewName("fileUpload");

        return modelAndView;
    }
}


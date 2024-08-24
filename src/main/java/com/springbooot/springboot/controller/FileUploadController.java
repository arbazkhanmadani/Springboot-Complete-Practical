package com.springbooot.springboot.controller;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@CrossOrigin
@RestController
@RequestMapping(method=RequestMethod.POST,value="/upload")
public class FileUploadController{

    private static final String UPLOAD_DIR = "src/main/resources/static/uploads/";

    @PostMapping("/image")
    public ResponseEntity<String> uploadFile(Model model,  @RequestParam("file") MultipartFile file) {
        
    	if(file.isEmpty())
            return new ResponseEntity<>("File is empty", HttpStatus.BAD_REQUEST);
        

        try{
           
        	// Create directory if not exists
            Path path = Paths.get(UPLOAD_DIR);
            System.out.println("Path : "+path);
            
            if(!Files.exists(path)){ 
                Files.createDirectories(path);
                System.out.println("files :");
     
            }

            // Save the file
            String fileName = StringUtils.cleanPath(file.getOriginalFilename());
            Path filePath = path.resolve(fileName);
            System.out.println("FilePath : "+filePath);
            
            Files.copy(file.getInputStream() ,filePath);
            model.addAttribute("imgurl", filePath);
            System.out.println("uploaded....................");
            return new ResponseEntity<>("File uploaded successfully", HttpStatus.OK);
        } 
        catch(IOException e){
        	System.out.println(e);
            return new ResponseEntity<>("File upload failed", HttpStatus.INTERNAL_SERVER_ERROR);
        }
        
    }
}

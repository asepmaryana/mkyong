package com.mkyong.upload.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class UploadController {
	
	private static String UPLOADED_FOLDER = "/assets";
	
	@GetMapping("/")
	public String index() {
		return "upload";
	}
	
	@PostMapping("/upload")
	public String singleFileUpload(@RequestParam("file") MultipartFile file, RedirectAttributes redirectAttributes, HttpSession session) {
		if (file.isEmpty()) {
            redirectAttributes.addFlashAttribute("message", "Please select a file to upload");
            return "redirect:uploadStatus";
        }

        try {
        	
        	ServletContext context = session.getServletContext();  
            String path = context.getRealPath(UPLOADED_FOLDER);  
            String filename = file.getOriginalFilename();  
          
            System.out.println(path+" "+filename);
            
            byte[] bytes = file.getBytes();  
            BufferedOutputStream stream =new BufferedOutputStream(new FileOutputStream(new File(path + File.separator + filename)));  
            stream.write(bytes);  
            stream.flush();  
            stream.close();  

            redirectAttributes.addFlashAttribute("message", "You successfully uploaded '" + file.getOriginalFilename() + "'");

        } catch (IOException e) {
        	redirectAttributes.addFlashAttribute("message", e.getMessage());
            e.printStackTrace();
        }

        return "redirect:/uploadStatus";
	}
	
	@GetMapping("/uploadStatus")
    public String uploadStatus() {
        return "uploadStatus";
    }
}

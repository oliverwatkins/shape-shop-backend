package com.shapeshop.controller;

import com.shapeshop.entity.CompanyEntity;
import com.shapeshop.entity.OrderEntity;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@CrossOrigin
@RestController
public class ImageController {


    //TODO is this being used?
    @CrossOrigin
    @RequestMapping(value = "/images/{sid}", method = RequestMethod.GET,
            produces = MediaType.IMAGE_JPEG_VALUE)
    public void getImage(HttpServletResponse response, @PathVariable("sid") String sid) throws IOException {

        var imgFile = new ClassPathResource("image/" + sid);

        response.setContentType(MediaType.IMAGE_JPEG_VALUE);
        StreamUtils.copy(imgFile.getInputStream(), response.getOutputStream());
    }


    //TODO
    @CrossOrigin
    @RequestMapping(value = "/{companyName}/images/{sid}", method = RequestMethod.POST,
            produces = MediaType.IMAGE_JPEG_VALUE)
    public void updateImage(HttpServletResponse response, @PathVariable("sid") String productId) throws IOException {

        System.out.println("updateImage ");

        var imgFile = new ClassPathResource("image/" + productId);

        response.setContentType(MediaType.IMAGE_JPEG_VALUE);
        StreamUtils.copy(imgFile.getInputStream(), response.getOutputStream());
    }
    //TODO
    @CrossOrigin
    @RequestMapping(value = "/{companyName}/uploadfile/{productId}", method = RequestMethod.POST)
    public void uploadFile(@RequestParam("file") MultipartFile file, HttpServletResponse response, @PathVariable("productId") String productId) throws IOException {

        System.out.println("updateImage " + file);

        var imgFile = new ClassPathResource("image/" + productId);

        response.setContentType(MediaType.IMAGE_JPEG_VALUE);
        StreamUtils.copy(imgFile.getInputStream(), response.getOutputStream());
    }

}

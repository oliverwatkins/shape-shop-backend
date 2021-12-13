package com.shapeshop.controller;

import com.shapeshop.entity.ProductEntity;
import com.shapeshop.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.*;

@CrossOrigin
@RestController
public class ImageController {


    @Autowired
    private ProductRepository productRepository;

    @CrossOrigin
    @RequestMapping(value = "/{companyName}/uploadfile/{productId}", method = RequestMethod.POST)
    public void uploadFile(@RequestParam("file") MultipartFile file, HttpServletResponse response, @PathVariable("productId") String productId) throws IOException {

        System.out.println("updateImage " + file);

        writeFileToFileSystem(file);

        ProductEntity p = productRepository.findById(Long.parseLong(productId));
        p.setImageFilename(file.getOriginalFilename());
        productRepository.save(p);

        System.out.println("convertMultiPartToFile : updated product with image filename " + file.getOriginalFilename());
    }

    private static File writeFileToFileSystem(MultipartFile file) throws IOException {

        String fileLocation = new File("src\\main\\resources\\alpenhof\\image").getAbsolutePath() + "\\" + file.getOriginalFilename();

        File convFile = new File(fileLocation);

        FileOutputStream fos = new FileOutputStream(convFile);

        fos.write(file.getBytes());
        fos.close();

        System.out.println("convertMultiPartToFile : saved file " + file.getOriginalFilename());

        return convFile;
    }
}

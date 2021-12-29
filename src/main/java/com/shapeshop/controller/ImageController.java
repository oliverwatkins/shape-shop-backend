package com.shapeshop.controller;

import com.shapeshop.entity.ProductEntity;
import com.shapeshop.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
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

        writeFileToFileSystem(file);

        ProductEntity p = productRepository.findById(Long.parseLong(productId));
        p.setImageFilename(file.getOriginalFilename());
        productRepository.save(p);
    }

    private static File writeFileToFileSystem(MultipartFile file) throws IOException {


        File file2 = new ClassPathResource("countries.xml").getFile();

        if (!file2.exists()) {
            throw new RuntimeException("!file2.exists()");
        }


        File file3 = new ClassPathResource("static\\images\\alpenhof\\testfile.xml").getFile();

        if (!file3.exists()) {
            throw new RuntimeException("!file3.exists()");
        }


        File file4 = new ClassPathResource("static\\images\\alpenhof\\").getFile();

        if (!file4.isDirectory()) {
            throw new RuntimeException("!file4.isDirectory()");
        }

        File file5 = new File(file4.getPath() + "\\" + "myNewFile.txt");
        if (file5.createNewFile()) {
            System.out.println("File created: " + file5.getName());
        } else {
            System.out.println("File already exists.");
        }

        File convFile = new File(file4.getPath() + "\\" + file.getOriginalFilename());
        convFile.createNewFile();

        FileOutputStream fos = new FileOutputStream(convFile);

        fos.write(file.getBytes());
        fos.close();

        return convFile;
    }
}

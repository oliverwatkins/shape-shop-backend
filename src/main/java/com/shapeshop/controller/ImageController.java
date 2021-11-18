package com.shapeshop.controller;

import com.shapeshop.entity.ProductEntity;
import com.shapeshop.repository.CompanyRepository;
import com.shapeshop.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.MediaType;
import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.*;

@CrossOrigin
@RestController
public class ImageController {


    @Autowired
    private ProductRepository productRepository;


    //TODO is this being used?
    @CrossOrigin
    @RequestMapping(value = "/{companyName}/images/{sid}", method = RequestMethod.GET,
            produces = MediaType.IMAGE_JPEG_VALUE)
    public void getImage(HttpServletResponse response, @PathVariable("companyName") String companyName,
                         @PathVariable("sid") String sid) throws IOException {

        var imgFile = new ClassPathResource("alpenhof/image/" + sid);

        response.setContentType(MediaType.IMAGE_JPEG_VALUE);
        StreamUtils.copy(imgFile.getInputStream(), response.getOutputStream());
    }


    //TODO
    @CrossOrigin
    @RequestMapping(value = "/{companyName}/images/{sid}", method = RequestMethod.POST,
            produces = MediaType.IMAGE_JPEG_VALUE)
    public void updateImage(HttpServletResponse response, @PathVariable("sid") String productId) throws IOException {

        System.out.println("updateImage ");

        var imgFile = new ClassPathResource("alpenhof/image/" + productId);

        response.setContentType(MediaType.IMAGE_JPEG_VALUE);
        StreamUtils.copy(imgFile.getInputStream(), response.getOutputStream());
    }
    //TODO
    @CrossOrigin
    @RequestMapping(value = "/{companyName}/uploadfile/{productId}", method = RequestMethod.POST)
    public void uploadFile(@RequestParam("file") MultipartFile file, HttpServletResponse response, @PathVariable("productId") String productId) throws IOException {

        System.out.println("updateImage " + file);

        convertMultiPartToFile(file);

        ProductEntity p = productRepository.findById(Long.parseLong(productId));
        p.setImageFilename(file.getOriginalFilename());
        productRepository.save(p);

    }

    private static File convertMultiPartToFile(MultipartFile file ) throws IOException
    {

        String fileLocation = new File("src\\main\\resources\\alpenhof\\image").getAbsolutePath() + "\\" + file.getOriginalFilename();

        File convFile = new File( fileLocation);

        FileOutputStream fos = new FileOutputStream( convFile );

        fos.write( file.getBytes() );
        fos.close();



        // now update image in Product

        return convFile;
    }

//    public String fileUpload(UploadedFile uploadedFile) {
//        InputStream inputStream = null;
//        OutputStream outputStream = null;
//        MultipartFile file = uploadedFile.getFile();
//        String fileName = file.getOriginalFilename();
//        File newFile = new File(imagesFolder + fileName);
//
//        try {
//            inputStream = file.getInputStream();
//
//            if (!newFile.exists()) {
//                newFile.createNewFile();
//            }
//            outputStream = new FileOutputStream(newFile);
//            int read = 0;
//            byte[] bytes = new byte[1024];
//
//            while ((read = inputStream.read(bytes)) != -1) {
//                outputStream.write(bytes, 0, read);
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//        return newFile.getAbsolutePath();
//    }
//    public String handleFileUpload(@RequestParam("file") MultipartFile file,
//                                   RedirectAttributes redirectAttributes) {
//
//        storageService.store(file);
//        redirectAttributes.addFlashAttribute("message",
//                "You successfully uploaded " + file.getOriginalFilename() + "!");
//
//        return "redirect:/";
//    }

}

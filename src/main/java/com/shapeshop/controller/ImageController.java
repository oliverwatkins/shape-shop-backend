package com.shapeshop.controller;

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


        convertMultiPartToFile(file);


//        response.setContentType(MediaType.IMAGE_JPEG_VALUE);
//        StreamUtils.copy(imgFile.getInputStream(), response.getOutputStream());
    }

    private static File convertMultiPartToFile(MultipartFile file ) throws IOException
    {
        File convFile = new File( file.getOriginalFilename() );
        FileOutputStream fos = new FileOutputStream( convFile );
        fos.write( file.getBytes() );
        fos.close();
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

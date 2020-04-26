package com.restapi.FileMetaData;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

@RestController
@RequestMapping("/api")
public class FileUploadController {
    @PostMapping(path = "/upload",consumes = MediaType.MULTIPART_FORM_DATA_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> uploadfile(@RequestParam("uploadfile")MultipartFile multipartFile) throws IOException, JSONException {
//        File file=new File("C:\\Users\\eakrnab\\Documents\\springBootProjects\\"+multipartFile.getOriginalFilename());
//        file.createNewFile();
//        FileOutputStream fout=new FileOutputStream(file);
//        fout.write(multipartFile.getBytes());
//        fout.close();
        String name=multipartFile.getOriginalFilename();
        String type=multipartFile.getContentType();
        String size=Long.toString(multipartFile.getSize());
        JSONObject entity = new JSONObject();
        entity.put("name",multipartFile.getOriginalFilename());
        entity.put("type",multipartFile.getContentType());
        entity.put("size",multipartFile.getSize());
        return new ResponseEntity<>(entity.toString(), HttpStatus.CREATED);
    }
}

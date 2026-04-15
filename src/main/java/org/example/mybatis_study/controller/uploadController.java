package org.example.mybatis_study.controller;

import lombok.extern.slf4j.Slf4j;
import org.example.mybatis_study.utils.Result;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

@RestController
@RequestMapping
@Slf4j
public class uploadController {
    @PostMapping("/upload")
    public Result upload(MultipartFile file) throws IOException {
        String fileName = file.getOriginalFilename();
        int i = fileName.lastIndexOf(".");
        String suffix = fileName.substring(i);
        String newFileName = UUID.randomUUID().toString() + "." + suffix;
        file.transferTo(new File("E:\\test\\" + newFileName));
        return Result.success();
    }
}

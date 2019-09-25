package com.sda.javagda22.Pjeski.domain.model;

import net.coobird.thumbnailator.Thumbnails;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

@Component
public class PhotoProcessor {

    @JmsListener(destination="photos")
    public void processPhoto(String path){
        System.out.println("Path is: " + path);
        File file = new File(path);
        Path thumbnailPath = Paths.get(path).getParent();
        Path filename = Paths.get(path).getFileName();
        String thumbnailFullPath = thumbnailPath + File.separator + "thumbnails" + File.separator + filename;
        File thumbnailFile = new File(thumbnailFullPath);
        try {
            Thumbnails.of(file).size(150,150).toFile(thumbnailFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

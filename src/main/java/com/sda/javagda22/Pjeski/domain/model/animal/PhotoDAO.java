package com.sda.javagda22.Pjeski.domain.model.animal;

import com.sda.javagda22.Pjeski.domain.repository.PhotoRepository;
import net.coobird.thumbnailator.Thumbnailator;
import net.coobird.thumbnailator.Thumbnails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import javax.jms.Queue;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@Component
public class PhotoDAO implements IPhotoDAO {

    @Autowired
    private JmsTemplate jmsTemplate;

    @Autowired
    private PhotoRepository photoRepository;


    @Override
    public void savePhotoImage(PhotoDTO photoDTO, MultipartFile files) throws Exception{
        Path currentPath = Paths.get(".");
        Path absolutePath = currentPath.toAbsolutePath();
//        ta linijka (i dwie poprzednie) zapisuje mi zdjęcie we wskazanym katalogu (ale nie robi wpisu w bazie danych)
        photoDTO.setPath(absolutePath + "/src/main/resources/static/photos/");
        byte[] bytes = files.getBytes();
        Path path = Paths.get(photoDTO.getPath() + files.getOriginalFilename());
        Files.write(path, bytes);
        jmsTemplate.convertAndSend("photos", path.normalize().toString());


    }



    @Override
    public void save(PhotoDTO photoDTO){
        photoRepository.save(photoDTO);
    }

    @Override
    public String getFirstPhoto() {

//        powinno być tak że znajduje do animala a znajduje po prostu pierwszy z tabeli wszystkich zdjęć
        List<PhotoDTO> allPhotos = photoRepository.findAll();
        if(!allPhotos.isEmpty()) {
            PhotoDTO firstPhotoDTO = allPhotos.get(0);
            return firstPhotoDTO.getFileName();
        }
        return "logo.jpg";
    }

//    @Override
//    public List<PhotoDTO> getFirstPhotoByAnimalId(Long animalId) {
//        return photoRepository.findFirst1ByAnimal(animalId);
//    }
}

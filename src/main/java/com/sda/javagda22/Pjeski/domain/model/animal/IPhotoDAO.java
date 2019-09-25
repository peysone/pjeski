package com.sda.javagda22.Pjeski.domain.model.animal;

import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface IPhotoDAO {
    void savePhotoImage(PhotoDTO photoDTO, MultipartFile files) throws Exception;

    void save(PhotoDTO photoDTO);

    String getFirstPhoto();

//    List<PhotoDTO> getFirstPhotoByAnimalId(Long animalId);
}

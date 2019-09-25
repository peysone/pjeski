package com.sda.javagda22.Pjeski.domain.repository;

import com.sda.javagda22.Pjeski.domain.model.animal.PhotoDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PhotoRepository extends JpaRepository<PhotoDTO, Long> {
//   @Modifying
//    @Query(value = "SELECT FILE_NAME FROM PHOTOS WHERE ANIMAL_ID=:animalId AND PHOTO_ID=(SELECT MIN(PHOTO_ID) FROM PHOTOS group by ANIMAL_ID)")
//    List<PhotoDTO> findFirstPhotoByAnimal_Id(@Param("animalId")Long id);
List<PhotoDTO> findAll();
//    List<PhotoDTO> findAllByAnimal_Id(Long id);
//@Modifying
//@Query(value = "UPDATE user_role ur SET ur.role_id = :roleId WHERE ur.user_id = :id", nativeQuery = true)
//void updateUserRole(@Param("roleId") int roleNr, @Param("id") Long id);

}

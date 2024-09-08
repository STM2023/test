package com.goit.proj2.dto;

import com.goit.proj2.service.Note;
import org.springframework.context.annotation.Profile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
//@Profile("dev, prod")
@Repository
public interface NoteRepository extends JpaRepository <Note, Long> {

}

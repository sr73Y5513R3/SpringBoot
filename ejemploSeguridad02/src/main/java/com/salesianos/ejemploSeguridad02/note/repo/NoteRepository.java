package com.salesianos.ejemploSeguridad02.note.repo;

import com.salesianos.ejemploSeguridad02.note.model.Note;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface NoteRepository extends JpaRepository<Note, Long> {

    List<Note> findByAuthor(String author);


}

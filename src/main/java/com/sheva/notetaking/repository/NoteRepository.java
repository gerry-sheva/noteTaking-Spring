package com.sheva.notetaking.repository;

import com.sheva.notetaking.model.Note;
import com.sheva.notetaking.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface NoteRepository extends JpaRepository<Note, Long> {

    List<Note> getNoteByUser(User user);
}

package com.sheva.notetaking.service;

import com.sheva.notetaking.model.Note;
import com.sheva.notetaking.model.NoteRequest;
import com.sheva.notetaking.model.User;
import com.sheva.notetaking.model.UserNoteRequest;
import com.sheva.notetaking.repository.NoteRepository;
import com.sheva.notetaking.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class NoteService {

    private final NoteRepository noteRepository;
    private final UserService userService;

    public List<Note> listAll() {
        return noteRepository.findAll();
    }

    public List<Note> getNoteByUser(UserNoteRequest userNoteRequest) {
        User user = userService.findByUid(userNoteRequest.getUid());
        return noteRepository.getNoteByUser(user);
    }

    public void addNote(NoteRequest newNote) {
        Note note = new Note();
        note.setTitle(newNote.getTitle());
        note.setMessage(newNote.getMessage());
        User user = userService.findByUid(newNote.getUid());
        note.setUser(user);
        noteRepository.save(note);
    }
}

package com.sheva.notetaking.controller;

import com.sheva.notetaking.model.Note;
import com.sheva.notetaking.model.NoteRequest;
import com.sheva.notetaking.model.User;
import com.sheva.notetaking.model.UserNoteRequest;
import com.sheva.notetaking.service.NoteService;
import com.sheva.notetaking.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class MainController {

    private final UserService userService;
    private final NoteService noteService;

    @GetMapping("/users")
    public List<User> getAllUsers() {
        return userService.listAll();
    }

    @GetMapping("/user")
    public User getUser(Integer uid) {
        return userService.findByUid(uid);
    }

    @PostMapping("/user")
    public void addUser(@RequestBody User user) {
        userService.addUser(user);
    }

    @PostMapping("/notes")
    public List<Note> getAllNotes(@RequestBody UserNoteRequest userNoteRequest) {
        return noteService.getNoteByUser(userNoteRequest);
    }

    @PostMapping("/note")
    public void addNote(@RequestBody NoteRequest newNote) {
        noteService.addNote(newNote);
    }

    @PutMapping("/note")
    public void updateNote(@RequestBody NoteRequest newNote) {
        noteService.updateNote(newNote);
    }
}

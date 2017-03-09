package xyz.llluper.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

import xyz.llluper.model.Note;
import xyz.llluper.service.NoteService;

@RestController
public class NoteRestController {
    @Autowired
    private NoteService service;

    @RequestMapping(value = "/rest/notes", method = RequestMethod.GET)
    public List<Note> listAllNotes() {
        List<Note> notes = service.getUsersNotes(getLoggedInUserName());
        return notes;
    }

    @RequestMapping(value = "/rest/notes/{id}", method = RequestMethod.GET)
    public Note retrieveNote(@PathVariable("id") String id) {
        return service.readById(id);
    }

    private String getLoggedInUserName() {
        Object principal = SecurityContextHolder.getContext()
                .getAuthentication().getPrincipal();
        if (principal instanceof UserDetails) {
            return ((UserDetails) principal).getUsername();
        }
        return principal.toString();
    }
}

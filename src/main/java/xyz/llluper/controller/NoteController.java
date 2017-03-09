package xyz.llluper.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
import javax.validation.Valid;

import xyz.llluper.model.Note;
import xyz.llluper.service.NoteService;

@Controller
public class NoteController {

    @Autowired
    NoteService service;

    @RequestMapping(value="/list-notes", method = RequestMethod.GET)
    public String showNotes(ModelMap model){
        model.addAttribute("notes", service.getUsersNotes(getLoggedInUserName()));
        return "list-notes";
    }

    @RequestMapping(value = "/add-note", method = RequestMethod.POST)
    public String addNote(@ModelAttribute Note note) {
        note.setUser(getLoggedInUserName());
        service.addNote(note);
        return "redirect:/list-notes";
    }

    @RequestMapping("/add-note")
    public String showAddNotePage(ModelMap model) {
        model.addAttribute("note", new Note());
        return "note";
    }

    @RequestMapping(value="/delete-note", method = RequestMethod.GET)
	public String deleteNote(@RequestParam String id){
        service.deleteById(id);
		return "redirect:/list-notes";
	}

    @RequestMapping(value = "/update-note", method = RequestMethod.GET)
    public String showUpdateNotePage(@RequestParam String id, ModelMap model) {
        model.addAttribute("note", service.readById(id));
        return "note";
    }

    @RequestMapping(value = "/update-note", method = RequestMethod.POST)
    public String updateNote(ModelMap model, @Valid Note note,
            BindingResult result) {
        if (result.hasErrors()) {
            return "note";
        }

        note.setUser(getLoggedInUserName());
        service.updateNote(note);

        model.clear();      // to prevent request parameter "name" to be passed
        return "redirect:/list-notes";
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

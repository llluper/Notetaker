package xyz.llluper.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
import javax.validation.Valid;


import xyz.llluper.model.Note;
import xyz.llluper.service.NoteService;
import xyz.llluper.repository.NoteRepository;
import xyz.llluper.repository.NoteRepositoryCrud;

@Controller
public class NoteController {

    @Autowired
    NoteService service;

    @Autowired
    NoteRepository noteRepository;

    @RequestMapping("/login")
    public String login() {
        return "login";
    }

    @RequestMapping(value="/list-notes", method = RequestMethod.GET)
    public String showNotes(ModelMap model){
        model.addAttribute("notes", noteRepository.findAll());
        return "list-notes";
    }

    @RequestMapping(value = "/add-note", method = RequestMethod.POST)
    public String addNote(@ModelAttribute Note note) {
        noteRepository.save(note);
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
        //Note note = service.retrieveNote(id);
        //model.put("note", note);
        //model.addAttribute("note", service.retrieveNote(id));
        return "note";
    }

    @RequestMapping(value = "/update-note", method = RequestMethod.POST)
    public String updateNote(@RequestParam String id) {

        service.update(id);

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

package xyz.llluper.repository;

import org.springframework.data.repository.CrudRepository;

import xyz.llluper.model.Note;

public interface NoteRepositoryCrud extends CrudRepository<Note, String> {}

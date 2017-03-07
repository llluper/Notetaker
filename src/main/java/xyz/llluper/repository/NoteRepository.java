package xyz.llluper.repository;

import xyz.llluper.model.Note;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface NoteRepository extends MongoRepository<Note, String> {

    //public Note findByTitle(String title);
    //public List<Note> findAllByTitle(String title);

}

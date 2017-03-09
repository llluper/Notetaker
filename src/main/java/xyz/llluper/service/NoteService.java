package xyz.llluper.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

import com.mongodb.WriteResult;

import xyz.llluper.model.Note;

@Service
public class NoteService {

    @Autowired
    private MongoTemplate mongoTemplate;

	private static final String noteCollection = "notes";

	public NoteService(MongoOperations mongoOps){
        this.mongoTemplate = mongoTemplate;
	}

    public List<Note> getUsersNotes(String user) {
        return mongoTemplate.find(new Query(Criteria.where("user").is(user)), Note.class, noteCollection);
    }

	public void addNote(Note note) {
		mongoTemplate.insert(note, noteCollection);
	}

	public Note readById(String id) {
		return mongoTemplate.findOne(new Query(Criteria.where("_id").is(id)), Note.class, noteCollection);
	}

    public void updateNote(Note note) {
        deleteById(note.getId());
        mongoTemplate.insert(note, noteCollection);
	}

	public void deleteById(String id) {
        mongoTemplate.remove(new Query(Criteria.where("_id").is(id)), Note.class, noteCollection);
	}

}

package xyz.llluper.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

import com.mongodb.WriteResult;

import xyz.llluper.model.Note;
import xyz.llluper.repository.NoteRepository;


@Service
public class NoteService extends NoteRepository {

    MongoTemplate mongoTemplate;

	private MongoOperations mongoOps;
	private static final String noteCollection = "notes";

	public NoteService(MongoOperations mongoOps){
		this.mongoOps = mongoOps;
        this.mongoTemplate = mongoTemplate;
	}

	public void create(Note note) {
		this.mongoOps.insert(note, noteCollection);
	}

	public Note readById(String id) {
		Query query = new Query(Criteria.where("_id").is(id));
		return this.mongoOps.findOne(query, Note.class, noteCollection);
	}

	public void update(String id) {
        mongoTemplate.updateFirst(new Query(Criteria.where("_id").is(id)),
				Update.update("title", "BOB"), Note.class, noteCollection);
		//this.mongoOps.save(note, noteCollection);
	}

	public int deleteById(String id) {
		Query query = new Query(Criteria.where("_id").is(id));
		WriteResult result = this.mongoOps.remove(query, Note.class, noteCollection);
		return result.getN();
	}

}

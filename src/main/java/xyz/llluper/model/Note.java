package xyz.llluper.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.util.List;

import java.util.ArrayList;

import javax.validation.constraints.Size;

@Document(collection = "notes")
public class Note {

    @Id
	private String id;

    private String user;
	private String title;
	private String body;
    private String label;

	public Note() {}

    public Note(String user, String title, String body, String label) {
        //this.id = id;
        this.user = user;
        this.title = title;
        this.body = body;
        this.label = label;
    }

	public String getId() {
		return id;
	}
    public void setId(String id) {
        this.id = id;
    }

    public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

    public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

    @Override
    public String toString() {
       return String.format(
               "Note [id=%s, title=%s, body=%s, label=%s]", id, title, body, label);
   }

    @Override
       public int hashCode() {
           final int prime = 31;
           int result = 1;
           result = prime * result + Integer.parseInt(id);
           return result;
       }

       @Override
          public boolean equals(Object obj) {
              if (this == obj) {
                  return true;
              }
              if (obj == null) {
                  return false;
              }
              if (getClass() != obj.getClass()) {
                  return false;
              }
              Note other = (Note) obj;
              if (id != other.id) {
                  return false;
              }
              return true;
          }


}

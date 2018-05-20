package com.groupsoft.rest.data;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Component;

import com.groupsoft.rest.models.notes;

@Component
public class NotesDaoService {

	static List<notes> listNotes = new ArrayList<notes>();
	
	static {
	    listNotes.add(new notes(1, "lorepum lorepum ajsa", "lorepum lorepum ajsa", "lorepum lorepum ajsa", "lorepum lorepum ajsa"));
	    listNotes.add(new notes(2, "lorepum lorepum ajsa", "lorepum lorepum ajsa", "lorepum lorepum ajsa", "lorepum lorepum ajsa"));
	    listNotes.add(new notes(3, "lorepum lorepum ajsa", "lorepum lorepum ajsa", "lorepum lorepum ajsa", "lorepum lorepum ajsa"));
	    listNotes.add(new notes(4, "lorepum lorepum ajsa", "lorepum lorepum ajsa", "lorepum lorepum ajsa", "lorepum lorepum ajsa"));
		listNotes.add(new notes(5, "lorepum lorepum ajsa", "lorepum lorepum ajsa", "lorepum lorepum ajsa", "lorepum lorepum ajsa"));
		listNotes.add(new notes(6, "lorepum lorepum ajsa", "lorepum lorepum ajsa", "lorepum lorepum ajsa", "lorepum lorepum ajsa"));

	}
	
	public List<notes> findAll(){
	    return listNotes;
	}
	
	public notes Save(notes note){
		note.set_Id(listNotes.size()+1);
		listNotes.add(note);
		return note;
	}
	
	public notes findOne(int id) {
		for (notes note : listNotes) {
			if(note.get_Id() == id ) {
				return note;
			}
		}
		return null;
	}

	public notes deleteById(int id) {
		Iterator<notes> iterator = listNotes.iterator();
		while (iterator.hasNext()){
			notes note = iterator.next();
			if(note.get_Id() == id){
				iterator.remove();
				return note;
			}
		}

		return null;
	}



}

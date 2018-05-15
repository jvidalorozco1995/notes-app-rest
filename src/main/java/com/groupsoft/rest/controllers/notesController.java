package com.groupsoft.rest.controllers;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.groupsoft.rest.data.notesDaoService;
import com.groupsoft.rest.models.notes;

@RestController
public class notesController {

	@Autowired
	private notesDaoService notesService;
	
	@GetMapping(path="/notes")
	public List<notes> getAllNotes(){
		return notesService.findAll();
	}
	
	@GetMapping(path="/notes/{id}")
	public notes getNote(@PathVariable int id){
		notes note =notesService.findOne(id);
		if(note == null) {
		   throw new noteNotFoundException("id--" + id);
		}
		return note;
	}
	
	@PostMapping(path="/notes")
	public ResponseEntity<Object> saveNote(@RequestBody notes note){
		
		notes savedNote = notesService.Save(note);
		
		URI location = ServletUriComponentsBuilder
				.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand(savedNote.get_Id()).toUri();
		
		return ResponseEntity.created(location).build();
	}
}

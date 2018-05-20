package com.groupsoft.rest.controllers;

import java.net.URI;
import java.util.List;

import com.groupsoft.rest.exceptions.NoteNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.groupsoft.rest.data.NotesDaoService;
import com.groupsoft.rest.models.notes;

import javax.validation.Valid;

@RestController
public class NotesController {

	@Autowired
	private NotesDaoService notesService;
	
	@GetMapping(path="/notes")
	public List<notes> getAllNotes(){
		return notesService.findAll();
	}
	
	@GetMapping(path="/notes/{id}")
	public Resource<notes> getNote(@PathVariable int id){
		notes note =notesService.findOne(id);
		if(note == null)
		   throw new NoteNotFoundException("id--" + id);

		//"all notes", SERVER PATH + "notes"
		//devuelve todas las notas
		Resource<notes> resource = new Resource<>(note);

		ControllerLinkBuilder linkTo =
				ControllerLinkBuilder.linkTo(ControllerLinkBuilder.methodOn(this.getClass()).getAllNotes());


		resource.add(linkTo.withRel("all-notes"));
		return resource;
	}
	
	@PostMapping(path="/notes")
	public ResponseEntity<Object> saveNote(@Valid @RequestBody notes note){
		
		notes savedNote = notesService.Save(note);
		
		URI location = ServletUriComponentsBuilder
				.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand(savedNote.get_Id()).toUri();
		
		return ResponseEntity.created(location).build();
	}

	@DeleteMapping("/users/{id}")
	public notes retrieveUser(@PathVariable int id){
		notes note = notesService.deleteById(id);
		if(note == null)
			throw new NoteNotFoundException("id-"+id);

	   return note;
	}

}

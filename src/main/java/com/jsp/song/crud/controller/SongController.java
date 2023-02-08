package com.jsp.song.crud.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jsp.song.crud.model.Song;
import com.jsp.song.crud.repository.SongRepository;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("/api")
public class SongController {
	
	@Autowired
	SongRepository songRepository;
	
	//Create
	@PostMapping("/song")
	public ResponseEntity<Song> createSong(@RequestBody Song song) {
		try {
			Song _song = songRepository
					.save(new Song(song.getTitle(), song.getDuration()));
			return new ResponseEntity<>(_song, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	//Read
	@GetMapping("/song/{id}")
	public ResponseEntity<Song> getSongById(@PathVariable("id") long id) {
		Optional<Song> SongData = songRepository.findById(id);

		if (SongData.isPresent()) {
			return new ResponseEntity<>(SongData.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	//Update
	@PutMapping("/song/{id}")
	public ResponseEntity<Song> updateSongById(@PathVariable("id") long id, @RequestBody Song song) {
		Optional<Song> songData = songRepository.findById(id);

		if (songData.isPresent()) {
			Song _song = songData.get();
			_song.setTitle(song.getTitle());
			_song.setDuration(song.getDuration());
			return new ResponseEntity<>(songRepository.save(_song), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	//Delete
	@DeleteMapping("/song/{id}")
	public ResponseEntity<HttpStatus> deleteSongById(@PathVariable("id") long id) {
		try {
			songRepository.deleteById(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	
	
}

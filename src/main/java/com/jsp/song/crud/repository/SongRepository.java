package com.jsp.song.crud.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.jsp.song.crud.model.Song;


public interface SongRepository extends JpaRepository<Song, Long> {

}
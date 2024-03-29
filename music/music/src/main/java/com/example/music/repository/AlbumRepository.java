package com.example.music.repository;

import com.example.music.entity.model.Album;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface AlbumRepository extends JpaRepository<Album, Long> {

}

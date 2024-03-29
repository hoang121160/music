package com.example.music.controller;

import com.example.music.entity.dto.AlbumDto;
import com.example.music.entity.dto.AlbumView;
import com.example.music.service.album.AlbumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/albums")
public class AlbumController {
    private final AlbumService service;
    @Autowired
    public AlbumController(AlbumService albumService){
        this.service = albumService;
    }

    @PostMapping("/create")
    public ResponseEntity<AlbumDto> create(@Valid @RequestBody AlbumDto albumDto){
            AlbumDto create =  service.createAlbum(albumDto);
            return ResponseEntity.status(HttpStatus.CREATED).body(create);
    }

    @GetMapping
    public ResponseEntity<List<AlbumView>> getAll(){
        List<AlbumView> albums = service.findAll();
        return ResponseEntity.ok(albums);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AlbumDto> getAlbumByid(@PathVariable Long id){
        AlbumDto albumDto = service.findById(id);
        return ResponseEntity.ok(albumDto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateAlbum(@PathVariable Long id, @Valid @RequestBody AlbumDto update){
        service.update(update);
        return ResponseEntity.ok("Album updated successfully");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteAlbum(@PathVariable Long id){
        service.deleteAlbum(id);
        return ResponseEntity.ok("Album deleted successfully");
    }



}

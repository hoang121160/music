package com.example.music.service.album;

import com.example.music.entity.dto.AlbumDto;
import com.example.music.entity.dto.AlbumView;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface AlbumService {
    AlbumDto createAlbum(AlbumDto albumDto);
    List<AlbumView> findAll();

    AlbumDto findById(Long id);

    void deleteAlbum(Long id);
    void update(AlbumDto albumDto);

}

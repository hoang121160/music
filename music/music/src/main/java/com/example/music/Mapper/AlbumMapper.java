package com.example.music.Mapper;

import com.example.music.entity.dto.AlbumDto;
import com.example.music.entity.dto.AlbumView;
import com.example.music.entity.model.Album;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Mapper(componentModel = "spring")
@Component
public interface AlbumMapper {
    AlbumView toView(Album album);

    Album toEntity(AlbumDto albumDto);

    AlbumDto toDto(Album album);
}

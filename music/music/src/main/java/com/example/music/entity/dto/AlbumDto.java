package com.example.music.entity.dto;

import com.example.music.entity.model.Status;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AlbumDto {
    private Long id;
    private String tenAlbum;
    private String artworkPath;
    private LocalDateTime ngayDang;
    private Long caSiId;
    private Long theLoaiId;
    private Status status;
}

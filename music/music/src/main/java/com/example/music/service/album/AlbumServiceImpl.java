package com.example.music.service.album;

import com.example.music.Mapper.AlbumMapper;
import com.example.music.entity.dto.AlbumDto;
import com.example.music.entity.dto.AlbumView;
import com.example.music.entity.model.Album;
import com.example.music.entity.model.CaSi;
import com.example.music.entity.model.TheLoai;
import com.example.music.repository.AlbumRepository;
import com.example.music.repository.CaSiRepository;
import com.example.music.repository.TheLoaiRepository;
import org.springframework.stereotype.Service;
//import jakarta.persistence.EntityNotFoundException;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AlbumServiceImpl implements AlbumService {
    private final AlbumRepository albumRepository;
    private final CaSiRepository caSiRepository;
    private final TheLoaiRepository theLoaiRepository;
    private final AlbumMapper mapper;

    public AlbumServiceImpl(AlbumRepository albumRepository,
                            CaSiRepository caSiRepository,
                            TheLoaiRepository theLoaiRepository, AlbumMapper mapper) {
        this.albumRepository = albumRepository;
        this.caSiRepository = caSiRepository;
        this.theLoaiRepository = theLoaiRepository;
        this.mapper = mapper;

    }

    @Override
    public AlbumDto createAlbum(AlbumDto albumDto) {
        validate(albumDto);
        Album album = mapper.toEntity(albumDto);
        Album savedAlbum = albumRepository.save(album);
        return mapper.toDto(savedAlbum);
    }

    private void validate(AlbumDto albumDto) {
        if (albumDto.getTenAlbum() == null || albumDto.getTenAlbum().isEmpty()) {
            throw new IllegalArgumentException("Tên album không được trống");
        }
        if (albumDto.getArtworkPath() == null || albumDto.getArtworkPath().isEmpty()) {
            throw new IllegalArgumentException("Đường dẫn artwork không được trống");
        }
        if (albumDto.getNgayDang() == null) {
            throw new IllegalArgumentException("Ngày đăng không được trống");
        }
        if (albumDto.getCaSiId() == null) {
            throw new IllegalArgumentException("ID của CaSi không được trống");
        }
        if (albumDto.getTheLoaiId() == null) {
            throw new IllegalArgumentException("ID của TheLoai không được trống");
        }
        if (albumDto.getStatus() == null) {
            throw new IllegalArgumentException("Trạng thái không được trống");
        }
    }

    @Override
    public List<AlbumView> findAll() {
        List<Album> albums = albumRepository.findAll();
        return albums.stream().map(mapper::toView).collect(Collectors.toList());
    }

    @Override
    public AlbumDto findById(Long id) {
        Album album = albumRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Album not found with id: " + id));
        return mapper.toDto(album);
    }

    @Override
    public void update(AlbumDto update) {
        Album existingAlbum = albumRepository.findById(update.getId())
                .orElseThrow(() -> new EntityNotFoundException("Album not found with id: " + update.getId()));
        existingAlbum.setTenAlbum(update.getTenAlbum());
        existingAlbum.setArtworkPath(update.getArtworkPath());
        existingAlbum.setNgayDang(update.getNgayDang());
        CaSi caSi = caSiRepository.findById(update.getCaSiId()).orElseThrow(() -> new EntityNotFoundException("CaSi not found"));
        existingAlbum.setCaSi(caSi);
        TheLoai theLoai = theLoaiRepository.findById(update.getTheLoaiId()).orElseThrow(() -> new EntityNotFoundException("TheLoai not found"));
        existingAlbum.setStatus(update.getStatus());
    }

    @Override
    public void deleteAlbum(Long id) {
        if (albumRepository.existsById(id)) {
            albumRepository.deleteById(id);
        } else {
            throw new RuntimeException("Album not found");
        }
    }
}

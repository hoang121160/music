package com.example.music.entity.model;

//import jakarta.persistence.*;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Table(name = "albums")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Getter
@Setter
@Builder
public class Album {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "tenAlbum")
    private String tenAlbum;

    @Column(name = "artworkPath")
    private String artworkPath;

    @Column(name = "ngayDang")
    private LocalDateTime ngayDang;

    @ManyToOne()
    @JoinColumn(name = "caSi")
    private CaSi caSi;

    @ManyToOne()
    @JoinColumn(name = "theLoai")
    private TheLoai theLoai;

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private Status status;
}

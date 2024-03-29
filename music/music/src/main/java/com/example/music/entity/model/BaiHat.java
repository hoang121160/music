package com.example.music.entity.model;
//import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "baihat")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BaiHat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "tenBaiHat")
    private String tenBaiHat;

    @ManyToOne
    @JoinColumn(name = "caSi")
    private CaSi caSi;

    @ManyToOne
    @JoinColumn(name = "album")
    private Album album;

    @ManyToOne
    @JoinColumn(name = "theLoai")
    private TheLoai theLoai;

    @Column(name = "duration")
    private String duration;

    @Column(name = "path")
    private String path;

    @Column(name = "albumOrder")
    private int albumOrder;

    @Column(name = "luotNghe")
    private int luotNghe;

    @Column(name = "dangBoi")
    private int dangBoi;

    @Column(name = "ngayDangBaiHat")
    private LocalDateTime ngayDangBaiHat;
}

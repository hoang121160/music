package com.example.music.entity.model;
//import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "users")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "ten")
    private String ten;

    @Column(name = "taiKhoan")
    private String taiKhoan;

    @Column(name = "matKhau")
    private String matKhau;

    @Column(name = "email")
    private String email;

    @Column(name = "phanQuyen")
    private int phanQuyen;

    @Column(name = "ngayDangKy")
    private LocalDateTime ngayDangKy;

    @Column(name = "anhDaiDien")
    private String anhDaiDien;
}

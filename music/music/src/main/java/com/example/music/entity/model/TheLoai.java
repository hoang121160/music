package com.example.music.entity.model;

//import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "theloai")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TheLoai {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "tenTheLoai")
    private String tenTheLoai;

}

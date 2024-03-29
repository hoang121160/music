package com.example.music.entity.model;
//import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "slider")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Slider {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "tieuDe")
    private String tieuDe;

    @Column(name = "hinh")
    private String hinh;

    @Column(name = "link")
    private String link;
}

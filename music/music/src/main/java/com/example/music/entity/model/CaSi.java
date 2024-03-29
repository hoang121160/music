package com.example.music.entity.model;

//import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "casi")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CaSi {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "tenCaSi")
    private String tenCaSi;
    @Column(name = "anhCaSi")
    private String anhCaSi;
}

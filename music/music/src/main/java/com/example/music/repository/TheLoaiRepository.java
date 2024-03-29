package com.example.music.repository;

import com.example.music.entity.model.TheLoai;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TheLoaiRepository extends JpaRepository<TheLoai, Long> {
}

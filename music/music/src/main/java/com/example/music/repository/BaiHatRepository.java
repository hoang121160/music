package com.example.music.repository;

import com.example.music.entity.model.BaiHat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BaiHatRepository extends JpaRepository<BaiHat, Long> {
}

package karyawan.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import karyawan.model.TitleModel;

@Repository
public interface TitleRepo extends JpaRepository<TitleModel, Integer> {
    
}
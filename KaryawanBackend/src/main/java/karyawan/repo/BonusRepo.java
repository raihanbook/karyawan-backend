package karyawan.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import karyawan.model.BonusModel;

@Repository
public interface BonusRepo extends JpaRepository<BonusModel, Integer> {
    
}

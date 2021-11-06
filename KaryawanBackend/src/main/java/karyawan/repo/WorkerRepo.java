package karyawan.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import karyawan.model.WorkerModel;

@Repository
public interface WorkerRepo extends JpaRepository<WorkerModel, Integer> {
    @Query(value = "SELECT * FROM worker ORDER BY worker.salary DESC LIMIT 5;", nativeQuery = true)
    public List<WorkerModel> getFiveBiggestSalary();
    
    @Query(value = "SELECT * FROM worker WHERE worker.salary IN ( SELECT worker.salary FROM worker GROUP BY worker.salary HAVING COUNT(*) > 1 );", nativeQuery = true)
    public List<WorkerModel> getSameSalaryWorker();

    @Query(value = "SELECT COUNT(worker.department) AS worker FROM worker GROUP BY worker.department;", nativeQuery = true)
    public List<Integer> getDepartmentWorkerCount();
    
    @Query(value = "SELECT worker.department AS worker FROM worker GROUP BY worker.department;", nativeQuery = true)
    public List<String> getDepartmentName();
}
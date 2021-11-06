package karyawan.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import karyawan.model.BonusModel;
import karyawan.model.DepartmentModel;
import karyawan.model.TitleModel;
import karyawan.model.WorkerModel;
import karyawan.repo.BonusRepo;
import karyawan.repo.TitleRepo;
import karyawan.repo.WorkerRepo;

@RestController
public class KaryawanController {
    @Autowired
    BonusRepo bonusRepo;
    
    @Autowired
    TitleRepo titleRepo;
    
    @Autowired
    WorkerRepo workerRepo;

    @PostMapping("/worker")
	public List<WorkerModel> saveWorkers(@RequestBody List<WorkerModel> workers) {
		return workerRepo.saveAll(workers);
	}

    @PutMapping("/worker")
	public WorkerModel updateWorker(@RequestBody WorkerModel worker) {
		return workerRepo.save(worker);
	}

    @DeleteMapping("/worker/{id}")
	public String deleteWorker(@PathVariable int id) {
		workerRepo.deleteById(id);
		return "Delete successfully";
	}
    
    @PostMapping("/bonus")
	public List<BonusModel> saveBonuses(@RequestBody List<BonusModel> bonuses) {
		return bonusRepo.saveAll(bonuses);
	}

    @PutMapping("/bonus")
	public BonusModel updateBonus(@RequestBody BonusModel bonus) {
		return bonusRepo.save(bonus);
	}

    @DeleteMapping("/bonus/{id}")
	public String deleteBonus(@PathVariable int id) {
		bonusRepo.deleteById(id);
		return "Delete successfully";
	}
    
    @PostMapping("/title")
	public List<TitleModel> saveTitles(@RequestBody List<TitleModel> titles) {
		return titleRepo.saveAll(titles);
	}

    @PutMapping("/title")
	public TitleModel updateTitle(@RequestBody TitleModel title) {
		return titleRepo.save(title);
	}

    @DeleteMapping("/title/{id}")
	public String deleteTitle(@PathVariable int id) {
		titleRepo.deleteById(id);
		return "Delete successfully";
	}

    @GetMapping("/worker-biggest-salary")
    public List<WorkerModel> getFiveBiggestSalary() {
        List<WorkerModel> listWorker = workerRepo.getFiveBiggestSalary();
        return listWorker;
    }
    
    @GetMapping("/worker-same-salary")
    public List<WorkerModel> getSameSalaryWorker() {
        List<WorkerModel> listWorker = workerRepo.getSameSalaryWorker();
        return listWorker;
    }
    
    @GetMapping("/worker-same-department")
    public List<DepartmentModel> getDepartmentWorker() {
        List<DepartmentModel> listDepartment = new ArrayList<DepartmentModel>();
        List<Integer> lisCount = workerRepo.getDepartmentWorkerCount();
        List<String> listName = workerRepo.getDepartmentName();

        for (int i = 0; i < lisCount.size(); i++) {
            DepartmentModel department = new DepartmentModel();
            department.setWorkerCount(lisCount.get(i));
            department.setDepartment(listName.get(i));
            listDepartment.add(department);
        }

        return listDepartment;
    }
}

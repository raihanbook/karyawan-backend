package karyawan.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="bonus")
public class BonusModel {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int bonusId;
	private String bonusDate;
	private int bonusAmount;
    @OneToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "workerId", referencedColumnName = "workerId")
	private WorkerModel workerId;
}

package re.edu.pharmacyservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import re.edu.pharmacyservice.entity.Medicine;

@Repository
public interface IMedicineRepository extends JpaRepository<Medicine, Long> {
}

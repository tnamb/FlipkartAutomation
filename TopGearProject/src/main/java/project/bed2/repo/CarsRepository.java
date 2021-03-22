package project.bed2.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import project.bed2.model.Cars;

import java.util.List;

public interface CarsRepository extends JpaRepository<Cars, Integer> 
{
    List<Cars> findByBrand(String brand);
    List<Cars> findById(Integer sno);
}

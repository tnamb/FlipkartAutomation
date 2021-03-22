package project.bed2.model;

import project.bed2.model.Cars;
import project.bed2.repo.CarsRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import javax.ws.rs.GET;

@RestController
public class Rest2Controller 
{
    @Autowired
    CarsRepository carsRepository;
    
    @GetMapping("/all")
    public List<Cars> getAll() 
    {
        return carsRepository.findAll();
    }
    
    @GET
    @GetMapping("/{brand}")
    public List<Cars> getCarByBrand(@PathVariable("brand") final String brand) 
    {
        return carsRepository.findByBrand(brand);
    }
    
    @GetMapping("/id/{sno}")
    public List<Cars> getUserById(@PathVariable("sno") Integer sno) 
    {
        return carsRepository.findById(sno);
    }
    
    
    

}

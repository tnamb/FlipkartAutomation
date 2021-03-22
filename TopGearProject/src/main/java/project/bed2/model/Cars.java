package project.bed2.model;

import javax.persistence.Column;
import lombok.Getter;
import lombok.Setter;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Setter
@Getter
@Entity
@Table(name = "cars", catalog = "testdb")
public class Cars 
{

    @Id @Column (name = "id")
	private Integer id;
    
    @Column(name = "brand")
	private String brand;
	
    @Column(name = "model")
	private String model;
    
    @Column(name = "year")
	private int year;
	
    @Column(name = "distance")
	private int distance;
	
    @Column(name = "price")
	private int price;
    
    @Column(name = "fuel")
    private String fuel;
    
    @Column(name = "sno")
    private int sno;

    public Cars(Integer id, String brand, String model, String fuel, int year, int distance, int price, int sno)
        {
            super();
            this.id = id;
            this.brand = brand;
            this.model = model;
            this.fuel = fuel;
            this.year = year;
            this.distance = distance;
            this.price = price;
            this.sno = sno;
        }

    public Cars()
    {}
    
	
}

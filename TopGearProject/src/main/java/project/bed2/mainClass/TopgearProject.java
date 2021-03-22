package project.bed2.mainClass;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories(basePackages = "project.bed2.*")
@ComponentScan(basePackages = { "project.bed2.*" })
@EntityScan("project.bed2.*")   
@SpringBootApplication

public class TopgearProject 
{
	public static void main(String[] args) 
	{
		SpringApplication.run(TopgearProject.class, args);
	}
}

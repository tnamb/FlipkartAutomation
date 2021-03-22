package project.bed2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import project.bed2.model.Cars;
import project.bed2.repo.CarsRepository;

import java.util.List;
import java.util.Map;

@Controller
public class CarsResource 
{    
    CarsRepository ps;
    
    @RequestMapping("/")
    public String welcome() 
    {
        return "welcome";
    }
    
    @RequestMapping("/BrandForm")
    public String BrandForm() 
    {
        return "BrandForm";
    }
    
    @RequestMapping("/PriceForm")
    public String PriceForm() 
    {
        return "PriceForm";
    }
    
        /*
         * @RequestMapping("/hib") public String PriceForm2() { return "Hibernate"; }
         */
    
    // --------------------------------------------
    
    @RequestMapping(value = "/brand", method = RequestMethod.POST)
	public ModelAndView CarsByBrand (@RequestParam("selectByBrand") String brand)
	{
			return new ModelAndView ("SearchByBrand", "", brand);
	}
	
	@RequestMapping(value = "/price", method = RequestMethod.POST)
	public ModelAndView CarsByPrice ()
	{
			return new ModelAndView("SearchByPrice");
	}
	
	@RequestMapping(value = "/ConfirmPage", method = RequestMethod.POST)
	public ModelAndView ConfirmPage(@RequestParam("car") String value)
	{
		return new ModelAndView("ConfirmPage", "", "");
	}
	
	@RequestMapping(value = "/confirm", method = RequestMethod.POST)
	public ModelAndView confirm(@RequestParam("car") String car)
	{
		
		return new ModelAndView("ConfirmPage", "", "");
	}
	
}

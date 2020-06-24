package com.erykszczesniak.cities;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.geo.Circle;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/cities")
public class CityControllerMvc {


    private CityRepository cityRepository;


    @Autowired
    public CityControllerMvc(CityRepository cityRepository) {
        this.cityRepository = cityRepository;
    }

    @GetMapping
    public String listCities(Model model){
        List<City>cities = cityRepository.findAll();
        model.addAttribute("cityList", cities);
        return "list";
    }

    @PostMapping
    public String addCity(@ModelAttribute City cityModel, RedirectAttributes redirectAttributes){
        cityRepository.save(cityModel);
        redirectAttributes.addFlashAttribute("message","City added successfully");
        return "redirect:/";
    }

}

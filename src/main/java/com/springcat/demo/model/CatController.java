package com.springcat.demo.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/catform")
public class CatController {

    // private List<Cat> catList;
    private CatsRepository catsRepository;



    @Autowired
    public CatController(CatsRepository catsRepository) {
        this.catsRepository = catsRepository;
        //catList = new ArrayList<>();
    }

    @GetMapping
    public String renderForm() {
        return "catform";
    }

    @PostMapping
    public void createsCatFromForm(Cat cat) {
        catsRepository.save(cat);
    }

    @GetMapping
    @RequestMapping("/filterColor")
    public String findCatsByColor(@RequestParam("findByColor") String color, Model model) {
        model.addAttribute("catlist", catsRepository.findByColor(color));
        return "allcats";
    }

    @GetMapping
    @RequestMapping("/allcats")
    public String loadAllCats(Model model) {
       model.addAttribute("catlist", catsRepository.findAll());
        return "allcats";
    }

}

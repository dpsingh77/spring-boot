package com.diy.lawnmower;

import com.diy.lawnmower.dao.LawnMowerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
public class HomeController {

    @Autowired
    LawnMowerRepo repo;

    @RequestMapping("/")
    public ModelAndView home(LawnMower mower)
    {
        System.out.println("is it coming here?");
        ModelAndView mv = new ModelAndView();
        mv.addObject("obj",mower);
        mv.setViewName("home");
        return mv;
    }

    @RequestMapping("/items")
    public Iterable<LawnMower> listItems()
    {
        System.out.println("all items?");
        return repo.findAll();
//        return mower.getId();
    }

    @RequestMapping("/item/{id}")
    public LawnMower findItem(@PathVariable Integer id)
    {
        System.out.println("get?");
        LawnMower mower = repo.findById(id).orElse(new LawnMower() );
        return mower;
//        return mower.getId();
    }
    @PostMapping("/addItem/")
    public Integer addItem(LawnMower mower)
    {
        System.out.println("Add?");
        repo.save(mower);
        return mower.getId();
    }

    @DeleteMapping("/deleteItem/{id}")
    public String deleteItem(@PathVariable Integer id)
    {
        System.out.println("Delete?");
        repo.deleteById(id);
        return "Deleted...: " + id;
    }
}

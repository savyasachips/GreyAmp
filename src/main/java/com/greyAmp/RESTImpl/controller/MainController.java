package com.greyAmp.RESTImpl.controller;

import com.greyAmp.RESTImpl.model.GreyAmpTable;
import com.greyAmp.RESTImpl.service.MainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.awt.*;
import java.util.List;

@RestController
@RequestMapping("/api")
public class MainController {

    @Autowired
    MainService mainService;

    @GetMapping("/")
    public String sayHello(){
        return "Hello GreyAmp";
    }

    @GetMapping("/all")
    public List<GreyAmpTable> viewAll(){
        return mainService.fetchAllInputs();
    }

    @PostMapping("/new")
    public GreyAmpTable addNew(@Valid @RequestBody GreyAmpTable greyAmpTable){
        return mainService.addNew(greyAmpTable);
    }



}

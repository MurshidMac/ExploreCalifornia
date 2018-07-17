package com.example.ec.explocali.controllers;

import com.example.ec.explocali.domain.TourPackage;
import com.example.ec.explocali.services.TourPackageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class TourPackageController {
    @Autowired
    private TourPackageService tourPackageService;

    @RequestMapping("/tourpackages")
    public List<TourPackage> getAlltourpackages(){
        Iterable<TourPackage> packages = tourPackageService.lookup();

        if(packages instanceof List){
            return (List<TourPackage>) packages;
        }

        ArrayList<TourPackage> list = new ArrayList<>();
        for(TourPackage e: packages){
            list.add(e);
        }

        return list;
    }

}

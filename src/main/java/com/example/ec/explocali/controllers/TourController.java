package com.example.ec.explocali.controllers;

import com.example.ec.explocali.domain.Tour;
import com.example.ec.explocali.services.TourService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/*
* Getting all the list of Tours
* */

@RestController
@RequestMapping("/api")
public class TourController {

    @Autowired
    private TourService tourService;

    private Iterable<Tour> tours;

    @RequestMapping("/tours")
    public List<Tour>  getAllTours(){
        tours = tourService.loopup();

        if(tours instanceof List){
            return (List<Tour>)tours;
        }

        ArrayList<Tour> arrayList = new ArrayList<>();

        if(tours !=null){
            for(Tour e : tours){
                arrayList.add(e);
            }
        }
        return arrayList;
    }

    // get a single instance of the tour
    @RequestMapping("/tours/{id}")
    public Tour getTour(Integer integer){
        //
    }

}

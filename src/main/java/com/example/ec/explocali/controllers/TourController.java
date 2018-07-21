package com.example.ec.explocali.controllers;

import com.example.ec.explocali.Repo.TourRepository;
import com.example.ec.explocali.domain.Tour;
import com.example.ec.explocali.services.TourService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

/*
* Getting all the list of Tours
* */

@RestController
@RequestMapping("/api")
public class TourController {

    @Autowired
    private TourService tourService;

    private Iterable<Tour> tours;

    Tour tour;


    protected TourController(){}

    @RequestMapping(value ="/tours", method = RequestMethod.GET)
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

    @RequestMapping(value = "/tours/{id}", method = RequestMethod.GET)
    public Tour getTour(@PathVariable(value = "id") Integer id){
        tour = tourService.verifyTour(id);
        return tour;
    }


}

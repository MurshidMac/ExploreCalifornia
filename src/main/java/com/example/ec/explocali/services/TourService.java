package com.example.ec.explocali.services;

import com.example.ec.explocali.Repo.TourPackageRepository;
import com.example.ec.explocali.Repo.TourRepository;
import com.example.ec.explocali.domain.Difficulty;
import com.example.ec.explocali.domain.Region;
import com.example.ec.explocali.domain.Tour;
import com.example.ec.explocali.domain.TourPackage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TourService {


    private TourRepository tourRepository;
    private TourPackageRepository tourPackageRepository;

    @Autowired
    public TourService(TourRepository tourRepository, TourPackageRepository tourPackageRepository) {
        this.tourRepository = tourRepository;
        this.tourPackageRepository= tourPackageRepository;
    }

    public Tour createTour(String title, String description, String blurb,
                           Integer price, String duration, String bullets, String keywords,
                           String tourPackageName, Difficulty diff, Region region){
        // before we create a tour package we should know wether the tour package exists in
        // the db
        TourPackage searchtourpacke = tourPackageRepository.findByName(tourPackageName);
        // This is to check for the changes happened in the 1.8 java
        // With few Name changes
        System.out.println(searchtourpacke.toString());

        // Modified to check the package name
        if(searchtourpacke==null){
            throw new RuntimeException("Tour package does not exists");
        }

        // This is getting from the list optional class
        //TourPackage packageFromOptional = searchtourpacke.get();
        return tourRepository.save(new Tour(title, description,blurb, price,duration,bullets,
                keywords,searchtourpacke ,diff,region));
    }

    public Iterable<Tour> loopup(){
        return tourRepository.findAll();
    }

    public long total(){
        return tourRepository.count();
    }

}

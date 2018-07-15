package com.example.ec.explocali;

import com.example.ec.explocali.services.TourPackageService;
import com.example.ec.explocali.services.TourService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ExplocaliApplication implements CommandLineRunner {
	@Autowired
	private TourService tourService;
	@Autowired
	private TourPackageService tourPackageService;

	public static void main(String[] args) {
		SpringApplication.run(ExplocaliApplication.class, args);
	}

	// This is to check for the data Dynamically wether its working properly
	@Override
	public void run(String... args) throws Exception {
		tourPackageService.createTourPackage("BC", "Backpack Cal");
		tourPackageService.createTourPackage("CC", "California Calm");
		tourPackageService.createTourPackage("CH", "California Hot springs");
		tourPackageService.createTourPackage("CY", "Cycle California");
		tourPackageService.createTourPackage("DS", "From Desert to Sea");
		tourPackageService.createTourPackage("KC", "Kids California");
		tourPackageService.createTourPackage("NW", "Nature Watch");
		tourPackageService.createTourPackage("SC", "Snowboard Cali");
		tourPackageService.createTourPackage("TC", "Taste of California");
		tourPackageService.lookup().forEach(tourPackage -> System.out.println(tourPackage));	//
	}
}

package com.example.ec.explocali;


import com.example.ec.explocali.domain.Difficulty;
import com.example.ec.explocali.domain.Region;
import com.example.ec.explocali.services.TourPackageService;
import com.example.ec.explocali.services.TourService;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;
import java.util.List;

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

		TourFromFile.importFromFile().forEach(t-> tourService.createTour(
				t.title,
				t.description,
				t.blurb,
				Integer.parseInt(t.price),
				t.length,
				t.bullets,
				t.keywords,
				t.packageType,
				Difficulty.valueOf(t.difficulty),
				Region.findByLabel(t.region)));
		System.out.println("Number of tours =" + tourService.total());

	}


	// Unit Testing the Project

	static class TourFromFile{
		// Attributes Listed as in the JSON file
		private String packageType,title, blurb,description,bullets,difficulty,length,price,region,
				keywords;

		static List<TourFromFile> importFromFile() throws IOException{
			return new ObjectMapper().setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY).
					readValue(TourFromFile.class.getResourceAsStream("/ExploreCalifornia.json"),
							new com.fasterxml.jackson.core.type.TypeReference<List<TourFromFile>>(){});	}
	}


}

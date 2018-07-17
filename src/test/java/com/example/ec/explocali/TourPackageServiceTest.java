package com.example.ec.explocali;

import com.example.ec.explocali.services.TourPackageService;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
public class TourPackageServiceTest {
    @TestConfiguration
    static class TourPackageServiceContextContextConfiguration{
        @Bean
        public TourPackageService tourPackageService(){
            //return new TourPackageService();
            return null;
        }

    }
}

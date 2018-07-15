package com.example.ec.explocali.Repo;

import com.example.ec.explocali.domain.Tour;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TourRepository extends CrudRepository<Tour, Integer> {
    List<Tour> findByTourPackageCode(@Param("name") String code);
}

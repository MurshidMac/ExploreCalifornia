package com.example.ec.explocali.Repo;

import com.example.ec.explocali.domain.TourPackage;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface TourPackageRepository extends CrudRepository<TourPackage, String> {
    TourPackage findByName(@Param("name") String name);
}

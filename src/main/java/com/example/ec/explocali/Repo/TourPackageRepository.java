package com.example.ec.explocali.Repo;

import com.example.ec.explocali.domain.TourPackage;
import org.springframework.data.repository.CrudRepository;

public interface TourPackageRepository extends CrudRepository<TourPackage, String> {
    TourPackage findByName(String name);
}

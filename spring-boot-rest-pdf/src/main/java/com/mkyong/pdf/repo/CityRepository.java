package com.mkyong.pdf.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mkyong.pdf.model.City;

public interface CityRepository extends JpaRepository<City, Long> {

}

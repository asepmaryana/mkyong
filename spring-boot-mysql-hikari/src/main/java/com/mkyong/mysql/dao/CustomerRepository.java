package com.mkyong.mysql.dao;

import java.util.Date;
import java.util.List;
import java.util.stream.Stream;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.mkyong.mysql.model.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
	
	List<Customer> findByEmail(String email);

    List<Customer> findByDate(Date date);

	// custom query example and return a stream
    @Query("select c from Customer c where c.email = :email")
    Stream<Customer> findByEmailReturnStream(@Param("email") String email);
    
}

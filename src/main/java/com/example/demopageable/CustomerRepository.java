package com.example.demopageable;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

    @Query("FROM Customer c " +
           "WHERE LOWER(c.name) like %:searchTerm% " +
           "OR LOWER(c.email) like %:searchTerm%")
    Page<Customer> search(
            @Param("searchTerm") String searchTerm,
            Pageable pageable);

}
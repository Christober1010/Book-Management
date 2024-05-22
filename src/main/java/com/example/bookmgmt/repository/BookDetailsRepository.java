package com.example.bookmgmt.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.bookmgmt.model.BookDetails;

@Repository
public interface BookDetailsRepository extends CrudRepository<BookDetails, Integer>{

}

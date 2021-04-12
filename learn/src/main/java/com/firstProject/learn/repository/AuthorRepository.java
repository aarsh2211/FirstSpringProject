package com.firstProject.learn.repository;

import com.firstProject.learn.domain.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository<Author, Long> {

}

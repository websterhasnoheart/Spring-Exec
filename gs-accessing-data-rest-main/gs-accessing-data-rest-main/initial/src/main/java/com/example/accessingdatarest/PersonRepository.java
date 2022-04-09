package com.example.accessingdatarest;


import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

/*
 * This interface lets you perform various operations involving Person object, it gets these operations
 *
 */
@RepositoryRestResource(collectionResourceRel = "people", path = "people")
public interface PersonRepository extends PagingAndSortingRepository<Person, Long> {
    List<Person> findByLastName(@Param("name") String name);
}

/*
 * At runtime, Spring Data REST automatically creates an implementation of this interface, then it uses the @RepositoryRestResource annotation to direct
 * Spring MVC to create RESTful endpoints at /people
 */
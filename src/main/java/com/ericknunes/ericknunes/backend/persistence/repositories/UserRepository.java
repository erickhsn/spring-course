package com.ericknunes.ericknunes.backend.persistence.repositories;

import com.ericknunes.ericknunes.backend.persistence.domain.backend.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
}

package de.inosofttech.springbootrestfulwebservices.repository;

import de.inosofttech.springbootrestfulwebservices.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}

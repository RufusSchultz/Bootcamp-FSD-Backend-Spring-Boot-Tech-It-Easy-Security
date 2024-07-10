package com.servicedto.techiteasy.repositories;


import com.servicedto.techiteasy.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String> {
}

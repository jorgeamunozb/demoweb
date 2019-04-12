package com.example.demoweb.repo;

import com.example.demoweb.model.UserApplication;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserRepo extends JpaRepository<UserApplication, Integer> {
    UserApplication findByName(String name);
}

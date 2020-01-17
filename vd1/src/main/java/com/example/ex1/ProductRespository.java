package com.example.ex1;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRespository extends JpaRepository<Product, Integer> {

}

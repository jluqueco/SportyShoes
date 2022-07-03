package com.simplilearn.assigment.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.simplilearn.assigment.model.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {

}

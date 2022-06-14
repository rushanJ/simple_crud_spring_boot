package com.example.assignment.repository;

import com.example.assignment.model.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface ItemRepository extends JpaRepository<Item,Long> {
}

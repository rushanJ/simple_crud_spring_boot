package com.example.assignment.repository;

import com.example.assignment.model.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface ItemRepository extends JpaRepository<Item,Long> {
    @Query(value = "SELECT * FROM item WHERE ?1", nativeQuery = true)
    List<Item> findByQuery (String query);
}

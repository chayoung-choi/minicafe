package com.eden.minicafe.repository;

import com.eden.minicafe.domain.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemRepository extends JpaRepository<Item, Long> {
  boolean existsByName(String name);
}

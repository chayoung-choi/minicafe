package com.eden.minicafe.repository;

import com.eden.minicafe.domain.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Item, Long> {

}

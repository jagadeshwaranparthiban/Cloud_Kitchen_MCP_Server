package com.jagadesh.mcpServer.repository;

import com.jagadesh.mcpServer.model.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ItemRepo extends JpaRepository<Item, Long> {
    Optional<Item> findByItemName(String itemName);

    List<Item> findByCategory(String category);
}

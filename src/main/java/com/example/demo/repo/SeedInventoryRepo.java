package com.example.demo.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.SeedInventory;

public interface SeedInventoryRepo extends JpaRepository<SeedInventory, Long> {
	List<SeedInventory> findBySeedId(String seedId);
}

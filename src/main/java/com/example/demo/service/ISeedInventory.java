package com.example.demo.service;

import java.util.List;


import org.springframework.data.domain.Page;

import com.example.demo.dto.SeedInventoryDTO;
import com.example.demo.model.SeedInventory;

public interface ISeedInventory {
	SeedInventoryDTO createSeedInventory(SeedInventoryDTO dto);

	SeedInventoryDTO updateSeedInventory(Long id, SeedInventoryDTO dto);

	void deleteSeedInventory(Long id);

	SeedInventoryDTO getSeedInventoryById(Long id);

	List<SeedInventoryDTO> getAllSeedInventories();

	SeedInventoryDTO getBySeedId(String seedId);

	SeedInventory saveSeed(SeedInventory seed);

	Page<SeedInventory> getPaginatedAndSortedSeedInventory(int page, int size, String sortBy, String direction);
}

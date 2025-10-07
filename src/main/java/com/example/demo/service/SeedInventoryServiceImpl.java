package com.example.demo.service;

import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.demo.dto.SeedInventoryDTO;
import com.example.demo.model.SeedInventory;
import com.example.demo.repo.SeedInventoryRepo;

@Service
public class SeedInventoryServiceImpl implements ISeedInventory {

	private static final Logger logger = LoggerFactory.getLogger(SeedInventoryServiceImpl.class);

	@Autowired
	private SeedInventoryRepo repository;

	@Override
	public SeedInventoryDTO createSeedInventory(SeedInventoryDTO dto) {
		SeedInventory entity = new SeedInventory();
		BeanUtils.copyProperties(dto, entity);
		logger.info("Record added id successfully...!");
		return convertToDTO(repository.save(entity));

	}

	@Override
	public SeedInventoryDTO updateSeedInventory(Long id, SeedInventoryDTO dto) {

		SeedInventory inventory = repository.findById(id)
				.orElseThrow(() -> new RuntimeException("SeedsInventory not found "));
		inventory.setAvailableQty(dto.getAvailableQty());
		inventory.setHoldQty(dto.getHoldQty());
		inventory.setSoldQty(dto.getSoldQty());
		inventory.setLotBatchNo(dto.getLotBatchNo());
		inventory.setBaseRate(dto.getBaseRate());
		inventory.setPurchesRate(dto.getPurchesRate());
		inventory.setPurchesDate(dto.getPurchesDate());
		inventory.setExpiryDate(dto.getExpiryDate());
		inventory.setSoldHoldStatus(dto.getSoldHoldStatus());
		inventory.setManufacture(dto.getManufacture());
		inventory.setInvoiceId(dto.getInvoiceId());
		inventory.setPvtType(dto.getPvtType());
		inventory.setItemStatus(dto.getItemStatus());
		inventory.setType(dto.getType());
		inventory.setAssetId(dto.getAssetId());
		inventory.setSeedId(dto.getSeedId());
		inventory.setVaPriId(dto.getVaPriId());
		inventory.setRoId(dto.getRoId());
		inventory.setAoId(dto.getAoId());
		inventory.setBagSize(dto.getBagSize());
		inventory.setBagNumber(dto.getBagNumber());
		inventory.setTotalQty(dto.getTotalQty());
		inventory.setIntakeMethod(dto.getIntakeMethod());
		inventory.setPackingMaterialId(dto.getPackingMaterialId());
		inventory.setStatus(dto.getStatus());

		logger.info("Updated Record Successfully of id " + id);
		return convertToDTO(repository.save(inventory));
	}

	@Override
	public void deleteSeedInventory(Long id) {
		logger.info("Record deleted of " + id);
		repository.deleteById(id);
	}

	@Override
	public SeedInventoryDTO getSeedInventoryById(Long id) {

		return repository.findById(id).map(this::convertToDTO)
				.orElseThrow(() -> new RuntimeException("Not found with id " + id));
	}

	@Override
	public List<SeedInventoryDTO> getAllSeedInventories() {
		logger.info("All Seed Inventories...!");
		return repository.findAll().stream().map(this::convertToDTO).collect(Collectors.toList());
	}

	@GetMapping("/seed/{seedId}")
	public SeedInventoryDTO getBySeedId(@PathVariable String seedId) {
		logger.info("Your record of id no. " + seedId);
		return (SeedInventoryDTO) repository.findBySeedId(seedId);
	}

	private SeedInventoryDTO convertToDTO(SeedInventory entity) {
		SeedInventoryDTO dto = new SeedInventoryDTO();
		BeanUtils.copyProperties(entity, dto);
		return dto;
	}

	@Override
	public SeedInventory saveSeed(SeedInventory seed) {
		return repository.save(seed);
	}

	@Override
	public Page<SeedInventory> getPaginatedAndSortedSeedInventory(int page, int size, String sortBy, String direction) {
	    Sort sort = direction.equalsIgnoreCase("desc") ? Sort.by(sortBy).descending() : Sort.by(sortBy).ascending();
	    Pageable pageable = PageRequest.of(page, size, sort);
	    return repository.findAll(pageable);
	}
	
}

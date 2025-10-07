package com.example.demo.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.common.MessageConstants;
import com.example.demo.common.ResponseModel;
import com.example.demo.dto.SeedInventoryDTO;
import com.example.demo.model.SeedInventory;
import com.example.demo.service.ISeedInventory;
import com.example.demo.service.SeedInventoryServiceImpl;

@RestController
@RequestMapping("/api/seed-inventory")
public class SeedInventoryController {

	private static final Logger logger = LoggerFactory.getLogger(SeedInventoryServiceImpl.class);

	@Autowired
	private ISeedInventory seedInventoryService;

	@PostMapping
	public ResponseEntity<ResponseModel> createSeed(@RequestBody SeedInventory seed) {
		logger.info("SeedInventoryController :::: with payload: {}", seed);
		try {
			SeedInventory created = seedInventoryService.saveSeed(seed);
			logger.info("Seed created successfully with ID: {}", created.getId());
			return ResponseEntity.status(HttpStatus.CREATED).body(new ResponseModel(MessageConstants.SUCCESS,
					MessageConstants.CREATED_STATUS_CODE, "Seed created successfully", created));
		} catch (Exception e) {
			logger.error("Failed to create seed: {}", e.getMessage(), e);
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ResponseModel(MessageConstants.FAILED,
					MessageConstants.BAD_REQUEST_STATUS_CODE, MessageConstants.DATA_NOT_SAVED, null));
		}
	}
	@GetMapping
	public ResponseEntity<ResponseModel> getAllSeeds() {
		try {
			List<SeedInventoryDTO> seeds = seedInventoryService.getAllSeedInventories();
			if (seeds.isEmpty()) {
				logger.warn("No seed inventory data found.");
				return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ResponseModel(MessageConstants.FAILED,
						MessageConstants.NOT_FOUND_STATUS_CODE, MessageConstants.DATA_NOT_AVAILABLE, null));
			}
			logger.info("Fetched {} seed records successfully.", seeds.size());
			return ResponseEntity.ok(new ResponseModel(MessageConstants.SUCCESS, MessageConstants.SUCCESS_STATUS_CODE,
					MessageConstants.SUCCESS_MESSAGE_ONE, seeds));
		} catch (Exception ex) {
			logger.error("Error occurred while fetching seeds: {}", ex.getMessage(), ex);
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body(ResponseModel.error("An error occurred while fetching seeds."));
		}
	}

	@PutMapping("/{id}")
	public ResponseEntity<ResponseModel> updateSeedInventory(@PathVariable Long id, @RequestBody SeedInventoryDTO dto) {
		logger.info("SeedInventoryController ::: Updating Seed Inventory for ID: {}", id);
		try {
			SeedInventoryDTO updated = seedInventoryService.updateSeedInventory(id, dto);
			logger.info("Seed Inventory updated successfully for ID: {}", id);

			return ResponseEntity.ok(new ResponseModel(MessageConstants.SUCCESS, MessageConstants.SUCCESS_STATUS_CODE,
					"Seed inventory updated successfully", updated));
		} catch (Exception e) {
			logger.error("Failed to update seed inventory with ID {}: {}", id, e.getMessage(), e);
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ResponseModel(MessageConstants.FAILED,
					MessageConstants.BAD_REQUEST_STATUS_CODE, MessageConstants.DATA_NOT_SAVED, null));
		}
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<ResponseModel> deleteSeedInventory(@PathVariable Long id) {
		logger.info("Attempting to delete Seed Inventory with ID: {}", id);
		try {
			seedInventoryService.deleteSeedInventory(id);
			logger.info("Seed Inventory deleted successfully for ID: {}", id);

			return ResponseEntity.ok(new ResponseModel(MessageConstants.SUCCESS, MessageConstants.SUCCESS_STATUS_CODE,
					"Seed inventory deleted successfully", null));
		} catch (Exception e) {
			logger.error("Failed to delete seed inventory with ID {}: {}", id, e.getMessage(), e);
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ResponseModel(MessageConstants.FAILED,
					MessageConstants.NOT_FOUND_STATUS_CODE, "Seed inventory not found or could not be deleted", null));
		}
	}

	
	@GetMapping("/{id}")
	public ResponseEntity<ResponseModel> getSeedInventoryById(@PathVariable Long id) {
		logger.info("Fetching Seed Inventory by ID: {}", id);
		try {
			SeedInventoryDTO dto = seedInventoryService.getSeedInventoryById(id);
			return ResponseEntity.ok(new ResponseModel(MessageConstants.SUCCESS, MessageConstants.SUCCESS_STATUS_CODE,
					"Seed inventory fetched successfully", dto));
		} catch (Exception e) {
			logger.error("Failed to fetch seed inventory with ID {}: {}", id, e.getMessage(), e);
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ResponseModel(MessageConstants.FAILED,
					MessageConstants.NOT_FOUND_STATUS_CODE, "Seed inventory not found", null));
		}
	}

	
	@GetMapping("/seedId/{seedId}")
	public ResponseEntity<ResponseModel> getBySeedId(@PathVariable String seedId) {
		logger.info("Fetching Seed Inventory by Seed ID: {}", seedId);
		try {
			SeedInventoryDTO dto = seedInventoryService.getBySeedId(seedId);
			return ResponseEntity.ok(new ResponseModel(MessageConstants.SUCCESS, MessageConstants.SUCCESS_STATUS_CODE,
					"Seed inventory fetched successfully by Seed ID", dto));
		} catch (Exception e) {
			logger.error("Failed to fetch seed inventory with Seed ID {}: {}", seedId, e.getMessage(), e);
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ResponseModel(MessageConstants.FAILED,
					MessageConstants.NOT_FOUND_STATUS_CODE, "Seed inventory not found with Seed ID", null));
		}

	}
	@GetMapping("/paginated")
	//GET /api/seed-inventory/paginated?page=0&size=5&sortBy=quantity&direction=desc

	public ResponseEntity<ResponseModel> getSeedsPaginated(
	        @RequestParam(defaultValue = "0") int page,
	        @RequestParam(defaultValue = "10") int size,
	        @RequestParam(defaultValue = "id") String sortBy,
	        @RequestParam(defaultValue = "asc") String direction
	) {
	    try {
	        Page<SeedInventory> pagedResult = seedInventoryService.getPaginatedAndSortedSeedInventory(page, size, sortBy, direction);
	        return ResponseEntity.ok(new ResponseModel(
	                MessageConstants.SUCCESS,
	                MessageConstants.SUCCESS_STATUS_CODE,
	                "Seed inventory page fetched successfully",
	                pagedResult
	        ));
	    } catch (Exception e) {
	        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(
	                new ResponseModel(
	                        MessageConstants.FAILED,
	                        MessageConstants.INTERNAL_SERVER_ERROR_STATUS_CODE,
	                        "Error while fetching paginated seed inventory",
	                        null
	                )
	        );
	    }
	}

}
/*
 * @PostMapping("/create") public ResponseEntity<SeedInventoryDTO>
 * createSeedInventory(@RequestBody SeedInventoryDTO dto) { SeedInventoryDTO
 * created = seedInventoryService.createSeedInventory(dto);
 * logger.info("Seed Inventory created....!"); return
 * ResponseEntity.ok(created); }
 * 
 * @GetMapping public ResponseEntity<List<SeedInventoryDTO>>
 * getAllSeedInventories() { List<SeedInventoryDTO> list =
 * seedInventoryService.getAllSeedInventories(); return ResponseEntity.ok(list);
 * }
 */
/*
 * @PutMapping("/{id}") public ResponseEntity<SeedInventoryDTO>
 * updateSeedInventory(@PathVariable Long id, @RequestBody SeedInventoryDTO dto)
 * { SeedInventoryDTO updated = seedInventoryService.updateSeedInventory(id,
 * dto); logger.info("Seed Inventory updated of this id  "+id); return
 * ResponseEntity.ok(updated); }
 */
/*
 * @DeleteMapping("/{id}") public ResponseEntity<Void>
 * deleteSeedInventory(@PathVariable Long id) {
 * seedInventoryService.deleteSeedInventory(id);
 * logger.info("Seed Inventory deleted....!"); return
 * ResponseEntity.noContent().build(); }
 */
/*
 * @GetMapping("/{id}") public ResponseEntity<SeedInventoryDTO>
 * getSeedInventoryById(@PathVariable Long id) { SeedInventoryDTO dto =
 * seedInventoryService.getSeedInventoryById(id); return ResponseEntity.ok(dto);
 * }
 */
/*
 * @GetMapping("/seedId/{seedId}") public ResponseEntity<SeedInventoryDTO>
 * getBySeedId(@PathVariable String seedId) { SeedInventoryDTO dto =
 * seedInventoryService.getBySeedId(seedId); return ResponseEntity.ok(dto); }
 */
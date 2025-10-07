package com.example.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SeedInventoryDTO {
	private Long id;

	private Integer availableQty;
	private Integer holdQty;
	private Integer soldQty;
	private String lotBatchNo;
	private String baseRate;
	private String purchesRate;
	private String purchesDate;
	private String expiryDate;

	private String soldHoldStatus;
	private String manufacture;
	private String invoiceId;
	private String pvtType;
	private String itemStatus;
	private String type;
	private String assetId;
	private String seedId;  // findBySeedId (created api )==> custom query 

	private String vaPriId;
	private String roId;
	private String aoId;
	private String bagSize;
	private String bagNumber;
	private String totalQty;
	private String intakeMethod;
	private String packingMaterialId;

	private String status;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getAvailableQty() {
		return availableQty;
	}

	public void setAvailableQty(Integer availableQty) {
		this.availableQty = availableQty;
	}

	public Integer getHoldQty() {
		return holdQty;
	}

	public void setHoldQty(Integer holdQty) {
		this.holdQty = holdQty;
	}

	public Integer getSoldQty() {
		return soldQty;
	}

	public void setSoldQty(Integer soldQty) {
		this.soldQty = soldQty;
	}

	public String getLotBatchNo() {
		return lotBatchNo;
	}

	public void setLotBatchNo(String lotBatchNo) {
		this.lotBatchNo = lotBatchNo;
	}

	public String getBaseRate() {
		return baseRate;
	}

	public void setBaseRate(String baseRate) {
		this.baseRate = baseRate;
	}

	public String getPurchesRate() {
		return purchesRate;
	}

	public void setPurchesRate(String purchesRate) {
		this.purchesRate = purchesRate;
	}

	public String getPurchesDate() {
		return purchesDate;
	}

	public void setPurchesDate(String purchesDate) {
		this.purchesDate = purchesDate;
	}

	public String getExpiryDate() {
		return expiryDate;
	}

	public void setExpiryDate(String expiryDate) {
		this.expiryDate = expiryDate;
	}

	public String getSoldHoldStatus() {
		return soldHoldStatus;
	}

	public void setSoldHoldStatus(String soldHoldStatus) {
		this.soldHoldStatus = soldHoldStatus;
	}

	public String getManufacture() {
		return manufacture;
	}

	public void setManufacture(String manufacture) {
		this.manufacture = manufacture;
	}

	public String getInvoiceId() {
		return invoiceId;
	}

	public void setInvoiceId(String invoiceId) {
		this.invoiceId = invoiceId;
	}

	public String getPvtType() {
		return pvtType;
	}

	public void setPvtType(String pvtType) {
		this.pvtType = pvtType;
	}

	public String getItemStatus() {
		return itemStatus;
	}

	public void setItemStatus(String itemStatus) {
		this.itemStatus = itemStatus;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getAssetId() {
		return assetId;
	}

	public void setAssetId(String assetId) {
		this.assetId = assetId;
	}

	public String getSeedId() {
		return seedId;
	}

	public void setSeedId(String seedId) {
		this.seedId = seedId;
	}

	public String getVaPriId() {
		return vaPriId;
	}

	public void setVaPriId(String vaPriId) {
		this.vaPriId = vaPriId;
	}

	public String getRoId() {
		return roId;
	}

	public void setRoId(String roId) {
		this.roId = roId;
	}

	public String getAoId() {
		return aoId;
	}

	public void setAoId(String aoId) {
		this.aoId = aoId;
	}

	public String getBagSize() {
		return bagSize;
	}

	public void setBagSize(String bagSize) {
		this.bagSize = bagSize;
	}

	public String getBagNumber() {
		return bagNumber;
	}

	public void setBagNumber(String bagNumber) {
		this.bagNumber = bagNumber;
	}

	public String getTotalQty() {
		return totalQty;
	}

	public void setTotalQty(String totalQty) {
		this.totalQty = totalQty;
	}

	public String getIntakeMethod() {
		return intakeMethod;
	}

	public void setIntakeMethod(String intakeMethod) {
		this.intakeMethod = intakeMethod;
	}

	public String getPackingMaterialId() {
		return packingMaterialId;
	}

	public void setPackingMaterialId(String packingMaterialId) {
		this.packingMaterialId = packingMaterialId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}

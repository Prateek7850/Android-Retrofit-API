package com.example.productlist.Model.ProductList;

import com.google.gson.annotations.SerializedName;

public class Meta{

	@SerializedName("createdAt")
	private String createdAt;

	@SerializedName("qrCode")
	private String qrCode;

	@SerializedName("barcode")
	private String barcode;

	@SerializedName("updatedAt")
	private String updatedAt;

	public void setCreatedAt(String createdAt){
		this.createdAt = createdAt;
	}

	public String getCreatedAt(){
		return createdAt;
	}

	public void setQrCode(String qrCode){
		this.qrCode = qrCode;
	}

	public String getQrCode(){
		return qrCode;
	}

	public void setBarcode(String barcode){
		this.barcode = barcode;
	}

	public String getBarcode(){
		return barcode;
	}

	public void setUpdatedAt(String updatedAt){
		this.updatedAt = updatedAt;
	}

	public String getUpdatedAt(){
		return updatedAt;
	}
}
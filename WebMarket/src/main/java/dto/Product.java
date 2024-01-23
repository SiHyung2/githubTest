package dto;

import java.io.Serializable;

public class Product implements Serializable {
	private static final long serialVersionUID = -6560609949281935315L;
	private String productId;
	private String pname;
	private Integer uniPrice;
	private String description;
	private String manufacturer;
	private String category;
	private long unitsInStock;
	private String condition;
	
	//7장 코드 추가
	private String filename;
	public String getFilename() {
		return filename;
	}
	public void setFilename(String filename) {
		this.filename=filename;
	}
	//----o----
	
	public Product() { super(); }


	public Product(String productId, String pname, Integer uniPrice) {
		super();
		this.productId = productId;
		this.pname = pname;
		this.uniPrice = uniPrice;
	}


	public String getProductId() {
		return productId;
	}


	public void setProductId(String productId) {
		this.productId = productId;
	}


	public String getPname() {
		return pname;
	}


	public void setPname(String pname) {
		this.pname = pname;
	}


	public Integer getUnitPrice() {
		return uniPrice;
	}


	public void setUnitPrice(Integer uniPrice) {
		this.uniPrice = uniPrice;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public String getManufacturer() {
		return manufacturer;
	}


	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}


	public String getCategory() {
		return category;
	}


	public void setCategory(String category) {
		this.category = category;
	}


	public long getUnitsInStock() {
		return unitsInStock;
	}


	public void setUnitsInStock(long unitsInStock) {
		this.unitsInStock = unitsInStock;
	}


	public String getCondition() {
		return condition;
	}


	public void setCondition(String condition) {
		this.condition = condition;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
}

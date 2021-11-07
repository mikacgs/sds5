package main.dtos;

import main.entities.Seller;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class SellerDTO implements Serializable {

	private Long id;
	private String name;
	private List<SaleDTO> sales = new ArrayList<>();

	public SellerDTO() {

	}

	public List<SaleDTO> getSales() {
		return sales;
	}

	public SellerDTO(Long id, String name, List<SaleDTO> sales) {
		super();
		this.id = id;
		this.name = name;
		this.sales = sales;
	}

	public SellerDTO(Long id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public SellerDTO(Seller entity) {
		super();
		this.id = entity.getId();
		this.name = entity.getName();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}

package com.mkyong.content.model;

public class Fruit {
	private Integer id;
	private String name;
	private String produceBy;
	
	public Fruit() {}

	public Fruit(Integer id, String name, String produceBy) {
		this.id = id;
		this.name = name;
		this.produceBy = produceBy;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getProduceBy() {
		return produceBy;
	}

	public void setProduceBy(String produceBy) {
		this.produceBy = produceBy;
	}
	
}

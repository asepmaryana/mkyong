package com.memorynotfound.model;

public class City {
	private String kode;
	private String nama;
	private String provinsi;
	
	public City(String kode, String nama, String provinsi) {
		super();
		this.kode = kode;
		this.nama = nama;
		this.provinsi = provinsi;
	}
	
	public City() {}

	public String getKode() {
		return kode;
	}

	public void setKode(String kode) {
		this.kode = kode;
	}

	public String getNama() {
		return nama;
	}

	public void setNama(String nama) {
		this.nama = nama;
	}

	public String getProvinsi() {
		return provinsi;
	}

	public void setProvinsi(String provinsi) {
		this.provinsi = provinsi;
	}
	
}

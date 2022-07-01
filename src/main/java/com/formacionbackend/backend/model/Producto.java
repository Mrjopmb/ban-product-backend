package com.formacionbackend.backend.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

//Products
@Entity
@Table(name = "tftmppro")


public class Producto {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer pro_iddpro;
	private String pro_nompro;
	private String pro_despro;
	private String pro_prepro;
	public Integer getPro_iddpro() {
		return pro_iddpro;
	}
	public void setPro_iddpro(Integer pro_iddpro) {
		this.pro_iddpro = pro_iddpro;
	}
	public String getPro_nompro() {
		return pro_nompro;
	}
	public void setPro_nompro(String pro_nompro) {
		this.pro_nompro = pro_nompro;
	}
	public String getPro_despro() {
		return pro_despro;
	}
	public void setPro_despro(String pro_despro) {
		this.pro_despro = pro_despro;
	}
	public String getPro_prepro() {
		return pro_prepro;
	}
	public void setPro_prepro(String pro_prepro) {
		this.pro_prepro = pro_prepro;
	}
	@Override
	public String toString() {
		return "producto [pro_iddpro=" + pro_iddpro + ", pro_nompro=" + pro_nompro + ", pro_despro=" + pro_despro
				+ ", pro_prepro=" + pro_prepro + "]";
	}
}

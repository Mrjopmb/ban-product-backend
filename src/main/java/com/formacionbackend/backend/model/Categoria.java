package com.formacionbackend.backend.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

//Category
@Entity
@Table(name = "tftmpcat")

public class Categoria {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer cat_iddcat;
	private String cat_nomcat;
	private String cat_descat;
	public Integer getCat_iddcat() {
		return cat_iddcat;
	}
	public void setCat_iddcat(Integer cat_iddcat) {
		this.cat_iddcat = cat_iddcat;
	}
	public String getCat_nomcat() {
		return cat_nomcat;
	}
	public void setCat_nomcat(String cat_nomcat) {
		this.cat_nomcat = cat_nomcat;
	}
	public String getCat_descat() {
		return cat_descat;
	}
	public void setCat_descat(String cat_descat) {
		this.cat_descat = cat_descat;
	}
	@Override
	public String toString() {
		return "categoria [cat_iddcat=" + cat_iddcat + ", cat_nomcat=" + cat_nomcat + ", cat_descat=" + cat_descat
				+ "]";
	}
}


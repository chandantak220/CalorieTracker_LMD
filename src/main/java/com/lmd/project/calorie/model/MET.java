package com.lmd.project.calorie.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "s_met")
public class MET {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(nullable = false)
	private String sActivity = "";

	@Column(nullable = false)
	private String sMotion = "";

	@Column(nullable = false)
	private double dMET = 0.0;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getsActivity() {
		return sActivity;
	}

	public void setsActivity(String sActivity) {
		this.sActivity = sActivity;
	}

	public String getsMotion() {
		return sMotion;
	}

	public void setsMotion(String sMotion) {
		this.sMotion = sMotion;
	}

	public double getdMET() {
		return dMET;
	}

	public void setdMET(double dMET) {
		this.dMET = dMET;
	}

	@Override
	public String toString() {
		return "MET [id=" + id + ", sActivity=" + sActivity + ", sMotion=" + sMotion + ", dMET=" + dMET + "]";
	}

}

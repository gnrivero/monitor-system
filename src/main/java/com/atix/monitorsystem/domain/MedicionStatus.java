package com.atix.monitorsystem.domain;

public class MedicionStatus {
	
	public static String OK = "OK";
	public static String ERROR = "ERROR";
	
	private String promedio;
	private String minMax;
	
	public String getPromedio() {
		return promedio;
	}
	public void setPromedio(String promedio) {
		this.promedio = promedio;
	}
	public String getMinMax() {
		return minMax;
	}
	public void setMinMax(String minMax) {
		this.minMax = minMax;
	}
	
}

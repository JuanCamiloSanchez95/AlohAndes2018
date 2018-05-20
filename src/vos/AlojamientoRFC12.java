package vos;

import org.codehaus.jackson.annotate.JsonProperty;

public class AlojamientoRFC12 {
	
	/**
	 * Numero de Semana
	 */
	@JsonProperty(value = "semana")
	private int semana;
	
	
	/**
	 * Ingreso en el periodo
	 */
	@JsonProperty(value = "ingresos")
	private double ingresos;
	
	
	/**
	 * Numero de Reservas en el periodo
	 */
	@JsonProperty(value = "numReservas")
	private int numReservas;
	
	/**
	 * Alojamiento asociado
	 */
	@JsonProperty(value = "alojamiento")
	private Alojamiento alojamiento;
	
	
/**
 * Metodo constructor para el alojamiento del Requerimiento RFC12
 * @param semana - numero de semana
 * @param ingresos - ingresos en la semana
 * @param numReservas - numero de reservas en la semana
 */
	public AlojamientoRFC12(int semana, double ingresos, int numReservas) {
		this.semana = semana;
		this.ingresos = ingresos;
		this.numReservas = numReservas;
	}

	public int getSemana() {
		return semana;
	}

	public double getIngresos() {
		return ingresos;
	}

	public int getNumReservas() {
		return numReservas;
	}

	public Alojamiento getAlojamiento() {
		return alojamiento;
	}

	public void setSemana(int semana) {
		this.semana = semana;
	}

	public void setIngresos(double ingresos) {
		this.ingresos = ingresos;
	}

	public void setNumReservas(int numReservas) {
		this.numReservas = numReservas;
	}

	public void setAlojamiento(Alojamiento alojamiento) {
		this.alojamiento = alojamiento;
	}

}

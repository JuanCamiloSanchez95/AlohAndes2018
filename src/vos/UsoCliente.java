package vos;

import org.codehaus.jackson.annotate.JsonProperty;

/**
 * Clase que representa el uso del sistema por parte de un  cliente
 * @author Cristian 
 */
public class UsoCliente {
	// ----------------------------------------------------------------------------------------------------------------------------------
	// ATRIBUTOS
	// ----------------------------------------------------------------------------------------------------------------------------------

	/**
	 * Nombre del cliente
	 */
	@JsonProperty(value = "nombreCliente")
	private String nombreCliente;

	/**
	 * Dias contratados
	 */
	@JsonProperty(value = "diasContratados")
	private int diasContratados;

	/**
	 * Tipo del Alojamiento
	 */
	@JsonProperty(value = "alojamientoFrecuente")
	private String alojamientoFrecuente;

	/**
	 * Costo pagado
	 */
	@JsonProperty(value = "dineroPagado")
	private double dineroPagado;

	// ----------------------------------------------------------------------------------------------------------------------------------
	// METODO CONSTRUCTOR
	// ----------------------------------------------------------------------------------------------------------------------------------

	/**
	 * Metodo constructor de la clase UsoCliente
	 *  <b>post: </b> Crea un objeto UsoCliente con los valores que entran por parametro
	 * 
	 * @param nombreCliente - nombre del cliente
	 * @param diasContratados- suma de dias contratados por el cliente.
	 * @param alojamientoFrecuente - tipo de alojamiento contratado.
	 * @param dineroPagado - Dinero pagado en total
	 */
	public UsoCliente(@JsonProperty(value = "nombreCliente") String nombreCliente,
			@JsonProperty(value = "diasContratados") Integer diasContratados,
			@JsonProperty(value = "alojamientoFrecuente") String alojamientoFrecuente,
			@JsonProperty(value = "dineroPagado") double dineroPagado) {
		this.nombreCliente = nombreCliente;
		this.diasContratados = diasContratados;
		this.alojamientoFrecuente = alojamientoFrecuente;
		this.dineroPagado = dineroPagado;

	}

	// ----------------------------------------------------------------------------------------------------------------------------------
	// METODOS DE LA CLASE
	// ----------------------------------------------------------------------------------------------------------------------------------

	public int getDiasContratados() {
		return diasContratados;
	}

	public String getAlojamientoFrecuente() {
		return alojamientoFrecuente;
	}

	public double getDineroPagado() {
		return dineroPagado;
	}

	public void setDiasContratados(int diasContratados) {
		this.diasContratados = diasContratados;
	}

	public void setAlojamientoFrecuente(String alojamientoFrecuente) {
		this.alojamientoFrecuente = alojamientoFrecuente;
	}

	public void setDineroPagado(double dineroPagado) {
		this.dineroPagado = dineroPagado;
	}

	public String getNombreCliente() {
		return nombreCliente;
	}

	public void setNombreCliente(String nombreCliente) {
		this.nombreCliente = nombreCliente;
	}
}

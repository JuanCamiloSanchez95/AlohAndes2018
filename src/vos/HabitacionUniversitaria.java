package vos;

import org.codehaus.jackson.annotate.JsonProperty;

/**
 * 
 * @author Juan
 * Clase que representa una habitacionUniversitaria  
 */
public class HabitacionUniversitaria extends Alojamiento
{
	//----------------------------------------------------------------------------------------------------------------------------------
	// ATRIBUTOS
	//----------------------------------------------------------------------------------------------------------------------------------
			
	/**
	 * ubicacion de la habitacion
	 */
	@JsonProperty(value="ubicacionH")
	private String ubicacionH;
	
	
	/**
	 * indicador si  la habitacion es compartida
	 */
	@JsonProperty(value="compartida")
	private boolean compartida;
	
	/**
	 * Capacidad de la habitacion
	 */
	@JsonProperty(value="capacidad")
	private int capacidad;
	
	/**
	 * indicador menaje de  la habitacion 
	 */
	@JsonProperty(value="menaje")
	private String menaje;
	
	/**
	 * indicador numHabitacion de  la habitacion 
	 */
	@JsonProperty(value="numHabitacion")
	private int numHabitacion;
	
	//----------------------------------------------------------------------------------------------------------------------------------
		// METODO CONSTRUCTOR
		//----------------------------------------------------------------------------------------------------------------------------------

	
	/**
	 * 
	 * @param id
	 * @param nombre
	 * @param tipo
	 * @param ubicacion
	 * @param descripcion
	 * @param costo
	 * @param minimoPeriodo
	 * @param ubicacionH
	 * @param compartida
	 * @param capacidad
	 * @param menaje
	 * @param numHabitacion
	 */
		public HabitacionUniversitaria(@JsonProperty(value="id") Integer id,@JsonProperty(value="nombre") String nombre, @JsonProperty(value="tipo") String tipo,@JsonProperty(value="ubicacion") String ubicacion,@JsonProperty(value="descripcion") String descripcion,@JsonProperty(value="costo") double costo, @JsonProperty(value="minimoPeriodo")int minimoPeriodo,@JsonProperty(value="ubicacionH")String ubicacionH,@JsonProperty(value="compartida")boolean compartida,@JsonProperty(value="capacidad")int capacidad,@JsonProperty(value="menaje")String menaje,@JsonProperty(value="numHabitacion")int numHabitacion) 
		{
			super(id, nombre, tipo, ubicacion, descripcion, costo, minimoPeriodo);
			this.capacidad=capacidad;
			this.compartida=compartida;
			this.menaje=menaje;
			this.ubicacionH=ubicacion;
			this.numHabitacion=numHabitacion;
		}

		//----------------------------------------------------------------------------------------------------------------------------------
		// METODOS DE LA CLASE
		//----------------------------------------------------------------------------------------------------------------------------------
		
		public String getUbicacion() {
			return ubicacionH;
		}

		public void setUbicacion(String ubicacion) {
			this.ubicacionH = ubicacion;
		}


		public boolean isCompartida() {
			return compartida;
		}

		public void setCompartida(boolean compartida) {
			this.compartida = compartida;
		}

		public String getUbicacionH() {
			return ubicacionH;
		}

		public void setUbicacionH(String ubicacionH) {
			this.ubicacionH = ubicacionH;
		}

		public int getCapacidad() {
			return capacidad;
		}

		public void setCapacidad(int capacidad) {
			this.capacidad = capacidad;
		}

		public String getMenaje() {
			return menaje;
		}

		public void setMenaje(String menaje) {
			this.menaje = menaje;
		}

		public int getNumHabitacion() {
			return numHabitacion;
		}

		public void setNumHabitacion(int numHabitacion) {
			this.numHabitacion = numHabitacion;
		}
}

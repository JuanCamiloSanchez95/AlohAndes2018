package rest;

import java.util.Date;
import java.util.List;

import javax.servlet.ServletContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.codehaus.jackson.annotate.JsonProperty;

import tm.AlohAndesTransactionManager;
import vos.Alojamiento;
import vos.AnalisisOperacion;
import vos.Bebedor;
import vos.ClienteFrecuente;
import vos.ConsultaAlojamiento;
import vos.SolicitudAnalisisOperacion;
import vos.UsoCliente;

@Path("alojamientos")
public class AlojamientoService {

	//----------------------------------------------------------------------------------------------------------------------------------
	// ATRIBUTOS
	//----------------------------------------------------------------------------------------------------------------------------------

	/**
	 * Atributo que usa la anotacion @Context para tener el ServletContext de la conexion actual.
	 */
	@Context
	private ServletContext context;

	//----------------------------------------------------------------------------------------------------------------------------------
	// METODOS DE INICIALIZACION
	//----------------------------------------------------------------------------------------------------------------------------------
	/**
	 * Metodo que retorna el path de la carpeta WEB-INF/ConnectionData en el deploy actual dentro del servidor.
	 * @return path de la carpeta WEB-INF/ConnectionData en el deploy actual.
	 */
	private String getPath() {
		return context.getRealPath("WEB-INF/ConnectionData");
	}


	private String doErrorMessage(Exception e){
		return "{ \"ERROR\": \""+ e.getMessage() + "\"}" ;
	}

	//----------------------------------------------------------------------------------------------------------------------------------
	// METODOS REST
	//----------------------------------------------------------------------------------------------------------------------------------

	/**
	 * Metodo GET que trae al alojamiento en la Base de Datos con el ID dado por parametro <br/>
	 * <b>Precondicion: </b> el archivo <em>'conectionData'</em> ha sido inicializado con las credenciales del usuario <br/>
	 * <b>URL: </b> http://localhost:8080/AlohAndes/rest/alojamientos/{id} <br/>
	 * @return	<b>Response Status 200</b> - JSON Alojamiento que contiene al alojamiento cuyo ID corresponda al parametro <br/>
	 * 			<b>Response Status 500</b> - Excepcion durante el transcurso de la transaccion
	 */
	@GET
	@Path( "{id: \\d+}" )
	@Produces( { MediaType.APPLICATION_JSON } )
	public Response getAlojamientoById( @PathParam( "id" ) Long id )
	{
		try{
			AlohAndesTransactionManager tm = new AlohAndesTransactionManager( getPath( ) );
			
			Alojamiento alojamiento = tm.getAlojamientoById(id);
			return Response.status( 200 ).entity( alojamiento ).build( );			
		}
		catch( Exception e )
		{
			return Response.status( 500 ).entity( doErrorMessage( e ) ).build( );
		}
	}
	
	/**
	 * Metodo GET que trae los clientes frecuentes del alojamiento en la Base de Datos con el ID dado por parametro <br/>
	 * <b>Precondicion: </b> el archivo <em>'conectionData'</em> ha sido inicializado con las credenciales del usuario <br/>
	 * <b>URL: </b> http://localhost:8080/AlohAndes/rest/alojamientos/{id}/clientes <br/>
	 * @return	<b>Response Status 200</b> - JSON Listas de clientes frecuentes del  alojamiento cuyo ID corresponda al parametro <br/>
	 * 			<b>Response Status 500</b> - Excepcion durante el transcurso de la transaccion
	 */
	@GET
	@Path( "{id: \\d+}/clientes" )
	@Produces( { MediaType.APPLICATION_JSON } )
	public Response getClientesFrecuentesById( @PathParam( "id" ) Long id )
	{
		try{
			AlohAndesTransactionManager tm = new AlohAndesTransactionManager( getPath( ) );
			List<ClienteFrecuente> clientes;
			clientes = tm.getClientesFrecuentes(id);
			return Response.status( 200 ).entity( clientes ).build( );			
		}
		catch( Exception e )
		{
			return Response.status( 500 ).entity( doErrorMessage( e ) ).build( );
		}
	}

	/**
	 * Metodo POST que trae los alojamientos que esten en un rango de fechas y con unos servicios dados en la Base de datos. 
	 * <b>Precondicion: </b> el archivo <em>'conectionData'</em> ha sido inicializado con las credenciales del usuario.
	 * <b>URL: </b> http://localhost:8080/AlohAndes/rest/alojamientos/busqueda
	 * @return	<b>Response Status 200</b> - JSON que contiene los alojamientos resultantes de la busqueda en la Base de Datos.
	 * 			<b>Response Status 500</b> - Excepcion durante el transcurso de la transaccion
	 */			
	@POST
	@Path( "/busqueda" )
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces({ MediaType.APPLICATION_JSON })
	public Response getAlojamientosByFechasAndServicios(ConsultaAlojamiento request) {

		try {
			AlohAndesTransactionManager tm = new AlohAndesTransactionManager(getPath());
			List<Alojamiento> alojamientos;
			alojamientos=tm.getAlojamientosByFechasAndServicios(request.getInicio(), request.getFin(), request.getServicios());
			return Response.status(200).entity(alojamientos).build();
		} 
		catch (Exception e) {
			return Response.status(500).entity(doErrorMessage(e)).build();
		}
	}
	
	/**
	 * Metodo POST que obtiene un analisis de operacion para un tipo de analisis en la Base de datos. 
	 * <b>Precondicion: </b> el archivo <em>'conectionData'</em> ha sido inicializado con las credenciales del usuario.
	 * <b>URL: </b> http://localhost:8080/AlohAndes/rest/alojamientos/analisis
	 * @return	<b>Response Status 200</b> - JSON que contiene el analisis dado por la busqueda en la Base de Datos.
	 * 			<b>Response Status 500</b> - Excepcion durante el transcurso de la transaccion
	 */			
	@POST
	@Path( "/analisis" )
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces({ MediaType.APPLICATION_JSON })
	public Response analisisByTipoDeAlojamiento(SolicitudAnalisisOperacion solicitud) {

		try {
			AlohAndesTransactionManager tm = new AlohAndesTransactionManager(getPath());
			AnalisisOperacion analisis;
			analisis=tm.analisisByAlojamiento(solicitud);
			return Response.status(200).entity(analisis).build();
		} 
		catch (Exception e) {
			return Response.status(500).entity(doErrorMessage(e)).build();
		}
	}
}

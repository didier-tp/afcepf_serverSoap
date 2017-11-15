package fr.afcepf.dja.rest;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import fr.afcepf.dja.dao.IDeviseDao;
import fr.afcepf.dja.data.Devise;
import fr.afcepf.dja.ws.IServiceDevise;

@Component //de Spring
@Path("devise")
@Produces("application/json")
//cette classe est une sorte de "adaptateur REST"
public class RestDeviseService {
	
	@Autowired //injection du "business service"
	private IServiceDevise serviceDevise;
	
	@Autowired //injection du "dao"
	private IDeviseDao deviseDao;
	
	@GET
	//url : http://localhost:8080/serverSoap/ws/rest/devise
	//ou bien http://localhost:8080/serverSoap/ws/rest/devise?tauxChangeMini=1.1
	@Path("") //ou bien @Path("/") ou bien @Path("/all")
	public List<Devise> /*allDevise()*/
	       devisesByCriteria(@QueryParam("tauxChangeMini")Double tauxChangeMini){
		    List<Devise> listeDevises = null; 
		     if(tauxChangeMini==null){
		    	 listeDevises = deviseDao.findAllDevise();
		     }
		     else{
		    	  listeDevises = deviseDao.findDeviseWithTauxMini(tauxChangeMini);		    	  
		      }
		      return listeDevises;
	}
	
	@GET
	//url : http://localhost:8080/serverSoap/ws/rest/devise/EUR
	@Path("/{codeDev}") 
	public Devise deviseByCode(@PathParam("codeDev")String codeDevise){
		return deviseDao.findDeviseByCode(codeDevise);
	}
	
	@DELETE
	//url : http://localhost:8080/serverSoap/ws/rest/devise/EUR
	@Path("/{codeDev}") 
	public Response deleteDeviseByCode(@PathParam("codeDev")String codeDevise){
		try {
			deviseDao.deleteDeviseBycode(codeDevise);
			return Response.status(Status.OK).build();
		} catch (Exception e) {
			e.printStackTrace();
			return Response.status(Status.NOT_FOUND).build();//ou Status.INTERNAL_SERVER_ERROR
		}
	}
	
	@POST
	//url : http://localhost:8080/serverSoap/ws/rest/devise
	@Path("") 
	@Consumes("application/json")
	public Response posterNouvelleDevise(Devise d){
		try {
			deviseDao.insertDevise(d);
			//return Response.status(Status.OK).build();
			return Response.ok(d)
					       .status(Status.OK)
					       .build();
		} catch (Exception e) {
			e.printStackTrace();
			return Response.status(Status.INTERNAL_SERVER_ERROR).build();
		}
	}
	
	
	
	

}

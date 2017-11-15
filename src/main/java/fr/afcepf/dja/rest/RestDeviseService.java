package fr.afcepf.dja.rest;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

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
		      List<Devise> listeDevises = deviseDao.findAllDevise();
		      if(tauxChangeMini!=null){
		    	  //boucle de n-1 à 0 pour ne pas perturber les indice lors du remove()
		    	  //si non , bogon = particule élémentaire de bug.
		    	  for(int i=listeDevises.size()-1;i>=0;i--){
		    		  Devise d = listeDevises.get(i);
		    		  if(d.getTauxChange()<tauxChangeMini){
		    			  listeDevises.remove(d);
		    		  }
		    	  }
		      }
		      return listeDevises;
	}
	@GET
	//url : http://localhost:8080/serverSoap/ws/rest/devise/EUR
	@Path("/{codeDev}") 
	public Devise deviseByCode(@PathParam("codeDev")String codeDevise){
		return deviseDao.findDeviseByCode(codeDevise);
	}
	
	
	
	

}

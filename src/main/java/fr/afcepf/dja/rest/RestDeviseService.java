package fr.afcepf.dja.rest;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

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
	@Path("") //ou bien @Path("/") ou bien @Path("/all")
	public List<Devise> allDevise(){
		return deviseDao.findAllDevise();
	}

}

package fr.afcepf.dja.ws;

import javax.jws.WebParam;
import javax.jws.WebService;

@WebService
public interface IServiceDevise {
	
	//convertir(50.0 , "EUR" , "JPY" ); convertir 50 euros en yen japonais
	public double convertir(@WebParam(name="montant")double montant , 
							@WebParam(name="codeMonnaieSource")String codeMonnaieSource, 
							@WebParam(name="codeMonnaieCible")String codeMonnaieCible);
	//...

}

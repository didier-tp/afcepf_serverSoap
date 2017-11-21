package fr.afcepf.dja.ws;

import javax.jws.WebParam;
import javax.jws.WebService;

@WebService
public interface IServiceCalcul {
	
	public double addition(@WebParam(name="s")double s,
			               @WebParam(name="t")double t);
	public double multiplication(@WebParam(name="u")double u,
			                     @WebParam(name="v")double v);
    //...
}

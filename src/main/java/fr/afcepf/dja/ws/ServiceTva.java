package fr.afcepf.dja.ws;

import javax.jws.WebParam;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;

import fr.afcepf.dja.data.ResCalculTva;

@WebService()//avec namespace par defaut : http:// + package java à l'envers + /
             //http://ws.dja.afcepf.fr/
//@SOAPBinding(style = SOAPBinding.Style.DOCUMENT) par defaut en java , en .net, ...
public interface ServiceTva {
	
	public double tva(@WebParam(name="ht")double ht,
			          @WebParam(name="taux") double taux);
	public String getAuteur();
    //...
	public ResCalculTva calculerTvaEtTtc(@WebParam(name="ht")double ht,
			                              @WebParam(name="taux") double taux);
}

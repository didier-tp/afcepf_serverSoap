package fr.afcepf.dja.ws;

import javax.jws.WebService;

@WebService(endpointInterface="fr.afcepf.dja.ws.ServiceTva")
public class ServiceTvaImpl implements ServiceTva {

	@Override
	public double tva(double ht, double taux) {
		return ht*taux/100.0;
	}

	@Override
	public String getAuteur() {
		return "didier defrance / formateur fou";
	}

}

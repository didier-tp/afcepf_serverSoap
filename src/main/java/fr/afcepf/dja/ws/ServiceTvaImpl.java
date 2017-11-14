package fr.afcepf.dja.ws;

import javax.jws.WebService;

import fr.afcepf.dja.data.ResCalculTva;

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

	@Override
	public ResCalculTva calculerTvaEtTtc(double ht, double taux) {
		ResCalculTva resCalculTva = new ResCalculTva();
		resCalculTva.setHt(ht);
		resCalculTva.setTaux(taux);
		resCalculTva.setTva(ht*taux/100.0);
		resCalculTva.setTtc(ht + resCalculTva.getTva());
		return resCalculTva;
	}

}

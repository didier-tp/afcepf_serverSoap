package fr.afcepf.dja.ws;

import javax.jws.WebService;

import org.springframework.stereotype.Service;

import fr.afcepf.dja.data.ResCalculTva;

@Service //@Component de Spring , id par défaut "serviceTvaImpl"
                                 // nom de classe avec minuscule au début
//@Transactional
@WebService(endpointInterface="fr.afcepf.dja.ws.ServiceTva")
public class ServiceTvaImpl implements ServiceTva {
	
	//@Autowired
	//private IDaoxy daoXy;

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

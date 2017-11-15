package fr.afcepf.dja.ws;



import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.afcepf.dja.dao.IDeviseDao;
import fr.afcepf.dja.data.Devise;

//@WebService(...)
@Service
@Transactional
public class ServiceDeviseImpl implements IServiceDevise {
	
	@Autowired
	private IDeviseDao deviseDao;
	
	@PostConstruct
	public void initJeuxDeDonnees(){
		if(deviseDao.findAllDevise().isEmpty()){
			deviseDao.insertDevise(new Devise("EUR",1.1));
			deviseDao.insertDevise(new Devise("USD",1.0));
			deviseDao.insertDevise(new Devise("JPY",112.0));
			deviseDao.insertDevise(new Devise("GBP",1.2));
		}
	}

	@Override
	public double convertir(double montant, String codeMonnaieSource, String codeMonnaieCible) {
		Devise deviseSource = deviseDao.findDeviseByCode(codeMonnaieSource);
		Devise deviseCible = deviseDao.findDeviseByCode(codeMonnaieCible);
		return montant * deviseCible.getTauxChange() / deviseSource.getTauxChange();
		//ou return montant *  deviseSource.getTauxChange() / deviseCible.getTauxChange() ;
	}

	

}

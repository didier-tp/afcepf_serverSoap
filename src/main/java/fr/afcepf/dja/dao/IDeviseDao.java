package fr.afcepf.dja.dao;

import java.util.List;

import fr.afcepf.dja.data.Devise;

public interface IDeviseDao {
	public Devise findDeviseByCode(String codeDevise);
	public List<Devise> findAllDevise();
	
	public void updateDevise(Devise d);
	//...
	
}

package fr.afcepf.dja.data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Devise {
	
	@Id
	private String codeDevise; //"EUR" , "USD"
	
	private Double tauxChange;

}

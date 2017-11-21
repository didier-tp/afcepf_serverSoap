package fr.afcepf.dja.ws;

import javax.jws.WebService;

import org.springframework.stereotype.Service;

@Service
@WebService(endpointInterface="fr.afcepf.dja.ws.IServiceCalcul")
public class ServiceCalculImpl implements IServiceCalcul {

	@Override
	public double addition(double s, double t) {
		double res=s+t;
		System.out.println("addition("+s+","+t+")="+res);
		return res;
	}

	@Override
	public double multiplication(double u, double v) {
		double res=u*v;
		System.out.println("multiplication("+u+","+v+")="+res);
		return res;
	}

}

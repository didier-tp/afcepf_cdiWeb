package fr.afcepf.dja.rest;

import javax.inject.Inject;
import javax.inject.Named;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

import fr.afcepf.dja.data.ResCalculTva;
import fr.afcepf.dja.ws.ServiceTva;
/* pour que @Inject de l'api CDI fonctionne
 * il faut dans le projet courant placer un fichier beans.xml
 * (avec entete CDI) dans META-INF (si projet EJB) ou dans WEB-INF (si projet web)
 */
@Path("tva")
@Produces("application/json")
@Named //equivalent CDI de @Component de Spring
public class MySimpleRestService {
	
	//NB: @Inject fonctionne bien avec un ejb @Local 
	                  //mais pas bien avec un ejb @Remote
	@Inject //equivalent CDI/JEE6 (compatible EJB) de @Autowired de Spring
	private ServiceTva ejbServiceTva;//ServiceTva est l'interface de l'ejb
	
	@GET
	@Path("/calculerTvaEtTtc")
	// http:localhost:8080/cdiWeb/services/rest/tva/calculerTvaEtTtc?ht=200&taux=20
	public ResCalculTva getResCalculTva(@QueryParam("ht")double ht,
			                            @QueryParam("taux")double taux){
		return ejbServiceTva.calculerTvaEtTtc(ht, taux);
	}

	public ServiceTva getEjbServiceTva() {
		return ejbServiceTva;
	}

	public void setEjbServiceTva(ServiceTva ejbServiceTva) {
		this.ejbServiceTva = ejbServiceTva;
	}
	
	
}




package fr.afcepf.dja.rest;

import javax.inject.Named;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

import fr.afcepf.dja.data.ResCalculTva;
/* pour que @Inject de l'api CDI fonctionne
 * il faut dans le projet courant placer un fichier beans.xml
 * (avec entete CDI) dans META-INF (si projet EJB) ou dans WEB-INF (si projet web)
 */
@Path("tva")
@Produces("application/json")
@Named //equivalent CDI de @Component de Spring
public class MySimpleRestService {
	
	//@Inject //equivalent CDI/JEE6 (compatible EJB) de @Autowired de Spring
	//private ServiceTva ejbServiceTva;//ServiceTva est l'interface de l'ejb
	
	@GET
	@Path("/calculerTvaEtTtc")
	// http:localhost:8080/cdiWeb/services/rest/tva/calculerTvaEtTtc?ht=200&taux=20
	public ResCalculTva getResCalculTva(@QueryParam("ht")double ht,
			                            @QueryParam("taux")double taux){
		ResCalculTva resCalculTva = new ResCalculTva();
		resCalculTva.setHt(ht);
		resCalculTva.setTaux(taux);
		resCalculTva.setTva(ht*taux/100.0);
		resCalculTva.setTtc(ht + resCalculTva.getTva());
		return resCalculTva;
	}
}




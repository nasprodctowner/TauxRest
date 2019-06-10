package serviceTaux.service;


import serviceTaux.dao.TauxDAO;
import serviceTaux.modele.Taux;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("test")
public class TauxService {

    @GET
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    @Path("/all")
    public List<Taux> getAllTaux() {
        return TauxDAO.getAllTaux();
    }


    @GET
    @Path("/{monnaieA}/{monnaieB}")
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public Taux getTaux(@PathParam("monnaieA") String monnaieA, @PathParam("monnaieB") String monnaieB) {
        return TauxDAO.getTaux(monnaieA,monnaieB);
    }

    @GET
    @Path("/{monnaieA}/{monnaieB}/{montant}")
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public float getResultFromConversion(@PathParam("monnaieA") String monnaieA, @PathParam("monnaieB") String monnaieB, @PathParam("montant") float montant) {
        return TauxDAO.convertMonnaie(monnaieA,monnaieB,montant);
    }

    @GET
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    @Path("query")
    public float getHelloQueryParam (@QueryParam("monnaieA") String monnaieA, @QueryParam("monnaieB") String monnaieB, @QueryParam("montant") float montant)
    {
        return TauxDAO.convertMonnaie(monnaieA,monnaieB,montant);
    }

    @POST
    @Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    // ça permet d'éviter d epassser directement par la base : passer plutot par le dao
    public Taux setNewTaux(Taux taux) {
        return TauxDAO.createTaux(taux);
    }

    @PUT
    @Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    // ça permet d'éviter d epassser directement par la base : passer plutot par le dao
    public Taux updateTaux(Taux taux) {
        return TauxDAO.updateTaux(taux);
    }

    @DELETE
    @Path("/{id}")
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public List<Taux> deleteTaux(@PathParam("id") int id) {
        TauxDAO.deleteTaux(id);
        return TauxDAO.getAllTaux();
    }
}

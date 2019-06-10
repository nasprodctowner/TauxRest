import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

public class ClientRest {
    public static void main(String[] args){

        Client client = ClientBuilder.newClient();

        WebTarget target = client.target("http://localhost:8080/taux/tauxservices/").path("dinar/euros");

        Invocation.Builder builder = target.request(MediaType.APPLICATION_JSON);

        Response response = builder.get();

        System.out.println("Output from Server .... \n");

        Taux taux = response.readEntity(Taux.class);

        System.out.println(taux.getTaux());

    }
}
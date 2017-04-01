package ro.askade.smartRecycle.dao;


import ro.askade.smartRecycle.exception.AskadeConcurentUpdateException;
import ro.askade.smartRecycle.exception.AskadeNoUserDefinedException;
import ro.askade.smartRecycle.exception.AskadeUserExpiredException;
import ro.askade.smartRecycle.exception.AskadeUserNotAvailableYetEx;
import ro.askade.smartRecycle.model.Client;
import java.math.BigInteger;
import java.util.List;

/**
 * Created by AdrianIonita on 3/8/2017.
 */
public interface ClientDao {

    public String BEAN_ID = "clientDao";
    public void addClient(String currentUser, Client client) throws AskadeNoUserDefinedException, AskadeUserExpiredException, AskadeUserNotAvailableYetEx;
    public void updateClient(String currentUser, Client client) throws AskadeNoUserDefinedException, AskadeUserExpiredException, AskadeUserNotAvailableYetEx, AskadeConcurentUpdateException;
    public List<Client> listClients();
    public Client getClientById(BigInteger clientId);

}

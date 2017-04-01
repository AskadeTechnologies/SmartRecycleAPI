package ro.askade.smartRecycle.daoImpl;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import ro.askade.smartRecycle.dao.ClientDao;
import ro.askade.smartRecycle.exception.AskadeConcurentUpdateException;
import ro.askade.smartRecycle.exception.AskadeNoUserDefinedException;
import ro.askade.smartRecycle.exception.AskadeUserExpiredException;
import ro.askade.smartRecycle.exception.AskadeUserNotAvailableYetEx;
import ro.askade.smartRecycle.model.Client;
import ro.askade.smartRecycle.utils.GenericDaoImpl;

import java.math.BigInteger;
import java.util.List;

/**
 * Created by AdrianIonita on 3/8/2017.
 */
@Repository(value = ClientDao.BEAN_ID)
public class ClientDaoImpl extends GenericDaoImpl implements ClientDao {

    /**
     *
     */
    public SessionFactory sessionFactory;

    /**
     * @param sessionFactory
     */
    public ClientDaoImpl(SessionFactory sessionFactory){
        this.sessionFactory = sessionFactory;
    }

    /**
     * @param sf
     */
    public void setSessionFactory(SessionFactory sf){
        this.sessionFactory = sf;
    }

    /**
     * @return
     */
    public SessionFactory getSessionFactory(){ return this.sessionFactory;}

    /**
     * @param currentUser
     * @param client
     * @throws AskadeNoUserDefinedException
     * @throws AskadeUserExpiredException
     * @throws AskadeUserNotAvailableYetEx
     */
    @Override
    public void addClient(String currentUser, Client client) throws AskadeNoUserDefinedException, AskadeUserExpiredException, AskadeUserNotAvailableYetEx {
        addObject(sessionFactory,currentUser,client);
    }

    /**
     * @param currentUser
     * @param client
     * @throws AskadeNoUserDefinedException
     * @throws AskadeUserExpiredException
     * @throws AskadeUserNotAvailableYetEx
     * @throws AskadeConcurentUpdateException
     */
    @Override
    public void updateClient(String currentUser, Client client) throws AskadeNoUserDefinedException, AskadeUserExpiredException, AskadeUserNotAvailableYetEx, AskadeConcurentUpdateException {

    }

    /**
     * @return
     */
    @Override
    public List<Client> listClients() {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from Client");
        return query.list();
    }

    /**
     * @param clientId
     * @return
     */
    @Override
    public Client getClientById(BigInteger clientId) {
        return null;
    }
}

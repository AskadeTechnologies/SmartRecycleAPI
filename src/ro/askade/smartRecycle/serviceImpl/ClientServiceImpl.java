package ro.askade.smartRecycle.serviceImpl;

import org.springframework.stereotype.Service;
import ro.askade.smartRecycle.dao.ClientDao;

/**
 * Created by AdrianIonita on 3/8/2017.
 */
@Service
public class ClientServiceImpl {

    private ClientDao clientDao;

    public void setClientDao(ClientDao clientDao) {
        this.clientDao = clientDao;
    }

    public ClientDao getClientDao() {
        return clientDao;
    }
}

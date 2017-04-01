package ro.askade.smartRecycle.serviceImpl;

import org.springframework.stereotype.Service;
import ro.askade.smartRecycle.dao.UserDao;
import ro.askade.smartRecycle.exception.*;
import ro.askade.smartRecycle.model.User;
import ro.askade.smartRecycle.service.RecycleUserService;
import ro.askade.smartRecycle.utils.GenericDaoImpl;

import javax.transaction.Transactional;
import java.math.BigInteger;
import java.util.List;

/**
 * Created by AdrianIonita on 3/8/2017.
 */
@Service
public class RecycleUserServiceImpl implements RecycleUserService {
    private UserDao userDao;

    /**
     * @param UserDao
     */
    public void setUserDAO(UserDao UserDao) {
        this.userDao = UserDao;
    }


    /**
     * @param currentUser
     * @param user
     * @throws AskadeNoUserDefinedException
     * @throws AskadeUserNotAvailableYetEx
     * @throws AskadeUserExpiredException
     */
    @Override
    @Transactional
    public void addUser(String currentUser, User user) throws AskadeNoUserDefinedException, AskadeUserNotAvailableYetEx, AskadeUserExpiredException {
        userDao.addUser(currentUser, user);
    }

    /**
     * @param currentUser
     * @param user
     * @throws AskadeNoUserDefinedException
     * @throws AskadeUserNotAvailableYetEx
     * @throws AskadeUserExpiredException
     * @throws AskadeConcurentUpdateException
     */
    @Override
    @Transactional
    public void updateUser(String currentUser, User user) throws AskadeNoUserDefinedException, AskadeUserNotAvailableYetEx, AskadeUserExpiredException, AskadeConcurentUpdateException {
        userDao.updateUser(currentUser, user);
    }

    @Override
    @Transactional
    public List<User> listUsers() {
        return userDao.listUsers();
    }

    /**
     * @param userCode
     * @return
     */
    @Override
    @Transactional
    public User getUserByCode(String userCode) {
        return userDao.getUserByCode(userCode);
    }

    @Override
    public void removePerson(int id) {

    }

    /**
     * @param userId
     * @return
     */
    @Override
    @Transactional
    public User getUserById(BigInteger userId) {
        return userDao.getUserById(userId);
    }

    /**
     * @param user
     * @return
     * @throws AskadeUserNotAvailableYetEx
     * @throws AskadeUserExpiredException
     * @throws AskadeIncorrectPasswordException
     */
    @Override
    @Transactional
    public User loginUser(User user) throws AskadeUserNotAvailableYetEx, AskadeUserExpiredException, AskadeIncorrectPasswordException {
        return userDao.loginUser(user);
    }
}

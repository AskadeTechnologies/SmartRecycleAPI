package ro.askade.smartRecycle.controller;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ro.askade.smartRecycle.exception.*;
import ro.askade.smartRecycle.model.User;
import ro.askade.smartRecycle.service.RecycleUserService;
import ro.askade.smartRecycle.utils.JsonResponse;

import java.math.BigInteger;

/**
 * Created by AdrianIonita on 4/1/2017.
 */
@Controller
@CrossOrigin
public class RecycleUserController {
    public static final Logger logger = LogManager.getLogger(RecycleUserController.class);
    @Autowired
    private RecycleUserService userService;

    /**
     * @return
     */
    @RequestMapping(value = "/userController/getRecycleUserList", method = RequestMethod.GET)
    public @ResponseBody JsonResponse getRecycleUserList(){
        logger.log(Level.TRACE,"verificare");
        return JsonResponse.forSuccess(userService.listUsers());
    }

    /**
     * @param userCode
     * @return
     */
    @RequestMapping(value = "/userController/getRecycleUser", method = RequestMethod.GET)
    public @ResponseBody JsonResponse getRecycleUser(@RequestParam(value = "userCode", required = true) String userCode){
        return JsonResponse.forSuccess(userService.getUserByCode(userCode));
    }

    /**
     * @param userId
     * @return
     */
    @RequestMapping(value = "/userController/getRecycleUserById", method = RequestMethod.GET)
    public @ResponseBody JsonResponse getRecycleUserById(@RequestParam(value = "userId", required = true)BigInteger userId){
        return JsonResponse.forSuccess(userService.getUserById(userId));
    }

    /**
     * @param currentUser
     * @param user
     * @return
     */
    @RequestMapping(value = "/userController/updateRecycleUser", method = RequestMethod.POST)
    public @ResponseBody JsonResponse updateRecycleUser(@RequestHeader("currentUser") String currentUser, @RequestBody User user){
        if (user.getUserId() == null){
            return JsonResponse.forError("User id was not determined");
        }else{
            try {
                userService.updateUser(currentUser,user);
            } catch (AskadeNoUserDefinedException e) {
                return JsonResponse.forError(e.getMessage());
            } catch (AskadeUserNotAvailableYetEx e) {
                return JsonResponse.forError(e.getMessage());
            } catch (AskadeUserExpiredException e) {
                return JsonResponse.forError(e.getMessage());
            } catch (AskadeConcurentUpdateException e) {
                return JsonResponse.forError(e.getMessage());
            }
        }
        return JsonResponse.forSuccess();
    }

    /**
     * @param currentUser
     * @param user
     * @return
     */
    @RequestMapping(value = "/userController/setRecycleUser", method = RequestMethod.POST)
    public @ResponseBody JsonResponse createRecycleUser(@RequestHeader ("currentUser") String currentUser,@RequestBody User user){
        try {
            userService.addUser(currentUser, user);
        } catch (AskadeNoUserDefinedException e) {
            return JsonResponse.forError(e.getMessage());
        } catch (AskadeUserExpiredException e) {
            return JsonResponse.forError(e.getMessage());
        } catch (AskadeUserNotAvailableYetEx e) {
            return JsonResponse.forError(e.getMessage());
        }
        return JsonResponse.forSuccess();
    }

    /**
     * @param recyclingUser
     * @return
     */
    //@CrossOrigin(origins = "http://localhost:9080", maxAge = 3600)
    @RequestMapping(value = "/userController/loginUser", method = RequestMethod.POST)
    public @ResponseBody JsonResponse loginUser(@RequestBody User recyclingUser){
        User user = null;
        try {
            user = userService.loginUser(recyclingUser);
        } catch (AskadeUserNotAvailableYetEx askadeUserNotAvailableYetEx) {
            return JsonResponse.forError(askadeUserNotAvailableYetEx.getMessage());
        } catch (AskadeUserExpiredException e) {
            return JsonResponse.forError(e.getMessage());
        } catch (AskadeIncorrectPasswordException e) {
            return JsonResponse.forError(e.getMessage());
        }
        if(user != null){
            return JsonResponse.forSuccess(user);
        }else{
            return JsonResponse.forError("User does not exists");
        }
    }
}

package ro.askade.smartRecycle.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import ro.askade.smartRecycle.service.ClientService;
import ro.askade.smartRecycle.service.RecycleUserService;

/**
 * Created by AdrianIonita on 3/8/2017.
 */
@Controller
@CrossOrigin
public class ClientController {
    public static final Logger logger = LogManager.getLogger(ClientController.class);
    @Autowired
    private RecycleUserService userService;

    @Autowired
    private ClientService clientService;


}

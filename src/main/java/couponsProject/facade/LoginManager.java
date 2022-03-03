package couponsProject.facade;

import couponsProject.utils.DateUtils;

import javax.security.auth.login.LoginException;
import java.sql.Date;

public class LoginManager {

    private static LoginManager instance = null;


    private LoginManager() {
    }


    public static LoginManager getInstance() {
        if (instance == null) {
            synchronized (LoginManager.class) {
                if (instance == null) {
                    instance = new LoginManager();
                }
            }
        }
        return instance;
    }


    public ClientFacade login(String email, String password, ClientType clientType) throws LoginException {
        switch (clientType) {

            case ADMINISTRATOR:
                ClientFacade adminFacade = new AdminFacade();
                if (!adminFacade.login(email, password)) {
                    throw new LoginException("Invalid username or password");
                }
                System.out.println(DateUtils.getLocalDateTime() + email + " was logged ");
                return adminFacade;


            case COMPANY:
                ClientFacade companyFacade = new CompanyFacade();
                if (!companyFacade.login(email, password)) {
                    throw new LoginException("Invalid username or password");
                }
                System.out.println(DateUtils.getLocalDateTime() + email + " was logged ");
                return companyFacade;


            case CUSTOMER:
                ClientFacade customerFacade = new CustomerFacade();
                if (!customerFacade.login(email, password)) {
                    throw new LoginException("Invalid username or password");
                }
                System.out.println(DateUtils.getLocalDateTime() + email + " was logged ");
                return customerFacade;


        }
        return null;
    }
}

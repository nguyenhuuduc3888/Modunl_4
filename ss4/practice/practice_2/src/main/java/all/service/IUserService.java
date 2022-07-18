package all.service;

import all.model.Login;
import all.model.User;

public interface IUserService {
    User checkLogin(Login login);

}

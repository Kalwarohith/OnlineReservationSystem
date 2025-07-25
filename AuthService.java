package service;

import model.User;
import util.DataStore;

public class AuthService {
    public static boolean login(String userId, String password) {
        User user = DataStore.users.get(userId);
        return user != null && user.getPassword().equals(password);
    }
}

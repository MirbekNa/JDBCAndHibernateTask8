package peaksoft.dao;

import peaksoft.model.User;

import java.util.List;

public class UserDaoHibernateImpl implements UserDao {

    public UserDaoHibernateImpl() {

    }

    @Override
    public void createUsersTable() {
cleanUsersTable();
    }

    @Override
    public void dropUsersTable() {
dropUsersTable();
    }

    @Override
    public void saveUser(String name, String lastName, byte age) {
saveUser(name,lastName,age);
    }

    @Override
    public void removeUserById(long id) {
removeUserById(id);
    }

    @Override
    public List<User> getAllUsers() {
        return getAllUsers();
    }

    @Override
    public void cleanUsersTable() {
cleanUsersTable();
    }
}

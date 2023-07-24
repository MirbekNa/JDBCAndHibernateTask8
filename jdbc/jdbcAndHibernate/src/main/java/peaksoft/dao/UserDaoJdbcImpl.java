package peaksoft.dao;

import peaksoft.model.User;
import peaksoft.util.Util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDaoJdbcImpl implements UserDao {
    private Util util = new Util();
    public UserDaoJdbcImpl() {

    }

    @Override
    public void createUsersTable() {
        try (Connection connection = util.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(
                     "CREATE TABLE IF NOT EXISTS users (" +
                             "id SERIAL PRIMARY KEY, " +
                             "name VARCHAR(255), " +
                             "last_name VARCHAR(255), " +
                             "age INT)"
             )) {
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void dropUsersTable() {
        try (Connection connection = util.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(
                     "DROP TABLE IF EXISTS users"
             )) {
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void saveUser(String name, String lastName, byte age) {
        try (Connection connection = util.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(
                     "INSERT INTO users (name, last_name, age) VALUES (?, ?, ?)"
             )) {
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, lastName);
            preparedStatement.setByte(3, age);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void removeUserById(long id) {
        try (Connection connection = util.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(
                     "DELETE FROM users WHERE id = ?"
             )) {
            preparedStatement.setLong(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<User> getAllUsers() {
        List<User> users = new ArrayList<>();
        try (Connection connection = util.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(
                     "SELECT * FROM users"
             )) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                long id = resultSet.getLong("id");
                String name = resultSet.getString("name");
                String lastName = resultSet.getString("last_name");
                byte age = resultSet.getByte("age");
                users.add(new User(id, name, lastName, age));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }

    @Override
    public void cleanUsersTable() {
        try (Connection connection = util.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(
                     "DELETE FROM users"
             )) {
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
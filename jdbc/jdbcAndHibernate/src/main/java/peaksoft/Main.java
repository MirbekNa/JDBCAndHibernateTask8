package peaksoft;

import peaksoft.model.User;
import peaksoft.service.UserService;
import peaksoft.service.UserServiceImpl;

import java.util.List;
import peaksoft.model.User;
import peaksoft.service.UserService;
import peaksoft.service.UserServiceImpl;

public class Main {
    public static void main(String[] args) {
        // Создаем объект UserServiceImpl
        UserService userService = new UserServiceImpl();

        // Создаем таблицу users, если она не существует
        userService.createUsersTable();

        // Добавляем 4 пользователя в базу данных
        userService.saveUser("John", "Doe", (byte) 30);
        userService.saveUser("Alice", "Smith", (byte) 25);
        userService.saveUser("Bob", "Johnson", (byte) 35);
        userService.saveUser("Eve", "Brown", (byte) 28);

        // Получаем всех пользователей из базы данных и выводим их на консоль
        System.out.println("All Users:");
        for (User user : userService.getAllUsers()) {
            System.out.println(user);
        }

        // Очищаем таблицу users
        userService.cleanUsersTable();

        // Удаляем таблицу users
        userService.dropUsersTable();
    }
}

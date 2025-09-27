package module_2;

import module_2.entity.User;
import module_2.service.UserService;

import java.util.List;
import java.util.Scanner;

public class MainApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        UserService userService = new UserService();

        while (true) {
            System.out.println("\nМеню: ");
            System.out.println("1. Создать нового пользователя");
            System.out.println("2. Найти пользователя по ID");
            System.out.println("3. Изменить существующего пользователя");
            System.out.println("4. Удалить пользователя");
            System.out.println("5. Показать всех пользователей");
            System.out.println("6. Выход");

            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1:
                    createUser(scanner, userService);
                    break;
                case 2:
                    findUser(scanner, userService);
                    break;
                case 3:
                    updateUser(scanner, userService);
                    break;
                case 4:
                    deleteUser(scanner, userService);
                    break;
                case 5:
                    showAllUsers(userService);
                    break;
                case 6:
                    System.out.println("Выход...");
                    System.exit(0);
                default:
                    System.out.println("Неверный выбор.");
            }
        }
    }

    private static void createUser(Scanner scanner, UserService userService) {
        System.out.println("Имя: ");
        String name = scanner.nextLine();
        System.out.println("Email: ");
        String email = scanner.nextLine();
        System.out.println("Возраст: ");
        int age = scanner.nextInt();
        scanner.nextLine();

        User user = new User(name, email, age);
        userService.addUser(user);
        System.out.println("Пользователь успешно создан!");
    }

    private static void findUser(Scanner scanner, UserService userService) {
        System.out.print("ID пользователя: ");
        int id = scanner.nextInt();
        User user = userService.getUserById(id);
        if (user != null) {
            System.out.println("Пользователь найден:\n" + user);
        } else {
            System.out.println("Пользователь не найден.");
        }
    }

    private static void updateUser(Scanner scanner, UserService userService) {
        System.out.print("ID пользователя для обновления: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        User existingUser = userService.getUserById(id);

        if (existingUser == null) {
            System.out.println("Пользователь не найден.");
            return;
        }

        System.out.print("Обновленное имя: ");
        String name = scanner.nextLine();
        System.out.print("Обновленный Email: ");
        String email = scanner.nextLine();
        System.out.print("Обновленный возраст: ");
        int age = scanner.nextInt();
        scanner.nextLine();

        existingUser.setName(name);
        existingUser.setEmail(email);
        existingUser.setAge(age);
        userService.editUser(existingUser);
        System.out.println("Пользователь успешно обновлен!");
    }

    private static void deleteUser(Scanner scanner, UserService userService) {
        System.out.print("ID пользователя для удаления: ");
        int id = scanner.nextInt();
        userService.removeUser(id);
        System.out.println("Пользователь успешно удалён!");
    }

    private static void showAllUsers(UserService userService) {
        List<User> users = userService.listUsers();
        for (User u : users) {
            System.out.println(u.toString());
        }
    }
}



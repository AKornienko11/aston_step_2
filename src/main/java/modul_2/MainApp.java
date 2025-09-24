package modul_2;



import modul_2.entity.User;
import modul_2.service.UserService;

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

            switch (scanner.nextInt()) {
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
                   // showAllUsers(userService);
                    break;
                case 6:
                    System.out.println("Выход...");
                    //userService.close();
                    System.exit(0);
                default:
                    System.out.println("Неверный выбор.");
            }
        }
    }

    private static void createUser(Scanner scanner, UserService userService) {
        System.out.print("Имя: ");
        String name = scanner.nextLine();
        System.out.print("Email: ");
        String email = scanner.nextLine();
        System.out.print("Возраст: ");
        int age = scanner.nextInt();
        scanner.nextLine();

        User user = new User(name, email, age);
        userService.addUser(user);
        System.out.println("Пользователь успешно создан!");
    }

    private static void findUser(Scanner scanner, UserService userService) {
        System.out.print("ID пользователя: ");
        long id = scanner.nextLong();
        User user = userService.getUserById(id);
        if (user != null) {
            System.out.println("Пользователь найден:\n" + user.toString());
        } else {
            System.out.println("Пользователь не найден.");
        }
    }

    private static void updateUser(Scanner scanner, UserService userService) {
        System.out.print("ID пользователя для обновления: ");
        long id = scanner.nextLong();
        scanner.nextLine(); // consume newline

        User existingUser = userService.getUserById(id);
        if (existingUser != null) {
            System.out.print("Обновленное имя: ");
            String name = scanner.nextLine();
            System.out.print("Обновленный Email: ");
            String email = scanner.nextLine();
            System.out.print("Обновленный возраст: ");
            int age = scanner.nextInt();
            scanner.nextLine(); // consume newline

            existingUser.setName(name);
            existingUser.setEmail(email);
            existingUser.setAge(age);
           // userService.editUser(existingUser);
            System.out.println("Пользователь успешно обновлен!");
        } else {
            System.out.println("Пользователь не найден.");
        }
    }

    private static void deleteUser(Scanner scanner, UserService userService) {
        System.out.print("ID пользователя для удаления: ");
        long id = scanner.nextLong();
      //  userService.removeUser(id);
        System.out.println("Пользователь успешно удалён!");
    }

//    private static void showAllUsers(UserService userService) {
//        List<User> users = userService.listUsers();
//        for (User u : users) {
//            System.out.println(u.toString());
//        }
//    }
}

package datatelephone.view;

import datatelephone.model.Gender;
import datatelephone.presenter.Presenter;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.Scanner;
import datatelephone.model.CheckMethods;

public class ConsoleUI implements View {
    private Scanner scanner;
    private Presenter presenter;
    private boolean work;
    private CheckMethods check = new CheckMethods();

    public ConsoleUI() {
        this.scanner = new Scanner(System.in);
        this.presenter = new Presenter(this);
        this.work = true; // Инициализируем работу
    }

    @Override
    public void printAnswer(String answer) {
        System.out.println(answer);
    }

    public void start() {
        System.out.println("Выберите нужный пункт меню.\n");
        while (work) {
            System.out.println("1. Добавить человека.");
            System.out.println("2. Удалить человека.");
            System.out.println("3. Показать список сотрудников.");
            System.out.println("4. Выйти.");
            System.out.print("Ваш выбор: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (choice) {
                case 1:
                    addHumanInBook();
                    break;
                case 2:
                    humanDelete();
                    break;
                case 3:
                    presenter.getList();
                    break;
                case 4:
                    work = false;
                    break;
                default:
                    System.out.println("Неверный выбор. Пожалуйста, попробуйте снова.");
            }
        }
    }

    public void addHumanInBook() {
        String name = getValidInput("Введите имя: ", "Введите корректное имя: ");
        String surname = getValidInput("Введите фамилию: ", "Введите корректную фамилию: ");

        LocalDate bdate = null;
        while (bdate == null) {
            System.out.print("Введите дату рождения (гггг.мм.дд): ");
            String bdateInput = scanner.nextLine();
            try {
                bdate = LocalDate.parse(bdateInput.replace(".", "-"));
            } catch (DateTimeParseException e) {
                System.out.println("Неверный формат даты. Пожалуйста, попробуйте снова.");
            }
        }

        Gender.Type gender = getGenderInput();

        String telephone = getValidNumber("Введите номер телефона: ", "Введите корректный номер телефона: ");
//        System.out.print("Введите номер телефона: ");
//        String telephone = scanner.nextLine();

        presenter.addHuman(name, surname, bdate, gender, telephone);
        System.out.println("Человек добавлен: " + name + " " + surname);
    }

    private String getValidInput(String prompt, String errorMessage) {
        String input;
        while (true) {
            System.out.print(prompt);
            input = scanner.nextLine();
            if (!input.isEmpty() && check.checkString(input)) {
                return input;
            }
            System.out.println(errorMessage);
        }
    }
    private String getValidNumber(String prompt, String errorMessage) {
        String input;
        while (true) {
            System.out.print(prompt);
            input = scanner.nextLine();
            try {
                Long.parseLong(input);
                return input;
            } catch (NumberFormatException e) {
                System.out.println(errorMessage);
            }
        }
    }

    private Gender.Type getGenderInput() {
        while (true) {
            System.out.print("Введите пол (м/ж): ");
            String genderInput = scanner.nextLine();
            if (genderInput.equalsIgnoreCase("м")) {
                return Gender.Type.MALE;
            } else if (genderInput.equalsIgnoreCase("ж")) {
                return Gender.Type.FEMALE;
            } else {
                System.out.println("Неверный ввод. Пожалуйста, введите 'м' или 'ж'.");
            }
        }
    }

    public void humanDelete() {
        System.out.print("Введите имя сотрудника для удаления: ");
        String name = scanner.nextLine();
        presenter.deleteHuman(name);
    }
}

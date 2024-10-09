package datatelephone.presenter;

import datatelephone.model.Gender;
import datatelephone.model.Human;
import datatelephone.model.PhoneBook;
import java.time.LocalDate;

public class Service implements ServiceInterface {
    private Human human;
    private PhoneBook book;


    public Service() {
        this.book = new PhoneBook();
    }
    public void addHum(String name, String surname, LocalDate bdate, Gender.Type gender, String telephone) {
        this.human = new Human(name, surname, bdate, gender, telephone);
        book.addHuman(human);
    }
    @Override
    public void getListHuman() {
        String answer = book.toString();
        System.out.println(answer);
    }
    
    @Override
    public void deleteHuman(String name) {
        boolean isDeleted = book.delHuman(name); // Assuming delHuman returns a boolean indicating success
        if (isDeleted) {
            System.out.println("Человек с именем " + name + " был успешно удален из телефонной книги.");
        } else {
            System.out.println("Человек с именем " + name + " не найден в телефонной книге.");
        }
        getListHuman(); // Refresh the list of humans
    }



}

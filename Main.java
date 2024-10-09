import datatelephone.model.Gender;
import datatelephone.model.Human;
import datatelephone.model.PhoneBook;
import datatelephone.view.ConsoleUI;
import datatelephone.view.View;
import java.time.LocalDate;
import datatelephone.presenter.Presenter;

public class Main {
    public static void main(String[] args) {
        View view = new ConsoleUI();
        view.start();
    }
}
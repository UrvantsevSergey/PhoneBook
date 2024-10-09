package datatelephone.model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class PhoneBook {
    private List<Human> phonebook;

    public PhoneBook() {
        this.phonebook = new ArrayList<>();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Список сотрудников: \n");
        if (phonebook.isEmpty()) {
            sb.append("Телефонная книга пуста.\n");
        } else {
            for (Human human : phonebook) {
                sb.append(human);
                sb.append("\n");
            }
        }
        return sb.toString();
    }

    public void addHuman(Human human) {
        if (human != null) {
            phonebook.add(human);
        } else {
            System.out.println("Невозможно добавить пустого человека.");
        }
    }

    public void removeHuman(Human human) {
        if (phonebook.remove(human)) {
            System.out.println("Человек успешно удален из телефонной книги.");
        } else {
            System.out.println("Человек не найден в телефонной книге.");
        }
    }

    public List<Human> getPhonebook() {
        return new ArrayList<>(phonebook); // Возвращаем копию списка
    }

    public boolean delHuman(String name) {
        Iterator<Human> iterator = phonebook.iterator();
        while (iterator.hasNext()) {
            Human human = iterator.next();
            if (human.getName().equalsIgnoreCase(name)) {
                iterator.remove(); // Safely remove the human
                return true; // Indicate success
            }
        }
        return false; // Indicate failure if not found
    }
    
    
}

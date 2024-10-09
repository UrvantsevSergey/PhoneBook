package datatelephone.model;

import java.time.LocalDate;

public class Human {
    private String name;
    private String surname;
    private LocalDate bdate; // Поле для даты рождения
    private Gender.Type gender; // Поле для пола
    private String telephone; // Поле для номера телефона

    // Конструктор с параметрами
    public Human(String name, String surname, LocalDate bdate, Gender.Type gender, String telephone) {
        this.name = name;
        this.surname = surname;
        this.bdate = bdate;
        this.gender = gender;
        this.telephone = telephone; // Инициализация номера телефона
    }

    // Пустой конструктор
    public Human() {
        this.name = "";
        this.surname = "";
        this.bdate = null; // Инициализация даты рождения
        this.gender = null; // Инициализация пола
        this.telephone = ""; // Инициализация номера телефона
    }

    @Override
    public String toString() {
        return "Имя: " + name + ", Фамилия: " + surname + ", Дата рождения: " + bdate + ", Пол: " + gender + ", Телефон: " + telephone;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBdate(LocalDate bdate) {
        this.bdate = bdate;
    }

    public void setGender(Gender.Type gender) {
        this.gender = gender;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getSurname() {
        return surname;
    }

    public String getName() {
        return name;
    }

    public LocalDate getBdate() {
        return bdate;
    }

    public Gender.Type getGender() {
        return gender;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setPhoneNumber(String string) {
        this.telephone = string;
    }
}

package actions.utilities;

import com.github.javafaker.Faker;

import java.util.Locale;

public class DataHelper {

    private final Locale locale = new Locale("eng");
    private final Faker faker = new Faker(locale);

    public static DataHelper getDataFaker() {
        return new DataHelper();
    }

    public String getFirstname() {
        return faker.address().firstName();
    }

    public String getEditFirstname() {
        return faker.address().firstName();
    }

    public String getLastname() {
        return faker.address().lastName();
    }

    public String getEditLastname() {
        return faker.address().lastName();
    }

    public String getCompanyName() {
        return faker.company().name();
    }

    public String getFullName() {
        return getFirstname() + getLastname();
        //return faker.name().fullName();
    }

    public String getEditFullName() {
        return getEditFirstname() + getEditLastname();
        //return faker.name().fullName();
    }

    public String getAddress() {
        return faker.address().streetAddress();
    }

    public String getEmail() {
        return faker.internet().emailAddress();
    }

    public String getPhone() {
        return faker.phoneNumber().phoneNumber();
    }

    public String getCity() {
        return faker.address().city();
    }

    public String getPassword() {
        return faker.internet().password(6, 10);
    }
}

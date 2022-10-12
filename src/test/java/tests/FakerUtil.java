package tests;

import com.github.javafaker.Faker;

public class FakerUtil {
    private static Faker faker = new Faker();

    private static String email = faker.name().firstName() + "." + faker.name().lastName() + "@gmail.com";
    private static String password = faker.color().name() + faker.cat().name() + faker.number().digit();
    private static String confirmPassword = password;
    private static String firstName = faker.name().firstName();
    private static String lastName = faker.name().lastName();
    private static String fullName = firstName + " " + lastName;
    private static String city = faker.address().city();
    private static String editedCity = city + " - edited";
    private static String country = faker.address().country();
    private static String phoneNumber = "3816" + faker.number().digits(8);
    private static String randomEmail = faker.internet().emailAddress();

    public static String getRandomEmail() {
        return email;
    }

    public static String getRandomPassword() {
        return password;
    }

    public static String getRandomFirstName() {
        return firstName;
    }

    public static String getRandomLastName() {
        return lastName;
    }

    public static String getRandomFullName() {
        return fullName;
    }

    public static String getConfirmPassword() {
        return confirmPassword;
    }

    public static String getRandomCity() {
        return city;
    }

    public static String getEditedCity() {
        return editedCity;
    }

    public static String getRandomPhoneNumber() {
        return phoneNumber;
    }

    public static String getRandomCountry() {
        return country;
    }

    public static String getRandomEmailFaker() {
        return getRandomEmail();
    }
}

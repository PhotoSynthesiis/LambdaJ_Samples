package filters;

public class Person {
    private String givenName;

    private String familyName;
    private int age;
    public Person(String givenName, String familyName, int age) {
        this.givenName = givenName;
        this.familyName = familyName;
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public String getGivenName() {
        return givenName;
    }
}

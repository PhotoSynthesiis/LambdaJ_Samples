package stringConcatenation;

import filters.Person;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static ch.lambdaj.Lambda.join;
import static ch.lambdaj.Lambda.joinFrom;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class TestStringConcatenation {
    @Test
    public void shouldJoinString() {
        List<String> stringList = Arrays.asList("Bangalore", "is", "not", "a", "nice", "place");
        String resultString = join(stringList, " ");
        String expectedString = "Bangalore is not a nice place";

        assertThat(expectedString, is(resultString));
    }

    @Test
    public void anotherWayOfJoiningString() {
        List<Person> personList = Arrays.asList(new Person("Qiushi", "Li", 24), new Person("Yan", "Mo", 23),
                new Person("Bowen", "Huang", 26), new Person("Pengfei", "Cui", 25), new Person("Yao", "Yao", 31),
                new Person("Zhewu", "Zhou", 25));
        String resultString = joinFrom(personList, " - ").getGivenName();
        String expectedString = "Qiushi" + " - " + "Yan" + " - " + "Bowen" + " - " + "Pengfei" + " - "
                + "Yao" + " - " + "Zhewu";

        assertThat(expectedString, is(resultString));
    }
}

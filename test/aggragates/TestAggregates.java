package aggragates;

import filters.Person;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static ch.lambdaj.Lambda.on;
import static ch.lambdaj.Lambda.sum;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class TestAggregates {
    @Test
    public void testAggregating() {
        List<Integer> numberList = Arrays.asList(1, 2, 3, 4, 5);
        int expectedResult = 15;

        Number resultByLambdaj = sum(numberList);
        assertThat(expectedResult, is(resultByLambdaj.intValue()));
    }

    @Test
    public void testTotalizeAge() {
        List<Person> personList = Arrays.asList(new Person("Qiushi", "Li", 24), new Person("Yan", "Mo", 23),
                new Person("Bowen", "Huang", 26), new Person("Pengfei", "Cui", 25), new Person("Yao", "Yao", 31),
                new Person("Zhewu", "Zhou", 25));
        int totalAge = sum(personList, on(Person.class).getAge());
        int expectedAge = 154;

        assertThat(expectedAge, is(totalAge));
    }
}

package filters;

import ch.lambdaj.function.matcher.Predicate;
import org.hamcrest.Matcher;
import org.hamcrest.Matchers;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static ch.lambdaj.Lambda.*;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.greaterThanOrEqualTo;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class TestFilters {
    @Test
    public void testGreaterThanThree() {
        List<Integer> numberList = Arrays.asList(4, 2, 5, 1, 3);
        List<Integer> expectedList = Arrays.asList(4, 5);

        List<Integer> sortedNumberList = filter(greaterThan(3), numberList);

        assertThat(expectedList, is(sortedNumberList));
    }

    @Test
    public void testDefineYourOwnMatcher() {
        List<Integer> numberList = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 13, 14, 68);
        List<Integer> sortedList = filter(selfDefinedOddSelectionMatcher(), numberList);

        List<Integer> expectedList = Arrays.asList(1, 3, 5, 7, 9, 13);

        assertThat(expectedList, Matchers.is(sortedList));
    }

    @Test
    public void testFilterObjects() {
        Person qiushi = new Person("Qiushi", "Li", 24);
        Person moyan = new Person("Yan", "Mo", 23);
        Person bowen = new Person("Bowen", "Huang", 26);
        Person pengfei = new Person("Pengfei", "Cui", 25);
        Person yaoyao = new Person("Yao", "Yao", 31);
        Person jojo = new Person("Zhewu", "Zhou", 25);

        List<Person> personList = Arrays.asList(qiushi, moyan, bowen, pengfei, yaoyao, jojo);
        List<Person> expectedList = Arrays.asList(bowen, pengfei, yaoyao, jojo);
        //  the method T on(Class<T> clazz) returns a proxy object that mocks the given Class,
        //  registering all the subsequent invocations on the objects of that Class.
        List<Person> sortedPersonList = filter(having(on(Person.class).getAge(), greaterThanOrEqualTo(25)), personList);

        assertThat(expectedList, Matchers.is(sortedPersonList));
    }

    private Matcher<Integer> selfDefinedOddSelectionMatcher() {
        return new Predicate<Integer>() {
            @Override
            public boolean apply(Integer integer) {
                return integer % 2 == 1;
            }
        };
    }
}

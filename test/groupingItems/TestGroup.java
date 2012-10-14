package groupingItems;

import ch.lambdaj.group.Group;
import filters.Person;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static ch.lambdaj.Lambda.group;
import static ch.lambdaj.Lambda.on;
import static ch.lambdaj.group.Groups.by;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class TestGroup {
    @Test
    public void testGroupByAge() {
        List<Person> personList = Arrays.asList(new Person("Qiushi", "Li", 24), new Person("Yan", "Mo", 23),
                new Person("Bowen", "Huang", 26), new Person("Pengfei", "Cui", 25), new Person("Yao", "Yao", 31),
                new Person("Zhewu", "Zhou", 25));

        Group<Person> groupedPerson = group(personList, by(on(Person.class).getAge()));
        Group<Person> groupPersonAgeIs25 = groupedPerson.findGroup("25");
        assertThat(2, is(groupPersonAgeIs25.getSize()));
    }

    @Test
    public void testGroupFirstByAgeThenByGivenName() {
        List<Person> personList = Arrays.asList(new Person("Qiushi", "Li", 24), new Person("Yan", "Mo", 23),
                new Person("Bowen", "Huang", 26), new Person("Pengfei", "Cui", 25), new Person("Yao", "Yao", 31),
                new Person("Zhewu", "Zhou", 25), new Person("Lianhao", "Gao", 25), new Person("Mengqiu", "Peng", 25));

        Group<Person> groupedPerson = group(personList, by(on(Person.class).getAge()), by(on(Person.class).getGivenName()));
        Group<Person> groupedPersonAgeIs25 = groupedPerson.findGroup("25");
        assertThat(4, is(groupedPersonAgeIs25.getSize()));
    }
}

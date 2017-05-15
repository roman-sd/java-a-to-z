package ru.sdroman.pro.map;

import org.junit.Before;
import org.junit.Test;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;


/**
 * @author sdroman
 * @since 05.2017
 */
public class MapTest {

    /**
     * Map.
     */
    private Map<User, String> map;

    /**
     * First user.
     */
    private User first;

    /**
     * Second user.
     */
    private User second;

    /**
     * User's birthday.
     */
    private Calendar birthday = new GregorianCalendar(74, 1, 1);

    /**
     * Setup.
     */
    @Before
    public void setUp() {
        map = new HashMap<>();
    }

    /**
     * В результате выполнения получаем два объекта. Это происходит
     * потому, что у этих двух объектов разные значения функции hash().
     */
    @Test
    public void whenNotOverrideHashCodeAndEqualsThenAddsTwoObjects() {
        first = new User("userName", 2, birthday);
        second = new User("userName", 2, birthday);
        map.put(first, "firstUser");
        map.put(second, "secondUser");
        System.out.println(map);
        System.out.println(map.size());
    }

    /**
     * В результате выполнения получим два объекта.
     * После переопределения метода hashCode(), хешкод этих объектов одинаков, но
     * разные значения. Возникла колизия. Объекты помешены в одну корзину,
     * создалась цепочка(связный список).
     */
    @Test
    public void whenOverrideHashCodeThenAddsTwoObjectsInBasket() {
        first = new UserOverrideHashCode("userName", 2, birthday);
        second = new UserOverrideHashCode("userName", 2, birthday);
        map.put(first, "firstUser");
        map.put(second, "secondUser");
        System.out.println(map);
    }

    /**
     * Создается два объекта, результат функции hash() разный.
     * Объекты добавлены в разные корзины.
     */
    @Test
    public void whenOverrideEqualsThenAddsTwoObject() {
        first = new UserOverrideEquals("userName", 2, birthday);
        second = new UserOverrideEquals("userName", 2, birthday);
        map.put(first, "firstUser");
        map.put(second, "secondUser");
        System.out.println(map);
    }

    /**
     * В результате получим один объект. Это связано с тем, что были переопределены
     * методы equals и hashCode.
     * Так как метод hashCode переопределен, то хешкоды этих объектов одинаков.
     * Но переопределен и метод equals. Значит объекты одинаковые, значения перезаписываются.
     */
    @Test
    public void whenOverrideEqualsAndHashCodeThenAddsOneObject() {
        first = new UserOverrideHashCodeAndEquals("userName", 2, birthday);
        second = new UserOverrideHashCodeAndEquals("userName", 2, birthday);
        map.put(first, "firstUser");
        map.put(second, "secondUser");
        System.out.println(map);
    }
}

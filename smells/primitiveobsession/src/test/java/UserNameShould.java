import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class UserNameShould {

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void throw_exception_if_value_is_null()
    {
        thrown.expect(IllegalArgumentException.class);

        new UserName(null);
    }

    @Test
    public void throw_exception_if_value_is_empty()
    {
        thrown.expect(IllegalArgumentException.class);

        new UserName("");
    }

    @Test
    public void throw_exception_if_value_contains_spaces()
    {
        thrown.expect(IllegalArgumentException.class);

        new UserName("  xurxodev  ");
    }

    @Test
    public void is_equal_to_another_with_the_same_value()
    {
        UserName username1 = new UserName("xurxodev");
        UserName username2 = new UserName("xurxodev");

        assertThat(username1,is(username2));
    }
}

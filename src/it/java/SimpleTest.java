import fr.maif.junit5.SimpleClass;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class SimpleTest {

    @Test
    public void test() {
        assertThat(SimpleClass.get()).isEqualTo("YO MAMA");
    }

}

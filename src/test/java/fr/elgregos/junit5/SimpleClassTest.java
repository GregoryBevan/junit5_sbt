package fr.elgregos.junit5;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class SimpleClassTest {

    @Test
    public void launch() {
        assertThat(SimpleClass.get()).isEqualTo("YO MAMA");
    }
}
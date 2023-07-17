package ru.job4j.template;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.*;

@Disabled("Тесты отключены. Удалить аннотацию после реализации всех методов по заданию.")
public class TemplateGeneratorTest {
    @Test
    public void whenAllKeysAreInTheMap() {
        Generator generator = new TemplateGenerator();
        Map<String, String> map = new HashMap<>();
        map.put("name", "Petr Arsentev");
        map.put("subject", "you");
        String string = "\"I am a Petr Arsentev, Who are you? \"";
        assertThat(generator.produce("I am a ${name}, Who are ${subject}? ", map)).isEqualTo(string);
    }

    @Test
    public void whenSomeKeysAreNotInTheMap() {
        Generator generator = new TemplateGenerator();
        Map<String, String> map = new HashMap<>();
        map.put("name", "Petr Arsentev");
        map.put("subject", "you");
        assertThatThrownBy(() -> generator.produce("I am a ${name}, Who are ${subject}?, what is your ${surname} ", map)).
                isInstanceOf(Exception.class);
    }

    @Test
    public void whenThereAreExtraKeysInTheMap() {
        Generator generator = new TemplateGenerator();
        Map<String, String> map = new HashMap<>();
        map.put("name", "Petr Arsentev");
        map.put("subject", "you");
        map.put("surname", "Vasechkin");
        assertThatThrownBy(() -> generator.produce("I am a ${name}, Who are ${subject}? ", map)).
                isInstanceOf(Exception.class);
    }

}
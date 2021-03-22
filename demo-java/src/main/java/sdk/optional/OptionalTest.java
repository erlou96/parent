package sdk.optional;

import java.util.Optional;

/**
 * Java8 Option 新特性学习
 */
public class OptionalTest {
    public static void test() {
        System.out.println(Optional.ofNullable(null).orElse(new String("hanzhe")).toString());
    }

    public static void main(String[] args) {
        test();
    }
}

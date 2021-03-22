package sdk.stream;

import org.apache.commons.collections.map.HashedMap;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * java Stream 特性学习
 */
public class StreamTest {
    /**
     * java Stream 特性将list 转为 Map
     */
    public static void list2Map() {
        List<String> list = Arrays.asList("zhangsan","lisi","wangwu");
        Map<Integer, String> map = new HashedMap();

        map = list.stream().collect(Collectors.toMap(str -> list.indexOf(str), str -> str));

        map.forEach((key, value) -> {
            System.out.println(key + "-----" + value);
        });
    }

    /**
     * list 的遍历
     */
    public static void listForEach() {
        List<String> list = Arrays.asList("zhangsan","lisi","wangwu");
        list.forEach(str -> str.toString());
    }

    /**
     * list 排序
     */
    public static void listSort() {
        List<String> list = Arrays.asList("zhangsan","lisi","wangwu");
        list.stream().sorted(String::compareToIgnoreCase).forEach(System.out::println);
    }

    /**
     * map 排序
     */
    public static void mapSort() {
        Map<Integer, String> map = new HashedMap();
        map.put(2, "lisi");
        map.put(1, "zhangsan");
        map.put(4, "wangwu");
        Map<Integer, String> finalMap = new HashMap<>();
        map.entrySet().stream()
                .sorted(Map.Entry.<Integer, String>comparingByKey().reversed())
                .forEachOrdered(e -> finalMap.put(e.getKey(), e.getValue()));
        finalMap.forEach((k, v) -> {
            System.out.println(k + "----" + v);
        });
    }
    public static void main(String[] args) {
        list2Map();
        listSort();
        mapSort();
    }
}

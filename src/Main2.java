import java.util.Map;
import java.util.TreeMap;

public class Main2 {
    public static void main(String[] args) {
        //Задача: дана строка(массив Character)
        //Требуется: найти и вернуть первый наиболее близко расположенный к началу алфовита уникальный символ строки
        //Пример: qwaqeraty => a
        final var input = "qwaqeraty".toCharArray();
        final var expected = 'e';

        //Алгоритм
        var charMap = new TreeMap<Character, Integer>();
        for (var ch: input)
        {
            charMap.put(ch, charMap.getOrDefault(ch, 0) + 1);
        }
        final var actual = charMap.entrySet().stream().
                filter(x -> x.getValue() == 1).
                map(Map.Entry::getKey).
                findFirst().
                orElseThrow();

        assert expected == actual;
        //p.s.: Алгоритм основан на том, что в TreeMap кортежи храняться в порядке возрастания ключей

        //Асимптотическая оценка сложности алгоритма с точностью до постоянного множителя - O(n*log n)
        //Поскольку имеет место полный проход в цикле for по списку(массиву)
        //И на каждой итерации вызывается метод getOrDefault TreeMap
        //Который имеет асимптотическую сложность O(log n)
    }
}

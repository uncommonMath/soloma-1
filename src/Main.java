import java.util.Objects;
import java.util.TreeMap;

record Point(float x, float y) implements Comparable<Point> {
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Point point)) return false;
        return Float.compare(point.x, x) == 0 && Float.compare(point.y, y) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }

    @Override
    public int compareTo(Point o) {
        var dy = y - o.y;
        if (dy != 0) {
            return (int)dy;
        }
        return (int)(x - o.x);
    }

    @Override
    public String toString() {
        return "Point{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}


public class Main {
    public static void main(String[] args) {
        var treeMap = new TreeMap<Point, String>();

        treeMap.put(new Point(1, 2), "A");
        treeMap.put(new Point(1, 3), "C");
        treeMap.put(new Point(5, 2), "B");

        assert treeMap.containsKey(new Point(1, 3));
        assert !treeMap.containsKey(new Point(1, 5));

        treeMap.remove(new Point(5, 2));
        treeMap.forEach((x, y) -> System.out.format("%s -> %s\n", x, y));
    }
}

import java.util.ArrayList;
import java.util.Map;

public class Main3 {
    public static void main(String[] args) {
        Number a = (float)3.5f;
        Number b = (long)4L;
        var list = new ArrayList<Number>();
        list.add(-1);
        list.add(b);
        list.add(a);
        list.add(-5);
        list.add(3.75);
        list.sort((x, y) -> {
            if (Math.signum(x.doubleValue()) == 1 && Math.signum(y.doubleValue()) == 1)
                return (int)(x.doubleValue()-y.doubleValue());
            else return 0;
        });
        System.out.print(list);
    }
}

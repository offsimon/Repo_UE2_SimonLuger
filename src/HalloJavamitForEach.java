import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class HalloJavamitForEach {

    private List<String> list = new ArrayList<>();

    public HalloJavamitForEach() {
        String[] array = new String[]{"a", "b", "c", "d"};
        Collections.addAll(list, array);
    }

    public void printWithForEach() {

        for (String s :
                list) {
            System.out.println(s);
        }
    }

    public void printWithInterface() {
        list.forEach((String s) -> System.out.println(s));
        //list.forEach(System.out::print);
    }
}

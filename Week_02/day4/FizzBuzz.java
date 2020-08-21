import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author yangxing
 * @version 1.0
 * @date 2020/8/20 0020 09:31
 * 412. Fizz Buzz
 * 写一个程序，输出从 1 到 n 数字的字符串表示。
 *
 * 1. 如果 n 是3的倍数，输出“Fizz”；
 *
 * 2. 如果 n 是5的倍数，输出“Buzz”；
 *
 * 3.如果 n 同时是3和5的倍数，输出 “FizzBuzz”。
 *
 * 示例：
 *
 * n = 15,
 *
 * 返回:
 * [
 *     "1",
 *     "2",
 *     "Fizz",
 *     "4",
 *     "Buzz",
 *     "Fizz",
 *     "7",
 *     "8",
 *     "Fizz",
 *     "Buzz",
 *     "11",
 *     "Fizz",
 *     "13",
 *     "14",
 *     "FizzBuzz"
 * ]
 */
public class FizzBuzz {

    public static void main(String[] args) {
        List<String> list = fizzBuzz(15);
        System.out.println(Arrays.toString(list.toArray()));
    }

    public static List<String> fizzBuzz(int n) {
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            if(i % 5 == 0 && i % 3 == 0){
                sb.append("FizzBuzz#");
            }else if(i % 5 == 0){
                sb.append("Buzz#");
            }else if (i % 3 == 0){
                sb.append("Fizz#");
            }else {
                sb.append(i + "#");
            }
        }
        return new ArrayList(Arrays.asList(sb.toString().split("#")));
    }

    public static List<String> fizzBuzz2(int n) {
        List<String> result = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            if(i % 5 == 0 && i % 3 == 0){
                result.add("FizzBuzz");
            }else if(i % 5 == 0){
                result.add("Buzz");
            }else if (i % 3 == 0){
                result.add("Fizz");
            }else {
                result.add(String.valueOf(i));
            }
        }
        return result;
    }
}

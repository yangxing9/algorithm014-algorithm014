import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author yangxing
 * @version 1.0
 * @date 2021/2/1 0001 14:42
 */
public class Test {

    public static void main(String[] args) {
        List<Integer> list = Stream.iterate(1, x -> ++x).limit(43).collect(Collectors.toList());

        for (int i = 0; i < 10; i++) {
//            List<Long> goodsIdList = list.stream().map(a -> a.getGoodsId()).collect(Collectors.toList());

        }

//        list.forEach(System.out::print);
//        System.out.println("==============");
//
//        List<Integer> rr = new ArrayList<>();
//        String res = "";
//        for (int i = 0,count = 1; i < list.size(); i++,count++) {
//            rr.add(list.get(i));
//            if (count >= 10){
////                rr.forEach(System.out::print);
////                System.out.println();
//                res = "a";
//                count = 0;
//                rr.clear();
//            } else if (i == list.size() - 1){
//                res = "b";
//            }
//            System.out.println(res);
//        }
    }

}

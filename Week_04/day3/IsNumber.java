/**
 * @author yangxing
 * @version 1.0
 * @date 2020/9/2 0002 16:39
 * 剑指 Offer 20. 表示数值的字符串
 * 请实现一个函数用来判断字符串是否表示数值（包括整数和小数）。例如，字符串"+100"、"5e2"、"-123"、"3.1416"、"-1E-16"、"0123"都表示数值，但"12e"、"1a3.14"、"1.2.3"、"+-5"及"12e+5.4"都不是。
 */
public class IsNumber {
    public boolean isNumber(String s) {
        if (s == null || s.isEmpty()) return false;
        boolean isNum = false;
        boolean isDot = false;
        boolean isE = false;
        s = s.trim();
        for (int i = 0; i < s.length(); i++) {
            //判定为数字，则标记numFlag
            if (s.charAt(i) >= '0' && s.charAt(i) <= '9'){
                isNum = true;
            // 判定是点的条件是 没出现过点，且 没出现过e
            }else if (s.charAt(i) == '.' && !isDot && !isE){
                isDot = true;
            // 判断是e，需要没出现过e，且出现过数字
            }else if ((s.charAt(i) == 'e' || s.charAt(i) == 'E') && !isE && isNum){
                isE = true;
                // 防止123e这种情况出现，出现e了，就立马将isNum置为false
                isNum = false;
            // 如果出现正负号，则必须是开头，或者前面是e
            }else if((s.charAt(i) == '+' || s.charAt(i) == '-') && (i == 0 || s.charAt(i - 1) == 'e' || s.charAt(i - 1) == 'E')){

            // 其他情况都是false
            }else {
                return false;
            }
        }
        // 返回 数字
        return isNum;
    }

}

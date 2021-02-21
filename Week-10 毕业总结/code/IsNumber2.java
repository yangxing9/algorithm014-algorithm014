/**
 * @author yangxing
 * @version 1.0
 * @date 2020/11/6 0006 17:18
 * 剑指 Offer 20. 表示数值的字符串
 * 请实现一个函数用来判断字符串是否表示数值（包括整数和小数）。例如，字符串"+100"、"5e2"、"-123"、"3.1416"、"-1E-16"、"0123"都表示数值，但"12e"、"1a3.14"、"1.2.3"、"+-5"及"12e+5.4"都不是。
 */
public class IsNumber2 {

    public boolean isNumber(String s) {
        boolean isNum = false;
        boolean isDot = false;
        boolean isE = false;
        s = s.trim();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) >= '0' && s.charAt(i) <= '9'){
                isNum = true;
            }else if (!isDot && !isE && s.charAt(i) == '.'){
                isDot = true;
            }else if ((s.charAt(i) == 'E' || s.charAt(i) == 'e') && isNum && !isE){
                isE = true;
                isNum = false;
            }else if ((s.charAt(i) == '+' || s.charAt(i) == '-') && (i == 0 || s.charAt(i - 1) == 'e' || s.charAt(i - 1) == 'E')){

            }else {
                return false;
            }
        }
        return isNum;
    }

}

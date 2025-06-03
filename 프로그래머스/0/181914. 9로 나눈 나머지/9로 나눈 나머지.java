import java.math.BigDecimal;

class Solution {
    public int solution(String number) {
        return new BigDecimal(number).remainder(new BigDecimal("9")).intValue();
    }
}
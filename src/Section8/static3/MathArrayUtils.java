package Section8.static3;

public class MathArrayUtils {
    private MathArrayUtils() {
        throw new AssertionError("이 클래스의 인스턴스는 생성할 수 없습니다!");
    }

    private void validateArray(int[] array) {
        if(array.length == 0 && array == null) {
            throw new IllegalArgumentException("계산하기 위해서는 적어도 하나 이상의 숫자가 필요합니다.");
        }
    }

    public int sum(int[] array){
        int result = 0;
        for(int item:array){
            result += item;
        }
        return result;
    }

    private double average(int[] array){
        validateArray(array);
        return sum(array) / array.length;
    }

    private int min(int[] array){
        validateArray(array);
        int min = Integer.MIN_VALUE;

        for (int item : array) {
            if(item < min) {
                min = item;
            }
        }
        return min;
    }

    private int max(int[] array){
        validateArray(array);
        int max = -Integer.MAX_VALUE;
        for (int item : array) {
            if(item > max) {
                max = item;
            }
        }
        return max;
    }
}

package Section8.static3;

public class MathArrayUtils {
    private MathArrayUtils() {
        throw new AssertionError("이 클래스의 인스턴스는 생성할 수 없습니다!");
    }

    private int sum(int[] array){
        // return Arrays.stream(array).sum(); // 이런 방법도 있다고 한다.
        int result = 0;
        for(int item:array){
            result += item;
        }
        return result;
    }

    private double average(int[] array){
        // return Arrays.stream(array).average(); 혹시나 했는데 이렇게 할 수 있던데 반환 타입을 OptionalDouble 로 해줘야함.

        if(array.length == 0) { // tot 가 0인 경우에도 에러 처리를 해야하나 했는데 생각해보니 분자가 0일때는 평균을 계산할 수 있다.
            throw new IllegalArgumentException("평균을 계산하기 위해서는 적어도 하나 이상의 숫자가 필요합니다."); // 메서드에 전달된 인자가 부적절할 때 사용하는 표준 예외
        }

        int tot = 0;
        for(int item:array){
            tot += item;
        }
        return (double) tot/array.length;
    }

    // OptionalDouble ?
    // 값이 있는지 명확하게 확인 (isPresent())
    // 값이 없을 때의 대체값을 지정 (orElse())
    // 값이 있을 때만 특정 작업을 수행 (ifPresent())

    private int min(int[] array){
        // return Arrays.stream(array).min();
        if(array.length == 0) {
            throw new IllegalArgumentException("최소값을 계산하기 위해서는 적어도 하나 이상의 숫자가 필요합니다.");
        }

        int min = -Integer.MIN_VALUE;

        for (int item : array) {
            if(item < min) {
                min = item;
            }
        }
        return min;
    }

    private int max(int[] array){
    // return Arrays.stream(array).max();
        if(array.length == 0) {
            throw new IllegalArgumentException("최대값을 계산하기 위해서는 적어도 하나 이상의 숫자가 필요합니다.");
        }

        int max = -Integer.MAX_VALUE;

        for (int item : array) {
            if(item > max) {
                max = item;
            }
        }
        return max;
    }
}

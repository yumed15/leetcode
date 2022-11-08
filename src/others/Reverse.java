package others;

// problem 6
public class Reverse {
    public static int reverse(int x) {
        int res = 0;

        int aux = Math.abs(x);
        int sign = 1;
        if(x<0)
            sign = -1;

        while (aux>0) {
            if(res > Integer.MAX_VALUE/10 || (res == Integer.MAX_VALUE/ 10 && x%10 > 7))
                return 0;
            if(res < Integer.MIN_VALUE/10 || (res == Integer.MIN_VALUE/ 10 && x%10 < -8))
                return 0;

            res = res*10+aux%10;
            aux = aux/10;
        }

        return sign*res;
    }
}

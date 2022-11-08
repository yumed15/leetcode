package others;

// problem 977
public class SquaresOfSortedArray {
    public static int[] sortedSquares(int[] A) {
        int[]res = new int[A.length];

        int k=0;
        while(k<A.length && A[k]<0)
            k++;

        int i=k-1;
        int j=k;

        int index = 0;
        int left = 0;
        int right = 0;


        while(i>=0 && j<A.length)
        {
            if (i>=0)
                left = A[i] * A[i];

            if (j<A.length)
                right = A[j] * A[j];

            if(left < right)
            {
                res[index] = left;
                i--;
            }
            else
            {
                res[index] = right;
                j++;
            }
            index++;
        }

        while(i>=0)
        {
            res[index] = A[i] * A[i];
            i--; index++;
        }

        while(j<A.length)
        {
            res[index] = A[j] * A[j];
            j++; index++;
        }

        return res;
    }
}

//Input: nums = [-4,-1,0,3,10]
//Output: [0,1,9,16,100]
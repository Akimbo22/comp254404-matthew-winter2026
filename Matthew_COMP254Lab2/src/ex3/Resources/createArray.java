package ex3.Resources;

public interface createArray {
    static int[] CreateArray(int[] arr)
    {
        for(int i=1; i<8001; i++){
            arr[i-1] += i;
        }
        return arr;
    }
}

package xqk.learn.datastructurealgorithm.utils;

public class ArrayUtils {
    public static <T> void swap(T[] arr,int x,int y){
        T temp=arr[x];
        arr[x]=arr[y];
        arr[y]=temp;
    }
}

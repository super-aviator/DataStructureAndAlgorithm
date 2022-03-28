package xqk.learn.datastructurealgorithm.algorithm.basic;

import java.util.Arrays;

/**
 * 二分查找：
 * 时间复杂度：O(logN)
 */
public class BinarySearch {
    private final int[] intArr={100,51,3,56,-1,4,29,9,90,100,789,-100};

    public int binarySearch(int num){
        Arrays.sort(intArr);
        int lo=0,hi=intArr.length,mid=-1;
        while(lo<=hi){
            mid=lo+(hi-lo)/2;
            if(intArr[mid]<num){
                lo=mid+1;
            }else if(intArr[mid]>num){
                hi=mid-1;
            }else{
                return intArr[mid];
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        BinarySearch binarySearch=new BinarySearch();
        System.out.println(binarySearch.binarySearch(90));
    }
}

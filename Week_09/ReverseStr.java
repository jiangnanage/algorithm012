/**
 * 541. 反转字符串 II
 * 给定一个字符串 s 和一个整数 k，你需要对从字符串开头算起的每隔 2k 个字符的前 k 个字符进行反转。
 *
 * 如果剩余字符少于 k 个，则将剩余字符全部反转。
 * 如果剩余字符小于 2k 但大于或等于 k 个，则反转前 k 个字符，其余字符保持原样。
 *
 */
public class ReverseStr {

    public String reverseStr(String s, int k) {
        char[] arr = s.toCharArray();
        int i = 0;
        while(i<arr.length){
            if(i+k>arr.length){
                k = arr.length-i;
            }
            for(int j=0;j<k/2;j++){
                char tmp = arr[i+j];
                arr[i+j] = arr[i+k-1-j];
                arr[i+k-1-j] = tmp;
            }
            i += 2*k;
        }
        return String.valueOf(arr);
    }
}

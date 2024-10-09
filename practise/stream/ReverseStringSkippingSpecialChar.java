package practise.stream;

public class ReverseStringSkippingSpecialChar {

    public static void main(String[] args) {

        String s = "hello#fromme";
        char[] arr = s.toCharArray();
        int i=0, j=arr.length-1;
        while(i<j) {
            char chi = arr[i];
            char chj = arr[j];
            if (Character.isAlphabetic(chi) && Character.isAlphabetic(chj)) {
                arr[j] = chi;
                arr[i] = chj;
            }
            i++;
            j--;
        }

        System.out.println(new String(arr));
    }
}

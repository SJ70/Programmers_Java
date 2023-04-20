import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        String str = new BufferedReader(new InputStreamReader(System.in)).readLine();
        StringBuilder sb = new StringBuilder();
        int diff = 'a'-'A';
        
        for(int i=0; i<str.length(); i++){
            char c = str.charAt(i);
            c += ((c<='Z') ? 1 : -1) * diff;
            sb.append(c);
        }
        System.out.println(sb);
    }
}

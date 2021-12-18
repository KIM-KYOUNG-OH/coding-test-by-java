package baekjoon;

import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

public class P10828 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        Stack<String> stack = new Stack<>();
        int n = Integer.parseInt(br.readLine());
        for(int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String order = st.nextToken();
            if(order.equals("push")) {
                stack.push(st.nextToken());
            }else if(order.equals("pop")) {
                if(stack.empty()) {
                    bw.write("-1\n");
                }else{
                    bw.write(stack.pop() + "\n");
                }
            }else if(order.equals("size")) {
                bw.write(stack.size() + "\n");
            }else if(order.equals("empty")) {
                if(stack.empty()) {
                    bw.write("1\n");
                }else {
                    bw.write("0\n");
                }
            }else if(order.equals("top")) {
                if(stack.empty()) {
                    bw.write("-1\n");
                }else {
                    bw.write(stack.peek() + "\n");
                }

            }
        }

        br.close();
        bw.flush();
        bw.close();
    }
}

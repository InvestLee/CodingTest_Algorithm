import java.io.BufferedReader;

import java.io.InputStreamReader;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        String s = br.readLine();

        int result = 0;

        for(int i = 0; i < n; i++){

            if (s.charAt(i) == 'S') result += 2;

            else result += 1;

        }

        System.out.println(Math.min(n,result/2+1));

    }

}
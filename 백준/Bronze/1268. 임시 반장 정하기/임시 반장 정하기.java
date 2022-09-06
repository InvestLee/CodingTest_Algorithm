import java.util.*;

public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int [][] graph = new int[N][5];
        for (int i = 0; i < N; i++){
            for (int j = 0; j < 5; j++){
                graph[i][j] = sc.nextInt();
            }
        }
        int max_value = 0; //가장 많은 같은 반이었던 학생 수
        int result = 1; //같은 반이었던 학생 수가 가장 많은 학생 번호

        //n번 학생 카운트
        for (int i = 0; i < N; i++){
            Set<Integer> set_student = new HashSet<>(); //같은 반이였던 학생 명수 사이즈로 카운트
            for (int j = 0; j < 5; j++){
                for (int k = 0; k < N; k++){
                    if (graph[i][j]==graph[k][j] && k != i) set_student.add(k);
                }
            }
            //최댓값 갱신
            if (max_value < set_student.size()){
                max_value = set_student.size();
                result = i+1;
            }
        }
        System.out.println(result);
        sc.close();
    }
}
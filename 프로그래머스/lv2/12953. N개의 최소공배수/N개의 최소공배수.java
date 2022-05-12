class Solution {
    public int solution(int[] arr) {
        int Big = 0;
        int Small = 0;
        int temp = 0;
        for(int i =0;i<(arr.length-1);i++){
            if (arr[i]>arr[i+1]){
                Big = arr[i];
                Small = arr[i+1];
            }
            else{
                Big = arr[i+1];
                Small = arr[i];
            }
            while (true){
                temp = Big%Small;
                Big = Small;
                Small = temp;
                if (Small==0){
                    arr[i+1] = (arr[i+1] * arr[i]) / Big;
                    break;
                }
            }
        }
        return arr[arr.length-1];
    }
}
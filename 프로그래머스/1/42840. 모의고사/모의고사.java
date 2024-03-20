import java.util.*;
class Solution {
    public int[] solution(int[] answers) {
        int[] answer = {};
        int num=0;
        int[][] pattern={
            {1,2,3,4,5},
            {2,1,2,3,2,4,2,5},
            {3,3,1,1,2,2,4,4,5,5}
        };
        int[] scores=new int[3];
    
        for(int i=0;i<answers.length;i++){
            for(int j=0;j<pattern.length;j++){
                if(answers[i]==pattern[j][i%pattern[j].length]){
                    scores[j]++;
                }
            }
        }
        int maxscore=Arrays.stream(scores).max().getAsInt();
        ArrayList<Integer>list =new ArrayList<>();
        for(int i=0;i<scores.length;i++){
            if(maxscore==scores[i]){
                list.add(i+1);
            }
        }
        
        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}
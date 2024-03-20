import java.util.*;
class Solution {
    public int[] solution(int N, int[] stages) {
    
        int[] result=new int[N+2];
        int a=0;
        for(int i=0;i<stages.length;i++){
           result[stages[i]]+=1;
        }
        HashMap<Integer,Double>fails =new HashMap<>();
        double total=stages.length;
        for(int i=1;i<=N;i++){
            if(result[i]==0){
                fails.put(i,0.);
            }
            else{
                fails.put(i,result[i]/total);
                total=total-result[i];
            }
        }
        
        
        return fails.entrySet().stream().sorted((o1,o2)->Double.compare(o2.getValue(),o1.getValue())).mapToInt(HashMap.Entry::getKey).toArray();
    }
}
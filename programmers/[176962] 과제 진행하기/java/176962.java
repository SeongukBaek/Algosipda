import java.util.*;

class Solution {
    private Queue<String[]> works = new PriorityQueue<>(new Comparator<String[]>() {
            @Override
            public int compare(String[] o1, String[] o2) {
                return o1[1].compareTo(o2[1]);
            }
        });
    private Stack<String[]> remain = new Stack<>();
    
    public String[] solution(String[][] plans) {
        String[] answer = new String[plans.length];
        int index = 0;
        
        for (String[] plan : plans) {
            works.add(plan);
        }
        
        while (!works.isEmpty()) {
            String[] current = works.poll();
            int currentTime = getTimeValue(current[1]);
            int currentCost = Integer.parseInt(current[2]);
            
            if (works.isEmpty()) {
                answer[index++] = current[0];
                break;
            }
            
            String[] next = works.peek();
            int nextTime = getTimeValue(next[1]);
            int between = nextTime - currentTime;

            if (currentCost <= between) {
                answer[index++] = current[0];
                between -= currentCost;
                
                while (!remain.isEmpty() && between > 0) {
                    String[] remainWork = remain.pop();
                    int remainCost = Integer.parseInt(remainWork[1]);

                    if (between >= remainCost) {
                        answer[index++] = remainWork[0];
                        between -= remainCost;
                    } else {
                        remain.add(new String[] {remainWork[0], String.valueOf(remainCost - between)});
                        between = 0;
                    }
                }
            } else {
                remain.add(new String[]{current[0], String.valueOf(currentCost - between)});
            }
        }
        
        while (!remain.isEmpty()) {
            answer[index++] = remain.pop()[0];
        }
        
        return answer;
    }
    
    private int getTimeValue(String time) {
        String[] value = time.split(":");
        return Integer.parseInt(value[0]) * 60 + Integer.parseInt(value[1]);
    }
}
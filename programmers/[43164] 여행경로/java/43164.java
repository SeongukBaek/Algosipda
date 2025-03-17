import java.util.*;

class Solution {
    private int ticketCount;
    private boolean[] isVisited;
    private final List<String> routes = new ArrayList<>();
    private String[][] tickets;
    
    public String[] solution(String[][] tickets) {
        ticketCount = tickets.length;
        isVisited = new boolean[ticketCount];
        this.tickets = tickets;
        
        findRoutes(0, "ICN", "ICN");
        
        Collections.sort(routes);

        return routes.get(0).split(" ");
    }
    
    private void findRoutes(int count, String start, String path) {
        if (ticketCount == count) {
            routes.add(path);
            return;
        }
        
        for (int index = 0; index < ticketCount; index++) {
            if (isVisited[index] || !tickets[index][0].equals(start)) {
                continue;
            }
            
            isVisited[index] = true;
            findRoutes(count + 1, tickets[index][1], path + " " + tickets[index][1]);
            isVisited[index] = false;
        }
    }
}
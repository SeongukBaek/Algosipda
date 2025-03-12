class Solution {
    public int solution(int[] bandage, int health, int[][] attacks) {
        int currentHealth = health;
        int lastAttack = attacks[attacks.length - 1][0];
        int attackIndex = 0;
        int timeStack = 0;
        
        for (int time = 1; time <= lastAttack; time++) {
            if (time == attacks[attackIndex][0]) {
                timeStack = 0;
                int damage = attacks[attackIndex][1];
                currentHealth -= damage;

                if (currentHealth <= 0) {
                    return -1;
                }
                
                attackIndex++;
            } else {
                timeStack++;
                if (currentHealth == health) {
                    continue;
                }
                
                currentHealth = Math.min(health, currentHealth + bandage[1]);
                if (timeStack == bandage[0]) {
                    currentHealth = Math.min(health, currentHealth + bandage[2]);
                    timeStack = 0;
                }
            }
        }
        
        return currentHealth;
    }
}
class Solution {
    private char[] vowels = {'A', 'E', 'I', 'O', 'U'};
    private String target;
    private int answer = 0;
    private int count = 0;
    
    public int solution(String word) {
        target = word;
        
        findWords(new StringBuilder(), 0);
        
        return answer;
    }
    
    private void findWords(StringBuilder result, int size) {
        if (target.equals(result.toString())) {
            answer = count;
            return;
        }
        
        for (int index = 0; index < 5; index++) {
            if (size < 5) {
                count++;
                result.append(vowels[index]);
                findWords(result, size + 1);
                result.deleteCharAt(result.length() - 1);
            }
            
            if (answer != 0) {
                return;
            }
        }
    }
}
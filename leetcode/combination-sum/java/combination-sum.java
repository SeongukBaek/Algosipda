class Solution {
    private final Set<List<Integer>> result = new HashSet<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);

        // 중복 조합 생성, 이때 target보다 커지면 X, 작은 경우만 continue, 같으면 종료
        for (int index = 0; index < candidates.length; index++) {
            if (candidates[index] <= target) {
                List<Integer> list = new ArrayList<>();
                list.add(candidates[index]);
                combinationSum(candidates, target, candidates[index], index, list);
            }
        }

        return new ArrayList<>(result);
    }

    private void combinationSum(int[] candidates, int target, int sum, int nIndex, List<Integer> numbers) {
        if (sum == target) {
            if (!result.contains(numbers)) {
                result.add(new ArrayList<>(numbers));
            }
            return;
        }

        for (int index = nIndex; index < candidates.length; index++) {
            if (target < sum + candidates[index]) {
                break;
            }
            numbers.add(candidates[index]);
            combinationSum(candidates, target, sum + candidates[index], index, numbers);
            numbers.remove(numbers.size() - 1);
        }
    }
}
// https://leetcode.com/problems/rabbits-in-forest/
// 781. Rabbits in Forest

class RabbitsinForest {
    public int numRabbits(int[] answers) {
        Map<Integer, Integer> ans = new HashMap<>();
        int result = 0;
        for(int num : answers) {
            ans.put(num, ans.getOrDefault(num, 0) + 1);
        }

        for(var data : ans.entrySet()){
            int group = data.getKey() + 1;
            int count = data.getValue();

            int groupSize = (int) Math.ceil((double) count / group);

            result += group * groupSize;
        }

        return result;
    }
}

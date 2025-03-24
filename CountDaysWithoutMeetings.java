// 3169. Count Days Without Meetings
// https://leetcode.com/problems/count-days-without-meetings/

class CountDaysWithoutMeetings {
    public int countDays(int days, int[][] meetings) {
        Arrays.sort(meetings, Comparator.comparingInt(row -> row[0]));

        int prev_end = 0;
        for(int[] meeting : meetings) {
            int start = Math.max(meeting[0], prev_end+1);
            days -= Math.max(meeting[1] - start + 1, 0);
            prev_end = Math.max(meeting[1], prev_end);
        }

        return days;
    }
}

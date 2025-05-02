// 838. Push Dominoes
// https://leetcode.com/problems/push-dominoes/

class PushDominoes {
    public String pushDominoes(String dominoes) {
        Queue<Integer> deque = new LinkedList<>();
        char [] ch = dominoes.toCharArray();
        for (int i = 0; i < dominoes.length(); i++) {
            if(dominoes.charAt(i) != '.') {
                deque.add(i);
            }
        }

        while (!deque.isEmpty()) {
            int i = deque.poll();

            if(ch[i] == 'L' && i-1 >= 0 && ch[i-1] == '.') {
                ch[i-1] = 'L';
                deque.add(i-1);
            } else if(ch[i] == 'R') {
                if(i+1 < ch.length && ch[i+1] == '.') {
                    if(i+2 < ch.length && ch[i+2] == 'L') {
                        deque.poll();
                    } else {
                        ch[i+1] = 'R';
                        deque.add(i+1);
                    }
                }
            }
        }
        return new String(ch);
    }
}

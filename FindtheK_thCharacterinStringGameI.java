// 3304. Find the K-th Character in String Game I
// https://leetcode.com/problems/find-the-k-th-character-in-string-game-i

class FindtheK_thCharacterinStringGameI {
    public char kthCharacter(int k) {
        StringBuilder sb = new StringBuilder("a");

        while(sb.length() < k) {
            int currlen = sb.length();
            int i = 0;

            for(; i<currlen; i++){
                char ch = sb.charAt(i);
                if(ch != 'z')
                    sb.append((char) (ch + 1));
                else
                    sb.append('a');
            }
        }

        return sb.charAt(k-1);
    }
}

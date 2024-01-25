class RomanToInteger {
    public int romanToInt(String data) {
        HashMap<Character,Integer> mp=new HashMap<>();
        mp.put('I',1);
        mp.put('V',5);
        mp.put('X',10);
        mp.put('L',50);
        mp.put('C',100);
        mp.put('D',500);
        mp.put('M',1000);

        int result = 0, index=0;
        for (int i = 0; i < data.length(); ) {
            if(data.length() - index >= 2) {
                if (data.charAt(index) == 'I' && data.charAt(index + 1) == 'V') {
                    result += 4;
                    index += 2;
                }
                else if (data.charAt(index) == 'I' && data.charAt(index + 1) == 'X') {
                    result += 9;
                    index += 2;
                }
                else if (data.charAt(index) == 'X' && data.charAt(index + 1) == 'L') {
                    result += 40;
                    index += 2;
                }
                else if (data.charAt(index) == 'X' && data.charAt(index + 1) == 'C') {
                    result += 90;
                    index += 2;
                }
                else if (data.charAt(index) == 'C' && data.charAt(index + 1) == 'D') {
                    result += 400;
                    index += 2;
                }
                else if (data.charAt(index) == 'C' && data.charAt(index + 1) == 'M') {
                    result += 900;
                    index += 2;
                }
            }
            if(i == index){
                result += mp.get(data.charAt(index));
                index++;
                i++;
            } else {
                i = index;
            }
        }

        return result;
    }
}

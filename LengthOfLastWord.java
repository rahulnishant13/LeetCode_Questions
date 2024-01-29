class LengthOfLastWord {
    public int lengthOfLastWord(String s) {
        String[] data = s.trim().split(" ");
        return data[data.length -1].length();
    }
}

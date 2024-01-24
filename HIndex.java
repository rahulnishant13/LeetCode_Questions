class HIndex {
    public int hIndex(int[] citations) {
        int n = citations.length;
        int [] hindex = new int[n+1];
        int count =0;

        for (int i=0; i<n; i++){
            if(citations[i] >= n){
                hindex[n]++;
            } else {
                hindex[citations[i]]++;
            }
        }

        for (int i=n; i>=0; i--){
            count += hindex[i];
            if(count >= i){
                return i;
            }
        }

        return 0;
        
    }
}

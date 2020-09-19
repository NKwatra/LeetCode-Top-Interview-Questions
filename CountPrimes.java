class Solution {
    public int countPrimes(int n) {
        
        if(n <= 2)
            return 0;
            
        boolean[] table = new boolean[n+1];
        for(int i = 2; i <= (int)Math.sqrt(n); i++)
        {
            for(int j = i * i; j <=n; j= j + i)
                table[j] = true;
            i++;
            while(table[i] == true)
                i++;
            i--;
        }
        
        int primeCount = 0;
        
        for(int j = 2; j < n; j++)
        {
            if(!table[j])
                primeCount++;
        }
        
        return primeCount;
    }
}

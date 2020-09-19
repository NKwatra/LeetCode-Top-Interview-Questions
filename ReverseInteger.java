class Solution {
    public int reverse(int x) {
        
        if(x == Integer.MIN_VALUE)
            return 0;
        
        boolean positive = x > 0 ;
        int num = Math.abs(x);
        
        int rem = 0, reversedNumber = 0;
        while(num > 0)
        {
            rem = num % 10;
            if(reversedNumber > Integer.MAX_VALUE / 10 || (reversedNumber == Integer.MAX_VALUE && rem > Integer.MAX_VALUE % 10))
                return 0;
            reversedNumber = reversedNumber * 10 + rem;
            num /= 10;
        }
        
        return positive ? reversedNumber : -reversedNumber;
    }
}

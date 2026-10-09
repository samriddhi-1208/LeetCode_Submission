int reverse(int x){
    long rev = 0;
    while(x!=0){
        int d = x%10;
          x/=10;
         rev = rev*10+d;
        if (rev>INT_MAX||rev<INT_MIN)
        return 0;
      
    }
    return (int)rev;
   }
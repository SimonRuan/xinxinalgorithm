package com.ruanxinxin.algorithm;

public class Pow {

    static double solution(double x,int n){
        long N=n;
        if(N<0){
            x=1/x;
            N=-N;
        }
        double ans=1;
        double current_product=x;

        for(long i=N;i>0;i/=2){
            if((i%2)==1){
                ans=ans*current_product;
            }
            current_product=current_product*current_product;
        }
        return ans;
    }

    public static void main(String[] args) {
        double ans=solution(3,5);
        System.out.println(ans);
    }

}

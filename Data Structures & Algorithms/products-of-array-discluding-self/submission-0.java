class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n=nums.length;
        long pref[]=new long[n];
        long suff[]=new long[n];
        Arrays.fill(pref,1);
        Arrays.fill(suff,1);

        for(int i=0;i<nums.length;i++){
            pref[i]=1L*nums[i]*(i>0?pref[i-1]:1);
        }
        for(int j=n-1;j>=0;j--){
            suff[j]=1L*nums[j]*(j+1<n?suff[j+1]:1);
        }
        int[]res=new int[n];
        Arrays.fill(res,1);
        for(int i=0;i<n;i++){
            long temp=1L*(i-1>=0?pref[i-1]:1)*(i+1<n?suff[i+1]:1);
            res[i]=(int)temp;
        }

        return res;
    }
}  

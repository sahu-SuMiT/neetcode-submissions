class Solution {
    public int trap(int[] height) {
        int[]suff=new int[height.length];
        int[]pref=new int[height.length];
        int n=height.length;
        int rMax=-1;
        for(int i=n-1;i>=0;i--){
            if(rMax>=height[i]){
                suff[i]=rMax;
            }
            rMax=Math.max(rMax,height[i]);
        }
        int lMax=-1;
        for(int i=0;i<n;i++){
            if(lMax>=height[i]){
                pref[i]=lMax;
            }
            lMax=Math.max(lMax,height[i]);
        }
        // System.out.println(Arrays.toString(pref));
        // System.out.println(Arrays.toString(suff));
        int acc=0;
        for(int i=0;i<height.length;i++){
            int c=Math.min(pref[i],suff[i])-height[i];
            if(c>0)acc+=c;
        }
        return acc;
    }
}

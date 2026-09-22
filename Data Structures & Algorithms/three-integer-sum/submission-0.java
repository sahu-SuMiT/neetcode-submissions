class Solution {
    long base=2*100000+10;
    long hashed(int a,int b,int c){
        return (1L*a*base+b)*base+c;
    }
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        int target=0;
        List<List<Integer>>res=new ArrayList<>();
        int n=nums.length;
        HashSet<Long>set=new HashSet<>();

        for(int i=0;i<n;i++){
            int j=i+1;
            int k=nums.length-1;
            while(j<k){
                if(nums[i]+nums[j]+nums[k]==target){
                    int a=Math.min(nums[i],Math.min(nums[j],nums[k]));
                    int c=Math.max(nums[i],Math.max(nums[j],nums[k]));
                    int b=(nums[i]+nums[j]+nums[k]-a-c);
                    if(!set.contains(hashed(a,b,c))){
                        List<Integer>temp=new ArrayList<>(Arrays.asList(a,b,c));
                        res.add(temp);
                        set.add(hashed(a,b,c));
                    }
                    j++;
                    k--;
                }else if(nums[i]+nums[j]+nums[k]<target){
                    j++;
                }else k--;
            }
        }
        return res;
    }
}

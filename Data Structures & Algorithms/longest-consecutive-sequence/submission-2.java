class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums.length==0)return 0;
        int res=0;
        HashSet<Integer>set=new HashSet<>();
        for(int num:nums){
            set.add(num);
        }
        ArrayList<Integer>list=new ArrayList<>(set);
        Collections.sort(list);
        int i=0;
        // System.out.println(list);
        int c=1;
        while(i<list.size()){
            int curr=list.get(i);
            
            if(i>0&&list.get(i)==list.get(i-1)+1){
                c++;
                i++;
                
            }else{
                res=Math.max(c,res);
                c=1;
                i++;
            }
            // System.out.println(i+" "+c);
            
        }
        res=Math.max(c,res);
        return res;
    }
}

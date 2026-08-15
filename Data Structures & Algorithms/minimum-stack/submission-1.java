class MinStack {
    int arr[];
    int i;
    int[]min;
    public MinStack() {
        arr=new int[30001];
        min=new int[30001];
        Arrays.fill(min,Integer.MAX_VALUE);
        i=-1;
    }
    
    public void push(int val) {
        i++;
        arr[i]=val;
        min[i]=Math.min(val,min[i]);
        if(i>0){
            min[i]=Math.min(min[i],min[i-1]);
        }
    }
    
    public void pop() {
        min[i]=Integer.MAX_VALUE;
        i--;
    }
    
    public int top() {
        return arr[i];
    }
    
    public int getMin() {
        return min[i];
    }
}

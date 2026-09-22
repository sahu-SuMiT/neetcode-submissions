class Solution {
    static String encodingPattern="$#12#$";
    static String nullPattern="###$$$null$$$###";
    static String emptyListPattern="###$$$empty$$$###";
    public String encode(List<String> strs) {
        if(strs.size()==0)return emptyListPattern;
        StringBuilder encoded=new StringBuilder();
        for(String str:strs){
            if(str.length()==0){
                encoded.append(nullPattern).append(encodingPattern);
            }else{
                encoded.append(str).append(encodingPattern);
            }
        }
        // System.out.println(encoded);
        // System.out.println(encoded.toString().split(Pattern.quote(encodingPattern)));
        return encoded.toString();
    }

    public List<String> decode(String str) {
        if(str.equals(emptyListPattern))return new ArrayList<>();
        String[]arr=str.split(Pattern.quote(encodingPattern));
        List<String>res=new ArrayList<>();
        for(String word:arr){
            if(word.equals(nullPattern)){
                res.add("");
            }else res.add(word);
        }
        return res;
    }   
}

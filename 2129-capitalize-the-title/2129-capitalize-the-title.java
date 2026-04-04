class Solution {
    public String capitalizeTitle(String title) {
        String[] words = title.split("\\s+");
        for(int i = 0 ; i < words.length ; i++){
            String s = words[i];
            if(s.length() > 2){
            words[i] = s.substring(0,1).toUpperCase() + s.substring(1).toLowerCase();
            }else{
                words[i] = words[i].toLowerCase();
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 0 ; i < words.length ; i++){
            sb.append(words[i] + " ");
        }
        return sb.toString().stripTrailing();
    }
}
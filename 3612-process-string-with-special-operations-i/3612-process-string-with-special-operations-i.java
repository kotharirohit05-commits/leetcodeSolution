class Solution {

    private String star(String d){
        if(d.length() >= 1){
            return d.substring(0, d.length() - 1);
        }else {
            return d;
        }
    }

    private String hash(String d){
        StringBuilder s = new StringBuilder(d);
        s.append(d);
        return s.toString();
    }

    private String rev(String d){
        StringBuilder s = new StringBuilder(d);   
        return s.reverse().toString();
    }

    public String processStr(String s) {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < s.length() ; i++){
            char ch = s.charAt(i);
            if(ch >= 'a' && ch <= 'z'){
                sb.append(ch);
            }else if(ch == '*'){
               sb = new StringBuilder( star(sb.toString()));
            }
            else if(ch == '#'){
               sb = new StringBuilder( hash(sb.toString()));
            }
            else if(ch == '%'){
               sb = new StringBuilder( rev(sb.toString()));
            }
        }
        return sb.toString();
    }
}
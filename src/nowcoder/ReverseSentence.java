package nowcoder;

public class ReverseSentence {
    public String ReverseSen(String str){
        if(str=="" || str.split(" ").length==0) return "";
        String[] strs=str.split(" ");
        StringBuilder sb=new StringBuilder();
        for(int i=strs.length-1;i>0;i--){
            sb.append(strs[i]+' ');
        }
        sb.append(strs[0]);
        return sb.toString();
    }
}

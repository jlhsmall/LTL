package AST;

import java.util.LinkedHashMap;

public class UntilNode extends ASTNode{
    public ASTNode left,right;
    public UntilNode(ASTNode left, ASTNode right){
        super("("+left.text+")U("+right.text+")");
        this.left=left;
        this.right=right;
        for(var left_mp : left.FormulaValue){
            for(var right_mp:right.FormulaValue){
                LinkedHashMap<ASTNode,Boolean>cur_mp=new LinkedHashMap<>(left_mp);
                boolean flag = true;
                for(var entry : right_mp.entrySet()){
                    if(cur_mp.containsKey(entry.getKey())){
                        if(!cur_mp.get(entry.getKey()).equals(entry.getValue())){
                            flag = false; break;
                        }
                    }else{
                        cur_mp.put(entry.getKey(),entry.getValue());
                    }
                }
                if(flag){
                    cur_mp.put(this,left_mp.get(left)||right_mp.get(right));
                    FormulaValue.add(cur_mp);
                    if(left_mp.get(left)&&!right_mp.get(right)){
                        LinkedHashMap<ASTNode,Boolean>cur_mp2=new LinkedHashMap<>(cur_mp);
                        cur_mp2.put(this,false);
                        FormulaValue.add(cur_mp2);
                    }
                }
            }
        }
    }
}

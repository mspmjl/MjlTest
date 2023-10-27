package com.mjl.skills;

/**
 * @author MJL
 * @date 2022/9/7.
 */
public class InterfaceSkills {
    public static void main(String[] args) {
        InterfaceSkills skills = new InterfaceSkills();

        System.out.println(skills.method((s) -> "pre" + s, "test"));
    }
    String method(ForExecute forExecute,String s){
        return forExecute.execute(s);
    }
}

interface ForExecute{
    String execute(String s);
}

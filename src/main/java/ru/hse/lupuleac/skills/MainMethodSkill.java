package ru.hse.lupuleac.skills;

import com.github.javaparser.ast.body.MethodDeclaration;
import com.github.javaparser.symbolsolver.javaparsermodel.JavaParserFacade;

public class MainMethodSkill extends Skill {
    @Override
    public String toString() {
        return "MAIN_METHOD";
    }

    @Override
    public void visit(MethodDeclaration n, JavaParserFacade arg) {
        super.visit(n, arg);
        //System.out.println(
         //       n.getDeclarationAsString(true, false, false).equals("public static void main(String[])"));
    }
}

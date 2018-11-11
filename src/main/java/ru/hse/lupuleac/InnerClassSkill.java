package ru.hse.lupuleac;

import com.github.javaparser.ast.body.ClassOrInterfaceDeclaration;
import com.github.javaparser.symbolsolver.javaparsermodel.JavaParserFacade;

public class InnerClassSkill extends Skill {
    @Override
    public void visit(ClassOrInterfaceDeclaration n, JavaParserFacade arg) {
        super.visit(n, arg);
       // arg.getTypeDeclaration(n)
    }

    @Override
    public String toString() {
        return "INNER_CLASS";
    }
}

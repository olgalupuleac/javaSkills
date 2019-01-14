package ru.hse.lupuleac.skills;

import com.github.javaparser.ast.body.ClassOrInterfaceDeclaration;
import com.github.javaparser.symbolsolver.javaparsermodel.JavaParserFacade;

public class InterfaceSkill extends Skill {
    @Override
    public void visit(ClassOrInterfaceDeclaration n, JavaParserFacade arg) {
        super.visit(n, arg);
        incrementScore(n.isInterface(), "interface");
    }

    @Override
    public String toString() {
        return "INTERFACE";
    }
}

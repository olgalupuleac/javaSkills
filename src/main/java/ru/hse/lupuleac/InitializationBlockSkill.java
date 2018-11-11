package ru.hse.lupuleac;

import com.github.javaparser.ast.body.InitializerDeclaration;
import com.github.javaparser.symbolsolver.javaparsermodel.JavaParserFacade;

public class InitializationBlockSkill extends Skill {
    @Override
    public void visit(InitializerDeclaration n, JavaParserFacade arg) {
        super.visit(n, arg);
        incrementScore(true);
    }

    @Override
    public String toString() {
        return "INITIALIZATION_BLOCK";
    }
}

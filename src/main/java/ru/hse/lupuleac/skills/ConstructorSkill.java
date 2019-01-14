package ru.hse.lupuleac.skills;

import com.github.javaparser.ast.body.ConstructorDeclaration;
import com.github.javaparser.symbolsolver.javaparsermodel.JavaParserFacade;

public class ConstructorSkill extends Skill {
    @Override
    public void visit(ConstructorDeclaration n, JavaParserFacade javaParserFacade) {
        super.visit(n, javaParserFacade);
        incrementScore(true, "constructor");
    }

    @Override
    public String toString() {
        return "CONSTRUCTOR";
    }
}

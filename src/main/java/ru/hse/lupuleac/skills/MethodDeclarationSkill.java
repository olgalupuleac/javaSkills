package ru.hse.lupuleac.skills;

import com.github.javaparser.ast.body.MethodDeclaration;
import com.github.javaparser.symbolsolver.javaparsermodel.JavaParserFacade;

public class MethodDeclarationSkill extends Skill {
    {
        minScore = 1;
    }
    @Override
    public String toString() {
        return "METHOD_DECLARATION";
    }

    @Override
    public void visit(MethodDeclaration n, JavaParserFacade javaParserFacade) {
        incrementScore(true);
    }
}

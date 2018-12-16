package ru.hse.lupuleac.skills;

import com.github.javaparser.ast.expr.ObjectCreationExpr;
import com.github.javaparser.symbolsolver.javaparsermodel.JavaParserFacade;

public class AnonymousClassSkill extends Skill {
    @Override
    public void visit(ObjectCreationExpr n, JavaParserFacade javaParserFacade){
        super.visit(n, javaParserFacade);
        incrementScore(n.getAnonymousClassBody().isPresent());
    }

    @Override
    public String toString() {
        return "ANONYMOUS_CLASS";
    }
}

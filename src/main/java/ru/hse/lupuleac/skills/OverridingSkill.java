package ru.hse.lupuleac.skills;

import com.github.javaparser.ast.expr.MarkerAnnotationExpr;
import com.github.javaparser.symbolsolver.javaparsermodel.JavaParserFacade;

public class OverridingSkill extends Skill {
    @Override
    public String toString() {
        return "OVERRIDING";
    }

    @Override
    public void visit(MarkerAnnotationExpr n, JavaParserFacade arg) {
        super.visit(n, arg);
        incrementScore(n.getNameAsString().equals("Override"), "annotation");
    }
}

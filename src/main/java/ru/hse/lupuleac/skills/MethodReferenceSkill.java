package ru.hse.lupuleac.skills;

import com.github.javaparser.ast.expr.MethodReferenceExpr;
import com.github.javaparser.symbolsolver.javaparsermodel.JavaParserFacade;

public class MethodReferenceSkill extends Skill {
    @Override
    public void visit(MethodReferenceExpr n, JavaParserFacade arg) {
        incrementScore(true, "ref");
    }

    @Override
    public String toString() {
        return "METHOD_REFERENCE";
    }
}

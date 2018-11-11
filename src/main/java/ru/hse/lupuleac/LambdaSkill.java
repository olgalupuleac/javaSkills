package ru.hse.lupuleac;

import com.github.javaparser.ast.expr.LambdaExpr;
import com.github.javaparser.symbolsolver.javaparsermodel.JavaParserFacade;

public class LambdaSkill extends Skill {
    @Override
    public void visit(LambdaExpr n, JavaParserFacade javaParserFacade) {
        super.visit(n, javaParserFacade);
        incrementScore(true);
    }

    @Override
    public String toString() {
        return "LAMBDA";
    }
}

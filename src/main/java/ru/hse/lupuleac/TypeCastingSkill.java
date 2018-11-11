package ru.hse.lupuleac;

import com.github.javaparser.ast.expr.CastExpr;
import com.github.javaparser.ast.expr.InstanceOfExpr;
import com.github.javaparser.symbolsolver.javaparsermodel.JavaParserFacade;

public class TypeCastingSkill extends Skill {
    @Override
    public void visit(CastExpr n, JavaParserFacade arg) {
        super.visit(n, arg);
        incrementScore(true);
    }

    @Override
    public void visit(InstanceOfExpr n, JavaParserFacade arg) {
        super.visit(n, arg);
        incrementScore(true);
    }

    @Override
    public String toString() {
        return "TYPE_CASTING";
    }
}

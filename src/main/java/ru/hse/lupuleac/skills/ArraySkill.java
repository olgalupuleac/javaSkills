package ru.hse.lupuleac.skills;

import com.github.javaparser.ast.body.Parameter;
import com.github.javaparser.ast.expr.ArrayAccessExpr;
import com.github.javaparser.ast.expr.ArrayCreationExpr;
import com.github.javaparser.ast.expr.ArrayInitializerExpr;
import com.github.javaparser.symbolsolver.javaparsermodel.JavaParserFacade;

public class ArraySkill extends Skill {
    @Override
    public void visit(ArrayAccessExpr n, JavaParserFacade arg) {
        super.visit(n, arg);
        incrementScore(true, "access");
    }

    @Override
    public void visit(ArrayCreationExpr n, JavaParserFacade arg) {
        super.visit(n, arg);
        incrementScore(true, "creation");
    }

    @Override
    public void visit(ArrayInitializerExpr n, JavaParserFacade arg) {
        super.visit(n, arg);
        incrementScore(true, "initializer");
    }

    @Override
    public void visit(Parameter n, JavaParserFacade arg) {
        super.visit(n, arg);
        incrementScore(n.getType().isArrayType(), "parameter");
    }

    @Override
    public String toString() {
        return "ARRAY";
    }
}

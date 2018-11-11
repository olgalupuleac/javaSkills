package ru.hse.lupuleac;

import com.github.javaparser.ast.body.MethodDeclaration;
import com.github.javaparser.ast.expr.ArrayAccessExpr;
import com.github.javaparser.ast.expr.ArrayCreationExpr;
import com.github.javaparser.ast.expr.ArrayInitializerExpr;
import com.github.javaparser.symbolsolver.javaparsermodel.JavaParserFacade;

public class ArraySkill extends Skill {
    @Override
    public void visit(ArrayAccessExpr n, JavaParserFacade arg) {
        super.visit(n, arg);
        incrementScore(true);
    }

    @Override
    public void visit(ArrayCreationExpr n, JavaParserFacade arg) {
        super.visit(n, arg);
        incrementScore(true);
    }

    @Override
    public void visit(ArrayInitializerExpr n, JavaParserFacade arg) {
        super.visit(n, arg);
        incrementScore(true);
    }

    @Override
    public void visit(MethodDeclaration n, JavaParserFacade arg) {
        super.visit(n, arg);
        n.getParameters().forEach(x -> incrementScore(arg.getType(x).isArray()));
    }

    @Override
    public String toString() {
        return "ARRAY";
    }
}

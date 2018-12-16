package ru.hse.lupuleac.skills;

import com.github.javaparser.ast.body.ClassOrInterfaceDeclaration;
import com.github.javaparser.ast.expr.MethodCallExpr;
import com.github.javaparser.symbolsolver.javaparsermodel.JavaParserFacade;

public class CollectorsSkill extends Skill {
    @Override
    public void visit(MethodCallExpr n, JavaParserFacade javaParserFacade) {
        super.visit(n, javaParserFacade);
        matchMethodCall("java\\.util.stream\\.Collector", n, javaParserFacade);
    }

    @Override
    public void visit(ClassOrInterfaceDeclaration c, JavaParserFacade javaParserFacade) {
        super.visit(c, javaParserFacade);
        hasAncestor("java.util.stream.Collector", c, javaParserFacade);
    }

    @Override
    public String toString() {
        return "COLLECTORS";
    }
}

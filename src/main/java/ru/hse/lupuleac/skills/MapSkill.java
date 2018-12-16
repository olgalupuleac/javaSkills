package ru.hse.lupuleac.skills;

import com.github.javaparser.ast.body.ClassOrInterfaceDeclaration;
import com.github.javaparser.ast.expr.MethodCallExpr;
import com.github.javaparser.symbolsolver.javaparsermodel.JavaParserFacade;

public class MapSkill extends Skill {
    @Override
    public void visit(MethodCallExpr m, JavaParserFacade javaParserFacade) {
        super.visit(m, javaParserFacade);
        matchMethodCall("java\\.util\\.(.*)Map\\.(.*)", m, javaParserFacade);
    }

    @Override
    public void visit(ClassOrInterfaceDeclaration c, JavaParserFacade javaParserFacade) {
        super.visit(c, javaParserFacade);
        hasAncestor("java.util.Map", c, javaParserFacade);
    }

    @Override
    public String toString() {
        return "MAP";
    }
}

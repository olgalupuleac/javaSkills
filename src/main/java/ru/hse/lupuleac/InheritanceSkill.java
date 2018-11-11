package ru.hse.lupuleac;

import com.github.javaparser.ast.body.ClassOrInterfaceDeclaration;
import com.github.javaparser.ast.expr.SuperExpr;
import com.github.javaparser.symbolsolver.javaparsermodel.JavaParserFacade;

import java.util.jar.JarEntry;

public class InheritanceSkill extends Skill {
    @Override
    public void visit(SuperExpr n, JavaParserFacade arg) {
        super.visit(n, arg);
        incrementScore(true);
    }

    @Override
    public void visit(ClassOrInterfaceDeclaration n, JavaParserFacade arg) {
        super.visit(n, arg);
        incrementScore(arg.getTypeDeclaration(n).getAllAncestors().size() > 1);
    }

    @Override
    public String toString() {
        return "INHERITANCE";
    }
}

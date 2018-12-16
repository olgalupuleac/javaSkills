package ru.hse.lupuleac.skills;

import com.github.javaparser.ast.body.ClassOrInterfaceDeclaration;
import com.github.javaparser.ast.expr.SuperExpr;
import com.github.javaparser.symbolsolver.javaparsermodel.JavaParserFacade;

public class InheritanceSkill extends Skill {
    @Override
    public void visit(SuperExpr n, JavaParserFacade arg) {
        super.visit(n, arg);
        incrementScore(true);
    }

    @Override
    public void visit(ClassOrInterfaceDeclaration n, JavaParserFacade arg) {
        super.visit(n, arg);
        try {
            incrementScore(arg.getTypeDeclaration(n).getAllAncestors().size() > 1);
        } catch (Exception e) {
            n.getExtendedTypes().forEach(System.out::println);
            n.getImplementedTypes().forEach(System.out::println);
        }
    }

    @Override
    public String toString() {
        return "INHERITANCE";
    }
}

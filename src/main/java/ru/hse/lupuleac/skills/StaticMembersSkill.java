package ru.hse.lupuleac.skills;

import com.github.javaparser.ast.body.ClassOrInterfaceDeclaration;
import com.github.javaparser.ast.body.FieldDeclaration;
import com.github.javaparser.ast.body.MethodDeclaration;
import com.github.javaparser.ast.expr.MethodCallExpr;
import com.github.javaparser.symbolsolver.javaparsermodel.JavaParserFacade;
import ru.hse.lupuleac.skills.Skill;

public class StaticMembersSkill extends Skill {
    @Override
    public void visit(MethodDeclaration n, JavaParserFacade arg) {
        super.visit(n, arg);
        incrementScore(n.isStatic(), "method");
    }

    @Override
    public void visit(FieldDeclaration n, JavaParserFacade arg) {
        super.visit(n, arg);
        incrementScore(n.isStatic(), "field");
    }

    @Override
    public void visit(MethodCallExpr n, JavaParserFacade arg) {
        super.visit(n, arg);
        try {
            incrementScore(n.resolveInvokedMethod().isStatic(), "method_call");
        } catch (Exception e) {
            System.err.println("Cannot solve " + n.getName());
        }
    }

    @Override
    public void visit(ClassOrInterfaceDeclaration n, JavaParserFacade arg) {
        super.visit(n, arg);
        incrementScore(n.isStatic(), "class");
    }

    @Override
    public String toString() {
        return "STATIC_MEMBERS";
    }
}

package ru.hse.lupuleac;

import com.github.javaparser.ast.body.FieldDeclaration;
import com.github.javaparser.ast.body.MethodDeclaration;
import com.github.javaparser.ast.expr.Name;
import com.github.javaparser.symbolsolver.javaparsermodel.JavaParserFacade;

public class StaticMembersSkill extends Skill {
    @Override
    public void visit(MethodDeclaration n, JavaParserFacade arg) {
        super.visit(n, arg);
        incrementScore(n.isStatic());
    }

    @Override
    public void visit(FieldDeclaration n, JavaParserFacade arg) {
        super.visit(n, arg);
        incrementScore(n.isStatic());
    }

    @Override
    public String toString() {
        return "STATIC_MEMBERS";
    }
}

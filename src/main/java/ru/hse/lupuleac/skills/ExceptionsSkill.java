package ru.hse.lupuleac.skills;

import com.github.javaparser.ast.body.ClassOrInterfaceDeclaration;
import com.github.javaparser.ast.stmt.ThrowStmt;
import com.github.javaparser.symbolsolver.javaparsermodel.JavaParserFacade;

public class ExceptionsSkill extends Skill {
    @Override
    public void visit(ThrowStmt n, JavaParserFacade arg) {
        super.visit(n, arg);
        incrementScore(true);
    }

    @Override
    public void visit(ClassOrInterfaceDeclaration n, JavaParserFacade arg) {
        super.visit(n, arg);
        hasAncestor("java.lang.Exception", n, arg);
    }

    @Override
    public String toString() {
        return "EXCEPTIONS";
    }

}

package ru.hse.lupuleac.skills;

import com.github.javaparser.ast.body.ClassOrInterfaceDeclaration;
import com.github.javaparser.ast.expr.MethodCallExpr;
import com.github.javaparser.ast.stmt.SynchronizedStmt;
import com.github.javaparser.symbolsolver.javaparsermodel.JavaParserFacade;
import ru.hse.lupuleac.skills.Skill;

public class ThreadSkill extends Skill {
    @Override
    public String toString() {
        return "THREAD";
    }

    @Override
    public void visit(MethodCallExpr n, JavaParserFacade arg) {
        super.visit(n, arg);
        matchMethodCall("java\\.lang\\.Thread\\.(.*)", n, arg);
    }

    @Override
    public void visit(SynchronizedStmt n, JavaParserFacade arg) {
        super.visit(n, arg);
        incrementScore(true);
    }

    @Override
    public void visit(ClassOrInterfaceDeclaration n, JavaParserFacade arg) {
        super.visit(n, arg);
        hasAncestor("java.lang.Thread", n, arg);
    }
}

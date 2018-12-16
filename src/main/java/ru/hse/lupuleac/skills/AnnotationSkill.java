package ru.hse.lupuleac.skills;

import com.github.javaparser.ast.body.AnnotationDeclaration;
import com.github.javaparser.ast.body.AnnotationMemberDeclaration;
import com.github.javaparser.ast.expr.MarkerAnnotationExpr;
import com.github.javaparser.symbolsolver.javaparsermodel.JavaParserFacade;

public class AnnotationSkill extends Skill  {
    @Override
    public void visit(AnnotationDeclaration n, JavaParserFacade arg) {
        super.visit(n, arg);
        incrementScore(true);
    }

    @Override
    public void visit(AnnotationMemberDeclaration n, JavaParserFacade arg) {
        super.visit(n, arg);
        incrementScore(true);
    }

    @Override
    public void visit(MarkerAnnotationExpr n, JavaParserFacade arg) {
        super.visit(n, arg);
        incrementScore(true);
    }

    @Override
    public String toString() {
        return "ANNOTATIONS";
    }
}

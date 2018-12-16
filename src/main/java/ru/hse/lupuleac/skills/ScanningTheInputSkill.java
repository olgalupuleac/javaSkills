package ru.hse.lupuleac.skills;

import com.github.javaparser.ast.Node;
import com.github.javaparser.ast.expr.MethodCallExpr;
import com.github.javaparser.ast.expr.NameExpr;
import com.github.javaparser.ast.expr.ObjectCreationExpr;
import com.github.javaparser.symbolsolver.javaparsermodel.JavaParserFacade;


public class ScanningTheInputSkill extends Skill {
    @Override
    public String toString() {
        return "SCANNING_THE_INPUT";
    }

    @Override
    public void visit(MethodCallExpr n, JavaParserFacade arg) {
        super.visit(n, arg);
        matchMethodCall("java\\.util\\.Scanner\\.(.*)", n, arg);
    }

    @Override
    public void visit(ObjectCreationExpr n, JavaParserFacade arg) {
        super.visit(n, arg);
        incrementScore(n.getArguments().stream().map(Node::toString).anyMatch(x -> x.equals("System.in")));
    }

    @Override
    public void visit(NameExpr n, JavaParserFacade arg) {
        super.visit(n, arg);
        //System.out.println(n.getName());
    }
}

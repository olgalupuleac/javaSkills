package ru.hse.lupuleac;

import com.github.javaparser.ast.expr.AssignExpr;
import com.github.javaparser.ast.expr.BinaryExpr;
import com.github.javaparser.ast.expr.UnaryExpr;
import com.github.javaparser.symbolsolver.javaparsermodel.JavaParserFacade;

import java.util.Arrays;

import static com.github.javaparser.ast.expr.BinaryExpr.Operator.*;

public class LogicalOperationsSkill extends Skill {
    private static final BinaryExpr.Operator[] logicalOperators = {BINARY_AND,
            BINARY_OR, AND, OR, XOR};

    private static final AssignExpr.Operator[] logicalAssignOperators = {
            AssignExpr.Operator.XOR, AssignExpr.Operator.AND, AssignExpr.Operator.OR};

    @Override
    public void visit(BinaryExpr n, JavaParserFacade arg) {
        super.visit(n, arg);
        boolean isBool = arg.getType(n.getRight()).describe().toLowerCase().contains("boolean");
        incrementScore(isBool && Arrays.asList(logicalOperators).contains(n.getOperator()));
    }

    @Override
    public void visit(UnaryExpr n, JavaParserFacade arg) {
        super.visit(n, arg);
        incrementScore(n.getOperator() == UnaryExpr.Operator.LOGICAL_COMPLEMENT);
    }

    @Override
    public String toString() {
        return "LOGICAL_OPERATIONS";
    }
}

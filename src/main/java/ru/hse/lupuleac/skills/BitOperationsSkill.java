package ru.hse.lupuleac.skills;

import com.github.javaparser.ast.expr.AssignExpr;
import com.github.javaparser.ast.expr.BinaryExpr;
import com.github.javaparser.ast.expr.UnaryExpr;
import com.github.javaparser.symbolsolver.javaparsermodel.JavaParserFacade;

import java.util.Arrays;

import static com.github.javaparser.ast.expr.BinaryExpr.Operator.*;

public class BitOperationsSkill extends Skill {
    private static final BinaryExpr.Operator[] bitOperators = {BINARY_AND,
            BINARY_OR, LEFT_SHIFT, SIGNED_RIGHT_SHIFT, UNSIGNED_RIGHT_SHIFT, XOR};

    private static final AssignExpr.Operator[] bitAssignOperators = {AssignExpr.Operator.LEFT_SHIFT,
            AssignExpr.Operator.SIGNED_RIGHT_SHIFT, AssignExpr.Operator.UNSIGNED_RIGHT_SHIFT,
            AssignExpr.Operator.XOR, AssignExpr.Operator.AND, AssignExpr.Operator.OR};

    @Override
    public void visit(BinaryExpr n, JavaParserFacade arg) {
        super.visit(n, arg);
        try {
            boolean isBool = arg.getType(n.getRight()).describe().toLowerCase().contains("boolean");
            incrementScore(!isBool && Arrays.asList(bitOperators).contains(n.getOperator()));
        } catch (Exception ignored) {
            //System.err.println("Cannot solve " + n);
        }
    }

    @Override
    public void visit(UnaryExpr n, JavaParserFacade arg) {
        super.visit(n, arg);
        incrementScore(n.getOperator() == UnaryExpr.Operator.BITWISE_COMPLEMENT);
    }

    @Override
    public void visit(AssignExpr n, JavaParserFacade arg) {
        super.visit(n, arg);
        try {
            boolean isBool = arg.getType(n.getTarget()).describe().toLowerCase().contains("boolean");
            incrementScore(!isBool && Arrays.asList(bitAssignOperators).contains(n.getOperator()));
        } catch (Exception ignored) {
        }
    }

    @Override
    public String toString() {
        return "BIT_OPERATIONS";
    }
}

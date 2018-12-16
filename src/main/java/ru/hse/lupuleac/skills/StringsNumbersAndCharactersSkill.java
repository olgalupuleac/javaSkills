package ru.hse.lupuleac.skills;

import com.github.javaparser.ast.expr.CharLiteralExpr;
import com.github.javaparser.ast.expr.IntegerLiteralExpr;
import com.github.javaparser.ast.expr.StringLiteralExpr;
import com.github.javaparser.symbolsolver.javaparsermodel.JavaParserFacade;
import ru.hse.lupuleac.skills.Skill;

public class StringsNumbersAndCharactersSkill extends Skill {
    @Override
    public String toString() {
        return "STRINGS_NUMBERS_AND_CHARACTERS";
    }

    @Override
    public void visit(IntegerLiteralExpr n, JavaParserFacade arg) {
        super.visit(n, arg);
        incrementScore(true);
    }

    @Override
    public void visit(CharLiteralExpr n, JavaParserFacade arg) {
        super.visit(n, arg);
        incrementScore(true);
    }

    @Override
    public void visit(StringLiteralExpr n, JavaParserFacade arg) {
        super.visit(n, arg);
        incrementScore(true);
    }
}

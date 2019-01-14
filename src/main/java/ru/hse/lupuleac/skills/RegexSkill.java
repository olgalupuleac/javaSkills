package ru.hse.lupuleac.skills;

import com.github.javaparser.ast.expr.MethodCallExpr;
import com.github.javaparser.symbolsolver.javaparsermodel.JavaParserFacade;

import java.util.stream.Stream;

public class RegexSkill extends Skill {
    private static String[] regexMethodPatterns = {"java\\.lang\\.String\\.matches",
            "java\\.lang\\.String\\.split",
            "java\\.lang\\.String\\.replaceFirst",
            "java\\.lang\\.String\\.replaceAll",
            "java\\.util\\.regex\\.Pattern\\.(.*)",
            "java\\.util\\.regex\\.Matcher\\.(.*)"};


    @Override
    public void visit(MethodCallExpr n, JavaParserFacade arg) {
        super.visit(n, arg);
        try {
            String name = arg.solve(n).getCorrespondingDeclaration()
                    .getQualifiedName();
            incrementScore(Stream.of(regexMethodPatterns).anyMatch(name::matches), name);
        } catch (Exception ignored) {
        }
    }

    @Override
    public String toString() {
        return "REGULAR_EXPRESSIONS";
    }
}

package ru.hse.lupuleac;

import com.github.javaparser.ast.body.ClassOrInterfaceDeclaration;
import com.github.javaparser.ast.expr.MethodCallExpr;
import com.github.javaparser.resolution.types.ResolvedReferenceType;
import com.github.javaparser.symbolsolver.javaparsermodel.JavaParserFacade;

public class CollectorsSkill extends Skill {
    @Override
    public void visit(MethodCallExpr n, JavaParserFacade javaParserFacade) {
        super.visit(n, javaParserFacade);
        try {
            incrementScore(javaParserFacade.solve(n).getCorrespondingDeclaration()
                    .getQualifiedName().startsWith("java.util.stream.Collector"));
        } catch (RuntimeException ignored) {
        }
    }

    @Override
    public void visit(ClassOrInterfaceDeclaration c, JavaParserFacade javaParserFacade) {
        super.visit(c, javaParserFacade);
        incrementScore(javaParserFacade.getTypeDeclaration(c).getAllAncestors().stream().map(ResolvedReferenceType::getQualifiedName).anyMatch(x -> x.equals("java.util.stream.Collector")));
    }

    @Override
    public String toString() {
        return "COLLECTORS";
    }
}

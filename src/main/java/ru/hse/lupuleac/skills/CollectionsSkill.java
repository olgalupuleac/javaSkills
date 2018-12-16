package ru.hse.lupuleac.skills;

import com.github.javaparser.ast.body.ClassOrInterfaceDeclaration;
import com.github.javaparser.ast.expr.MethodCallExpr;
import com.github.javaparser.symbolsolver.javaparsermodel.JavaParserFacade;

public class CollectionsSkill extends Skill {
    @Override
    public void visit(ClassOrInterfaceDeclaration n, JavaParserFacade javaParserFacade) {
        super.visit(n, javaParserFacade);
        hasAncestor("java.util.Collection", n, javaParserFacade);
    }

    @Override
    public void visit(MethodCallExpr m, JavaParserFacade javaParserFacade) {
        super.visit(m, javaParserFacade);
        matchMethodCall("java\\.util\\.Collection\\.(.*)", m, javaParserFacade);
    }

    @Override
    public String toString() {
        return "COLLECTIONS";
    }

   /* @Override
   //TODO
    public void visit(MethodDeclaration n, JavaParserFacade javaParserFacade) {
        super.visit(n, javaParserFacade);
        boolean hasCollectionAsParameter = n.getParameters().stream().map(Parameter::getType).filter(Type::isClassOrInterfaceType)
                .map(x -> javaParserFacade.getType(x)..getQualifiedName()).anyMatch(x -> x.startsWith("java.util.Collection"));
        incrementScore(hasCollectionAsParameter);

    }*/

}

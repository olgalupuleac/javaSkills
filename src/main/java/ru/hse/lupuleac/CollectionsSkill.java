package ru.hse.lupuleac;

import com.github.javaparser.ast.body.ClassOrInterfaceDeclaration;
import com.github.javaparser.ast.body.MethodDeclaration;
import com.github.javaparser.ast.body.Parameter;
import com.github.javaparser.ast.expr.MethodCallExpr;
import com.github.javaparser.ast.expr.VariableDeclarationExpr;
import com.github.javaparser.ast.type.Type;
import com.github.javaparser.resolution.types.ResolvedReferenceType;
import com.github.javaparser.symbolsolver.javaparsermodel.JavaParserFacade;

public class CollectionsSkill extends Skill {
    @Override
    public void visit(ClassOrInterfaceDeclaration n, JavaParserFacade javaParserFacade) {
        super.visit(n, javaParserFacade);
        boolean implementsCollection = javaParserFacade.getTypeDeclaration(n).getAllAncestors().stream().map(ResolvedReferenceType::getQualifiedName).anyMatch(x -> x.equals("java.util.Collection"));
        incrementScore(implementsCollection);
    }

    @Override
    public void visit(MethodCallExpr m, JavaParserFacade javaParserFacade) {
        super.visit(m, javaParserFacade);
        incrementScore(
                javaParserFacade.solve(m).getCorrespondingDeclaration()
                        .getQualifiedName().startsWith("java.util.Collection"));
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

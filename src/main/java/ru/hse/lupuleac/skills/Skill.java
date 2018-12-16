package ru.hse.lupuleac.skills;


import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.ast.body.ClassOrInterfaceDeclaration;
import com.github.javaparser.ast.expr.MethodCallExpr;
import com.github.javaparser.ast.expr.Name;
import com.github.javaparser.ast.expr.ObjectCreationExpr;
import com.github.javaparser.ast.visitor.VoidVisitorAdapter;
import com.github.javaparser.resolution.declarations.ResolvedClassDeclaration;
import com.github.javaparser.resolution.declarations.ResolvedMethodDeclaration;
import com.github.javaparser.resolution.types.ResolvedReferenceType;
import com.github.javaparser.symbolsolver.javaparsermodel.JavaParserFacade;
import com.github.javaparser.symbolsolver.model.resolution.SymbolReference;

public abstract class Skill extends VoidVisitorAdapter<JavaParserFacade> {
    protected int score;
    protected int minScore;
    public int getScore() {
        return score - minScore;
    }

    protected void incrementScore(boolean isIncremented) {
        if(isIncremented) {
            score++;
        }
    }

    protected void matchMethodCall(String regex, MethodCallExpr n, JavaParserFacade javaParserFacade) {
        try {
            SymbolReference<ResolvedMethodDeclaration> solved = javaParserFacade.solve(n);
            if (!solved.isSolved()) {
                //System.err.println("Cannot solve " + n.getName());
                return;
            }
            String qualifiedName = solved.getCorrespondingDeclaration()
                    .getQualifiedName();
            incrementScore(qualifiedName.matches(regex));
        } catch (Exception e) {
           //System.out.println("!!!!! " + n.getName());
        }
    }

    protected void logDebug(MethodCallExpr n, JavaParserFacade javaParserFacade) {
        System.out.println(javaParserFacade.solve(n).getCorrespondingDeclaration()
                .getQualifiedName());
    }

    protected void hasAncestor(String ancestor, ClassOrInterfaceDeclaration n, JavaParserFacade javaParserFacade) {
        try {
            incrementScore(javaParserFacade.getTypeDeclaration(n).getAllAncestors().stream().
                    map(ResolvedReferenceType::getQualifiedName).anyMatch(x -> x.equals(ancestor)));
        } catch (Exception e) {
            incrementScore(n.getImplementedTypes().stream().anyMatch(x -> ancestor.matches("(.*)\\." + x)));
            incrementScore(n.getExtendedTypes().stream().anyMatch(x -> ancestor.matches("(.*)\\." + x)));
        }
    }

    protected void hasParent(String ancestor, ClassOrInterfaceDeclaration n, JavaParserFacade javaParserFacade) {
        try {
            incrementScore(javaParserFacade.getTypeDeclaration(n).getAncestors().stream().
                    map(ResolvedReferenceType::getQualifiedName).anyMatch(x -> x.equals(ancestor)));
        } catch (Exception e) {
            incrementScore(n.getImplementedTypes().stream().anyMatch(x -> ancestor.matches("(.*)\\." + x)));
            incrementScore(n.getExtendedTypes().stream().anyMatch(x -> ancestor.matches("(.*)\\." + x)));
        }
    }

    protected void isSpecifiedObjectCreation(String className, ObjectCreationExpr n, JavaParserFacade arg){
        try {
            ResolvedClassDeclaration type = arg.solve(n).getCorrespondingDeclaration().declaringType();
            if (type.isClass()) {
                incrementScore(type.asClass().getQualifiedName().equals(className));
                incrementScore(type.getSuperClass().getQualifiedName().equals(className));
            }
        } catch (Exception e) {
            //System.err.println("Cannot resolve " + n);
        }
    }

    public void clear() {
        score = 0;
    }
}

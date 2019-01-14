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

import java.util.HashSet;
import java.util.Set;

public abstract class Skill extends VoidVisitorAdapter<JavaParserFacade> {
    private Set<String> grainSkills = new HashSet<>();
    public int getScore() {
        return grainSkills.size();
    }

    protected void incrementScore(boolean isIncremented, String grain) {
        if(isIncremented) {
            grainSkills.add(grain);
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
            incrementScore(qualifiedName.matches(regex), qualifiedName);
        } catch (Exception e) {
           //System.out.println("!!!!! " + n.getName());
        }
    }

    protected void logDebug(MethodCallExpr n, JavaParserFacade javaParserFacade) {
        System.out.println(javaParserFacade.solve(n).getCorrespondingDeclaration()
                .getQualifiedName());
    }

    protected void hasAncestor(String ancestor, ClassOrInterfaceDeclaration n, JavaParserFacade javaParserFacade) {
        String grain = "ancestor#" + ancestor;
        try {
            incrementScore(javaParserFacade.getTypeDeclaration(n).getAllAncestors().stream().
                    map(ResolvedReferenceType::getQualifiedName).anyMatch(x -> x.equals(ancestor)), grain);
        } catch (Exception e) {
            incrementScore(n.getImplementedTypes().stream().anyMatch(x -> ancestor.matches("(.*)\\." + x)), grain);
            incrementScore(n.getExtendedTypes().stream().anyMatch(x -> ancestor.matches("(.*)\\." + x)), grain);
        }
    }

    protected void hasParent(String ancestor, ClassOrInterfaceDeclaration n, JavaParserFacade javaParserFacade) {
        String grain = "ancestor#" + ancestor;
        try {
            incrementScore(javaParserFacade.getTypeDeclaration(n).getAncestors().stream().
                    map(ResolvedReferenceType::getQualifiedName).anyMatch(x -> x.equals(ancestor)), grain);
        } catch (Exception e) {
            incrementScore(n.getImplementedTypes().stream().anyMatch(x -> ancestor.matches("(.*)\\." + x)), grain);
            incrementScore(n.getExtendedTypes().stream().anyMatch(x -> ancestor.matches("(.*)\\." + x)), grain);
        }
    }

    protected void isSpecifiedObjectCreation(String className, ObjectCreationExpr n, JavaParserFacade arg){
        String grain = "new#" + className;
        try {
            ResolvedClassDeclaration type = arg.solve(n).getCorrespondingDeclaration().declaringType();
            if (type.isClass()) {
                incrementScore(type.asClass().getQualifiedName().equals(className), grain);
                incrementScore(type.getSuperClass().getQualifiedName().equals(className), grain);
            }
        } catch (Exception e) {
            //System.err.println("Cannot resolve " + n);
        }
    }

    public void clear() {
        grainSkills.clear();
    }

    public Set<String> getGrainSkills() {
        return grainSkills;
    }
}

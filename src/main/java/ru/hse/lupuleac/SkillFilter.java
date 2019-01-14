package ru.hse.lupuleac;

import com.github.javaparser.JavaParser;
import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.symbolsolver.JavaSymbolSolver;
import com.github.javaparser.symbolsolver.javaparsermodel.JavaParserFacade;
import com.github.javaparser.symbolsolver.resolution.typesolvers.CombinedTypeSolver;
import com.github.javaparser.symbolsolver.resolution.typesolvers.ReflectionTypeSolver;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Lists;
import org.jetbrains.annotations.NotNull;
import ru.hse.lupuleac.skills.*;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class SkillFilter {
    private static CombinedTypeSolver combinedTypeSolver;
    static {
        combinedTypeSolver = new CombinedTypeSolver();
        combinedTypeSolver.add(new ReflectionTypeSolver());

        // Configure JavaParser to use type resolution
        JavaSymbolSolver symbolSolver = new JavaSymbolSolver(combinedTypeSolver);
        JavaParser.getStaticConfiguration().setSymbolResolver(symbolSolver);
    }

    static List<Skill> skills =
                    Lists.newArrayList(
                            new ConstructorSkill(),
                            new EnumSkill(),
                            new StaticMembersSkill(),
                            new AnnotationSkill(),
                            new InitializationBlockSkill(),
                            new AnonymousClassSkill(),
                            new AbstractClassSkill(),
                            new InheritanceSkill(),
                            new InterfaceSkill(),
                            new OverridingSkill(),
                            new BigIntegerSkill(),
                            new MathLibrarySkill(),
                            new ReflectionSkill(),
                            new GenericsSkill(),
                            new WildcardSkill(),
                            new SerializationSkill(),
                            new ExceptionHandlingSkill(),
                            new ExceptionsSkill(),
                            new MethodDeclarationSkill(),
                            new MainMethodSkill(),
                            new StringBuilderSkill(),
                            new StringsSkill(),
                            new ArraySkill(),
                            new ControlFlowStatementSkill(),
                            new ScanningTheInputSkill(),
                            new IntegerSkill(),
                            new BitOperationsSkill(),
                            new TypeCastingSkill(),
                            new LogicalOperationsSkill(),
                            new CodeStyleSkill(),
                            new ThreadSkill(),
                            new ConcurrencySkill(),
                            new SocketSkill(),
                            new ListSkill(),
                            new MapSkill(),
                            new CollectionsSkill(),
                            new SetSkill(),
                            new IteratorSkill(),
                            new CollectorsSkill(),
                            new LambdaSkill(),
                            new MethodReferenceSkill(),
                            new StreamsSkill(),
                            new FilesSkill(),
                            new RegexSkill(),
                            new LoggingSkill(),
                            new StringsNumbersAndCharactersSkill());


    public static Map<String, Set<String>> getSkillsForCode(String code) {
        CompilationUnit agendaCu = JavaParser.parse(code);
        Map<String, Set<String>> res = new HashMap<>();
        for (Skill skill : skills) {
            skill.clear();
            agendaCu.accept(skill, JavaParserFacade.get(combinedTypeSolver));
            if (!skill.getGrainSkills().isEmpty()) {
                res.put(skill.toString(), skill.getGrainSkills());
            }
        }
        return res;
    }


}

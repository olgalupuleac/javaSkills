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
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

public class SkillFilter {
    private static Map<String, List<Skill>> topicsWithSkills = ImmutableMap.<String, List<Skill>>builder()
            .put(
                    "Classes and objects",
                    Lists.newArrayList(
                            new ConstructorSkill(),
                            new EnumSkill(),
                            //new StaticMembersSkill(),
                            new AnnotationSkill(),
                            new InitializationBlockSkill()
                    ))
            .put(
                    "Inheritance and polymorphism",
                    Lists.newArrayList(
                            new AnonymousClassSkill(),
                            new AbstractClassSkill(),
                            new InheritanceSkill(),
                            new InterfaceSkill(),
                            new OverridingSkill()
                    ))
            .put(
                    "Essential standard classes",
                    Lists.newArrayList(
                            new BigIntegerSkill(),
                            new MathLibrarySkill()
                    ))
            .put(
                    "Reflection",
                    Lists.newArrayList(
                            new ReflectionSkill()
                    )
            ).put(
                    "Generics",
                    Lists.newArrayList(
                            new GenericsSkill(),
                            new WildcardSkill()
                    )
            ).put(
                    "Serialization",
                    Lists.newArrayList(new SerializationSkill())
            ).put(
                    "Exception handling",
                    Lists.newArrayList(
                            new ExceptionHandlingSkill(),
                            new ExceptionsSkill()
                    )
            ).put("Methods",
                    Lists.newArrayList(
                            new MethodDeclarationSkill(),
                            new MainMethodSkill()
                    )
            ).put(
                    "Strings",
                    Lists.newArrayList(
                            new StringBuilderSkill(),
                            new StringsSkill()
                    )
            ).put(
                    "Arrays",
                    Lists.newArrayList(new ArraySkill())
            ).put(
                    "Control flow statements",
                    Lists.newArrayList(new ControlFlowStatementSkill())
            )
            .put(
                    "Simple program",
                    Lists.newArrayList(
                            new ScanningTheInputSkill(),
                            new IntegerSkill()
                    )
            ).put(
                    "Data types and operations",
                    Lists.newArrayList(
                            new BitOperationsSkill(),
                            new TypeCastingSkill(),
                            new LogicalOperationsSkill()
                    )
            ).put(
                    "Code style",
                    Lists.newArrayList(new CodeStyleSkill())
            ).put(
                    "Multithreading",
                    Lists.newArrayList(
                            new ThreadSkill(),
                            new ConcurrencySkill()
                    )
            ).put(
                    "Networking",
                    Lists.newArrayList(new SocketSkill())
            ).put(
                    "Collections",
                    Lists.newArrayList(
                            new ListSkill(),
                            new MapSkill(),
                            new CollectionsSkill(),
                            new SetSkill(),
                            new IteratorSkill()
                    )
            ).put(
                    "Functional streams",
                    Lists.newArrayList(
                            new CollectorsSkill(),
                            new LambdaSkill(),
                            new MethodReferenceSkill(),
                            new StreamsSkill()
                    )
            ).put(
                    "File processing",
                    Lists.newArrayList(new FilesSkill())
            ).put(
                    "Regular expressions",
                    Lists.newArrayList(new RegexSkill())
            ).put(
                "Logging",
                Lists.newArrayList(new LoggingSkill())
            ).build();

    public static Map<String, Map<String, Integer>> getSkillsScoreForOneFile(File file) throws IOException {
        CombinedTypeSolver combinedTypeSolver = new CombinedTypeSolver();
        combinedTypeSolver.add(new ReflectionTypeSolver());

        // Configure JavaParser to use type resolution
        JavaSymbolSolver symbolSolver = new JavaSymbolSolver(combinedTypeSolver);
        JavaParser.getStaticConfiguration().setSymbolResolver(symbolSolver);

        CompilationUnit agendaCu = JavaParser.parse(new FileInputStream(file));
        Map<String, Map<String, Integer>> result = new HashMap<>();
        for (Map.Entry<String, List<Skill>> skillsWithTopic : topicsWithSkills.entrySet()) {
            String topic = skillsWithTopic.getKey();
            Map<String, Integer> skillsForTopic = new HashMap<>();
            List<Skill> skills = skillsWithTopic.getValue();
            for (Skill skill : skills) {
                skill.clear();
                agendaCu.accept(skill, JavaParserFacade.get(combinedTypeSolver));
                if (skill.getScore() == 0) {
                    continue;
                }
                skillsForTopic.put(skill.toString(), skill.getScore());
            }
            if (!skillsForTopic.isEmpty()) {
                result.put(topic, skillsForTopic);
            }
        }
        return result;
    }

    public static void printSkillsForFile(File file, PrintStream out) throws Exception {
        Map<String, Map<String, Integer>> result = getSkillsScoreForOneFile(file);
        for (Map.Entry<String, Map<String, Integer>> entry : result.entrySet()) {
            //System.out.println(entry.getKey());
            for (Map.Entry<String, Integer> innerEntry : entry.getValue().entrySet()) {
                for (int i = 0; i < innerEntry.getValue(); i++) {
                    out.println(innerEntry.getKey()  /* + " " + innerEntry.getValue()*/);
                }
            }
        }
        out.println();
    }

    private static void getProgress(@NotNull String[] paths) {
        Map<String, Map<String, Integer>> knowledge = new HashMap<>();
        for (String path : paths) {
            System.out.println(path);
            try {
                Map<String, Map<String, Integer>> newSkills = getSkillsScoreForOneFile(new File(path));
                for (Map.Entry<String, Map<String, Integer>> entry : newSkills.entrySet()) {
                    String key = entry.getKey();
                    if (!knowledge.containsKey(key)) {
                        System.out.println("New skill acquired:\n" + key);
                        for (Map.Entry<String, Integer> keyVal : entry.getValue().entrySet()) {
                            System.out.println("    " + keyVal.getKey() + " " + keyVal.getValue());
                        }
                        knowledge.put(key, entry.getValue());
                        continue;
                    }
                    for (Map.Entry<String, Integer> innerEntry : entry.getValue().entrySet()) {
                        if (!knowledge.get(key).containsKey(innerEntry.getKey())) {
                            System.out.println(innerEntry.getKey() + " + " + innerEntry.getValue() + " to " + key);
                            knowledge.get(key).put(innerEntry.getKey(), innerEntry.getValue());
                        }
                    }
                }
            } catch (Exception e) {
                System.err.println(e.getMessage());
            }
        }
    }

    private static void getProgressForOneUser(String path, PrintStream out) throws Exception {
        Files.walk(Paths.get(path))
                .filter(Files::isRegularFile)
                .peek(System.out::println)
                .forEach(x -> {
                    try {
                        printSkillsForFile(x.toFile(), out);
                    } catch (Exception ignored) {
                    }
                });
    }


    public static void main(String[] args) throws Exception {
        String basicPath = "C:\\Users\\olga\\PycharmProjects\\csv";
        String[] paths = IntStream.range(2, 36).mapToObj(
                i -> basicPath + File.separator + i + File.separator + 0 + File.separator + "Solution.java"
        ).toArray(String[]::new);
        String path = "C:\\Users\\olga\\PycharmProjects\\csv\\31\\0\\Solution.java";
        PrintStream err = new PrintStream(new File("exceptions.txt"));
        try {
            //System.out.println(SkillCalculator.getScore(new FilesSkill(), path, "C:\\Users\\olga\\PycharmProjects\\csv\\33\\0"));
            //printSkillsForFile();
            //getProgress(paths);
             getProgressForOneUser("C:\\Users\\olga\\PycharmProjects\\csv\\1", new PrintStream(
                     new File("C:\\Users\\olga\\PycharmProjects\\csv\\constitution.txt")));
           // printSkillsForFile(new File("C:\\Users\\olga\\PycharmProjects\\csv\\1\\53996\\0.java"));
        } catch (Exception e) {
            System.out.println("Exception");
            e.printStackTrace();
        }
    }
}

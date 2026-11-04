package hsd.inflab.dice.framework;

import hsd.inflab.dice.types.Dice;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Modifier;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

/*
 *
 * DIESE KLASSE NICHT VERÄNDERN!
 *
 */

public class DiceFactory {
    public static List<Class<? extends Dice>> discoverDiceTypes() {
        String packagePath = "hsd/inflab/dice/types";
        URL resource = DiceFactory.class.getClassLoader().getResource(packagePath);
        if (resource == null) {
            return List.of();
        }

        List<Class<? extends Dice>> types = new ArrayList<>();
        try {
            Path dir = Paths.get(resource.toURI());
            try (Stream<Path> files = Files.list(dir)) {
                for (Path file : files.filter(p -> p.toString().endsWith(".class")).toList()) {
                    String simpleName = file.getFileName().toString().replace(".class", "");
                    Class<?> candidate = Class.forName("hsd.inflab.dice.types." + simpleName);
                    if (Dice.class.isAssignableFrom(candidate)
                            && !Modifier.isAbstract(candidate.getModifiers())
                            && candidate != Dice.class) {
                        types.add((Class<? extends Dice>) candidate);
                    }
                }
            }
        } catch (URISyntaxException | IOException | ClassNotFoundException e) {
            throw new IllegalStateException("Würfeltypen konnten nicht ermittelt werden.", e);
        }

        types.sort(Comparator.comparing(Class::getSimpleName));

        return types;
    }

    public static Dice create(Class<? extends Dice> type) {
        try {
            return type.getConstructor().newInstance();
        } catch (NoSuchMethodException e) {
            throw new IllegalArgumentException("Der Würfeltyp "
                    + type.getSimpleName() + " kann nicht ohne Seitenzahl erzeugt werden.");
        } catch (InvocationTargetException e) {
            if (e.getCause() instanceof IllegalArgumentException iae) {
                throw iae;
            }
            throw new IllegalStateException("Würfel konnte nicht erzeugt werden.", e);
        } catch (InstantiationException | IllegalAccessException e) {
            throw new IllegalStateException("Würfel konnte nicht erzeugt werden.", e);
        }
    }

    public static Dice create(Class<? extends Dice> type, int sides) {
        if (!supportsSides(type)) {
            throw new IllegalArgumentException("Der Würfeltyp "
                    + type.getSimpleName() + " kann nicht mit einer Seitenzahl erzeugt werden.");
        }
        try {
            return type.getConstructor(int.class).newInstance(sides);
        } catch (NoSuchMethodException e) {
            throw new IllegalArgumentException("Der Würfeltyp "
                    + type.getSimpleName() + " kann nicht mit einer Seitenzahl erzeugt werden.");
        } catch (InvocationTargetException e) {
            if (e.getCause() instanceof IllegalArgumentException iae) {
                throw iae;
            }
            throw new IllegalStateException("Würfel konnte nicht erzeugt werden.", e);
        } catch (InstantiationException | IllegalAccessException e) {
            throw new IllegalStateException("Würfel konnte nicht erzeugt werden.", e);
        }
    }

    public static boolean supportsSides(Class<? extends Dice> type) {
        try {
            type.getConstructor(int.class);
            return true;
        } catch (NoSuchMethodException e) {
            return false;
        }
    }

}

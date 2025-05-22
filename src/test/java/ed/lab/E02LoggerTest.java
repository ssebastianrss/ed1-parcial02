package ed.lab;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.io.IOException;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class E02LoggerTest {

    @ParameterizedTest
    @MethodSource("testArguments")
    void shouldPrintMessage(List<LoggingOperation> loggingOperations) {
        List<LoggingOperation> previousOps = new LinkedList<>();

        E02Logger e02Logger = new E02Logger();

        for (LoggingOperation loggingOperation : loggingOperations) {
            previousOps.add(loggingOperation);

            boolean actual = e02Logger.shouldPrintMessage(loggingOperation.timestamp(), loggingOperation.message());

            assertEquals(loggingOperation.expectedResult(), actual,
                    () -> String.format("Error al llamar a shouldPrintMessage(%s, %s). Se esperaba %s, pero se obtuvo %s\nLista de operaciones previas:\n%s",
                            loggingOperation.timestamp(), loggingOperation.message(), loggingOperation.expectedResult(), actual,
                            previousOps.stream()
                                    .map(String::valueOf)
                                    .collect(Collectors.joining("\n"))));
        }

    }

    private static Stream<List<LoggingOperation>> testArguments() {
        try {
            final String fileContent = new String(
                    Objects.requireNonNull(E02LoggerTest.class.getClassLoader()
                                    .getResourceAsStream("ed/lab/E02.csv"))
                            .readAllBytes());

            final String[] lines = fileContent.split("\n");

            Stream.Builder<List<LoggingOperation>> builder = Stream.builder();

            List<LoggingOperation> operations = new LinkedList<>();

            for (String line : lines) {
                if (line.isBlank()) {
                    builder.add(operations);
                    operations = new LinkedList<>();
                    continue;
                }

                String[] commands = line.split(",");

                int timestamp = Integer.parseInt(commands[0]);
                String message = commands[1].trim();
                boolean expectedResult = Boolean.parseBoolean(commands[2].trim());

                operations.add(new LoggingOperation(timestamp, message, expectedResult));
            }

            if (!operations.isEmpty())
                builder.add(operations);

            return builder.build();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private record LoggingOperation(int timestamp, String message, boolean expectedResult) {
        @Override
        public String toString() {
            return String.format("shouldPrintMessage(%d, %s) -> %s", timestamp, message, expectedResult);
        }
    }
}
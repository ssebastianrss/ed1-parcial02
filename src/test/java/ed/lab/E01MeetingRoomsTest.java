package ed.lab;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class E01MeetingRoomsTest {

    @ParameterizedTest
    @CsvFileSource(resources = "E01.csv", useHeadersInDisplayName = true, delimiter = '|', maxCharsPerColumn = 8192)
    void minMeetingRooms(String input, Integer expected) {
        List<MeetingInterval> meetingIntervals = Arrays.stream(input.trim().split(","))
                .map(s -> s.split("-"))
                .map(s -> {
                    int startTime = Integer.parseInt(s[0]);
                    int endTime = Integer.parseInt(s[1]);

                    return new MeetingInterval(startTime, endTime);
                })
                .toList();

        E01MeetingRooms e01 = new E01MeetingRooms();
        int actual = e01.minMeetingRooms(new ArrayList<>(meetingIntervals));
        assertEquals(expected, actual,
                () -> String.format("Se esperaba: %s y se obtuvo: %s\nIntervalos: %s",
                        expected,
                        actual,
                        meetingIntervals));
    }
}
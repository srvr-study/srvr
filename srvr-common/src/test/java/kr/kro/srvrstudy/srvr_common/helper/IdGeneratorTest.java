package kr.kro.srvrstudy.srvr_common.helper;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class IdGeneratorTest {

    @Test
    @DisplayName("동시 Id 제너레이터 테스트")
    void generate_500_000_Ids_must_not_be_same_concurrently() {
        // given
        int endNumber = 500_000;
        Map<Long, Object> duplicationCheckMap = new ConcurrentHashMap<>();

        // when
        IntStream.range(0, endNumber)
                 .parallel()
                 .forEach((index) -> duplicationCheckMap.put(IdGenerator.generate(), index));

        // then
        assertEquals(endNumber, duplicationCheckMap.size());
    }

    @Test
    @DisplayName("Id 제너레이터 테스트")
    void generate_500_000_Ids_must_not_be_same() {
        // given
        int endNumber = 500_000;
        Set<Long> duplicationCheckSet = new HashSet<>();

        // when
        IntStream.range(0, endNumber)
                 .forEach((index) -> duplicationCheckSet.add(IdGenerator.generate()));

        // then
        assertEquals(endNumber, duplicationCheckSet.size());
    }

}

package ua.kh.mst.demo.repository.impl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ua.kh.mst.demo.domain.Info;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class InMemoryInfoRepositoryTest {

    private static final int DEFAULT_TOP_RESULTS_LIMIT = 20;

    private InMemoryInfoRepository infoRepository;

    @BeforeEach
    void init() {
        infoRepository = new InMemoryInfoRepository();
    }

    @Test
    void shouldReturnOrderedTopUserInfoByUserId() {
        int userId = 1;
        Info info1 = new Info(userId, 1, 1);
        Info info2 = new Info(userId, 1, 2);
        Info info3 = new Info(userId, 2, 3);
        Info info4 = new Info(userId, 3, 3);
        infoRepository.createInfo(info1);
        infoRepository.createInfo(info2);
        infoRepository.createInfo(info3);
        infoRepository.createInfo(info4);

        List<Info> expectedResult = List.of(info4, info3, info2, info1);
        List<Info> actualResult = infoRepository.getTopUserInfo(userId, DEFAULT_TOP_RESULTS_LIMIT);

        assertIterableEquals(expectedResult, actualResult);
    }

    @Test
    void shouldNotReturnUserInfoForOtherUserId() {
        int userId = 1;
        int otherUserId = 2;
        Info info1 = new Info(userId, 1, 1);
        Info info2 = new Info(userId, 1, 2);
        Info otherInfo = new Info(otherUserId, 2, 3);
        infoRepository.createInfo(info1);
        infoRepository.createInfo(info2);
        infoRepository.createInfo(otherInfo);

        List<Info> expectedResult = List.of(info2, info1);
        List<Info> actualResult = infoRepository.getTopUserInfo(userId, DEFAULT_TOP_RESULTS_LIMIT);

        assertIterableEquals(expectedResult, actualResult);
    }

    @Test
    void shouldLimitTopUserResults() {
        int topResultsLimit = 3;

        int userId = 1;
        Info info1 = new Info(userId, 1, 1);
        Info info2 = new Info(userId, 1, 2);
        Info info3 = new Info(userId, 2, 3);
        Info info4 = new Info(userId, 3, 3);
        infoRepository.createInfo(info1);
        infoRepository.createInfo(info2);
        infoRepository.createInfo(info3);
        infoRepository.createInfo(info4);

        List<Info> expectedResult = List.of(info4, info3, info2);
        List<Info> actualResult = infoRepository.getTopUserInfo(userId, topResultsLimit);

        assertIterableEquals(expectedResult, actualResult);
    }

    @Test
    void shouldReturnOrderedTopLevelInfoByLevelId() {
        int levelId = 1;
        Info info1 = new Info(1, levelId, 1);
        Info info2 = new Info(1, levelId, 2);
        Info info3 = new Info(2, levelId, 3);
        Info info4 = new Info(3, levelId, 3);
        infoRepository.createInfo(info1);
        infoRepository.createInfo(info2);
        infoRepository.createInfo(info3);
        infoRepository.createInfo(info4);

        List<Info> expectedResult = List.of(info4, info3, info2, info1);
        List<Info> actualResult = infoRepository.getTopLevelInfo(levelId, DEFAULT_TOP_RESULTS_LIMIT);

        assertIterableEquals(expectedResult, actualResult);
    }

    @Test
    void shouldNotReturnLevelInfoForOtherLevelId() {
        int levelId = 1;
        int otherLevelId = 2;
        Info info1 = new Info(1, levelId, 1);
        Info info2 = new Info(1, levelId, 2);
        Info otherInfo = new Info(2, otherLevelId, 3);
        infoRepository.createInfo(info1);
        infoRepository.createInfo(info2);
        infoRepository.createInfo(otherInfo);

        List<Info> expectedResult = List.of(info2, info1);
        List<Info> actualResult = infoRepository.getTopLevelInfo(levelId, DEFAULT_TOP_RESULTS_LIMIT);

        assertIterableEquals(expectedResult, actualResult);
    }

    @Test
    void shouldLimitTopLevelResults() {
        int topResultsLimit = 3;

        int levelId = 1;
        Info info1 = new Info(1, levelId, 1);
        Info info2 = new Info(1, levelId, 2);
        Info info3 = new Info(2, levelId, 3);
        Info info4 = new Info(3, levelId, 3);
        infoRepository.createInfo(info1);
        infoRepository.createInfo(info2);
        infoRepository.createInfo(info3);
        infoRepository.createInfo(info4);

        List<Info> expectedResult = List.of(info4, info3, info2);
        List<Info> actualResult = infoRepository.getTopLevelInfo(levelId, topResultsLimit);

        assertIterableEquals(expectedResult, actualResult);
    }
}
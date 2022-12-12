package ua.kh.mst.demo.repository;

import ua.kh.mst.demo.domain.Info;

import java.util.List;

public interface InfoRepository {

    List<Info> getTopUserInfo(int userId, int limit);

    List<Info> getTopLevelInfo(int levelId, int limit);

    void createInfo(Info info);
}

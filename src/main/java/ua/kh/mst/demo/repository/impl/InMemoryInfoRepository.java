package ua.kh.mst.demo.repository.impl;

import org.springframework.stereotype.Component;
import ua.kh.mst.demo.domain.Info;
import ua.kh.mst.demo.repository.InfoRepository;

import java.util.Comparator;
import java.util.List;
import java.util.Vector;
import java.util.stream.Collectors;

@Component
public class InMemoryInfoRepository implements InfoRepository {

    private final List<Info> infos = new Vector<>();

    @Override
    public List<Info> getTopUserInfo(int userId, int limit) {
        return infos.stream()
                    .filter(i -> i.getUserId() == userId)
                    .sorted(Comparator.comparingInt(Info::getResult)
                                      .thenComparing(Info::getLevelId)
                                      .reversed())
                    .limit(limit)
                    .collect(Collectors.toList());
    }

    @Override
    public List<Info> getTopLevelInfo(int levelId, int limit) {
        return infos.stream()
                    .filter(i -> i.getLevelId() == levelId)
                    .sorted(Comparator.comparingInt(Info::getResult)
                                      .thenComparing(Info::getUserId)
                                      .reversed())
                    .limit(limit)
                    .collect(Collectors.toList());
    }

    @Override
    public void createInfo(Info info) {
        infos.add(info);
    }
}

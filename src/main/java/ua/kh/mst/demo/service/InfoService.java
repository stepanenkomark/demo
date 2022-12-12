package ua.kh.mst.demo.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ua.kh.mst.demo.domain.Info;
import ua.kh.mst.demo.properties.ApplicationProperties;
import ua.kh.mst.demo.repository.InfoRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class InfoService {

    private final InfoRepository infoRepository;
    private final ApplicationProperties properties;

    public List<Info> getTopUserInfo(int userId) {
        return infoRepository.getTopUserInfo(userId, properties.getInfoTopCount());
    }

    public List<Info> getTopLevelInfo(int levelId) {
        return infoRepository.getTopLevelInfo(levelId, properties.getInfoTopCount());
    }

    public void setInfo(Info info) {
        infoRepository.createInfo(info);
    }
}

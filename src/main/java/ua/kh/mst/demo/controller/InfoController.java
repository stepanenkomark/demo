package ua.kh.mst.demo.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ua.kh.mst.demo.domain.Info;
import ua.kh.mst.demo.service.InfoService;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class InfoController {

    private final InfoService infoService;

    @GetMapping(path = "/userinfo/{user_id}")
    public List<Info> getUserInfo(@PathVariable("user_id") int userId) {
        return infoService.getTopUserInfo(userId);
    }

    @GetMapping(path = "/levelinfo/{level_id}")
    public List<Info> getLevelInfo(@PathVariable("level_id") int levelId) {
        return infoService.getTopLevelInfo(levelId);
    }

    @PutMapping(path = "/setinfo")
    public void putInfo(@RequestBody Info info) {
        infoService.setInfo(info);
    }
}

package ua.kh.mst.demo.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Info {

    @JsonProperty("user_id")
    private int userId;
    @JsonProperty("level_id")
    private int levelId;
    private int result;
}

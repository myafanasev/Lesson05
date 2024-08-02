package ru.dl.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

// дополнительные признаки для сегмента КИБ(VIP),
@Data
public class ModelProp {
    List<ModelPropBody> data;

    @Data
    private static class ModelPropBody {
        private String key;
        private String value;
        private String name;
    }

}

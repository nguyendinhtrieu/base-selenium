package ueirt.logic.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@AllArgsConstructor
@Data
public class SettingJob {
    private List<MyData> myData;
    private int nThread;
}

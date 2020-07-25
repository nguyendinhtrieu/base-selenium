package ueirt.logic.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;

@AllArgsConstructor
@Getter
public class MyData {
    private String data;
    private Point point;
    private Dimension dimension;
}

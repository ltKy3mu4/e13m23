package ru.mpei.lec19.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.mpei.lec19.DataSource;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Request {
    private DataSource.GoodsType type;
}

package ru.mpei.lec19;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DataSourceTest {
    @Test
    void testRun(){
        DataSource ds = new DataSource();
        ds.ss(4444);
    }
}
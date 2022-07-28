package org.jeecg;

import org.jeecg.system.service.ICeshiZhongkrNoteService;
import org.jeecg.system.service.impl.CeshiZhongkrNoteServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class YuanTestApplicationTests {

    @Autowired
    private ICeshiZhongkrNoteService ceshiZhongkrNoteService;
    @Test
    void contextLoads() {
        System.out.println(new CeshiZhongkrNoteServiceImpl().list());
    }

}

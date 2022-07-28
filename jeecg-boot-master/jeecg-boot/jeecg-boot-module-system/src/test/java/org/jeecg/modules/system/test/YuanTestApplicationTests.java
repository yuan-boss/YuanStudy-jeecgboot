package org.jeecg.modules.system.test;

import org.jeecg.JeecgSystemApplication;
import org.jeecg.system.entity.CeshiZhongkrNote;
import org.jeecg.system.service.ICeshiZhongkrNoteService;
import org.jeecg.system.service.impl.CeshiZhongkrNoteServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT,classes = JeecgSystemApplication.class)
class YuanTestApplicationTests {

    @Autowired
    private ICeshiZhongkrNoteService ceshiZhongkrNoteService;
    @Test
    void contextLoads() {
        CeshiZhongkrNote ceshiZhongkrNote = new CeshiZhongkrNote().setCreateBy("yuan").setCreateTime(new Date()).setSysOrgCode("统战部");
        System.out.println(ceshiZhongkrNoteService.save(ceshiZhongkrNote));
    }

}

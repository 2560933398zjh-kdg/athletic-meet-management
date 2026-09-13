package com.itheima.athleticmeet.mapper;

import com.itheima.athleticmeet.AthleticmeetApplicationTests; // 不需要引入，只是说明位置
import com.itheima.athleticmeet.entity.Athlete;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest  // 与您现有的测试类风格一致
@Transactional
public class AthleteMapperTest {
    @Autowired
    private AthleteMapper athleteMapper;

    @Test
    void testFindAll() {
        List<Athlete> list = athleteMapper.findAll();
        assertNotNull(list);
        System.out.println("记录数：" + list.size());
    }

    @Test
    void testFindById() {
        Athlete athlete = athleteMapper.findById(1);
        // 如果有数据可以取消注释
        // assertNotNull(athlete);
    }

    @Test
    void testInsert() {
        Athlete athlete = new Athlete();
        athlete.setName("王五");
        athlete.setGender("男");
        athlete.setTeam("篮球队");
        int rows = athleteMapper.insert(athlete);
        assertEquals(1, rows);
        assertNotNull(athlete.getId());
    }

    @Test
    void testUpdate() {
        // 插入临时数据
        Athlete athlete = new Athlete();
        athlete.setName("李四");
        athlete.setGender("女");
        athlete.setTeam("排球队");
        athleteMapper.insert(athlete);
        Integer id = athlete.getId();

        athlete.setTeam("羽毛球队");
        int rows = athleteMapper.update(athlete);
        assertEquals(1, rows);

        Athlete updated = athleteMapper.findById(id);
        assertEquals("羽毛球队", updated.getTeam());
    }

    @Test
    void testDeleteById() {
        Athlete athlete = new Athlete();
        athlete.setName("赵六");
        athleteMapper.insert(athlete);
        Integer id = athlete.getId();

        int rows = athleteMapper.deleteById(id);
        assertEquals(1, rows);

        assertNull(athleteMapper.findById(id));
    }
}


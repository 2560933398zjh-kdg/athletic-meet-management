package com.itheima.athleticmeet.mapper;

import com.itheima.athleticmeet.entity.Event;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface EventMapper {
    @Select("SELECT * FROM event")
    List<Event> findAll();

    @Select("SELECT * FROM event WHERE id = #{id}")
    Event findById(Integer id);

    @Insert("INSERT INTO event(name, date) VALUES(#{name}, #{date})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    int insert(Event event);

    @Update("UPDATE event SET name=#{name}, date=#{date} WHERE id=#{id}")
    int update(Event event);

    @Delete("DELETE FROM event WHERE id = #{id}")
    int deleteById(Integer id);
}

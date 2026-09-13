package com.itheima.athleticmeet.mapper;

import com.itheima.athleticmeet.entity.Athlete;
import org.apache.ibatis.annotations.*;

import java.util.List;


@Mapper
public interface AthleteMapper {
    @Select("SELECT * FROM athlete WHERE id = #{id}")
    Athlete findById(Integer id);

    @Select("SELECT * FROM athlete")
    List<Athlete> findAll();

    @Insert("INSERT INTO athlete(name, gender, team) VALUES(#{name}, #{gender}, #{team})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    int insert(Athlete athlete);

    @Update("UPDATE athlete SET name=#{name}, gender=#{gender}, team=#{team} WHERE id=#{id}")
    int update(Athlete athlete);

    @Delete("DELETE FROM athlete WHERE id = #{id}")
    int deleteById(Integer id);
}

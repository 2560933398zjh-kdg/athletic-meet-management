package com.itheima.athleticmeet.mapper;
import com.itheima.athleticmeet.entity.Score;
import com.itheima.athleticmeet.vo.ScoreRankVO;
import org.apache.ibatis.annotations.*;
import java.util.List;

@Mapper
public interface ScoreMapper {
    // 插入成绩（运动员-项目-分数）
    @Insert("INSERT INTO score(athlete_id, event_id, score) VALUES(#{athleteId}, #{eventId}, #{score})")
    int insert(Score score);

    // 根据运动员ID和项目ID查询成绩（用于判断是否已存在，可选）
    @Select("SELECT * FROM score WHERE athlete_id = #{athleteId} AND event_id = #{eventId}")
    Score findByAthleteAndEvent(@Param("athleteId") Integer athleteId, @Param("eventId") Integer eventId);

    // 查询某项目成绩排名（运动员姓名、项目名称、分数，按分数降序）
    @Select("SELECT a.name as athleteName, e.name as eventName, s.score " +
            "FROM score s " +
            "JOIN athlete a ON s.athlete_id = a.id " +
            "JOIN event e ON s.event_id = e.id " +
            "WHERE s.event_id = #{eventId} " +
            "ORDER BY s.score DESC")
    List<ScoreRankVO> getRankByEventId(@Param("eventId") Integer eventId);

    // 查询某运动员的所有成绩
    @Select("SELECT e.name as eventName, s.score " +
            "FROM score s JOIN event e ON s.event_id = e.id " +
            "WHERE s.athlete_id = #{athleteId}")
    List<ScoreRankVO> getScoresByAthleteId(@Param("athleteId") Integer athleteId);
}

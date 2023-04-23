package personal.xjl.jerrymouse.mapper;

import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;
import personal.xjl.jerrymouse.entity.Course;
import personal.xjl.jerrymouse.entity.Teacher;

import java.util.List;

@Mapper
public interface TeacherMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table teacher
     *
     * @mbggenerated
     */
    @Delete({
            "delete from teacher",
            "where Id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table teacher
     *
     * @mbggenerated
     */
    @Insert({
            "insert into teacher (Id, name, ",
            "password, sex, birthday, ",
            "course_id, professional)",
            "values (#{id,jdbcType=INTEGER}, #{name,jdbcType=VARCHAR}, ",
            "#{password,jdbcType=VARCHAR}, #{sex,jdbcType=INTEGER}, #{birthday,jdbcType=VARCHAR}, ",
            "#{course_Id,jdbcType=INTEGER}, #{professional,jdbcType=VARCHAR})"
    })
    int insert(Teacher record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table teacher
     *
     * @mbggenerated
     */
    @InsertProvider(type=TeacherSqlProvider.class, method="insertSelective")
    int insertSelective(Teacher record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table teacher
     *
     * @mbggenerated
     */
    @Select({
            "select",
            "*",
            "from teacher",

    })
    @Results({
            @Result(column="Id", property="id", jdbcType=JdbcType.INTEGER, id=true),
            @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR),
            @Result(column="password", property="password", jdbcType=JdbcType.VARCHAR),
            @Result(column="sex", property="sex", jdbcType=JdbcType.INTEGER),
            @Result(column="birthday", property="birthday", jdbcType=JdbcType.VARCHAR),
            @Result(column="course_id", property="course_Id", jdbcType=JdbcType.INTEGER),
            @Result(column="professional", property="professional", jdbcType=JdbcType.VARCHAR),
            @Result(column="id", property="courses", javaType= List.class,
            many=@Many(select = "personal.xjl.jerrymouse.mapper.CourseMapper.selectCourseByTeacherId"))
    })
    List<Teacher>  queryAll();
    @Select({
            "select",
            "Id, name, password, sex, birthday, course_id, professional",
            "from teacher",
            "where Id = #{id,jdbcType=INTEGER}"
    })
    @Results({
            @Result(column="Id", property="id", jdbcType=JdbcType.INTEGER, id=true),
            @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR),
            @Result(column="password", property="password", jdbcType=JdbcType.VARCHAR),
            @Result(column="sex", property="sex", jdbcType=JdbcType.INTEGER),
            @Result(column="birthday", property="birthday", jdbcType=JdbcType.VARCHAR),
            @Result(column="course_id", property="course_Id", jdbcType=JdbcType.INTEGER),
            @Result(column="professional", property="professional", jdbcType=JdbcType.VARCHAR)
    })
    Teacher selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table teacher
     *
     * @mbggenerated
     */
    @UpdateProvider(type=TeacherSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(Teacher record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table teacher
     *
     * @mbggenerated
     */
    @Update({
            "update teacher",
            "set name = #{name,jdbcType=VARCHAR},",
            "password = #{password,jdbcType=VARCHAR},",
            "sex = #{sex,jdbcType=INTEGER},",
            "birthday = #{birthday,jdbcType=VARCHAR},",
            "course_id = #{course_Id,jdbcType=INTEGER},",
            "professional = #{professional,jdbcType=VARCHAR}",
            "where Id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(Teacher record);

    @Select("SELECT  * from teacher where name=#{username} and password=#{password}")
    List<Teacher> selectByNameAndPassword(String username, String password);

    @Select("select * from teacher t,tbl_teacherCourse tc where t.id=tc.teacher_id and tc.course_id=#{courseId}")
    List<Teacher> selectTeacherByCourseId(int courseId);
}
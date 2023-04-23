package personal.xjl.jerrymouse.mapper;

import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;
import personal.xjl.jerrymouse.entity.Course;

import java.util.List;
@Mapper
public interface CourseMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table course
     *
     * @mbggenerated
     */
    @Delete({
            "delete from course",
            "where Id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table course
     *
     * @mbggenerated
     */
    @Insert({
            "insert into course (Id, name, ",
            "teacher_id)",
            "values (#{id,jdbcType=INTEGER}, #{name,jdbcType=VARCHAR}, ",
            "#{teacherId,jdbcType=INTEGER})"
    })
    int insert(Course record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table course
     *
     * @mbggenerated
     */
    @InsertProvider(type=CourseSqlProvider.class, method="insertSelective")
    int insertSelective(Course record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table course
     *
     * @mbggenerated
     */
    @Select({
            "select",
            "Id, name, teacher_id",
            "from course",
            "where Id = #{id,jdbcType=INTEGER}"
    })
    @Results({
            @Result(column="Id", property="id", jdbcType=JdbcType.INTEGER, id=true),
            @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR),
            @Result(column="teacher_id", property="teacherId", jdbcType=JdbcType.INTEGER)
    })
    Course selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table course
     *
     * @mbggenerated
     */
    @UpdateProvider(type=CourseSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(Course record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table course
     *
     * @mbggenerated
     */
    @Update({
            "update course",
            "set name = #{name,jdbcType=VARCHAR},",
            "teacher_id = #{teacherId,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(Course record);
    @Select({
            "select",
            "Id, name, teacher_id",
            "from course"
    })
    @Results({
            @Result(column="Id", property="id", jdbcType=JdbcType.INTEGER, id=true),
            @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR),
            @Result(column="teacher_id", property="teacherId", jdbcType=JdbcType.INTEGER),
            @Result(column="Id", property="teachers", javaType=List.class,
            many = @Many(select = "personal.xjl.jerrymouse.mapper.TeacherMapper.selectTeacherByCourseId"))
    })
    List<Course> queryAll();
    @Select("select * from course c,tbl_teacherCourse tc where c.id=tc.course_id and tc.teacher_id=#{teacherId}")
    List<Course> selectCourseByTeacherId(int teacherId);
}
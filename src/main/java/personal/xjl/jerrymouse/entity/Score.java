package personal.xjl.jerrymouse.entity;

import lombok.Getter;
import lombok.Setter;

public class Score {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column score.Id
     *
     * @mbggenerated
     */
    private Integer id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column score.student_id
     *
     * @mbggenerated
     */
    private Integer studentId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column score.course_id
     *
     * @mbggenerated
     */
    private Integer course_Id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column score.score
     *
     * @mbggenerated
     */
    private Double score;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column score.Id
     *
     * @return the value of score.Id
     *
     * @mbggenerated
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column score.Id
     *
     * @param id the value for score.Id
     *
     * @mbggenerated
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column score.student_id
     *
     * @return the value of score.student_id
     *
     * @mbggenerated
     */
    public Integer getStudentId() {
        return studentId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column score.student_id
     *
     * @param studentId the value for score.student_id
     *
     * @mbggenerated
     */
    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column score.course_id
     *
     * @return the value of score.course_id
     *
     * @mbggenerated
     */
    public Integer getCourse_Id() {
        return course_Id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column score.course_id
     *
     * @param course_Id the value for score.course_id
     *
     * @mbggenerated
     */
    public void setCourse_Id(Integer course_Id) {
        this.course_Id = course_Id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column score.score
     *
     * @return the value of score.score
     *
     * @mbggenerated
     */
    public Double getScore() {
        return score;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column score.score
     *
     * @param score the value for score.score
     *
     * @mbggenerated
     */
    public void setScore(Double score) {
        this.score = score;
    }

    @Getter@Setter
    private Course course;
}
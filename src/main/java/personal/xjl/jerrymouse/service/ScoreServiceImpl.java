package personal.xjl.jerrymouse.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import personal.xjl.jerrymouse.entity.Score;
import personal.xjl.jerrymouse.mapper.ScoreMapper;

@Service
public class ScoreServiceImpl {
    @Autowired
    ScoreMapper scoreMapper;
    public int grade(Score score){
        return scoreMapper.insert(score);
    }
}

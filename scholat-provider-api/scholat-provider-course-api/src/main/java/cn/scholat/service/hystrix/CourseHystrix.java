package cn.scholat.service.hystrix;

import cn.scholat.service.CourseUserServiceApi;
import org.scholat.common.ResultMsg;
import org.scholat.common.pojo.CourseUserInfo;
import org.springframework.stereotype.Component;

@Component
public class CourseHystrix implements CourseUserServiceApi {


    @Override
    public ResultMsg<Object> joinCourse(CourseUserInfo courseUser) {
        return new ResultMsg<>(-3,null,"课程微服务不行了");
    }
}

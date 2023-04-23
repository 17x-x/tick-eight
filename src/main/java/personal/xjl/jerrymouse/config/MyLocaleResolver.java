package personal.xjl.jerrymouse.config;

import org.springframework.util.StringUtils;
import org.springframework.web.servlet.LocaleResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;

public class MyLocaleResolver  implements LocaleResolver {

    @Override
    public Locale resolveLocale(HttpServletRequest request) {
        String lang = request.getParameter("l");

        Locale locale = Locale.getDefault();//如果没有就用默认的
        //如果请求链接携带了国际化的参数
        if (!StringUtils.isEmpty(lang)){
            //zh_CN
            String[] split = lang.split("_");
            //国家，地区
            locale= new Locale(split[0], split[1]);
        }
        return locale;
    }

    @Override
    public void setLocale(HttpServletRequest request, HttpServletResponse response, Locale locale) {

    }
}

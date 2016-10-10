package com.pro.test.web.test;

import java.net.MalformedURLException;
import java.net.URL;
import java.text.ParseException;
import java.util.Random;

/**
 * Created by hxpeng on 2016/7/20.
 */
public class test {

    public static void main(String[] args) throws ParseException, MalformedURLException {
//        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
//        Validator validator = factory.getValidator();
//
//        TbHxpArticle entity = new TbHxpArticle();
//        entity.setArticleTitle("111111");
//        Set<ConstraintViolation<TbHxpArticle>> constraintViolations = validator.validate(entity);
//        for (ConstraintViolation<TbHxpArticle> constraintViolation : constraintViolations) {
//            System.out.println("对象属性:"+constraintViolation.getPropertyPath());
//            System.out.println("国际化key:"+constraintViolation.getMessageTemplate());
//            System.out.println("错误信息:"+constraintViolation.getMessage());
//        }
//
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
//        System.out.println(new Timestamp(sdf.parse("20160608000000").getTime()));

//        for(int i =0; i < 100; i++){
//            System.out.println(getMyRecommendCode());
//        }


//        Class t = ArticleRange.class;
//        for (Object o : t.getEnumConstants()) {
//            ArticleRange a = (ArticleRange) o;
//            if (a.getKey().equals("other")) {
//                System.out.println(a.getValue());
//            }
//        }


//        for (int i = 0; i < 10; i++){
//            for(int j = 0; j < 5; j++){
//                if(j == 3){
//                    break;
//                }
//                System.out.println("i:"+i+",j:"+j);
//            }
//        }

        URL url = new URL("http://file.gzl.cn/group1/M00/00/0B/wKkBHlf4S2qAQBg_AAAMHkwnAg0406.jpg");
        System.out.println(url.getPath());

//        String s = "http://topic.csdn.net/u/20120604/22/2479ec15-887a-4a7f-9ca6-042d37214302.html";
//        Pattern p = Pattern.compile("(?<=//|)((\\w)+\\.)+\\w+");
//        Matcher m = p.matcher(s);
//        if(m.find()){
//            System.out.println(m.group());
//        }


    }

    //随机生成用户推荐码
    public static String getMyRecommendCode() {
        Random random = new Random();
        int length = random.nextInt(5) + 6;
        StringBuffer sb = new StringBuffer();
        sb.append("");
        for (int i = 0; i < length; i++) {
            sb.append(String.valueOf(random.nextInt(10)));
        }
        return sb.toString();
    }
}

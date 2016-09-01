package com.pro.test.web.test;

import com.pro.test.core.enumdata.ArticleRange;

import java.text.ParseException;
import java.util.Random;

/**
 * Created by hxpeng on 2016/7/20.
 */
public class test {

    public static void main(String[] args) throws ParseException {
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


        Class t = ArticleRange.class;
        for(Object o : t.getEnumConstants()){
            ArticleRange a = (ArticleRange) o;
            if(a.getKey().equals("other")){
                System.out.println(a.getValue());
            }
        }

    }

    //随机生成用户推荐码
    public static String getMyRecommendCode(){
        Random random = new Random();
        int length = random.nextInt(5)+6;
        StringBuffer sb = new StringBuffer();
        sb.append("");
        for (int i = 0; i < length; i++) {
            sb.append(String.valueOf(random.nextInt(10)));
        }
        return sb.toString();
    }
}

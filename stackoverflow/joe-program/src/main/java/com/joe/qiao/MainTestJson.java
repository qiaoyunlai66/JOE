package com.joe.qiao;

import com.joe.qiao.drreports.element.image.PngElement;
import com.joe.qiao.domain.fileparser.FileReaderHelper;
import com.joe.qiao.domain.json.JSONHelper;
import com.joe.qiao.domain.json.Question;
import com.joe.qiao.domain.json.Questions;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Joe Qiao on 04/01/2018.
 */
public class MainTestJson {
    public static void main(String[] args) {
        //new MainTestJson().testFromJson();
        new MainTestJson().test();
    }
    
    public void testFromJson(){
        try {
            String json = FileReaderHelper.getFromClassRootPath("section.json");
            List<Object> elements = JSONHelper.fromJsonForBoj(json, ArrayList.class);
            PngElement png = (PngElement) Class.forName("com.joe.qiao.drreports.element.PngElement").newInstance();
            System.out.println(MainTestJson.class.getPackage().getName());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void test(){
        List<Question> list = new ArrayList<>();
        Question q=new Question();
        q.setAnswer("an");
        q.setQuestionId(124);
        list.add(q);
        Questions questions= new Questions();
        questions.setQuestion(list);
        try {
            String s = JSONHelper.toJsonJackSon(questions);
            System.out.println(s);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

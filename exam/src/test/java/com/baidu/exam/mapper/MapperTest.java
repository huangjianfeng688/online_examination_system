package com.baidu.exam.mapper;

import com.baidu.exam.model.ExamItems;
import com.baidu.exam.model.ExamPaper;
import com.baidu.exam.model.ExamUser;
import com.baidu.exam.service.IExamItemService;
import com.baidu.exam.service.IExamPaperService;
import com.baidu.exam.service.IExamUserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: samsung
 * Date: 2019/9/14
 * Time: 13:02
 * Description:测试类
 */@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class MapperTest {
     @Autowired
     private IExamUserService iExamUserService;
     @Autowired
     private IExamPaperService iExamPaperService;

     @Autowired
     private IExamItemService iExamItemService;

     @Autowired
     private IExamItemService examItemService;


     @Test
     public void test01(){
         System.out.println(iExamUserService.searchExamUser("admin1","123456"));

     }

     @Test
     public void test02(){
          System.out.println(iExamPaperService.getAllExamPaper(0));
     }

     @Test
     public void test03(){
          iExamPaperService.searchExamPaper("java",1);
     }


     @Test
     public void test04(){
          List<ExamItems> itemsByPaperId = iExamItemService.getItemsByPaperId(3);

          System.out.println(itemsByPaperId);
     }


     @Test
     public void test05(){
          System.out.println(iExamPaperService.getAllExamPaper(1));
     }


     @Test
     public void test06(){
          ExamPaper examPaper = new ExamPaper();
          examPaper.setPaperid(3);
          examPaper.setUserid(1);

          iExamItemService.getItemsAndScore(3,1);
     }
}

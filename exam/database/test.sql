/*
SQLyog Ultimate v12.08 (64 bit)
MySQL - 5.5.56 : Database - java1313
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`java1313` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `java1313`;

/*Table structure for table `exam_items` */

DROP TABLE IF EXISTS `exam_items`;

CREATE TABLE `exam_items` (
  `eid` int(11) NOT NULL AUTO_INCREMENT COMMENT '试题id,主键自增',
  `ename` varchar(100) COLLATE utf8_unicode_ci NOT NULL COMMENT '试题题目',
  `epaperid` int(11) NOT NULL COMMENT '试卷id',
  `escore` int(11) NOT NULL DEFAULT '0' COMMENT '试题应得分数',
  `etype` int(11) DEFAULT '0' COMMENT '1,填空; 2,判断 ;3,单选; 4,多选;5,问答',
  `edegree` int(11) DEFAULT NULL COMMENT '试卷难易程度,默认是1',
  `ea` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT 'a选项',
  `eb` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT 'b选项',
  `ec` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT 'c选项',
  `ed` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT 'd选项',
  `ee` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT 'e选项',
  `ef` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT 'f选项',
  `ekeys` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '试题答案',
  `ehints` varchar(250) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '试题解析',
  PRIMARY KEY (`eid`)
) ENGINE=MyISAM AUTO_INCREMENT=33 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

/*Data for the table `exam_items` */

insert  into `exam_items`(`eid`,`ename`,`epaperid`,`escore`,`etype`,`edegree`,`ea`,`eb`,`ec`,`ed`,`ee`,`ef`,`ekeys`,`ehints`) values (18,'cat 文件名 # 显示文件所有内容',3,4,2,1,'正确','错误',NULL,NULL,NULL,NULL,'a','正确'),(19,'vi 编辑器具有两种工作模式',3,4,2,1,'正确','错误',NULL,NULL,NULL,NULL,'b','错误'),(20,'mv 命令可以移动文件和目录,但是不可以重命名',3,4,2,1,'正确','错误',NULL,NULL,NULL,NULL,'b','错误'),(21,'在超级用户下显示系统命令 用ls',3,5,2,1,'正确','错误',NULL,NULL,NULL,NULL,'a','正确'),(22,'当前目录命令为 ./ 上一层目录为 ../ ',3,5,2,1,'正确','错误',NULL,NULL,NULL,NULL,'a','正确'),(23,'rm命令可以删除文件和目录',3,5,2,1,'正确','错误',NULL,NULL,NULL,NULL,'a','正确'),(24,'建立一个新文件可以使用的命令是',3,5,3,1,'chmod','more','cp','touch',NULL,NULL,'d','略'),(25,'在给定文件中查找与设定的内容条件',3,5,3,1,'grep','gzip','find','sort',NULL,NULL,'a','略'),(26,'下面的哪个命令可以压缩部分文件',3,5,3,1,'tar -dzvf filename.tgz *','tar -tzvf filename.tgz *','tar -zcvf filename.tgz *','tar -zxvf filename.tgz *',NULL,NULL,'c','略'),(27,'用什么命令检测网络是否连通',3,5,3,1,'ifconfig','ping','netstat','route',NULL,NULL,'b','略'),(28,'在vim中退出不保存的命令是',3,5,3,1,':q',':w',':wq',':q!',NULL,NULL,'d ','略'),(29,'linux文件权限一共10位长度,第三个位置代表的是什么?',3,5,3,1,'文件类型','文件所有者的权限','文件所有者所在组的权限','其他用户权限',NULL,NULL,'c ','略'),(30,'对系统变量的设置,应修改的文件是什么?',3,5,3,1,'/etc/bashrc','/etc/profile','~/.bash_profile','/etc/skel/.bashrc',NULL,NULL,'b','略'),(31,'如何删除一个非空子目录 /temp',3,5,3,1,'del /tmp/*','rm -rf /temp',' rm -ra /temp','rm -rf /temp/*',NULL,NULL,'b','略'),(32,'下面哪个命令可以吧f1.txt 复制为 f2.txt',3,5,3,1,'cp f1.txt|f2.txt','cat f1.txt | f2.txt','cat f1.txt > f2.txt','copy f1.txt | f2.txt',NULL,NULL,'c','略');

/*Table structure for table `exam_paper` */

DROP TABLE IF EXISTS `exam_paper`;

CREATE TABLE `exam_paper` (
  `paperid` int(10) NOT NULL AUTO_INCREMENT COMMENT '试卷id,主键自增',
  `papername` varchar(50) DEFAULT NULL COMMENT '试卷名称',
  `papertype` varchar(10) DEFAULT NULL COMMENT '试卷类型',
  `method` varchar(50) DEFAULT NULL COMMENT '阅卷方式:默认为自动阅卷',
  `remarks` varchar(10) DEFAULT NULL COMMENT '试卷总分',
  `create_time` date DEFAULT NULL COMMENT '创建试卷的日期',
  PRIMARY KEY (`paperid`)
) ENGINE=MyISAM AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;

/*Data for the table `exam_paper` */

insert  into `exam_paper`(`paperid`,`papername`,`papertype`,`method`,`remarks`,`create_time`) values (1,'java面试试卷','java','自动阅卷','100','2019-09-01'),(2,'java-ssm框架试卷','java','自动阅卷','100','2019-09-01'),(3,'java-linux基础试卷','java','自动阅卷','100','2019-09-01'),(4,'java-jsp考试试卷','java','自动阅卷','100','2019-09-01'),(5,'全国英语四级考试真题','英语','自动阅卷','100','2019-09-01'),(6,'小学英语考试','英语','自动阅卷','100','2019-09-01'),(7,'小学数学试卷','数学','自动阅卷','100','2019-09-01'),(8,'高考全国卷I综合','综合','自动阅卷','100','2019-08-22'),(9,'教师资格考试面试试卷','综合','自动阅卷','100','2019-09-12'),(10,'全国英语考试六级','英语','自动阅卷','100','2019-09-06'),(11,'计算机等级考试二级java科目','java','自动阅卷','100','2019-09-12'),(12,'小学语文试卷','语文','自动阅卷','100','2019-09-14');

/*Table structure for table `exam_score` */

DROP TABLE IF EXISTS `exam_score`;

CREATE TABLE `exam_score` (
  `scoreid` int(11) NOT NULL AUTO_INCREMENT COMMENT '成绩id,主键自增',
  `userid` int(11) NOT NULL COMMENT '用户id',
  `paperid` int(11) NOT NULL COMMENT '试卷id',
  `score` int(11) NOT NULL COMMENT '该试卷实际得分',
  `rights` int(11) NOT NULL COMMENT '答对题目数',
  `errors` int(11) DEFAULT NULL COMMENT '答错题目数',
  PRIMARY KEY (`scoreid`)
) ENGINE=MyISAM AUTO_INCREMENT=19 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

/*Data for the table `exam_score` */

insert  into `exam_score`(`scoreid`,`userid`,`paperid`,`score`,`rights`,`errors`) values (15,3,3,68,14,1),(14,1,3,68,14,1),(16,4,3,63,13,2),(17,4,1,0,0,0),(18,4,5,0,0,0);

/*Table structure for table `exam_score_detail` */

DROP TABLE IF EXISTS `exam_score_detail`;

CREATE TABLE `exam_score_detail` (
  `detailid` int(11) NOT NULL AUTO_INCREMENT COMMENT '成绩详情id,主键自增',
  `scoreid` int(11) DEFAULT NULL COMMENT '成绩id',
  `eid` int(11) DEFAULT NULL COMMENT '试题id',
  `uanswer` varchar(200) DEFAULT NULL COMMENT '用户答案',
  `upoint` int(11) DEFAULT NULL COMMENT '该题目实际得分',
  PRIMARY KEY (`detailid`)
) ENGINE=MyISAM AUTO_INCREMENT=271 DEFAULT CHARSET=utf8;

/*Data for the table `exam_score_detail` */

insert  into `exam_score_detail`(`detailid`,`scoreid`,`eid`,`uanswer`,`upoint`) values (225,15,32,'c',5),(224,15,21,'a',5),(223,15,31,'b',5),(222,15,20,'b',4),(221,15,30,'b',5),(220,15,19,'a',0),(219,15,29,'c',5),(218,15,18,'a',4),(217,15,28,'d',5),(216,15,27,'b',5),(215,15,26,'c',5),(214,15,25,'a',5),(213,15,24,'d',5),(212,15,23,'a',5),(211,15,22,'a',5),(210,14,32,'c',5),(209,14,21,'a',5),(208,14,31,'b',5),(207,14,20,'b',4),(206,14,30,'b',5),(205,14,19,'a',0),(204,14,29,'c',5),(203,14,18,'a',4),(202,14,28,'d',5),(201,14,27,'b',5),(200,14,26,'c',5),(199,14,25,'a',5),(198,14,24,'d',5),(197,14,23,'a',5),(196,14,22,'a',5),(226,16,22,'a',5),(227,16,23,'a',5),(228,16,24,'d',5),(229,16,25,'a',5),(230,16,26,'c',5),(231,16,27,'b',5),(232,16,28,'d',5),(233,16,18,'a',4),(234,16,29,'c',5),(235,16,19,'b',4),(236,16,30,'b',5),(237,16,20,'a',0),(238,16,31,'b',5),(239,16,21,'b',0),(240,16,32,'c',5),(241,17,22,NULL,NULL),(242,17,23,NULL,NULL),(243,17,24,NULL,NULL),(244,17,25,NULL,NULL),(245,17,26,NULL,NULL),(246,17,27,NULL,NULL),(247,17,28,NULL,NULL),(248,17,18,NULL,NULL),(249,17,29,NULL,NULL),(250,17,19,NULL,NULL),(251,17,30,NULL,NULL),(252,17,20,NULL,NULL),(253,17,31,NULL,NULL),(254,17,21,NULL,NULL),(255,17,32,NULL,NULL),(256,18,22,NULL,NULL),(257,18,23,NULL,NULL),(258,18,24,NULL,NULL),(259,18,25,NULL,NULL),(260,18,26,NULL,NULL),(261,18,27,NULL,NULL),(262,18,28,NULL,NULL),(263,18,18,NULL,NULL),(264,18,29,NULL,NULL),(265,18,19,NULL,NULL),(266,18,30,NULL,NULL),(267,18,20,NULL,NULL),(268,18,31,NULL,NULL),(269,18,21,NULL,NULL),(270,18,32,NULL,NULL);

/*Table structure for table `exam_user` */

DROP TABLE IF EXISTS `exam_user`;

CREATE TABLE `exam_user` (
  `userid` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `uname` varchar(100) NOT NULL,
  `upwd` varchar(50) NOT NULL,
  PRIMARY KEY (`userid`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

/*Data for the table `exam_user` */

insert  into `exam_user`(`userid`,`uname`,`upwd`) values (1,'admin','123456'),(2,'李玉华','12457'),(3,'黄剑锋','123456'),(4,'谢华康','383838');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

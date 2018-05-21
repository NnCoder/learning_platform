/*
Navicat MySQL Data Transfer

Source Server         : mysql
Source Server Version : 50624
Source Host           : localhost:3306
Source Database       : edu

Target Server Type    : MYSQL
Target Server Version : 50624
File Encoding         : 65001

Date: 2018-05-21 12:14:33
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for chapter
-- ----------------------------
DROP TABLE IF EXISTS `chapter`;
CREATE TABLE `chapter` (
  `Chapter_id` int(11) NOT NULL AUTO_INCREMENT,
  `Chapter_name` varchar(255) DEFAULT NULL,
  `Course_id` int(11) NOT NULL,
  `create_time` datetime NOT NULL,
  `update_time` datetime NOT NULL,
  `state` tinyint(2) DEFAULT '1' COMMENT '是否被删除 1:存在 2:已删除',
  PRIMARY KEY (`Chapter_id`,`Course_id`),
  KEY `Chapter_id` (`Chapter_id`),
  KEY `chapter_ibfk_1` (`Course_id`),
  CONSTRAINT `chapter_ibfk_1` FOREIGN KEY (`Course_id`) REFERENCES `course` (`Course_id`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=27 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of chapter
-- ----------------------------
INSERT INTO `chapter` VALUES ('16', '新建章节4', '5', '2018-04-02 21:04:09', '2018-04-02 21:04:09', '1');
INSERT INTO `chapter` VALUES ('17', '新建章节5', '5', '2018-04-02 21:04:11', '2018-04-02 21:04:11', '1');
INSERT INTO `chapter` VALUES ('18', '新建章节6', '5', '2018-04-02 21:04:12', '2018-04-02 21:04:12', '1');
INSERT INTO `chapter` VALUES ('21', '章节1.1', '5', '2018-05-01 14:19:12', '2018-05-01 14:19:12', '1');
INSERT INTO `chapter` VALUES ('22', '新建章节', '6', '2018-05-06 23:14:12', '2018-05-06 23:14:12', '1');
INSERT INTO `chapter` VALUES ('23', '新建章节', '6', '2018-05-06 23:14:14', '2018-05-06 23:14:14', '1');
INSERT INTO `chapter` VALUES ('24', '新建章节', '7', '2018-05-08 11:28:17', '2018-05-08 11:28:17', '1');
INSERT INTO `chapter` VALUES ('25', '新建章节', '7', '2018-05-08 11:28:23', '2018-05-08 11:28:23', '1');
INSERT INTO `chapter` VALUES ('26', '新建章节', '9', '2018-05-20 16:12:08', '2018-05-20 16:12:08', '1');

-- ----------------------------
-- Table structure for chapter_data
-- ----------------------------
DROP TABLE IF EXISTS `chapter_data`;
CREATE TABLE `chapter_data` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `chapter_id` int(11) DEFAULT NULL,
  `data_name` varchar(255) DEFAULT NULL,
  `data_src` varchar(255) DEFAULT NULL,
  `create_account` varchar(12) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `chapter_data_ibfk_1` (`chapter_id`),
  CONSTRAINT `chapter_data_ibfk_1` FOREIGN KEY (`chapter_id`) REFERENCES `chapter` (`Chapter_id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of chapter_data
-- ----------------------------

-- ----------------------------
-- Table structure for comment
-- ----------------------------
DROP TABLE IF EXISTS `comment`;
CREATE TABLE `comment` (
  `kp_id` int(11) DEFAULT NULL,
  `comment_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(255) DEFAULT NULL,
  `comment_content` text,
  `comment_time` datetime DEFAULT NULL,
  `parent_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`comment_id`),
  KEY `comment_ibfk_1` (`kp_id`),
  KEY `parent_id` (`parent_id`),
  CONSTRAINT `comment_ibfk_1` FOREIGN KEY (`kp_id`) REFERENCES `knowledge_point` (`kp_id`) ON DELETE CASCADE,
  CONSTRAINT `comment_ibfk_2` FOREIGN KEY (`parent_id`) REFERENCES `comment` (`comment_id`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of comment
-- ----------------------------
INSERT INTO `comment` VALUES ('20', '1', '04151807 韩金龙', '问的好', '2018-05-01 14:57:21', null);
INSERT INTO `comment` VALUES ('20', '2', '04151807 韩金龙', '好的', '2018-05-01 14:57:26', null);
INSERT INTO `comment` VALUES ('20', '3', '04150309 姓名1', '好的', '2018-05-04 22:52:30', null);
INSERT INTO `comment` VALUES ('20', '4', '陈志冲', '问的好', '2018-05-04 22:56:49', '3');
INSERT INTO `comment` VALUES ('20', '5', '陈志chong', 'haode like chuli', '2018-05-15 17:36:45', '2');
INSERT INTO `comment` VALUES ('20', '6', '04151306 陈晓涛', '我有新的问题', '2018-05-19 12:45:22', null);

-- ----------------------------
-- Table structure for course
-- ----------------------------
DROP TABLE IF EXISTS `course`;
CREATE TABLE `course` (
  `Course_id` int(11) NOT NULL AUTO_INCREMENT,
  `Course_name` varchar(255) NOT NULL,
  `Course_imgSrc` varchar(255) DEFAULT NULL,
  `Course_process` text,
  `Course_intro` text,
  `Tch_account` varchar(12) DEFAULT NULL,
  `Visit_time` int(11) DEFAULT '0',
  `create_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `state` tinyint(2) DEFAULT '1' COMMENT '是否被删除 1:存在 2:已删除',
  PRIMARY KEY (`Course_id`),
  KEY `Course_id` (`Course_id`),
  KEY `course_ibfk_1` (`Tch_account`),
  CONSTRAINT `course_ibfk_1` FOREIGN KEY (`Tch_account`) REFERENCES `teacher` (`tch_account`) ON DELETE SET NULL
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of course
-- ----------------------------
INSERT INTO `course` VALUES ('5', 'C语言', 'http://localhost:8080/edu-manager/file/2d84b9d2f763483d910e22d50f9f86ef.jpg', '本课程是程序设计的入门基础，通过对本课程的学习，即使零基础的人也能实现对计算机讲话，编写自己的专属应用，而不是仅仅只能使用别人做好的应用。在本课程结束之后，学生应该具备编写一些简单程序的能力，包括用计算机去解决一些数学、物理题，一些趣味性的小程序和小游戏，甚至是演奏一段音乐等。&nbsp;&nbsp;', 'C语言是目前世界上最流行、使用最广泛的高级程序设计语言之一,在TIOBE世界编程语言社区排行榜中始终位居前两位，对操作系统和需要对硬件进行编程的场合，用C语言明显优于其他高级语言，许多大型系统软件都是用C语言编写的。同时，C语言简洁、紧凑，使用方便、灵活，运算符和数据类型丰富，使用其编写的程序可移植性好，并具备很强的数据处理能力。&nbsp;&nbsp;&nbsp; C语言是一门优秀的教学语言，其优美的结构，完善的语法，都是对面向过程的结构化编程语言最好的诠释。同时，C语言也是其他很多程序设计语言的基础，是后续学好其他程序设计语言甚至是学好整个计算机技术的一块基石，所以，各高等学校和专科院校校均采用C语言作为计算机编程的入门语言。&nbsp; &nbsp; 本课程面向广大程序设计入门者，既可以作为各高等学校和专科院校计算机专业学习程序设计和深入学习计算机技术的先修课程，也可以作为理工类各专业的一门公共基础课程，更是广大程序设计爱好者及非理工类专业学生都能够学懂学会的课程，是真正打开人机对话之门的一把钥匙。本课程讲解细致入微，范例实用、丰富，浅显易懂，一步步推进，让大家彻底摆脱C语言枯燥乏味的固有印象。每节课课前均由引导题作为内容引出，课后有思考题和练习题作为总结和任务驱动，由浅入深，知识点环环相扣，尤其是针对编程入门的新手易犯的错误，均有特别指出和说明。&nbsp;&nbsp;&nbsp;本课程考虑到大多数的零基础同学，配备全套的教学资料，包括教学ppt、课堂练习、程序示例、题库和课外阅读的参考资料等，也会有助教团队负责大家平时学习过程中的讨论、在线互动和答疑解惑，并且会定期发布公告提醒大家学习的进度和安排。需要说明的是，本课程所有演示均采用VC++6.0编译环境，这是目前学习C语言最易上手的平台之一，目的是除了适用于各高等学校和专科院校的教学现状和机考环境，还可以兼顾计算机等级考试的备考者所需。', 'admin', '55', '2018-02-08 21:58:08', '2018-02-08 21:58:52', '1');
INSERT INTO `course` VALUES ('6', 'JAVA', 'http://localhost:8080/edu-manager/file/108750a1609043faacde345370b4a5ef.png', '車', '是', 'admin', '3', '2018-05-06 23:13:58', '2018-05-06 23:13:58', '1');
INSERT INTO `course` VALUES ('7', 'JavaScript', 'http://localhost:8080/edu-manager/file/d2380b3e6bd94b998135e7e11c69cefc.jpg', '的', '的', 'admin', '6', '2018-05-06 23:14:08', '2018-05-06 23:14:08', '1');
INSERT INTO `course` VALUES ('8', 'JAVA基础', 'http://localhost:8080/edu-manager/file/d71d64d3e3844245be3601e213b6a3fc.png', '零基础教学', '零基础教学', '04150309', '4', '2018-05-16 19:22:01', '2018-05-16 19:22:01', '1');
INSERT INTO `course` VALUES ('9', 'JAVA8', 'http://localhost:8080/edu-manager/file/df91be85199040639356d3be825246ac.png', '', '', '04151306', '1', '2018-05-17 09:09:13', '2018-05-17 09:09:13', '1');

-- ----------------------------
-- Table structure for course_desc
-- ----------------------------
DROP TABLE IF EXISTS `course_desc`;
CREATE TABLE `course_desc` (
  `course_id` int(11) NOT NULL,
  `course_desc` text,
  PRIMARY KEY (`course_id`),
  KEY `course_id` (`course_id`),
  CONSTRAINT `course_desc_ibfk_1` FOREIGN KEY (`course_id`) REFERENCES `course` (`Course_id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of course_desc
-- ----------------------------
INSERT INTO `course_desc` VALUES ('5', '<h1>\r\n	<div class=\"category-title f-f0\" style=\"margin:0px;padding:0px 0px 10px;font-family:&quot;font-size:18px;font-weight:bold;color:#333333;background-color:#FFFFFF;\">\r\n		<span class=\"f-ib f-vam\" style=\"vertical-align:middle;\">课程大纲</span>\r\n	</div>\r\n	<div class=\"category-content j-cover-overflow\" style=\"margin:0px 0px 50px;padding:0px;color:#333333;font-family:&quot;background-color:#FFFFFF;\">\r\n		<div class=\"f-richEditorText\" style=\"margin:0px;padding:0px;border:0px;font-family:&quot;color:#666666;\">\r\n			<p>\r\n				入门篇：\r\n			</p>\r\n			<p>\r\n				<span>1.C &nbsp;Travel </span>\r\n			</p>\r\n			<p>\r\n				<span>&nbsp;1.1 为什么要学习C语言？</span>\r\n			</p>\r\n			<p>\r\n				<span>&nbsp;1.2 扬帆起航：计算机文化基础</span>\r\n			</p>\r\n			<p>\r\n				<span>&nbsp;1.3 磨刀不误砍柴工：雇佣“翻译”</span>\r\n			</p>\r\n			<p>\r\n				<span><br />\r\n</span>\r\n			</p>\r\n			<p>\r\n				<span>2.初识C语言程序 </span>\r\n			</p>\r\n			<p>\r\n				<span>&nbsp;2.1 让计算机开口“说话”</span>\r\n			</p>\r\n			<p>\r\n				<span>&nbsp;2.2 让计算机帮我们做算术</span>\r\n			</p>\r\n			<p>\r\n				<span>&nbsp;2.3 让计算机自己做决定</span>\r\n			</p>\r\n			<p>\r\n				<span><br />\r\n</span>\r\n			</p>\r\n			<p>\r\n				<span>3.有多少种“房间” </span>\r\n			</p>\r\n			<p>\r\n				<span>&nbsp;3.1 初识数据类型</span>\r\n			</p>\r\n			<p>\r\n				<span>&nbsp;3.2 第一种房间：整数类型</span>\r\n			</p>\r\n			<p>\r\n				<span>&nbsp; &nbsp; 3.2.1 整数类型（上）</span>\r\n			</p>\r\n			<p>\r\n				<span>&nbsp; &nbsp; 3.2.2 整数类型（下）</span>\r\n			</p>\r\n			<p>\r\n				<span>&nbsp; &nbsp; 3.2.3 移形换位心法</span>\r\n			</p>\r\n			<p>\r\n				<span>&nbsp;3.3 第二种房间：实数类型</span>\r\n			</p>\r\n			<p>\r\n				<span>&nbsp; &nbsp; 3.3.1 浮点型（上）</span>\r\n			</p>\r\n			<p>\r\n				<span>&nbsp; &nbsp; 3.3.2 浮点型（下）</span>\r\n			</p>\r\n			<p>\r\n				<span>&nbsp;3.4 第三种房间：字符类型</span>\r\n			</p>\r\n			<p>\r\n				<span>&nbsp; &nbsp; 3.4.1 字符型（上）</span>\r\n			</p>\r\n			<p>\r\n				<span>&nbsp; &nbsp; 3.4.2 字符型（下）</span>\r\n			</p>\r\n			<p>\r\n				<span>&nbsp; &nbsp; 3.4.3 变形计：转义字符</span>\r\n			</p>\r\n			<p>\r\n				<span><br />\r\n</span>\r\n			</p>\r\n			<p>\r\n				<span>4.相亲相爱的一家人 </span>\r\n			</p>\r\n			<p>\r\n				<span><span style=\"font-size:19px;font-family:宋体;\"></span>&nbsp;4.1 在一起：混合运算&nbsp;</span>\r\n			</p>\r\n			<p>\r\n				<span>&nbsp;4.1 做什么：运算符和表达式（上）</span>\r\n			</p>\r\n			<p>\r\n				<span>&nbsp;4.3 做什么：运算符和表达式 （下）</span>\r\n			</p>\r\n			<p>\r\n				<span><br />\r\n</span>\r\n			</p>\r\n			<p>\r\n				<span>5.三种结构——顺序</span>\r\n			</p>\r\n			<p>\r\n				<span>&nbsp;5.1 格式化输出</span>\r\n			</p>\r\n			<p>\r\n				<span>&nbsp;5.2 格式化输入</span>\r\n			</p>\r\n			<p>\r\n				<span><br />\r\n</span>\r\n			</p>\r\n			<p>\r\n				<span>6.三种结构——选择</span>\r\n			</p>\r\n			<p>\r\n				<span>&nbsp;6.1 我想做选择</span>\r\n			</p>\r\n			<p>\r\n				<span>&nbsp;6.2 选择与多重选择</span>\r\n			</p>\r\n			<p>\r\n				<span><br />\r\n</span>\r\n			</p>\r\n			<p>\r\n				<span>7. 三种结构——循环</span>\r\n			</p>\r\n			<p>\r\n				<span>&nbsp;7.1 循环结构（上）</span>\r\n			</p>\r\n			<p>\r\n				<span>&nbsp;7.2 循环结构（下）</span>\r\n			</p>\r\n			<p>\r\n				<span>&nbsp;7.3 能不能更快一点</span>\r\n			</p>\r\n			<p>\r\n				<span><br />\r\n</span>\r\n			</p>\r\n			<p>\r\n				<span>8.一大波数来了</span>\r\n			</p>\r\n			<p>\r\n				<span>&nbsp;8.1 我想排序</span>\r\n			</p>\r\n			<p>\r\n				<span>&nbsp;8.2 初试锋芒</span>\r\n			</p>\r\n			<p>\r\n				<span>&nbsp;8.3 大显身手</span>\r\n			</p>\r\n			<p>\r\n				<span>&nbsp;8.4 弹奏一首音乐</span>\r\n			</p>\r\n		</div>\r\n	</div>\r\n<br />\r\n</h1>');
INSERT INTO `course_desc` VALUES ('6', '<p>\r\n	<strong>阿斯蒂芬阿斯蒂芬第三方阿斯蒂芬沙发</strong>\r\n</p>\r\n<p>\r\n	<strong><img src=\"http://localhost:8080/edu-manager/static/js/kindeditor-4.1.10/plugins/emoticons/images/20.gif\" border=\"0\" alt=\"\" /><img src=\"http://localhost:8080/edu-manager/static/js/kindeditor-4.1.10/plugins/emoticons/images/29.gif\" border=\"0\" alt=\"\" /><img src=\"http://localhost:8080/edu-manager/static/js/kindeditor-4.1.10/plugins/emoticons/images/28.gif\" border=\"0\" alt=\"\" /><br />\r\n</strong>\r\n</p>');
INSERT INTO `course_desc` VALUES ('7', '');
INSERT INTO `course_desc` VALUES ('8', '');
INSERT INTO `course_desc` VALUES ('9', '');

-- ----------------------------
-- Table structure for data
-- ----------------------------
DROP TABLE IF EXISTS `data`;
CREATE TABLE `data` (
  `Data_id` int(11) NOT NULL AUTO_INCREMENT,
  `Data_name` varchar(255) DEFAULT NULL,
  `Data_src` varchar(255) DEFAULT NULL,
  `Data_type` tinyint(4) DEFAULT NULL COMMENT '资料类型 1:普通资料 2:测试资料',
  `Kp_id` int(11) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `create_account` varchar(12) DEFAULT NULL,
  PRIMARY KEY (`Data_id`),
  KEY `data_ibfk_1` (`Kp_id`),
  CONSTRAINT `data_ibfk_1` FOREIGN KEY (`Kp_id`) REFERENCES `knowledge_point` (`kp_id`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of data
-- ----------------------------
INSERT INTO `data` VALUES ('13', '02-Spring的Java配置方式.mp4', 'http://localhost:8080/quinFS/file/5e3e2e7bbbe34f55adebb87c49085761.mp4', '1', '23', '2018-05-01 14:19:51', '2018-05-01 14:19:51', 'admin');
INSERT INTO `data` VALUES ('14', '1.xlsx', 'null', '1', '20', '2018-05-15 16:52:29', '2018-05-15 16:52:29', 'admin');
INSERT INTO `data` VALUES ('15', '20171223073815853.png', 'null', '1', '20', '2018-05-15 16:52:41', '2018-05-15 16:52:41', 'admin');

-- ----------------------------
-- Table structure for knowledge_point
-- ----------------------------
DROP TABLE IF EXISTS `knowledge_point`;
CREATE TABLE `knowledge_point` (
  `kp_id` int(11) NOT NULL AUTO_INCREMENT,
  `kp_name` varchar(255) DEFAULT NULL,
  `kp_detail` text,
  `kp_advice` text,
  `kp_read` text,
  `chapter_id` int(11) DEFAULT NULL,
  `state` tinyint(2) unsigned DEFAULT '1' COMMENT '是否被删除 1:存在 2:已删除',
  PRIMARY KEY (`kp_id`),
  KEY `knowledge_point_ibfk_1` (`chapter_id`),
  CONSTRAINT `knowledge_point_ibfk_1` FOREIGN KEY (`chapter_id`) REFERENCES `chapter` (`Chapter_id`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=36 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of knowledge_point
-- ----------------------------
INSERT INTO `knowledge_point` VALUES ('20', '3.3 第二种房间：实数类', '精讲', '111', '111', '16', '1');
INSERT INTO `knowledge_point` VALUES ('23', '知识点111', '111', '111', '111', '21', '1');
INSERT INTO `knowledge_point` VALUES ('24', '111', '111', '111', '111', '21', '1');
INSERT INTO `knowledge_point` VALUES ('28', '知识点知识点知识点', '知识点', '知识点', '知识点', '16', '1');
INSERT INTO `knowledge_point` VALUES ('30', '知识点111', '11111', '111', '1111', '22', '1');
INSERT INTO `knowledge_point` VALUES ('31', '知识点3', '知识点3', '知识点3', '知识点3', '16', '0');
INSERT INTO `knowledge_point` VALUES ('32', '知识点4', '知识点4', '知识点4', '知识点4', '16', '0');
INSERT INTO `knowledge_point` VALUES ('33', '知识点5', '知识点5', '知识点5', '知识点5', '16', '0');
INSERT INTO `knowledge_point` VALUES ('34', '知识点3', '知识点3', '知识点3&nbsp;&nbsp;', '', '16', '1');
INSERT INTO `knowledge_point` VALUES ('35', '知识点4', '知识点4', '知识点4', '', '16', '1');

-- ----------------------------
-- Table structure for major
-- ----------------------------
DROP TABLE IF EXISTS `major`;
CREATE TABLE `major` (
  `major_name` varchar(255) NOT NULL,
  PRIMARY KEY (`major_name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of major
-- ----------------------------
INSERT INTO `major` VALUES ('网络工程');
INSERT INTO `major` VALUES ('计算机科学与技术');
INSERT INTO `major` VALUES ('软件工程');

-- ----------------------------
-- Table structure for notice
-- ----------------------------
DROP TABLE IF EXISTS `notice`;
CREATE TABLE `notice` (
  `notice_id` int(11) NOT NULL AUTO_INCREMENT,
  `notice_content` text,
  `notice_time` datetime NOT NULL,
  `notice_title` varchar(255) NOT NULL,
  `is_show` tinyint(1) DEFAULT '1' COMMENT '是否在首页展示',
  PRIMARY KEY (`notice_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of notice
-- ----------------------------
INSERT INTO `notice` VALUES ('1', '<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;叠几行落叶随风的小字，停泊指尖，于心的宁静中，藏一掬思念，轻轻落凡尘。这点滴的心思，汇聚在无声的雨里，捎去遥远的梦想，寻思着，这花香烟火，一沓沓，恰好可以，恰好能够，落入相逢的城池。<br>　　<br>　　总想着，即便是散落天涯的尘埃，也能挥着隐形的翅膀，如童话故事那般，随缘晾晒，把盏岁月。风飞舞流年窗台，挺暖地，在装满阳光的细碎往事中，掀开喜爱的页脚，于最美的时光，流泻厚实的线条，写意几笔，诗行几句，小日子里的小心情，挺好的！<br>　　<br>　　一粒烟火，一沓花香，几步清影，几度夕阳红，安心地，在一方种满欢喜的小院子，心无杂念，等黎明的曙光，等未曾谋面的缘份，于遥远时空中，踏月而来。只是简单着，再简单的，等一朵花，开了；待一滴细雨，醉了，自由自在于一抹清风徐来之时，数一枚枚心事，打开一叠一叠的似水年华，让生命入住烟火。<br>　　<br>　　向来喜欢浅淡的颜色，小巧玲珑的植物，略有年代的物件，就如一直专注一个字，一句话，一沓又一沓的花香，沾着一点烟火的味道，有些清明，有些温润，轻轻微微惠临身旁。带着那么一点的忧思，合着小小的愿望，组合一方，只是恰好入了心情，醉了心意，而已。<br>　　<br>　　如此美好在，种下的花香绿植里，自行诗意抽花，或许一直未曾花开，只是绿意盎然了，一方院子，一窗台阳光，也挺好。在灯火阑珊处，为夕阳谱写了，一卷春生的愿望；为平凡的生活，点缀了一响欢颜，一道风景，专属着一种味道，让日子生香。<br>　　<br>　　当经过了烟火半生，回望那年那月，一季初夏的花开，也曾相识相知，欢喜写意，扣字书信，折香间。在成长的路程上，远了谁的记忆？隔断谁的初心？总是在回忆的一方小盒子里，翻阅时光太瘦的答案，却未能解读，戏如人生的轮换。<br>　　<br>　　也许烟火的季节，本是交替着的美丽，没有一如当初，一如往昔，都是不断追逐黎明，相互暗换，不同的面孔，不同的人事布局。黑白棋子，交替落下，没有始终的人生赢家，有的只是看待的角度。<br>　　<br>　　想来，想去，曾经落款的故事，烙印在一方格子间，而这烟火人生，不过是，格子间的一沓沓的花香串联，我闻到了，踏马来到这，有了一段时光，花开花落了一墙角花月。<br>　　<br>　　花香烟火，一沓沓，邻水静坐数光阴，一朵忧，一瓣喜，从容迎来，淡然相送。生活的过场，简单而细致，斟酌各种况味，叠加人生的角角落落，一些彩绘，一点点的浅妆，厚重着一双手，去温暖忽而之间的薄凉。<br>　　<br>　　岁月缝花，时光煮雨，萌生些葱茏，盛放些欢喜，于生命绿圃，让花香烟火，一沓沓，随心而来，随缘而去，不论如何，一枚温善深情，不负你我，不负生命，就好！<br>　　<br>　　文落梅雪舞\r\n\r\n</p><p><br></p>', '2018-02-08 20:32:09', '测试通知', '1');
INSERT INTO `notice` VALUES ('2', '<p>文/花汐颜<br>　　<br>　　一片落霞孤鸿的眷恋中，依依送别秋水长天的一程相逢。一篱冬阳，隔开季节分明的两端；冬，就这么悄无声息地来在身边……<br>　　<br>　　光阴不懂人情，竟自流转，然而我们心底终有些撇不清的东西，留在了逝去的时光里。下一个轮回久远的重逢之约，又开启了新一轮的期盼与等待。秋去冬来的日子，生命愈发深邃厚重；凝眸时令清旷的边缘，心持一份前尘的留恋，秋意与冬情交接的时刻，我们含笑见证。<br>　　<br>　　此时，世态的喧嚣已被季候凉透，草木花树不说话，也仿佛习惯了冷暖聚散的变故。秋天，从来有许多故事，不经意，我们都已一一经历。风尘里来去，到底心无怨尤，光阴中驻足，听岁月深处的低低细语。有风的日子，人心似一枚秋叶，徘徊在宿命风崖的枝梢；阳光穿透思绪的薄衫，托起昨夜月光散落的叹息。<br>　　<br>　　如若，一切的凉薄与温暖，都随了季节的必然更迭；所有的得失与因果，都交予时间来定夺，那么自己将以怎样的步伐，去追逐冗长的光年？！又会不会有一种明媚的笑容，去迎接拨云而出的阳光？！世相端然，深谙了一季秋风秋雨的使命，终赋予一段人生本真意义的领悟。<br>　　<br>　　当生命的枝头繁华落尽，请为我唱一支平淡归真的歌谣；当生命的枝头梅红傲雪，请为我折去不堪修剪的枝桠。透过人间草木吐纳的清然香气，那些用心的捡拾，那些无意的阴凉，终被季节默默接纳。悲欢须臾间，一些肝胆相照的人，终是走散了；而一些平实的陪伴，依然为自己深情。<br>　　<br>　　走过人世繁芜，只愿记取眼中最凝神的花朵。越过山川大地，淌过江河溪流，多少人一路风尘仆仆地赶来，又轻盈笑意地拂袖而去。我明白，心灵的驿站，所谓缘深缘浅，不在远处，不在近处，而在一切有常无常的烛光明灭之间。<br>　　<br>　　曾经枯荣岁月，自己越来越在乎一些存在，也越来越看淡一些流落。虽说，对于光鲜的生活也有努力，但从不强求能力之外的获得。虽说，没有放弃过心中的梦想与向往，但也懂得适时有度，不会沉溺偏执。一直懂得，一切都可以是烟云浮花，一切都可以得失坦然，但没有什么能比自己在乎的人平安、日子过得安稳更重要的了！<br>　　<br>　　轮回仿似匆忙，人生征程万里，无论生命怎样光华艳丽，也总需一檐陋室，将一颗心妥贴安放。站在冬的路口，一双凝望的眼神，一瞬明亮的光景，铺陈一条往心的路。阑珊灯火处，隐约听见晚归的熟悉足音，转过起风的街角，踏入自己等候的烟火柴门。命运恩泽，不忘厚待善行人，这许多年人生，守望与回程，都落满温柔情意。<br>　　<br>　　风雨兼程的岁月，心种彩虹的期盼，便会多一米阳光的温度。每一个季节都有花开，人心亦不忘生长。光阴深深，日渐凉薄，然而一些风尘经历却愈发动人。是年，轻藏起一朵秋花的记忆，便有了一个暗香他年的理由。一怀初情若雪，洁白也暖意，足以抵挡人世的落拓清寒。前尘风雪中的遇见，相信，会是春风十里的感动。<br>　　<br>　　站在冬天的路口，轻轻抬首，迎见满目清灿的尘光。岁月温情可掬，且尚有秋的余暖莹然心怀；忽而感恩，与自己一起，走进这个冬天的人……<img src=\"http://img.t.sinajs.cn/t4/appstyle/expression/ext/normal/6a/laugh.gif\" alt=\"[哈哈]\" data-w-e=\"1\"></p>', '2018-02-08 20:45:54', '守望，冬天的路口', '1');

-- ----------------------------
-- Table structure for pratice_history
-- ----------------------------
DROP TABLE IF EXISTS `pratice_history`;
CREATE TABLE `pratice_history` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `kp_id` int(11) DEFAULT NULL,
  `user_account` varchar(255) DEFAULT NULL,
  `content` text,
  `create_time` datetime DEFAULT NULL,
  `answer_sheet` text,
  `duration` int(11) DEFAULT NULL,
  `paper_name` varchar(255) DEFAULT NULL,
  `point_get` int(11) DEFAULT NULL,
  `submit_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `kp_id` (`kp_id`),
  KEY `pratice_history_ibfk_2` (`user_account`),
  CONSTRAINT `pratice_history_ibfk_1` FOREIGN KEY (`kp_id`) REFERENCES `knowledge_point` (`kp_id`) ON DELETE CASCADE,
  CONSTRAINT `pratice_history_ibfk_2` FOREIGN KEY (`user_account`) REFERENCES `student` (`Stu_account`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of pratice_history
-- ----------------------------

-- ----------------------------
-- Table structure for question
-- ----------------------------
DROP TABLE IF EXISTS `question`;
CREATE TABLE `question` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `content` text NOT NULL,
  `question_type_id` int(11) NOT NULL COMMENT '题型',
  `duration` int(11) DEFAULT NULL COMMENT '试题考试时间',
  `points` int(11) DEFAULT NULL,
  `group_id` int(11) DEFAULT NULL COMMENT '班组ID',
  `is_visible` tinyint(1) NOT NULL DEFAULT '0' COMMENT '试题可见性',
  `create_time` timestamp NULL DEFAULT NULL,
  `creator` varchar(20) NOT NULL DEFAULT 'admin' COMMENT '创建者',
  `last_modify` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `answer` mediumtext NOT NULL,
  `expose_times` int(11) NOT NULL DEFAULT '2',
  `right_times` int(11) NOT NULL DEFAULT '1',
  `wrong_times` int(11) NOT NULL DEFAULT '1',
  `difficulty` int(5) NOT NULL DEFAULT '1',
  `analysis` mediumtext,
  `reference` text,
  `examing_point` text,
  `keyword` text,
  PRIMARY KEY (`id`),
  KEY `question_type_id` (`question_type_id`),
  KEY `et_question_ibfk_5` (`creator`),
  CONSTRAINT `et_question_ibfk_1` FOREIGN KEY (`question_type_id`) REFERENCES `question_type` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=134 DEFAULT CHARSET=utf8 COMMENT='试题';

-- ----------------------------
-- Records of question
-- ----------------------------
INSERT INTO `question` VALUES ('129', '知识点', '<QuestionContent>\n  <title>知识点</title>\n  <titleImg></titleImg>\n  <choiceList>\n    <entry>\n      <string>A</string>\n      <string>知识点</string>\n    </entry>\n    <entry>\n      <string>B</string>\n      <string>知识点</string>\n    </entry>\n    <entry>\n      <string>C</string>\n      <string>知识点</string>\n    </entry>\n    <entry>\n      <string>D</string>\n      <string>知识点</string>\n    </entry>\n  </choiceList>\n  <choiceImgList/>\n</QuestionContent>', '1', null, '0', null, '0', '2018-05-14 16:41:42', 'admin', '2018-05-14 16:41:41', 'A', '2', '1', '1', '1', '大师傅阿斯蒂芬', '呃呃呃', '呃呃呃', '呃呃呃');
INSERT INTO `question` VALUES ('130', '鲁迅是哪里人？', '<QuestionContent>\n  <title>鲁迅是哪里人？</title>\n  <titleImg></titleImg>\n  <choiceList>\n    <entry>\n      <string>A</string>\n      <string>浙江</string>\n    </entry>\n    <entry>\n      <string>B</string>\n      <string>周树人</string>\n    </entry>\n  </choiceList>\n  <choiceImgList/>\n</QuestionContent>', '1', null, '0', null, '0', '2018-05-16 14:24:33', 'admin', '2018-05-16 14:24:33', 'A', '2', '1', '1', '1', '无', '公告', '', '');
INSERT INTO `question` VALUES ('131', 'int i = 0;', '<QuestionContent>\n  <title>int i = 0; i++;</title>\n  <titleImg></titleImg>\n  <choiceList>\n    <entry>\n      <string>A</string>\n      <string>i=1</string>\n    </entry>\n    <entry>\n      <string>B</string>\n      <string>i=0</string>\n    </entry>\n  </choiceList>\n  <choiceImgList/>\n</QuestionContent>', '1', null, '0', null, '0', '2018-05-19 12:40:51', 'admin', '2018-05-19 12:40:50', 'A', '2', '1', '1', '1', 'i自增  i=1', '', '', '');
INSERT INTO `question` VALUES ('132', 'String 是最基', '<QuestionContent>\n  <title>String 是最基本的数据类型吗？</title>\n  <titleImg></titleImg>\n  <choiceList/>\n  <choiceImgList/>\n</QuestionContent>', '3', null, '0', null, '0', '2018-05-20 15:57:40', 'admin', '2018-05-20 15:57:39', 'F', '2', '1', '1', '1', '不是。Java中的基本数据类型只有8个：byte、short、int、long、float、double、char、boolean；除了基本类型（primitive type）和枚举类型（enumeration type），剩下的都是引用类型（reference type）。', 'http://www.importnew.com/22083.html', 'String', '');
INSERT INTO `question` VALUES ('133', 'float f=3.', '<QuestionContent>\n  <title>float f=3.4;是否正确？</title>\n  <titleImg></titleImg>\n  <choiceList/>\n  <choiceImgList/>\n</QuestionContent>', '3', null, '0', null, '0', '2018-05-20 15:58:08', 'admin', '2018-05-20 15:58:07', 'F', '2', '1', '1', '1', '答:不正确。3.4是双精度数，将双精度型（double）赋值给浮点型（float）属于下转型（down-casting，也称为窄化）会造成精度损失，因此需要强制类型转换float f =(float)3.4; 或者写成float f =3.4F;。', '', 'float', '');

-- ----------------------------
-- Table structure for question_point
-- ----------------------------
DROP TABLE IF EXISTS `question_point`;
CREATE TABLE `question_point` (
  `question_2_point_id` int(11) NOT NULL AUTO_INCREMENT,
  `question_id` int(11) DEFAULT NULL,
  `point_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`question_2_point_id`),
  KEY `question_id` (`question_id`),
  KEY `question_point_ibfk_2` (`point_id`),
  CONSTRAINT `question_point_ibfk_1` FOREIGN KEY (`question_id`) REFERENCES `question` (`id`),
  CONSTRAINT `question_point_ibfk_2` FOREIGN KEY (`point_id`) REFERENCES `knowledge_point` (`kp_id`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of question_point
-- ----------------------------
INSERT INTO `question_point` VALUES ('1', '129', '28');
INSERT INTO `question_point` VALUES ('2', '130', '20');
INSERT INTO `question_point` VALUES ('3', '131', '20');
INSERT INTO `question_point` VALUES ('4', '132', '20');
INSERT INTO `question_point` VALUES ('5', '133', '20');

-- ----------------------------
-- Table structure for question_type
-- ----------------------------
DROP TABLE IF EXISTS `question_type`;
CREATE TABLE `question_type` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) NOT NULL,
  `subjective` tinyint(1) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8 COMMENT='试题类型';

-- ----------------------------
-- Records of question_type
-- ----------------------------
INSERT INTO `question_type` VALUES ('1', '单选题', '0');
INSERT INTO `question_type` VALUES ('2', '多选题', '0');
INSERT INTO `question_type` VALUES ('3', '判断题', '0');
INSERT INTO `question_type` VALUES ('4', '填空题', '0');
INSERT INTO `question_type` VALUES ('5', '简答题', '1');
INSERT INTO `question_type` VALUES ('6', '论述题', '1');
INSERT INTO `question_type` VALUES ('7', '分析题', '1');

-- ----------------------------
-- Table structure for student
-- ----------------------------
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student` (
  `Stu_account` varchar(8) NOT NULL,
  `Stu_password` varchar(255) NOT NULL DEFAULT '123456',
  `Stu_name` varchar(255) NOT NULL,
  `class_index` int(3) NOT NULL DEFAULT '1',
  `major_name` varchar(255) DEFAULT NULL,
  `state` tinyint(2) DEFAULT '1' COMMENT '是否被删除 1:存在 2:已删除',
  PRIMARY KEY (`Stu_account`),
  KEY `student_ibfk_1` (`major_name`),
  CONSTRAINT `student_ibfk_1` FOREIGN KEY (`major_name`) REFERENCES `major` (`major_name`) ON DELETE SET NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of student
-- ----------------------------
INSERT INTO `student` VALUES ('04150309', '5844ec23e5faa62977694126c0e04cea', '姓名1', '3', '计算机科学与技术', '1');
INSERT INTO `student` VALUES ('04151306', '03a33d2efd559627ef3c8b1bb3cb4cd9', '陈晓涛', '14', '软件工程', '1');
INSERT INTO `student` VALUES ('04151307', '80dbb4518ce059c3b046c26ca0bd9f30', '陈', '13', '计算机科学与技术', '1');
INSERT INTO `student` VALUES ('04151311', '4314efe8fb97bf798663ed62e514f285', '陈xx', '13', '网络工程', '1');
INSERT INTO `student` VALUES ('04151611', '6ddb89f5f3542a4a6dd0f5f1d2c7fb27', '李四', '16', '网络工程', '1');
INSERT INTO `student` VALUES ('04151710', '4c89f2e1d27d923904f61934bcf4c2fe', '姓名2', '17', '网络工程', '1');
INSERT INTO `student` VALUES ('04151807', 'e1c12da92b25cfb897cd98239e8dcda2', '韩金龙', '18', '网络工程', '1');
INSERT INTO `student` VALUES ('04151808', '74fd29d0fe89f7d7d0d77285c47445dc', '李默默', '18', '网络工程', '1');

-- ----------------------------
-- Table structure for stu_course
-- ----------------------------
DROP TABLE IF EXISTS `stu_course`;
CREATE TABLE `stu_course` (
  `stu_account` varchar(12) NOT NULL,
  `course_id` int(11) NOT NULL,
  `score` int(11) DEFAULT '0' COMMENT '学生在该门课程的成绩',
  `state` int(2) NOT NULL DEFAULT '1' COMMENT '该成绩是否可用 1:''可用'' 0:''不可用''',
  PRIMARY KEY (`stu_account`,`course_id`),
  KEY `stu_course_ibfk_2` (`course_id`),
  CONSTRAINT `stu_course_ibfk_1` FOREIGN KEY (`stu_account`) REFERENCES `student` (`Stu_account`) ON DELETE CASCADE,
  CONSTRAINT `stu_course_ibfk_2` FOREIGN KEY (`course_id`) REFERENCES `course` (`Course_id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of stu_course
-- ----------------------------
INSERT INTO `stu_course` VALUES ('04150309', '5', '1', '1');
INSERT INTO `stu_course` VALUES ('04151306', '5', '23', '1');
INSERT INTO `stu_course` VALUES ('04151611', '5', '3', '1');
INSERT INTO `stu_course` VALUES ('04151710', '5', '0', '1');
INSERT INTO `stu_course` VALUES ('04151807', '5', '1', '1');
INSERT INTO `stu_course` VALUES ('04151808', '5', '0', '1');

-- ----------------------------
-- Table structure for stu_video
-- ----------------------------
DROP TABLE IF EXISTS `stu_video`;
CREATE TABLE `stu_video` (
  `Stu_account` varchar(8) DEFAULT NULL,
  `Video_id` int(11) DEFAULT NULL,
  `Last_visit` datetime DEFAULT NULL,
  KEY `stu_video_ibfk_1` (`Stu_account`),
  KEY `stu_video_ibfk_2` (`Video_id`),
  CONSTRAINT `stu_video_ibfk_1` FOREIGN KEY (`Stu_account`) REFERENCES `student` (`Stu_account`) ON DELETE CASCADE,
  CONSTRAINT `stu_video_ibfk_2` FOREIGN KEY (`Video_id`) REFERENCES `video` (`Vedio_id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of stu_video
-- ----------------------------

-- ----------------------------
-- Table structure for tch_stu
-- ----------------------------
DROP TABLE IF EXISTS `tch_stu`;
CREATE TABLE `tch_stu` (
  `tch_account` varchar(12) NOT NULL,
  `stu_account` varchar(12) NOT NULL,
  PRIMARY KEY (`tch_account`,`stu_account`),
  KEY `tch_stu_ibfk_2` (`stu_account`),
  CONSTRAINT `tch_stu_ibfk_1` FOREIGN KEY (`tch_account`) REFERENCES `teacher` (`tch_account`) ON DELETE CASCADE,
  CONSTRAINT `tch_stu_ibfk_2` FOREIGN KEY (`stu_account`) REFERENCES `student` (`Stu_account`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tch_stu
-- ----------------------------

-- ----------------------------
-- Table structure for teacher
-- ----------------------------
DROP TABLE IF EXISTS `teacher`;
CREATE TABLE `teacher` (
  `tch_account` varchar(12) NOT NULL,
  `tch_name` varchar(12) NOT NULL,
  `tch_password` varchar(32) NOT NULL DEFAULT '123456',
  `role` char(10) DEFAULT 'teacher',
  `state` int(2) unsigned DEFAULT '1' COMMENT '1:存在  2:已删除',
  PRIMARY KEY (`tch_account`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of teacher
-- ----------------------------
INSERT INTO `teacher` VALUES ('04150309', '姓名1', '5844ec23e5faa62977694126c0e04cea', 'teacher', '1');
INSERT INTO `teacher` VALUES ('04151306', '陈晓涛', '03a33d2efd559627ef3c8b1bb3cb4cd9', 'teacher', '1');
INSERT INTO `teacher` VALUES ('04151611', '李四', '6ddb89f5f3542a4a6dd0f5f1d2c7fb27', 'teacher', '1');
INSERT INTO `teacher` VALUES ('04151710', '姓名2', '4c89f2e1d27d923904f61934bcf4c2fe', 'teacher', '1');
INSERT INTO `teacher` VALUES ('04151807', '韩金龙', 'e1c12da92b25cfb897cd98239e8dcda2', 'teacher', '1');
INSERT INTO `teacher` VALUES ('04151808', '李默默', '74fd29d0fe89f7d7d0d77285c47445dc', 'teacher', '1');
INSERT INTO `teacher` VALUES ('admin', '陈志chong', '928bfd2577490322a6e19b793691467e', 'admin', '1');

-- ----------------------------
-- Table structure for video
-- ----------------------------
DROP TABLE IF EXISTS `video`;
CREATE TABLE `video` (
  `Vedio_id` int(11) NOT NULL AUTO_INCREMENT,
  `Vedio_name` varchar(255) DEFAULT NULL,
  `Vedio_src` varchar(255) DEFAULT NULL,
  `Vedio_grade` tinyint(4) DEFAULT NULL,
  `Visit_time` int(11) DEFAULT '0',
  `kp_id` int(11) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `state` tinyint(2) DEFAULT '1' COMMENT '是否被删除 1:存在 2:已删除',
  `create_account` varchar(12) DEFAULT NULL,
  PRIMARY KEY (`Vedio_id`),
  KEY `video_ibfk_1` (`kp_id`),
  CONSTRAINT `video_ibfk_1` FOREIGN KEY (`kp_id`) REFERENCES `knowledge_point` (`kp_id`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=36 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of video
-- ----------------------------
INSERT INTO `video` VALUES ('31', '01-Spring的发展.mp4', 'http://localhost:8080/quinFS/file/b82f4402ff0e45b282ac1acd43ab40d6.mp4', '2', '0', '23', '2018-05-01 14:19:45', '2018-05-01 14:19:45', '1', 'admin');
INSERT INTO `video` VALUES ('34', '为什么要学习C语言？', 'http://localhost:8080/quinFS/file/405eaf448a7842698b059e6b50b492ca.mp4', '2', '0', '20', '2018-05-15 17:32:58', '2018-05-15 21:14:17', '1', 'admin');
INSERT INTO `video` VALUES ('35', '03-实战-读取外部的配置文件.mp4', 'http://localhost:8080/quinFS/file/f935d2ac6e4541b4ad360143e68b5719.mp4', '2', '0', '20', '2018-05-18 23:16:41', '2018-05-18 23:16:41', '1', 'admin');

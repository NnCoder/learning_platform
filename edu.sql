/*
Navicat MySQL Data Transfer

Source Server         : mysql
Source Server Version : 50624
Source Host           : localhost:3306
Source Database       : edu

Target Server Type    : MYSQL
Target Server Version : 50624
File Encoding         : 65001

Date: 2018-04-30 12:23:28
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
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of chapter
-- ----------------------------
INSERT INTO `chapter` VALUES ('10', '新建章节', '5', '2018-02-08 22:04:09', '2018-02-08 22:04:09', '1');
INSERT INTO `chapter` VALUES ('14', '新建章节2', '5', '2018-04-02 21:04:06', '2018-04-02 21:04:06', '1');
INSERT INTO `chapter` VALUES ('15', '新建章节3', '5', '2018-04-02 21:04:07', '2018-04-02 21:04:07', '1');
INSERT INTO `chapter` VALUES ('16', '新建章节4', '5', '2018-04-02 21:04:09', '2018-04-02 21:04:09', '1');
INSERT INTO `chapter` VALUES ('17', '新建章节5', '5', '2018-04-02 21:04:11', '2018-04-02 21:04:11', '1');
INSERT INTO `chapter` VALUES ('18', '新建章节6', '5', '2018-04-02 21:04:12', '2018-04-02 21:04:12', '1');

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
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of chapter_data
-- ----------------------------
INSERT INTO `chapter_data` VALUES ('1', '10', 'DatatablesDemo-master.zip', 'http://localhost:8080/quinFS/file/601ea96dc56a41358cdfebf5c0e81a77.zip', 'admin');
INSERT INTO `chapter_data` VALUES ('2', '10', 'layui-v2.2.5.zip', 'http://localhost:8080/quinFS/file/bb1ee7d7621c4ec5bf8b8dc42aa16b97.zip', 'admin');

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
) ENGINE=InnoDB AUTO_INCREMENT=44 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of comment
-- ----------------------------
INSERT INTO `comment` VALUES ('12', '1', '04151307 陈晓涛', 'hello world', '2018-04-18 12:17:40', null);
INSERT INTO `comment` VALUES ('12', '2', '04151307 ???', 'hello world', '2018-04-18 14:16:28', null);
INSERT INTO `comment` VALUES ('12', '3', '04151307 ???', 'hello world', '2018-04-18 14:18:11', null);
INSERT INTO `comment` VALUES ('12', '4', '04151307chenxiaotao', '评论', '2018-04-18 14:19:50', null);
INSERT INTO `comment` VALUES ('12', '5', '04151307chenxiaotao', '评论', '2018-04-18 14:22:39', null);
INSERT INTO `comment` VALUES ('12', '6', '04151307 ???', 'hello world', '2018-04-18 14:27:54', null);
INSERT INTO `comment` VALUES ('12', '7', '04151307chenxiaotao', '评论', '2018-04-18 14:28:43', null);
INSERT INTO `comment` VALUES ('12', '8', '04151307 ???', 'hello world', '2018-04-18 14:32:10', null);
INSERT INTO `comment` VALUES ('12', '9', '04151307 ???', 'hello world', '2018-04-18 14:34:00', null);
INSERT INTO `comment` VALUES ('12', '10', '04151307 ???', 'hello world', '2018-04-18 14:36:10', null);
INSERT INTO `comment` VALUES ('12', '11', '04151307chenxiaotao', '评     论', '2018-04-18 14:39:13', null);
INSERT INTO `comment` VALUES ('12', '12', '04151307 ???', 'hello world', '2018-04-18 14:41:23', null);
INSERT INTO `comment` VALUES ('12', '13', '04151307 ???', 'hello world', '2018-04-18 14:42:33', null);
INSERT INTO `comment` VALUES ('12', '14', '04151307 ???', 'hello world', '2018-04-18 14:45:10', null);
INSERT INTO `comment` VALUES ('12', '15', '04151307 ???', 'hello world', '2018-04-18 14:52:06', null);
INSERT INTO `comment` VALUES ('12', '16', '04151307 ???', 'hello world', '2018-04-18 14:53:24', null);
INSERT INTO `comment` VALUES ('12', '17', '04151307 ???', 'hello world', '2018-04-18 14:53:59', null);
INSERT INTO `comment` VALUES ('12', '18', '04151307 ???', 'hello world', '2018-04-18 14:54:23', null);
INSERT INTO `comment` VALUES ('12', '19', '04151307 ???', 'hello world', '2018-04-18 14:55:07', null);
INSERT INTO `comment` VALUES ('12', '20', '04151307 ???', 'hello world', '2018-04-18 14:56:55', null);
INSERT INTO `comment` VALUES ('12', '21', '04151306 陈晓涛', '刚才', '2018-04-20 16:30:44', null);
INSERT INTO `comment` VALUES ('12', '22', '04151306 陈晓涛', '刚才', '2018-04-20 16:30:51', null);
INSERT INTO `comment` VALUES ('12', '23', '04151306 陈晓涛', '个', '2018-04-20 16:32:01', null);
INSERT INTO `comment` VALUES ('12', '24', '04151306 陈晓涛', '的是', '2018-04-20 16:32:36', null);
INSERT INTO `comment` VALUES ('12', '25', '04151306 陈晓涛', '提问', '2018-04-20 16:35:04', null);
INSERT INTO `comment` VALUES ('12', '26', '04151306 陈晓涛', '提问。。。', '2018-04-20 16:35:14', null);
INSERT INTO `comment` VALUES ('12', '27', '04151306 陈晓涛', '提问啊啊啊', '2018-04-20 16:36:13', null);
INSERT INTO `comment` VALUES ('12', '28', '04151306 陈晓涛', '提问：Spring', '2018-04-20 16:38:03', null);
INSERT INTO `comment` VALUES ('12', '29', '04151306 陈晓涛', '提问：my', '2018-04-20 16:38:30', null);
INSERT INTO `comment` VALUES ('12', '30', '04151306 陈晓涛', '提问', '2018-04-20 16:39:05', null);
INSERT INTO `comment` VALUES ('12', '31', '04151306 陈晓涛', '提问', '2018-04-20 16:39:26', null);
INSERT INTO `comment` VALUES ('12', '32', '04151306 陈晓涛', '提问啦啦啦', '2018-04-20 16:40:15', null);
INSERT INTO `comment` VALUES ('12', '33', '04151306 陈晓涛', '我的提问', '2018-04-20 16:40:59', null);
INSERT INTO `comment` VALUES ('12', '34', '04151306 陈晓涛', '我的提问222222', '2018-04-20 16:43:17', null);
INSERT INTO `comment` VALUES ('12', '35', '04151306 陈晓涛', '我的提问', '2018-04-20 16:44:38', null);
INSERT INTO `comment` VALUES ('12', '36', '04151306 陈晓涛', '更多的评论', '2018-04-20 16:45:31', null);
INSERT INTO `comment` VALUES ('12', '37', '04151306 陈晓涛', '更多的评论', '2018-04-20 16:45:57', null);
INSERT INTO `comment` VALUES ('12', '38', '04151306 陈晓涛', '我的提问', '2018-04-20 16:46:40', null);
INSERT INTO `comment` VALUES ('12', '39', '04151306 陈晓涛', '我的提问问你问你问额外呢', '2018-04-20 16:47:10', null);
INSERT INTO `comment` VALUES ('12', '41', '陈志冲', '好的我知道了', '2018-04-20 22:13:14', '39');
INSERT INTO `comment` VALUES ('12', '42', '陈志冲', '嗯嗯嗯嗯', '2018-04-20 22:13:33', '39');
INSERT INTO `comment` VALUES ('12', '43', '陈志冲', '提问得好', '2018-04-26 13:10:32', '38');

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
  KEY `Tch_account` (`Tch_account`),
  KEY `Course_id` (`Course_id`),
  CONSTRAINT `course_ibfk_1` FOREIGN KEY (`Tch_account`) REFERENCES `teacher` (`tch_account`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of course
-- ----------------------------
INSERT INTO `course` VALUES ('5', '课程2', 'http://localhost:8080/edu-manager/file/b2d2792b59a247e48f19730bbaa00c49.jpg', '&lt;p&gt;&lt;/p&gt;&lt;script&gt;adfasdfasdf&lt;/script&gt;', 'public&nbsp;class&nbsp;HtmlTemplateLoader&nbsp;implements&nbsp;TemplateLoader&nbsp;{&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;private&nbsp;static&nbsp;final&nbsp;String&nbsp;HTML_ESCAPE_PREFIX=&nbsp;\"&lt;#escape&nbsp;x&nbsp;as&nbsp;x?html&gt;\";&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;private&nbsp;static&nbsp;final&nbsp;String&nbsp;HTML_ESCAPE_SUFFIX&nbsp;=&nbsp;\"&lt;/#escape&gt;\";&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;private&nbsp;final&nbsp;TemplateLoader&nbsp;delegate;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;public&nbsp;HtmlTemplateLoader(TemplateLoader&nbsp;delegate)&nbsp;{&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;this.delegate&nbsp;=&nbsp;delegate;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;}&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;@Override&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;public&nbsp;Object&nbsp;findTemplateSource(String&nbsp;name)&nbsp;throws&nbsp;IOException&nbsp;{&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;return&nbsp;delegate.findTemplateSource(name);&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;}&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;@Override&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;public&nbsp;long&nbsp;getLastModified(Object&nbsp;templateSource)&nbsp;{&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;return&nbsp;delegate.getLastModified(templateSource);&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;}&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;@Override&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;public&nbsp;Reader&nbsp;getReader(Object&nbsp;templateSource,&nbsp;String&nbsp;encoding)&nbsp;throws&nbsp;IOException&nbsp;{&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Reader&nbsp;reader&nbsp;=&nbsp;delegate.getReader(templateSource,&nbsp;encoding);&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;String&nbsp;templateText&nbsp;=&nbsp;IOUtils.toString(reader);&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;return&nbsp;new&nbsp;StringReader(HTML_ESCAPE_PREFIX+templateText&nbsp;+&nbsp;HTML_ESCAPE_SUFFIX);&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;}&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;@Override&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;public&nbsp;void&nbsp;closeTemplateSource(Object&nbsp;templateSource)&nbsp;throws&nbsp;IOException&nbsp;{&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;delegate.closeTemplateSource(templateSource);&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;}&nbsp;&nbsp;&nbsp;&nbsp;}&nbsp;&nbsp;', 'admin', '38', '2018-02-08 21:58:08', '2018-02-08 21:58:52', '1');

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
INSERT INTO `course_desc` VALUES ('5', '<h1>\r\n	fasdf&nbsp;\r\n	<p style=\"font-size:16px;color:#2A2A2A;text-align:justify;font-family:&quot;background-color:#FFFFFF;\">\r\n		外键 (FK) 是用于建立和加强两个表数据之间的链接的一列或多列。当创建或修改表时可通过定义 FOREIGN KEY 约束来创建外键。\r\n	</p>\r\n	<p style=\"font-size:16px;color:#2A2A2A;text-align:justify;font-family:&quot;background-color:#FFFFFF;\">\r\n		在外键引用中，当一个表的列被引用作为另一个表的主键值的列时，就在两表之间创建了链接。这个列就成为第二个表的外键。\r\n	</p>\r\n	<p style=\"font-size:16px;color:#2A2A2A;text-align:justify;font-family:&quot;background-color:#FFFFFF;\">\r\n		例如，因为销售订单和销售人员之间存在一种逻辑关系，所以 AdventureWorks 数据库中的&nbsp;<span style=\"font-weight:700;\">Sales.SalesOrderHeader</span>&nbsp;表含有一个指向<span style=\"font-weight:700;\">Sales.SalesPerson</span>&nbsp;表的链接。<span style=\"font-weight:700;\">SalesOrderHeader</span>&nbsp;表中的&nbsp;<span style=\"font-weight:700;\">SalesPersonID</span>&nbsp;列与&nbsp;<span style=\"font-weight:700;\">SalesPerson</span>&nbsp;表中的主键列相对应。<span style=\"font-weight:700;\">SalesOrderHeader</span>&nbsp;表中的<span style=\"font-weight:700;\">SalesPersonID</span>&nbsp;列是指向&nbsp;<span style=\"font-weight:700;\">SalesPerson</span>&nbsp;表的外键。\r\n	</p>\r\n<img id=\"fkart1\" alt=\"SalesOrderHeader.SalesPersonID 为外键。\" src=\"https://i-msdn.sec.s-msft.com/dynimg/IC146434.gif\" title=\"SalesOrderHeader.SalesPersonID 为外键。\" />\r\n	<p style=\"font-size:16px;color:#2A2A2A;text-align:justify;font-family:&quot;background-color:#FFFFFF;\">\r\n		<span style=\"background-color:#33FF33;\">FOREIGN KEY 约束并不仅仅可以与另一表的 PRIMARY KEY 约束相链接，它还可以定义为引用另一表的 UNIQUE 约束</span>。FOREIGN KEY 约束可以包含空值，但是，如果任何组合 FOREIGN KEY 约束的列包含空值，则将跳过组成 FOREIGN KEY 约束的所有值的验证。若要确保验证了组合 FOREIGN KEY 约束的所有值，请将所有参与列指定为 NOT NULL。\r\n	</p>\r\n</h1>');

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
  KEY `Kp_id` (`Kp_id`),
  CONSTRAINT `data_ibfk_1` FOREIGN KEY (`Kp_id`) REFERENCES `knowledge_point` (`kp_id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of data
-- ----------------------------
INSERT INTO `data` VALUES ('9', '图片222', 'http://120.79.10.20:8080/quinFS/file/65c51ebd86974d2282fa473e24fc9ad0.jpg', '1', '12', '2018-04-02 21:03:45', '2018-04-29 16:11:47', 'admin');
INSERT INTO `data` VALUES ('10', '.gitignore', 'http://120.79.10.20:8080/quinFS/file/8cdc3c40c92b4b888c27bf0f9ff3d94f.gitignore', '2', '12', '2018-04-13 21:21:36', '2018-04-13 21:21:36', 'admin');
INSERT INTO `data` VALUES ('11', 'basic-plus.html', 'http://120.79.10.20:8080/quinFS/file/b8f159fcd4974bab9be7ef5ac901eb06.html', '2', '12', '2018-04-13 21:21:43', '2018-04-13 21:21:43', 'admin');
INSERT INTO `data` VALUES ('12', 'edu.sql', 'http://120.79.10.20:8080/quinFS/file/7241b4b4924f4820a67ccf44ab3b0a76.sql', '1', '12', '2018-04-13 21:37:38', '2018-04-13 21:37:38', 'admin');
INSERT INTO `data` VALUES ('14', 'pconline1489049981826.zip', 'http://120.79.10.20:8080/quinFS/file/71207e8a8ff24a0d858f5e3b842e8ad3.zip', '2', '15', '2018-04-14 19:59:17', '2018-04-14 19:59:17', 'admin');

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
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of knowledge_point
-- ----------------------------
INSERT INTO `knowledge_point` VALUES ('12', '知识点1', '&lt;p&gt;&lt;/p&gt;\"\"\"\"\"\"', 'niasdfsadf', '', '10', '1');
INSERT INTO `knowledge_point` VALUES ('15', '知识点', '', '', '', '14', '1');
INSERT INTO `knowledge_point` VALUES ('16', '知识点2', '知识点2', '知识点2', '知识点2', '14', '1');
INSERT INTO `knowledge_point` VALUES ('17', '知识点3', '知识点3', '知识点3', '知识点3', '14', '1');
INSERT INTO `knowledge_point` VALUES ('18', '知识点4', '知识点4', '知识点4', '知识点4', '14', '1');

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
INSERT INTO `student` VALUES ('04151306', '03a33d2efd559627ef3c8b1bb3cb4cd9', '陈晓涛', '13', '软件工程', '1');
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
INSERT INTO `stu_course` VALUES ('04150309', '5', '0', '1');
INSERT INTO `stu_course` VALUES ('04151306', '5', '7', '1');
INSERT INTO `stu_course` VALUES ('04151611', '5', '0', '1');
INSERT INTO `stu_course` VALUES ('04151710', '5', '0', '1');
INSERT INTO `stu_course` VALUES ('04151807', '5', '0', '1');
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
INSERT INTO `teacher` VALUES ('admin', '陈志冲', '928bfd2577490322a6e19b793691467e', 'admin', '1');

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
) ENGINE=InnoDB AUTO_INCREMENT=32 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of video
-- ----------------------------
INSERT INTO `video` VALUES ('27', '01-Spring的发展.mp4', 'http://localhost:8080/quinFS/file/4390c3ed1b3c4df2a52a8f63d1d482c1.mp4', '2', '0', '12', '2018-04-20 16:03:15', '2018-04-29 16:16:51', '1', 'admin');
INSERT INTO `video` VALUES ('28', '04-SpringBoot简介.mp4', 'http://localhost:8080/quinFS/file/cc6412b6a64d422abcbfdf844a2ccae2.mp4', '2', '0', '12', '2018-04-20 16:03:17', '2018-04-26 15:33:15', '1', 'admin');
INSERT INTO `video` VALUES ('29', '01-Spring的发展.mp4', 'http://localhost:8080/quinFS/file/ef72c1d0a77445468d53e08c35f43ac7.mp4', '2', '0', '15', '2018-04-20 22:26:21', '2018-04-20 22:26:21', '1', 'admin');
INSERT INTO `video` VALUES ('30', '01-Spring的发展.mp4', 'http://localhost:8080/quinFS/file/91a2a7c15713427a931161d6d92dbe9d.mp4', '2', '0', '16', '2018-04-20 22:27:35', '2018-04-20 22:27:35', '1', 'admin');
INSERT INTO `video` VALUES ('31', '08-starter', 'http://localhost:8080/quinFS/file/5101f4a0069a4e9f8e1f5541e02a9fac.mp4', '2', '0', '16', '2018-04-20 22:27:46', '2018-04-20 22:27:46', '1', 'admin');

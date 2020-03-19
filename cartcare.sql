-- phpMyAdmin SQL Dump
-- version 4.1.14
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: 2020-02-17 13:40:37
-- 服务器版本： 5.6.17
-- PHP Version: 5.5.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `cartcare`
--
CREATE DATABASE IF NOT EXISTS `cartcare` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;
USE `cartcare`;

-- --------------------------------------------------------

--
-- 表的结构 `admin`
--
-- 创建时间： 2020-02-14 18:13:18
--

CREATE TABLE IF NOT EXISTS `admin` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(30) DEFAULT NULL,
  `password` varchar(30) DEFAULT NULL,
  `dept` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=13 ;

--
-- 转存表中的数据 `admin`
--

INSERT INTO `admin` (`id`, `username`, `password`, `dept`) VALUES
(1, '百里登风aaa', '12345678', '维修部'),
(2, '回眸序三千A', '1234567890', '保养部'),
(3, '令狐冲666', 'abc123', '维修部'),
(4, '迪丽热巴姐姐', '12345678', '宣传部'),
(5, '陈晓洁', '12345678', '保养部'),
(6, '柳二龙', '12345678', '维修部'),
(7, '小刚', '12345678', '维修部'),
(8, '水冰儿', '12345678', '保养部'),
(9, '火舞', '12345678', '保养部'),
(10, '神风', '12345678', '保养部'),
(11, '玉天恒', '12345678', '保养部'),
(12, '蓝电霸王龙', '12345678', '维修部');

-- --------------------------------------------------------

--
-- 表的结构 `article`
--
-- 创建时间： 2020-02-15 15:34:50
--

CREATE TABLE IF NOT EXISTS `article` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(50) DEFAULT NULL,
  `content` varchar(5000) DEFAULT NULL,
  `createat` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=13 ;

--
-- 转存表中的数据 `article`
--

INSERT INTO `article` (`id`, `title`, `content`, `createat`) VALUES
(1, '预计2020年底亮相 全新高尔夫R谍照曝光', '<p>[汽车之家&nbsp;<a href="https://www.autohome.com.cn/11078/0/1/conjunction.html" target="_blank">海外谍照</a>]&nbsp; 日前，有海外媒体曝光了一组全新大众高尔夫R无伪谍照。新车的前包围与普通版车型有着明显不同，看起来更运动。据悉，新车预计将于2020年年底亮相。</p>\r\n\r\n<hr />\r\n<p>&nbsp;</p>\r\n\r\n<p><strong>　　友情提示：</strong>希望热心网友能够将您所发现的新车谍照拍摄下来，并发送到我们相应的邮箱内：<a href="https://www.autohome.com.cn/diezhao@autohome.com.cn" target="_blank">diezhao@autohome.com.cn</a>，期待您的来信，并成为&ldquo;谍报家&rdquo;中的一员。</p>\r\n\r\n<hr />\r\n<p>&nbsp;</p>\r\n\r\n<p><a href="https://www.autohome.com.cn/img/?img=newsdfs/g27/M05/A7/34/autohomecar__ChsEnV5DaQeAKR2aAAG8LaFB6dw960.jpg" target="_blank"><img alt="汽车之家" src="https://www2.autoimg.cn/newsdfs/g27/M05/A7/34/744x0_0_autohomecar__ChsEnV5DaQeAKR2aAAG8LaFB6dw960.jpg" style="width:744px" /></a></p>\r\n\r\n<p>　　从谍照来看，新车前脸设计相比普通版车型要更具有攻击性。比如新车采用全新的前包围设计，透露出象征运动的&ldquo;R&rdquo;精神。虽然测试车辆显示新车的格栅没有变化，但预计未来会增加R标识。另外，走线&ldquo;妖娆&rdquo;的前大灯组还是延续了普通版设计。</p>\r\n\r\n<p><a href="https://www.autohome.com.cn/img/?img=newsdfs/g27/M09/AA/6B/autohomecar__ChcCQF5DaQeAZAxJAAOWl9hOQf4761.jpg" target="_blank"><img alt="汽车之家" src="https://www3.autoimg.cn/newsdfs/g27/M09/AA/6B/744x0_0_autohomecar__ChcCQF5DaQeAZAxJAAOWl9hOQf4761.jpg" style="width:744px" /></a></p>\r\n\r\n<p><a href="https://www.autohome.com.cn/img/?img=newsdfs/g1/M0A/BD/AA/autohomecar__ChsEj15DaQeAPnp3AAH5dWPd7TY548.jpg" target="_blank"><img alt="汽车之家" src="https://www3.autoimg.cn/newsdfs/g1/M0A/BD/AA/744x0_0_autohomecar__ChsEj15DaQeAPnp3AAH5dWPd7TY548.jpg" style="width:744px" /></a></p>\r\n\r\n<p>　　车尾部分，新车配备标志性的双边共四出排气，证明其&ldquo;R&rdquo;身份。其余部分并没有与普通版车型有太多区别，包括横向尾灯组等，但全黑色的扩散器还是带来了浓厚的运动气息。</p>\r\n', '2020-02-12 13:05:47'),
(2, '系统功率180kW 西雅特Cupra Leon预告图', '<p>[汽车之家&nbsp;<a href="https://ev.autohome.com.cn/#pvareaid=3311257" target="_blank">新能源</a>]&nbsp; 日前，西雅特旗下高性能子品牌Cupra发布了一张Cupra Leon的预告图，新车将在2月20日的发布会上首次亮相，随后在2020日内瓦车展上展出。新车的动力系统与斯柯达明锐RS插电式混合动力车型相同，由1.4TSI发动机和驱动电机组成，最大功率为242HP（180kW）。</p>\r\n\r\n<p><a href="https://www.autohome.com.cn/img/?img=newsdfs/g27/M05/A7/E6/autohomecar__ChsEfF5DZd6AGri8AAG5VgIrFRA928.jpg" target="_blank"><img alt="汽车之家" src="https://www2.autoimg.cn/newsdfs/g27/M05/A7/E6/744x0_1_autohomecar__ChsEfF5DZd6AGri8AAG5VgIrFRA928.jpg" style="width:744px" /></a></p>\r\n\r\n<p>　　Cupra是西雅特旗下的高性能子品牌，该品牌正式宣布将于2月20日的发布会上正式亮相旗下首款插电混动式紧凑型车&mdash;&mdash;Cupra Leon，新车还将在3月份举办的2020日内瓦车展上展出。从预告图中可以看出，新车的LOGO已从西雅特更换为Cupra，而隐约可见的前脸造型加上LED日间行车灯的点缀，给人一种气势汹汹的视觉效果。</p>\r\n\r\n<p><a href="https://www.autohome.com.cn/img/?img=newsdfs/g24/M0A/C2/36/autohomecar__ChsEeV2NomWAdjmDAAKeQh-4Yis111.jpg" target="_blank"><img alt="汽车之家" src="https://www2.autoimg.cn/newsdfs/g24/M0A/C2/36/744x0_0_autohomecar__ChsEeV2NomWAdjmDAAKeQh-4Yis111.jpg" style="width:744px" /></a></p>\r\n', '2020-02-12 13:06:29'),
(3, '97种车身组合 新款雪铁龙C3官图发布', '<p>[汽车之家&nbsp;<a href="https://www.autohome.com.cn/11079/0/1/conjunction.html" target="_blank">新车官图</a>]&nbsp; 日前，雪铁龙官方发布了中期改款C3车型的官图。新车整体造型更加圆润，凸显其特点。此外，新车升级至97种外观颜色组合，消费者可以根据自己的喜好来选择搭配。</p>\r\n\r\n<p><a href="https://car.autohome.com.cn/photo/43865/53/5405889.html" target="_blank"><img alt="雪铁龙(进口) 雪铁龙C3 2020款 基本型" src="https://www3.autoimg.cn/cardfs/product/g26/M09/A9/07/744x0_1_autohomecar__ChcCP15DUfWAGpEdAAHHZr6bPqs522.jpg" style="width:744px" /></a></p>\r\n\r\n<p>　　外观方面，<a href="https://www.autohome.com.cn/329/" target="_blank">雪铁龙C3</a>(<a href="https://car.autohome.com.cn/config/series/329.html" target="_blank">参数</a>|<a href="https://leads.autohome.com.cn/landingpage/views/pc/pcInquiry/id_10001344/channelid_29/?seriesid=329&amp;eid=1|1|37|3|203736|302100" target="_blank">询价</a>)采用全新的家族化设计，整体造型风格更加时尚圆润。分体式设计的前大灯显得格外迥异，内部采用LED光源。侧面来看，新车采用隐藏式A/B柱设计，营造出悬浮式车顶的效果。此外，车顶及后视镜外壳则采用另一种统一的颜色。</p>\r\n\r\n<p><a href="https://car.autohome.com.cn/photo/43865/53/5405887.html" target="_blank"><img alt="雪铁龙(进口) 雪铁龙C3 2020款 基本型" src="https://www2.autoimg.cn/cardfs/product/g28/M08/A5/1E/744x0_1_autohomecar__ChsEnl5DUfOANYjsAAGs5iqquB4704.jpg" style="width:744px" /></a></p>\r\n', '2020-02-12 13:06:59'),
(4, '西雅特Tarraco FR/FR Sport官图发布', '<p>[汽车之家&nbsp;<a href="https://www.autohome.com.cn/11079/0/1/conjunction.html" target="_blank">新车官图</a>]&nbsp; 日前，西雅特发布了Tarraco FR及FR Sport车型的官图。新车采用了较为运动化的外观套件，使其看上去更加年轻。此前，FR套件车型为Tarraco PHEV插电混动版专属，现在燃油版Tarraco也拥有了FR套件车型。价格方面，Tarraco FR在英国市场的起售价为31680英镑（约合人民币28.58万元），而FR Sport车型为33430英镑（约合人民币30.16万元）。</p>\r\n\r\n<p><a href="https://car.autohome.com.cn/photo/43868/53/5405932.html" target="_blank"><img alt="西雅特 Tarraco 2020款 FR Sport" src="https://www2.autoimg.cn/cardfs/product/g3/M07/A0/E3/744x0_1_autohomecar__ChsEm15DWZuAa7BTAAEzqiiyLao514.jpg" style="width:744px" /></a></p>\r\n\r\n<p><a href="https://car.autohome.com.cn/photo/43868/53/5405930.html" target="_blank"><img alt="西雅特 Tarraco 2020款 FR Sport" src="https://www2.autoimg.cn/cardfs/product/g3/M05/B3/E7/744x0_1_autohomecar__ChsEkV5DWZKAQh8HAAEy-48ucM4087.jpg" style="width:744px" /></a></p>\r\n\r\n<p><a href="https://car.autohome.com.cn/photo/43868/53/5405931.html" target="_blank"><img alt="西雅特 Tarraco 2020款 FR Sport" src="https://www3.autoimg.cn/cardfs/product/g25/M0A/07/8A/744x0_1_autohomecar__ChcCr15DWZOAXka4AAFDC2xA7dM661.jpg" style="width:744px" /></a></p>\r\n', '2020-02-12 13:07:24'),
(5, '更不羁 阿斯顿·马丁Vantage敞篷版官图', '<p>[汽车之家&nbsp;<a href="https://www.autohome.com.cn/11079/0/1/conjunction.html" target="_blank">新车官图</a>]&nbsp; 日前，阿斯顿&middot;马丁官方发布了<a href="https://www.autohome.com.cn/385/" target="_blank">Vantage</a>(<a href="https://car.autohome.com.cn/config/series/385.html" target="_blank">参数</a>|<a href="https://leads.autohome.com.cn/landingpage/views/pc/pcInquiry/id_10001344/channelid_29/?seriesid=385&amp;eid=1|1|37|3|203736|302100" target="_blank">询价</a>)敞篷版的官图，新车基于硬顶版车型打造，更加优雅和不羁，它将会在2020年第二季度正式交付。</p>\r\n\r\n<p><a href="https://www.autohome.com.cn/img/?img=newsdfs/g28/M00/A5/97/autohomecar__ChsEfV5DVAKAPM7UAAE-62SRzF8762.jpg" target="_blank"><img alt="汽车之家" src="https://www3.autoimg.cn/newsdfs/g28/M00/A5/97/744x0_1_autohomecar__ChsEfV5DVAKAPM7UAAE-62SRzF8762.jpg" style="width:744px" /></a></p>\r\n\r\n<p><a href="https://www.autohome.com.cn/img/?img=newsdfs/g28/M03/A5/97/autohomecar__ChsEfV5DVAKAOCIVAAEODihG07I262.jpg" target="_blank"><img alt="汽车之家" src="https://www2.autoimg.cn/newsdfs/g28/M03/A5/97/744x0_1_autohomecar__ChsEfV5DVAKAOCIVAAEODihG07I262.jpg" style="width:744px" /></a></p>\r\n\r\n<p><a href="https://www.autohome.com.cn/img/?img=newsdfs/g30/M06/A4/F0/autohomecar__ChsEf15DVcGAGgg0AHJtS7KnsMU767.gif" target="_blank"><img alt="汽车之家" src="https://www2.autoimg.cn/newsdfs/g30/M06/A4/F0/autohomecar__ChsEf15DVcGAGgg0AHJtS7KnsMU767.gif" style="height:419px; width:744px" /></a></p>\r\n', '2020-02-12 13:07:40'),
(6, '售价不变 华晨宝马530Le里程升级版上市', '<p>[汽车之家&nbsp;<a href="https://www.autohome.com.cn/51/0/1/conjunction.html" target="_blank">新车上市</a>]&nbsp; 日前我们从宝马官网获悉，华晨宝马530Le里程升级版正式上市，价格相比现款车型不变，<strong>仍为49.99-53.69万元</strong>。据悉，530Le里程升级版最大的升级点在于换装了第四代eDrive系统，其电池容量和纯电续航里程分别由现款车型的13kWh、67km增加到了17.7kWh、95km，进一步提升了纯电动模式下的出行半径（注：文中配图为现款车型）。</p>\r\n\r\n<table align="center" border="1" cellpadding="5" cellspacing="0" style="width:744px">\r\n	<tbody>\r\n		<tr>\r\n			<td colspan="2"><strong>宝马530Le里程升级版 指导售价</strong></td>\r\n		</tr>\r\n		<tr>\r\n			<td><strong>车型</strong></td>\r\n			<td><strong>售价（万元）</strong></td>\r\n		</tr>\r\n		<tr>\r\n			<td colspan="1" rowspan="1">530Le 里程升级版 豪华套装</td>\r\n			<td colspan="1" rowspan="1">49.99</td>\r\n		</tr>\r\n		<tr>\r\n			<td colspan="1" rowspan="1">530Le 里程升级版 先锋版</td>\r\n			<td colspan="1" rowspan="1">53.69</td>\r\n		</tr>\r\n	</tbody>\r\n</table>\r\n\r\n<p><a href="https://car.autohome.com.cn/photo/42356/1/5199212.html" target="_blank"><img alt="华晨宝马 宝马5系新能源 2020款 530Le 豪华套装" src="https://www3.autoimg.cn/cardfs/product/g30/M04/C5/5F/744x0_1_autohomecar__ChsEf12tuxaAH6TrAAkT6LZ-wGo238.jpg" style="width:744px" /></a></p>\r\n\r\n<p><a href="https://car.autohome.com.cn/photo/42356/1/5199208.html" target="_blank"><img alt="华晨宝马 宝马5系新能源 2020款 530Le 豪华套装" src="https://www3.autoimg.cn/cardfs/product/g30/M0A/C5/5C/744x0_1_autohomecar__ChsEf12tuwmAbLNFAAmLjBH99KM614.jpg" style="width:744px" /></a></p>\r\n', '2020-02-12 13:08:04'),
(7, '续航里程达400km 奔驰EQA将于秋季上市', '<p>[汽车之家&nbsp;<a href="https://www.autohome.com.cn/news/" target="_blank">新闻</a>]&nbsp; 日前，我们从戴姆勒集团2019年业绩财报中看到，<strong>奔驰EQA将于2020年秋季上市</strong>。与此同时，全新<a href="https://www.autohome.com.cn/59/" target="_blank">奔驰S级</a>(<a href="https://car.autohome.com.cn/config/series/59.html" target="_blank">参数</a>|<a href="https://leads.autohome.com.cn/landingpage/views/pc/pcInquiry/id_10001344/channelid_29/?seriesid=59&amp;eid=1|1|37|3|203736|302100" target="_blank">询价</a>)、奔驰EQV以及多款插电式混合动力车型和搭载48V车型在2020年内推出。值得一提的是，梅赛德斯-奔驰计划将在2020年总销量中将插电式混合动力车型和纯电动车型的销量占比提升三倍。</p>\r\n\r\n<p><a href="https://www.autohome.com.cn/img/?img=newsdfs/g28/M01/34/85/autohomecar__ChsEnl3LbGKADA-SAAFW2aCg_40726.jpg" target="_blank"><img alt="汽车之家" src="https://www2.autoimg.cn/newsdfs/g28/M01/34/85/744x0_0_autohomecar__ChsEnl3LbGKADA-SAAFW2aCg_40726.jpg" style="width:744px" /></a></p>\r\n\r\n<p><a href="https://www.autohome.com.cn/img/?img=newsdfs/g1/M03/55/88/autohomecar__ChsEmV3LbGOAAbtsAAHGoJFY8P0779.jpg" target="_blank"><img alt="汽车之家" src="https://www2.autoimg.cn/newsdfs/g1/M03/55/88/744x0_0_autohomecar__ChsEmV3LbGOAAbtsAAHGoJFY8P0779.jpg" style="width:744px" /></a></p>\r\n\r\n<p>『奔驰EQA量产版谍照』</p>\r\n\r\n<p>　　结合此前谍照来看，奔驰EQA整体造型汲取了现款奔驰GLA设计风格，但在有些细节方面有所不同。具体来看，该车采用了封闭式前格栅以及奔驰EQ系列风格的前后大灯组，进一步加强该车身份。</p>\r\n', '2020-02-12 13:08:28'),
(8, '电池供货短缺 捷豹I-PACE等车面临停产', '<p>[汽车之家&nbsp;<a href="https://www.autohome.com.cn/hangye/" target="_blank">行业</a>]&nbsp; 汽车零部件之于整车，往往具有&ldquo;牵一发而动全身&rdquo;的影响。日前，由于LG化学方面电池供货不足，<a href="https://www.autohome.com.cn/4251/" target="_blank">捷豹I-PACE</a>(<a href="https://car.autohome.com.cn/config/series/4251.html" target="_blank">参数</a>|<a href="https://leads.autohome.com.cn/landingpage/views/pc/pcInquiry/id_10001344/channelid_29/?seriesid=4251&amp;eid=1|1|37|3|203736|302100" target="_blank">询价</a>)将要关停相关生产线，停产时间从2月17日开始，持续一周。</p>\r\n\r\n<p><a href="https://car.autohome.com.cn/photo/33684/1/4443139.html" target="_blank"><img alt="捷豹 捷豹I-PACE 2018款 EV400 首发限量版" src="https://www2.autoimg.cn/cardfs/product/g29/M01/83/BF/744x0_1_autohomecar__wKgHG1ttV-OANS7wAAtdPe5_WQs559.jpg" style="width:744px" /></a></p>\r\n\r\n<p>『捷豹I-PACE』</p>\r\n\r\n<p>　　据悉，捷豹并非是首家遭遇LG化学供货问题的车企，奥迪和戴姆勒集团也分别削减了奥迪e-tron和奔驰EQC车型的产量目标。此前，捷豹一直在努力提升电池产能，公司于2018年与三星SDI签订了电池合同，但旗下的捷豹I-PACE车型仍在使用LG化学供应的电池零部件。</p>\r\n\r\n<p>　　一直以来，LG化学都在考虑采取各种方案来扩大在欧洲的电动车电池业务。2018年初，LG化学在波兰弗罗茨瓦夫建立了一家电池工厂，并投资5.77亿美元将工厂电池年产量提升至70GWh，预计每年可为30万辆电动车提供电池零部件。现在看来，这样的产能依然不能满足各大车企的需求。根据德国《经理人》杂志报道，由于LG化学电池供应不足，奔驰已将旗下EQC车型的生产目标从6万辆削减至3万辆。此外，由于LG化学弗罗茨瓦夫工厂的质量控制问题，奥迪e-tron也因此延迟了投产时间。</p>\r\n\r\n<p><a href="https://car.autohome.com.cn/photo/38829/1/5170532.html" target="_blank"><img alt="奥迪(进口) 奥迪e-tron 2019款 55 quattro 专享型" src="https://www3.autoimg.cn/cardfs/product/g1/M02/AA/6B/744x0_1_autohomecar__ChsEj12fFs6AO8gpAA9J0DXlzJQ709.jpg" style="width:744px" /></a></p>\r\n\r\n<p>『奥迪e-tron』</p>\r\n', '2020-02-12 13:08:53'),
(9, '预见2020 | 新能源市场需求如何变化？', '<p>[汽车之家&nbsp;<a href="https://www.autohome.com.cn/30901/0/1/conjunction.html#pvareaid=3311698" target="_blank">深评</a>]&nbsp; 2020开年，车企、经销商一致的动作，是推出直播卖车、盲购等线上卖车举措，搭配送门上车、预约上门试驾等，积极应对新冠肺炎带来的门市萧条。而新能源汽车在增长九年之后，2019年销量第一次下降，短期压力叠加宏观环境的不利因素，2020年依旧挑战重重。我们分析了当前的新能源乘用车需求和供给，向新能源汽车企业建议谏言，期盼阅者有所收获。</p>\r\n\r\n<p><a href="https://www.autohome.com.cn/img/?img=newsdfs/g26/M00/A8/28/autohomecar__ChcCP15Cx8CAF4h0AAUrhYCXURk522.jpg" target="_blank"><img alt="汽车之家" src="https://www2.autoimg.cn/newsdfs/g26/M00/A8/28/744x0_0_autohomecar__ChcCP15Cx8CAF4h0AAUrhYCXURk522.jpg" style="width:744px" /></a></p>\r\n\r\n<hr />\r\n<p><strong>●《深评问道》是什么？</strong></p>\r\n\r\n<p>　　《深评问道》是汽车之家首个面向行业端用户打造的栏目，特约汽车行业资深从业者执笔，独家解析／揭秘行业大事件。除了热闹表象，我们更想向您呈现对事物本质、因果以及未来可能性的探究和思考。</p>\r\n\r\n<hr />\r\n<p>&nbsp;</p>\r\n\r\n<p>　　<strong>本期行业评论员</strong>&mdash;&mdash;邱锴俊，《电动汽车观察家》创始人，总编辑。新能源汽车界意见领袖，曾担任新能源汽车垂直媒体第一电动网主编、CEO，从2013年开始报道研究新能源汽车。拥有十余年的媒体内容生产运营经营经验，曾任职北京日报、《财经》杂志、财新传媒等知名媒体。</p>\r\n', '2020-02-12 13:09:17'),
(11, '奔驰V260L改装隐藏六座厂家年底大酬宾', '<p>19款奔驰<a href="http://auto.chexun.com/vito/" target="_blank">威霆</a>7座商务车新一代18款<a href="http://auto.chexun.com/brand_benz/" target="_blank">奔驰</a>威霆在外型、气质方面的深层次蜕变，相信大家都是有目共睹的，首开先河将<a href="http://car.chexun.com/car/result-a0-b1111-c0-d0-e0-f0-g0-s0.html" target="_blank">轿车</a>化运动前脸元素与<a href="http://auto.chexun.com/level/#level_6" target="_blank">MPV</a>的沉稳外形相融合，三段镀铬条拱卫硕大的三叉星辉标识，品牌层次感以及灵动性彰显无疑，延伸至两侧的大曲面楔形鹰眼造型大灯，也是极具视觉冲击性，加之更立体的引擎盖以及富有张力的前保险杠设计，构筑了19款奔驰威霆新生代的高颜值。</p>\r\n\r\n<p><img alt="奔驰V260L改装隐藏六座厂家年底大酬宾  " src="http://i0.chexun.net/images/2020/0215/37661/news_default_912A3E2F46D152AD3B24CC85DA9BB66F.jpg" style="width:683px" /></p>\r\n\r\n<p>　　奔驰V级商务现车充足<a href="http://car.chexun.com/price/" target="_blank">&nbsp;价格</a>优惠多 详情咨询文章底部<a href="http://www.chexun.com/gouche/" target="_blank">购车</a>电话</p>\r\n\r\n<p><img alt="奔驰V260L改装隐藏六座厂家年底大酬宾  " src="http://i1.chexun.net/images/2020/0215/37661/news_default_B041C11C18026736DB55BC197E7E7B94.jpg" style="width:555px" /></p>\r\n\r\n<p><img alt="奔驰V260L改装隐藏六座厂家年底大酬宾  " src="http://i2.chexun.net/images/2020/0215/37661/news_default_75A2680173275BB95BBADA55DBBCE39A.jpg" style="width:555px" /></p>\r\n\r\n<p><img alt="奔驰V260L改装隐藏六座厂家年底大酬宾  " src="http://i3.chexun.net/images/2020/0215/37661/news_default_02C3906EECCF40CF995677F6BA7A9D57.jpg" style="width:555px" /></p>\r\n\r\n<p><img alt="奔驰V260L改装隐藏六座厂家年底大酬宾  " src="http://i2.chexun.net/images/2020/0215/37661/news_default_D1F9ED583BDA8E14E80CF3F1A9AF57AA.jpg" style="width:555px" /></p>\r\n', '2020-02-16 00:08:03'),
(12, '2020年1月MPV销量排行，自主下滑明', '<p>本篇文章我们来分析一下，2020年1月中国市场<a href="http://auto.chexun.com/level/#level_6" target="_blank">MPV</a>的销量排行榜，1月份MPV销量为9.9万辆，同比下滑34.6%。其中曾经比较热销的<a href="http://car.chexun.com/" target="_blank">车型</a>，包括<a href="http://auto.chexun.com/wlhg/" target="_blank">五菱宏光</a>，<a href="http://auto.chexun.com/brand_baojun/" target="_blank">宝骏</a>730，宝骏360等等非常多的MPV销量都出现了明显的下滑。</p>\r\n\r\n<p><img alt="2020年1月MPV销量排行，自主下滑明显，谁来挑战GL8？" src="http://i2.chexun.net/images/2020/0215/37664/news_default_F498CA830D74630F80AC2AF856FD0042.jpg" /></p>\r\n\r\n<p>&nbsp;</p>\r\n\r\n<p>&nbsp;</p>\r\n\r\n<p>我们首先看一下销量第一的五菱宏光，1月份的销量为29,998辆，同比下滑了38.9%，去年同期的销量是4.9万辆。而今年的销量下滑是比较明显的。除此之外，宝骏360的销量下滑也很明显，销量下滑了66%只有4729辆。此外宝骏730的销量下滑也很明显，下滑了46%销量只有7557辆。</p>\r\n\r\n<p><img alt="2020年1月MPV销量排行，自主下滑明显，谁来挑战GL8？" src="http://i2.chexun.net/images/2020/0215/37664/news_default_B1EFCFC36EE2569DC6BD461F35772BB5.jpg" /></p>\r\n\r\n<p>&nbsp;</p>\r\n\r\n<p>&nbsp;</p>\r\n\r\n<p>其实我们可以简单的看一下这些10万元以下，特别是五六万元的国产MPV车型。曾经凭借着超高的性价比，宽大的空间，迅速占领了三四线城市和农村市场。这些MPV车型载人拉货都可以，实用性很强。</p>\r\n\r\n<p>不过随着这一市场逐渐饱和，消费者在进行换购升级的时候，往往不会再选择五菱宏光，宝骏730，而是会选择更高一级别的MPV或者是<a href="http://car.chexun.com/car/result-a0-b1111-c0-d0-e0-f0-g0-s0.html" target="_blank">轿车</a>，或者是<a href="http://www.chexun.com/suv/" target="_blank">SUV</a>。</p>\r\n\r\n<p>因此我认为市场的饱和消费升级是导致自主品牌MPV销量出现下滑的最重要原因。</p>\r\n', '2020-02-16 00:08:52');

-- --------------------------------------------------------

--
-- 表的结构 `cart`
--
-- 创建时间： 2020-02-15 15:19:02
--

CREATE TABLE IF NOT EXISTS `cart` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `userid` int(11) DEFAULT NULL,
  `vin` varchar(17) DEFAULT NULL,
  `pinpai` varchar(10) DEFAULT NULL,
  `color` varchar(10) DEFAULT NULL,
  `chepaihao` varchar(20) DEFAULT NULL,
  `chexing` varchar(20) DEFAULT NULL,
  `pic` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=16 ;

--
-- 转存表中的数据 `cart`
--

INSERT INTO `cart` (`id`, `userid`, `vin`, `pinpai`, `color`, `chepaihao`, `chexing`, `pic`) VALUES
(1, 14, 'LBV8W3102JMM51200', '宝马', '灰色', '京A88888', '小型车', 'd104e5d6c07a40acbaa1bfa2a352c2cf.jpg'),
(2, 2, 'LBV8W3102JMM51200', '宝马', '灰色', '京B88888', '小型车', 'ceec537e16874e69bc40bea787bf6b2d.jpg'),
(3, 7, 'LBV8W3102JMM51200', '宝马', '灰色', '京C88888', '小型车', 'ceec537e16874e69bc40bea787bf6b2d.jpg'),
(4, 5, 'LBV8W3102JMM51200', '宝马', '灰色', '京D88888', '小型车', 'ceec537e16874e69bc40bea787bf6b2d.jpg'),
(5, 6, 'LBV8W3102JMM51200', '宝马', '灰色', '京E88888', '小型车', 'ceec537e16874e69bc40bea787bf6b2d.jpg'),
(6, 4, 'LBV8W3102JMM51200', '宝马', '灰色', '京F88888', '小型车', 'ceec537e16874e69bc40bea787bf6b2d.jpg'),
(7, 10, 'LBV8W3102JMM51200', '宝马', '灰色', '京G88888', '小型车', 'ceec537e16874e69bc40bea787bf6b2d.jpg'),
(8, 3, 'LBV8W3102JMM51200', '宝马', '灰色', '京H88888', '小型车', 'ceec537e16874e69bc40bea787bf6b2d.jpg'),
(9, 9, 'LBV8W3102JMM51200', '宝马', '灰色', '京I88888', '小型车', 'ceec537e16874e69bc40bea787bf6b2d.jpg'),
(10, 8, 'LBV8W3102JMM51200', '宝马', '灰色', '京J88888', '小型车', 'ceec537e16874e69bc40bea787bf6b2d.jpg'),
(11, 11, 'LBV8W3102JMM51200', '宝马', '灰色', '京K88888', '小型车', 'ceec537e16874e69bc40bea787bf6b2d.jpg'),
(12, 12, 'LBV8W3102JMM51200', '宝马', '灰色', '京L88888', '小型车', 'ceec537e16874e69bc40bea787bf6b2d.jpg'),
(14, 13, 'LBV8W3102JMM51200', '宝马', '灰色', '京N88888', '小型车', 'ceec537e16874e69bc40bea787bf6b2d.jpg'),
(15, 2, 'LBV8W3102JMM51209', '奔驰', '白色', '粤B88888', '小型车', '0a0afd6586234a578b2b851bced8364e.jpg');

-- --------------------------------------------------------

--
-- 表的结构 `huifu`
--
-- 创建时间： 2020-02-16 10:52:41
--

CREATE TABLE IF NOT EXISTS `huifu` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `userid` int(11) DEFAULT NULL,
  `liuyanid` int(11) DEFAULT NULL,
  `totitle` varchar(30) DEFAULT NULL,
  `content` varchar(255) DEFAULT NULL,
  `createat` datetime DEFAULT NULL,
  `status` int(2) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=6 ;

--
-- 转存表中的数据 `huifu`
--

INSERT INTO `huifu` (`id`, `userid`, `liuyanid`, `totitle`, `content`, `createat`, `status`) VALUES
(1, 9, 31, '汽车排气管冒蓝烟。', '1、使用不合格的机油,或者机油长时间没有更换,原因就是机油过稀,燃烧不充分; 解决方法:更换合格的机油。', '2020-02-17 13:35:18', 1),
(2, 3, 26, '汽车排气管冒蓝烟。', '1、使用不合格的机油,或者机油长时间没有更换,原因就是机油过稀,燃烧不充分; 解决方法:更换合格的机油。', '2020-02-17 13:37:44', 1),
(3, 1, 32, '测试', '测试成功哦。', '2020-02-17 17:50:50', 1),
(4, 1, 33, '再测试一下。', '再回复一下，哈哈。', '2020-02-17 17:55:25', 1),
(5, 1, 34, '哇塞', '好棒。', '2020-02-17 17:56:54', 1);

-- --------------------------------------------------------

--
-- 表的结构 `liuyan`
--
-- 创建时间： 2020-02-16 04:31:33
--

CREATE TABLE IF NOT EXISTS `liuyan` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `userid` int(11) DEFAULT NULL,
  `title` varchar(30) DEFAULT NULL,
  `content` varchar(255) DEFAULT NULL,
  `createat` datetime DEFAULT NULL,
  `status` int(2) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=35 ;

--
-- 转存表中的数据 `liuyan`
--

INSERT INTO `liuyan` (`id`, `userid`, `title`, `content`, `createat`, `status`) VALUES
(18, 2, '汽车排气管冒蓝烟。', '车尾部排气下车管排出的烟是蓝烟,味道还挺好闻的,很多不能理解车为什么会冒蓝烟', '2019-12-20 02:33:43', 1),
(19, 2, '汽车排气管冒蓝烟。', '车尾部排气下车管排出的烟是蓝烟,味道还挺好闻的,很多不能理解车为什么会冒蓝烟', '2019-12-20 02:36:39', 1),
(20, 1, '汽车排气管冒蓝烟。', '车尾部排气下车管排出的烟是蓝烟,味道还挺好闻的,很多不能理解车为什么会冒蓝烟', '2019-12-20 13:20:54', 1),
(21, 4, '汽车排气管冒蓝烟。', '车尾部排气下车管排出的烟是蓝烟,味道还挺好闻的,很多不能理解车为什么会冒蓝烟', '2019-12-20 14:06:15', 1),
(22, 4, '汽车排气管冒蓝烟。', '车尾部排气下车管排出的烟是蓝烟,味道还挺好闻的,很多不能理解车为什么会冒蓝烟', '2019-12-20 14:06:27', 1),
(23, 13, '汽车排气管冒蓝烟。', '车尾部排气下车管排出的烟是蓝烟,味道还挺好闻的,很多不能理解车为什么会冒蓝烟', '2019-12-20 14:09:20', 1),
(24, 13, '汽车排气管冒蓝烟。', '车尾部排气下车管排出的烟是蓝烟,味道还挺好闻的,很多不能理解车为什么会冒蓝烟', '2019-12-20 14:09:38', 1),
(25, 2, '汽车排气管冒蓝烟。', '车尾部排气下车管排出的烟是蓝烟,味道还挺好闻的,很多不能理解车为什么会冒蓝烟', '2020-02-09 16:56:53', 1),
(26, 3, '汽车排气管冒蓝烟。', '车尾部排气下车管排出的烟是蓝烟,味道还挺好闻的,很多不能理解车为什么会冒蓝烟', '2020-02-16 14:14:21', 0),
(27, 4, '汽车排气管冒蓝烟。', '车尾部排气下车管排出的烟是蓝烟,味道还挺好闻的,很多不能理解车为什么会冒蓝烟', '2020-02-16 14:15:22', 1),
(28, 6, '汽车排气管冒蓝烟。', '车尾部排气下车管排出的烟是蓝烟,味道还挺好闻的,很多不能理解车为什么会冒蓝烟', '2020-02-16 14:15:24', 1),
(29, 8, '汽车排气管冒蓝烟。', '车尾部排气下车管排出的烟是蓝烟,味道还挺好闻的,很多不能理解车为什么会冒蓝烟', '2020-02-16 14:15:27', 1),
(30, 5, '汽车排气管冒蓝烟。', '车尾部排气下车管排出的烟是蓝烟,味道还挺好闻的,很多不能理解车为什么会冒蓝烟', '2020-02-16 14:15:29', 1),
(31, 9, '汽车排气管冒蓝烟。', '车尾部排气下车管排出的烟是蓝烟,味道还挺好闻的,很多不能理解车为什么会冒蓝烟', '2020-02-16 14:15:32', 0),
(32, 1, '测试', '测试一下。', '2020-02-17 17:46:12', 0),
(33, 1, '再测试一下。', '再测试一下，哈哈。', '2020-02-17 17:55:07', 0),
(34, 1, '哇塞', '留言功能找好了。', '2020-02-17 17:56:30', 0);

-- --------------------------------------------------------

--
-- 表的结构 `marks`
--
-- 创建时间： 2020-02-15 16:23:50
--

CREATE TABLE IF NOT EXISTS `marks` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `userid` int(11) DEFAULT NULL,
  `chepaihao` varchar(20) DEFAULT NULL,
  `price` int(11) DEFAULT NULL,
  `vin` varchar(20) DEFAULT NULL,
  `title` varchar(30) DEFAULT NULL,
  `createat` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=13 ;

--
-- 转存表中的数据 `marks`
--

INSERT INTO `marks` (`id`, `userid`, `chepaihao`, `price`, `vin`, `title`, `createat`) VALUES
(1, 13, '粤A88888', 2500, 'LBV8W3102JMM51200', '洗车、上外油、打蜡等一条龙', '2020-02-12 17:51:06'),
(2, 13, '粤B88888', 1000, 'LBV8W3102JMM51200', '机修，修理汽车的各类机械故障', '2020-02-12 17:57:44'),
(3, 13, '粤C88888', 2000, 'LBV8W3102JMM51200', '自动变速箱清洗换油机', '2020-02-12 17:57:59'),
(4, 1, '粤D88888', 3000, 'LBV8W3102JMM51200', '洗车、上外油、打蜡等一条龙', '2020-02-12 18:05:58'),
(5, 1, '粤E88888', 2000, 'LBV8W3102JMM51200', '自动变速箱清洗换油机', '2020-02-13 01:48:06'),
(6, 6, '粤BCCCCC', 2500, 'LBV8W3102JMM51200', '洗车、上外油、打蜡、加油', '2020-02-16 01:13:01'),
(7, 1, '粤BCCCCC', 2500, 'LBV8W3102JMM51200', '洗车、上外油、打蜡等一条龙', '2020-02-16 01:16:08'),
(8, 1, '粤BCCCCC', 2500, 'LBV8W3102JMM51200', '洗车、上外油、打蜡等一条龙', '2020-02-16 01:16:12'),
(9, 1, '粤BCCCCC', 2500, 'LBV8W3102JMM51200', '洗车、上外油、打蜡等一条龙', '2020-02-16 01:16:14'),
(10, 1, '粤BCCCCC', 2500, 'LBV8W3102JMM51200', '洗车、上外油、打蜡等一条龙', '2020-02-16 01:16:18'),
(11, 1, '粤BCCCCC', 2500, 'LBV8W3102JMM51200', '洗车、上外油、打蜡等一条龙', '2020-02-16 01:16:20'),
(12, 1, '粤BCCCCC', 2500, 'LBV8W3102JMM51200', '洗车、上外油、打蜡等一条龙', '2020-02-16 01:16:25');

-- --------------------------------------------------------

--
-- 表的结构 `user`
--
-- 创建时间： 2020-02-15 13:21:48
--

CREATE TABLE IF NOT EXISTS `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `truename` varchar(20) DEFAULT NULL,
  `phone` varchar(11) DEFAULT NULL,
  `password` varchar(20) DEFAULT NULL,
  `beizhu` varchar(30) DEFAULT NULL,
  `status` int(2) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=15 ;

--
-- 转存表中的数据 `user`
--

INSERT INTO `user` (`id`, `truename`, `phone`, `password`, `beizhu`, `status`) VALUES
(1, '李白', '15012345678', '123456', '无', 1),
(2, '貂蝉', '17802939090', '87654321', '离间计高手', 1),
(3, '吕布', '18238271891', '1234567', '无双', 1),
(4, '诸葛亮', '17878828828', '88888888', '八卦阵', 1),
(5, '郦瑜然', '17827381123', '111222333', '无', 1),
(6, '桓访儿', '12323231231', '12341234', '无', 1),
(7, '古悦媛', '18989299271', '888888', '无', 1),
(8, '武谷芹', '19283982323', '666666', '无', 0),
(9, '言凝云', '18727361726', '666123666', '无', 0),
(10, '孟冷荷', '17627367231', '888888', '无', 0),
(11, '栾千风', '19899988213', '898989', '哇塞', 1),
(12, '楚芃芃', '17676254243', '444123444', '玛莎拉蒂', 1),
(13, '陈琳', '18996254299', '44412344', '宝马', 1),
(14, '楚云', '15213254298', '444123444', '玛莎拉蒂', 1);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

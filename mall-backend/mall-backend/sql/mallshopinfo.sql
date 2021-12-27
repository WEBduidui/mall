/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 50723
 Source Host           : localhost:3306
 Source Schema         : mallshopinfo

 Target Server Type    : MySQL
 Target Server Version : 50723
 File Encoding         : 65001

 Date: 26/12/2021 14:19:18
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for address_info
-- ----------------------------
DROP TABLE IF EXISTS `address_info`;
CREATE TABLE `address_info`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `user_id` int(11) NULL DEFAULT NULL COMMENT '用户id',
  `name` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '联系人姓名',
  `phone` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '联系人电话',
  `mobile` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '联系人手机',
  `prov` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '省份',
  `city` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '城市',
  `area` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '区县',
  `address` varchar(150) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '详细地址',
  `is_default` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '是否默认',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  `ext1` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '扩展字段',
  `ext2` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '扩展字段',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 9 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '客户地址信息' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of address_info
-- ----------------------------
INSERT INTO `address_info` VALUES (1, 1, '胡小姐', '18878687868', '18878687868', '广东省', '深圳市', '福田区', '大中华国际交易广场', '0', '2021-12-20 03:12:15', '2021-12-20 03:12:15', NULL, NULL);
INSERT INTO `address_info` VALUES (7, 5, '李先生', '18688888888', '', '山西省', '长治市', '上党区', '阳泉一中', '0', '2021-12-25 23:01:35', '2021-12-25 23:01:35', '', '');
INSERT INTO `address_info` VALUES (8, 5, '赵先生', '18678689868', '', '', '', '', '北京市天哪一天', '1', '2021-12-25 23:41:41', '2021-12-25 23:41:41', '', '');

-- ----------------------------
-- Table structure for admin
-- ----------------------------
DROP TABLE IF EXISTS `admin`;
CREATE TABLE `admin`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `name` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '姓名',
  `username` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '用户名',
  `password` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '密码',
  `email` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '邮箱',
  `phone` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '手机号',
  `role` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '用户角色',
  `in_use` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '是否启用',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  `ext1` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '扩展字段',
  `ext2` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '扩展字段',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '管理员' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of admin
-- ----------------------------
INSERT INTO `admin` VALUES (1, 'admin', 'admin', '$2a$10$Bn242nGNR1IloNFEnRC0o.MV0sLq9Gin8lcPAYCqOhoWDwp2TutPm', '4897879879@qq.com', 'admin', '2', '1', '2021-12-20 03:12:15', '2021-12-20 03:12:15', NULL, NULL);

-- ----------------------------
-- Table structure for agreement
-- ----------------------------
DROP TABLE IF EXISTS `agreement`;
CREATE TABLE `agreement`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `content` text CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL COMMENT '协议内容',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  `ext1` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '扩展字段',
  `ext2` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '扩展字段',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '协议' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of agreement
-- ----------------------------
INSERT INTO `agreement` VALUES (1, '  <div style=\"justify-content: center;display: flex;\">\r\n                <h2>用户注册协议</h2>\r\n            </div>\r\n            <br />\r\n            <h3>一、注册协议条款的确认和接受</h3>\r\n            <p>文都/文都网(以下亦称&ldquo;本网站&rdquo;)同意按照本协议的规定及其不定时发布的操作规则提供基于互联网和移动互联网的相关服务(以下称&ldquo;网络服务&rdquo;)。</p>\r\n            <p>为获得网络服务, 申请人应当认真阅读、充分理解本《协议》中各条款, 包括免除或者限制文都责任的免责条款及对用户的权利限制条款。审慎阅读并选择接受或不接受本《协议》(未成年人应在法定监护人陪同下阅读)。</p>\r\n            <p>同意接受本协议的全部条款的, 申请人应当按照页面上的提示完成全部的注册程序, 并在注册程序过程中点击&ldquo;同意&rdquo;按钮, 否则视为不接受本《协议》全部条款, 申请人应当终止并退出申请。</p>\r\n            <p>本《协议》可由文都定期更新, 更新后的协议条款一旦公布即代替原来的协议条款, 恕不再另行通知, 用户可在文都查阅最新版协议条款。在文都修改《协议》条款后, 如果用户不接受修改后的条款, 请立即停止使用文都提供的网络服务, 继续使用的用户将被视为已接受了修改后的协议。</p>\r\n            <h3>二、服务内容</h3>\r\n            <p>1、网络服务的具体内容由文都根据实际情况提供, 包括学习资讯、学习工具、文都社群、文都问答、SIS在线测评、文都直播、文都网校、文都中小学、文都国际教育、文都考研集训营、泉题库及其旗下APP相关应用等服务。</p>\r\n            <p>2、文都提供的网络服务包括收费和免费。收费服务包括但不限于文都网、文都网校和APP的部分收费课程, 用户使用收费网络服务需要支付约定费用。对于收费服务, 文都会在用户使用之前给予用户明确的提示, 只有用户根据提示确认同意支付相关费用, 用户才能使用该等收费服务。如用户未支付相关费用, 则文都有权不向用户提供该等收费服务。</p>\r\n            <p>3、用户理解, 文都仅提供文都明确承诺的网络服务, 除此之外与相关网络服务有关的设备(如个人电脑、手机、及其他与接入互联网或移动网有关的装置)及所需的费用(如为接入互联网而支付的电话费及上网费、为使用移动网络而支付的手机费)均应由用户自行负担。</p>\r\n            <p>4、用户理解，文都网/文都网校/文都直播平台提供并提请用户在购买课程前先完整试听。用户可按《文都网校退班政策说明》，在从购买课程之日起7天之内且未产生听课记录（不含试听）的，可无理由退班。除特别说明外，包括但不限于PC端和移动端下载课件在内的所有服务均附期限，到期终止。用户应在截止日期前享受其购买的服务。</p>\r\n            <h3>三、用户帐号</h3>\r\n            <p>1、经文都注册系统完成注册程序并通过身份认证的用户即为正式用户。</p>\r\n            <p>2、如发现用户帐号中含有不雅文字或不恰当名称的, 文都保留注销其用户帐号的权利。</p>\r\n            <p>3、用户帐号的所有权归文都, 用户完成申请注册手续后, 用户享有使用权。3个月未使用的用户账号, 文都保留收回的权利。</p>\r\n            <p>4、用户有义务保证密码和帐号的安全, 用户利用该帐号所进行的一切活动引起的任何损失或损害, 由用户自行承担全部责任, 文都不承担任何责任。如用户发现帐号遭到未授权的使用或发生其他任何安全问题, 应立即修改账号密码并妥善保管。因黑客行为或用户的保管疏忽导致帐号非法使用, 文都不承担任何责任。</p>\r\n            <p><strong>5、用户帐号和密码仅由初始申请注册人使用，用户不得将自己用户账户或密码有偿或无偿以转让、出借、授权等方式提供给第三人操作和使用, 否则用户应当自行承担因违反此要求而遭致的任何损失。违反本项约定的，文都并保留收回账号的权利。若因违反本约定对他人造成损害的，用户应与实际使用人承担连带赔偿责任，同时文都保留追究用户违约责任的权利。</strong></p>\r\n            <p>6、用户帐号在丢失、遗忘密码及因合用产生使用权归属纠纷后, 须遵照文都的申诉途径请求找回帐号。用户可以凭初始注册资料向文都申请找回帐号。文都的账户恢复机制仅负责识别申请用户所提资料与系统记录资料是否一致, 而无法识别申诉人是否系帐号的真正使用权人。对用户因被他人冒名申请而致的任何损失, 文都不承担任何责任, 用户知晓帐号及密码保管责任在于用户, 文都并不承诺帐号丢失或遗忘密码后用户一定能通过申诉找回帐号。用户应当谨慎填写初始手机号或注册邮箱作为确认接收争议帐号的指定邮箱。</p>\r\n            <p>7、文都建议用户应当使用本人名义为用户账户充值或行使付款行为。若用户存在使用第三人的名义进行充值或付款，或委托第三人代为充值或付款之行为的，则以上行为被视作本人的行为，若由于该第三人行为导致充值或付款行为失败或成功后又被撤销的，均被认为是用户本人真实意思的表示和用户本人实施的行为，由此所造成的一切法律后果均由用户自行承担。</p>\r\n            <h3>四、使用规则</h3>\r\n            <p>1、用户在使用文都网络服务过程中, 必须遵循国家的相关法律法规, 不得发布危害国家安全、色情、暴力、侵犯版权等任何合法权利等非法内容; 也不得利用文都平台发布含有虚假、有害、胁迫、侵害他人隐私、骚扰、侵害、中伤、粗俗、或其它道德上令人反感的内容。</p>\r\n            <p>2、文都可依其合理判断, 对违反有关法律法规或本协议约定; 或侵犯、妨害、威胁任何人权利或安全的内容, 或者假冒他人的行为, 文都有权停止传输任何前述内容, 并有权依其自行判断对违反本条款的任何用户采取适当的法律行动, 包括但不限于, 删除具有违法性、侵权性、不当性等内容, 阻止其使用文都全部或部分网络服务, 并且依据法律法规保存有关信息并向有关部门报告等。</p>\r\n            <p>3、对于经由文都网络服务而传送的内容, 文都不保证前述内容的正确性、完整性或品质。用户在接受本服务时, 有可能会接触到令人不快、不适当或令人厌恶的内容。在任何情况下, 文都均不对任何内容负责, 包括但不限于任何内容发生任何错误或纰漏以及衍生的任何损失或损害。文都有权(但无义务)自行拒绝或删除经由文都网络服务提供的任何内容。用户使用上述内容, 应自行承担风险。</p>\r\n            <p>4、对于用户通过文都网络服务(包括但不限于文都网、文都社群、文都中小学、文都国际教育、文都网校、泉题库、SIS在线测评及对应APP、相关应用等服务)上传到文都上可公开获取区域的任何内容, 用户同意文都在全世界范围内具有免费的、永久性的、不可撤销的、非独家的和完全再许可的权利和许可, 以使用、复制、修改、改编、出版、翻译、据以创作衍生作品、传播、表演和展示此等内容(整体或部分), 和/或将此等内容编入当前已知的或以后开发的其他任何形式的作品、媒体或技术中。</p>\r\n            <p>5、用户通过文都网络服务所发布的任何内容并不反映文都的观点或政策, 文都对此不承担任何责任。用户须对上述内容的真实性、合法性、无害性、有效性等全权负责, 与用户所发布信息相关的任何法律责任由用户自行承担, 与文都无关。</p>\r\n            <h3>五、版权声明</h3>\r\n            <p>文都提供的网络服务中包含的任何文本、图片、图形、音频和/或视频资料均受版权、商标和/或其它财产所有权法律的保护, 未经相关权利人同意, 上述资料均不得在任何媒体直接或间接发布、播放、出于播放或发布目的而改写或再发行, 或者被用于其他任何商业目的。所有以上资料或资料的任何部分仅可作为私人和非商业用途保存。文都不就由上述资料产生或在传送或递交全部或部分上述资料过程中产生的延误、不准确、错误和遗漏或从中产生或由此产生的任何损害赔偿, 以任何形式, 向用户或任何第三方负责。</p>\r\n            <h3>六、隐私保护</h3>\r\n            <p>1、保护用户隐私是文都的一项基本政策, 文都保证不对外公开或向第三方提供用户的注册资料及用户在使用网络服务时存储在文都内的非公开内容, 但下列情况除外:</p>\r\n            <p>（1）事先获得用户的书面明确授权;</p>\r\n            <p>（2）根据有关的法律法规要求;</p>\r\n            <p>（3）按照相关政府主管部门的要求;</p>\r\n            <p>（4）为维护社会公众的利益;</p>\r\n            <p>（5）为维护文都的合法权益;</p>\r\n            <p>2、为了更好地为用户提供全面服务，用户同意文都可将用户注册资料及使用信息提供文都关联公司使用。文都保证前述关联公司同等级地严格遵循本协议第六条第1款之隐私保护责任。</p>\r\n            <p>3、用户同意：文都或文都运营商的关联公司在必要时有权根据用户注册时或接受服务时所提供的联系信息（包括但不限于电子邮件地址、联系电话、联系地址、即时聊天工具账号等），通过电子邮件、电话、短信、邮寄、即时聊天、弹出页面等方式向用户发送如下信息：</p>\r\n            <p>（1）各类重要通知信息，可能包括但不限于订单、交易单、修改密码提示等重要信息。此类信息可能对用户的权利义务产生重大的有利或不利影响，用户务必及时关注。</p>\r\n            <p>（2）商品和服务广告、促销优惠等商业性信息。若用户不愿意接收此类信息，则可通过告知（口头或书面）的方式通知文都或文都运营商的关联公司取消发送，亦可通过文都或文都运营商关联公司所提供的相应退订功能（若有）进行退订。</p>\r\n            <h3>七、协议的用途、更新和效力</h3>\r\n            <p>1、本协议之服务条款用以规范用户使用文都提供的服务,本协议与文都社区行为准则构成完整的协议。</p>\r\n            <p>2、鉴于国家法律法规不时变化及文都运营之需要，文都有权对本协议条款不时地进行修改，修改后的协议一旦被公布于文都上即告生效，并替代原来的协议。 用户有义务不时关注并阅读最新版的协议及网站公告。如用户不同意更新后的协议，则应立即停止接受文都依据本协议提供的服务；若用户继续使用文都提供的服务的，即视为同意更新后的协议。 如果本协议中任何一条被视为废止、无效或因任何理由不可执行，该条应视为可分的且并不影响任何其余条款的有效性和可执行性。</p>\r\n  ', '2021-12-20 03:12:15', '2021-12-20 03:12:15', NULL, NULL);

-- ----------------------------
-- Table structure for banner
-- ----------------------------
DROP TABLE IF EXISTS `banner`;
CREATE TABLE `banner`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `img_url` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '图片地址',
  `orderNo` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '排序号',
  `ext1` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '扩展字段',
  `ext2` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '扩展字段',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '首图' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of banner
-- ----------------------------
INSERT INTO `banner` VALUES (1, 'https://kilogod.oss-cn-shenzhen.aliyuncs.com/mallshop/20211225/16404446509055098672354.zcool.cn_community_016168595f2da9a8012193a3d39f3e.jpg@1280w_1l_2o_100sh.jpg&refer=http___img.zcool.jpg', '1', NULL, NULL);
INSERT INTO `banner` VALUES (2, 'https://kilogod.oss-cn-shenzhen.aliyuncs.com/mallshop/20211225/16404446570781358242269.zcool.cn_community_01a96557a937df0000012e7ef98362.jpg@1280w_1l_2o_100sh.png&refer=http___img.zcool.jpg', '2', NULL, NULL);
INSERT INTO `banner` VALUES (3, 'https://kilogod.oss-cn-shenzhen.aliyuncs.com/mallshop/20211225/16404446614425867284481.zcool.cn_community_01ca505a387c5ca80121db80508480.jpg@1280w_1l_2o_100sh.jpg&refer=http___img.zcool.jpg', '3', NULL, NULL);
INSERT INTO `banner` VALUES (4, 'https://kilogod.oss-cn-shenzhen.aliyuncs.com/mallshop/20211225/16404446662024508875271.16pic.com_00_55_64_16pic_5564279_b.jpg&refer=http___pic3.16pic.jpg', '4', NULL, NULL);
INSERT INTO `banner` VALUES (5, 'https://kilogod.oss-cn-shenzhen.aliyuncs.com/mallshop/20211225/16404446701681739259928.jpg', '5', '', '');

-- ----------------------------
-- Table structure for collection
-- ----------------------------
DROP TABLE IF EXISTS `collection`;
CREATE TABLE `collection`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `user_id` int(11) NOT NULL COMMENT '用户id',
  `shop_id` int(11) NOT NULL COMMENT '商品id',
  `shop_name` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '商品名称',
  `image_src` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '商品图片',
  `price` decimal(10, 2) NULL DEFAULT NULL COMMENT '单价',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  `ext1` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '扩展字段',
  `ext2` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '扩展字段',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `user_id`(`user_id`, `shop_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 31 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '收藏' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of collection
-- ----------------------------
INSERT INTO `collection` VALUES (28, 5, 2, '富安娜欧式提花四件套纯棉床单涤棉被套床品奢华轻奢床上用品秋冬', 'https://kilogod.oss-cn-shenzhen.aliyuncs.com/cloudmall/20211113/16367470499096362416912.jpg_580x580Q90.jpg', 399.00, '2021-12-20 03:12:15', '2021-12-20 03:12:15', NULL, NULL);
INSERT INTO `collection` VALUES (29, 5, 16, '广西百香果新鲜包邮5斤大果黄金水果百香果浓浆果酱原浆当季整箱', 'https://kilogod.oss-cn-shenzhen.aliyuncs.com/cloudmall/20211113/16367480043465540228172.jpg_580x580Q90.jpg', 12.90, '2021-12-20 03:12:15', '2021-12-20 03:12:15', NULL, NULL);
INSERT INTO `collection` VALUES (30, 5, 1, '卡撒天娇家纺长绒棉四件套casa calvin全棉四件套高档欧式床品', 'https://kilogod.oss-cn-shenzhen.aliyuncs.com/cloudmall/20211113/16367469234411418784424.jpg_580x580Q90.jpg', 1599.00, '2021-12-26 02:05:09', '2021-12-26 02:05:09', NULL, NULL);

-- ----------------------------
-- Table structure for evaluate
-- ----------------------------
DROP TABLE IF EXISTS `evaluate`;
CREATE TABLE `evaluate`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `orderid` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '订单id',
  `userid` int(11) NULL DEFAULT NULL COMMENT '用户id',
  `username` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '用户姓名',
  `goodsid` int(11) NULL DEFAULT NULL COMMENT '商品id',
  `goodsname` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '商品名称',
  `img` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '商品图片',
  `score` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '评分',
  `content` text CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL COMMENT '评价内容',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '商品图片',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  `ext1` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '扩展字段',
  `ext2` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '扩展字段',
  `ext3` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '扩展字段',
  `ext4` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '扩展字段',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '评价' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of evaluate
-- ----------------------------
INSERT INTO `evaluate` VALUES (1, '20211225234345796', 5, '丽丽', 10, '夏春茶2021秋冬季新款POLO领条纹针织衫女设计感小众慵懒风毛衣潮', 'https://kilogod.oss-cn-shenzhen.aliyuncs.com/cloudmall/20211113/16367475097281963874203.jpg_400x400.jpg', '5', '非常好', '2021-12-26 01:59:30', '2021-12-26 01:59:30', '', '', '', '');
INSERT INTO `evaluate` VALUES (2, '20211225234205848', 5, '丽丽', 11, '英爵伦2021冬季新款毛衣男刺绣毛线衣薄款男装秋冬圆领针织打底衫', 'https://kilogod.oss-cn-shenzhen.aliyuncs.com/cloudmall/20211113/16367475688864027662702.jpg_430x430q90.jpg', '3', '还行吧', '2021-12-26 02:02:29', '2021-12-26 02:02:29', '', '', '', '');
INSERT INTO `evaluate` VALUES (3, '20211226020555754', 5, '丽丽', 10, '夏春茶2021秋冬季新款POLO领条纹针织衫女设计感小众慵懒风毛衣潮', 'https://kilogod.oss-cn-shenzhen.aliyuncs.com/cloudmall/20211113/16367475097281963874203.jpg_400x400.jpg', '5', '非常好', '2021-12-26 02:08:29', '2021-12-26 02:08:29', '', '', '', '');

-- ----------------------------
-- Table structure for feedback
-- ----------------------------
DROP TABLE IF EXISTS `feedback`;
CREATE TABLE `feedback`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `user_id` int(11) NULL DEFAULT NULL COMMENT '用户id',
  `content` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '反馈内容',
  `type` char(2) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '反馈类型',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  `ext1` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '扩展字段',
  `ext2` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '扩展字段',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '意见反馈' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of feedback
-- ----------------------------
INSERT INTO `feedback` VALUES (1, 1, '大三大四的', NULL, '2021-12-20 03:12:15', '2021-12-20 03:12:15', NULL, NULL);
INSERT INTO `feedback` VALUES (2, 2, '阿萨大苏打大苏打是', NULL, '2021-12-20 03:12:15', '2021-12-20 03:12:15', NULL, NULL);
INSERT INTO `feedback` VALUES (3, 2, '阿瑟打算裤脚和闺女吃', NULL, '2021-12-20 03:12:15', '2021-12-20 03:12:15', NULL, NULL);
INSERT INTO `feedback` VALUES (4, 5, '阿萨德多撒', NULL, '2021-12-20 03:12:15', '2021-12-20 03:12:15', NULL, NULL);
INSERT INTO `feedback` VALUES (5, 5, '和共和国环境来看', NULL, '2021-12-26 02:08:52', '2021-12-26 02:08:52', NULL, NULL);

-- ----------------------------
-- Table structure for goods
-- ----------------------------
DROP TABLE IF EXISTS `goods`;
CREATE TABLE `goods`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `shop_id` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '商品编码',
  `shop_name` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '商品名称',
  `image_src` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '主图地址',
  `price` decimal(10, 2) NULL DEFAULT NULL COMMENT '价格',
  `category_id` int(11) NULL DEFAULT NULL COMMENT '分类id',
  `detailed` text CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL COMMENT '描述',
  `sales` int(11) NOT NULL DEFAULT 0 COMMENT '销量',
  `isput` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '是否上架',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  `ext1` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '扩展字段',
  `ext2` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '扩展字段',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `idx_shop_id`(`shop_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 19 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '商品' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of goods
-- ----------------------------
INSERT INTO `goods` VALUES (1, '594321508536', '卡撒天娇家纺长绒棉四件套casa calvin全棉四件套高档欧式床品', 'https://kilogod.oss-cn-shenzhen.aliyuncs.com/cloudmall/20211113/16367469234411418784424.jpg_580x580Q90.jpg', 1599.00, 7, '<p><img src=\"http://yanxuan.nosdn.127.net/2597f9e2e41093f50761837eb4c2e6be.jpg\" _src=\"http://yanxuan.nosdn.127.net/2597f9e2e41093f50761837eb4c2e6be.jpg\" style=\"\"/></p><p><img src=\"http://yanxuan.nosdn.127.net/4377adc892bf9d16f9d0fd78f88a6986.jpg\" _src=\"http://yanxuan.nosdn.127.net/4377adc892bf9d16f9d0fd78f88a6986.jpg\" style=\"\"/></p><p><img src=\"http://yanxuan.nosdn.127.net/986bd3a7517a356265049443cbb747d9.jpg\" _src=\"http://yanxuan.nosdn.127.net/986bd3a7517a356265049443cbb747d9.jpg\" style=\"\"/></p><p><img src=\"http://yanxuan.nosdn.127.net/5cdf3958b3a8d9982b879e3fea1fd616.jpg\" _src=\"http://yanxuan.nosdn.127.net/5cdf3958b3a8d9982b879e3fea1fd616.jpg\" style=\"\"/></p><p><img src=\"http://yanxuan.nosdn.127.net/47e5be34ef476258f44f307982c705d4.jpg\" _src=\"http://yanxuan.nosdn.127.net/47e5be34ef476258f44f307982c705d4.jpg\" style=\"\"/></p><p><img src=\"http://yanxuan.nosdn.127.net/a2220e4cbb5ebc49e9cecb64176983d9.jpg\" _src=\"http://yanxuan.nosdn.127.net/a2220e4cbb5ebc49e9cecb64176983d9.jpg\" style=\"\"/></p><p><img src=\"http://yanxuan.nosdn.127.net/dee62e466465b370c349e37fccd3b596.jpg\" _src=\"http://yanxuan.nosdn.127.net/dee62e466465b370c349e37fccd3b596.jpg\" style=\"\"/></p><p><img src=\"http://yanxuan.nosdn.127.net/c021b91f965ac022182eb03b2780e5de.jpg\" _src=\"http://yanxuan.nosdn.127.net/c021b91f965ac022182eb03b2780e5de.jpg\" style=\"\"/></p><p><img src=\"http://yanxuan.nosdn.127.net/b9f7afd9441928d7f670fd7879ba869d.jpg\" _src=\"http://yanxuan.nosdn.127.net/b9f7afd9441928d7f670fd7879ba869d.jpg\" style=\"\"/></p><p><img src=\"http://yanxuan.nosdn.127.net/8a73b69a2fefbd154a2a6ad45102b565.jpg\" _src=\"http://yanxuan.nosdn.127.net/8a73b69a2fefbd154a2a6ad45102b565.jpg\" style=\"\"/></p><p><img src=\"http://yanxuan.nosdn.127.net/5836d918faa9b11eb8d9f97f9787cda9.jpg\" _src=\"http://yanxuan.nosdn.127.net/5836d918faa9b11eb8d9f97f9787cda9.jpg\" style=\"\"/></p><p><img src=\"http://yanxuan.nosdn.127.net/8216a8addae2f02a5a570ef45d5ecffc.jpg\" _src=\"http://yanxuan.nosdn.127.net/8216a8addae2f02a5a570ef45d5ecffc.jpg\" style=\"\"/></p><p><img src=\"http://yanxuan.nosdn.127.net/da382973dcb0e524a36519baab880204.jpg\" _src=\"http://yanxuan.nosdn.127.net/da382973dcb0e524a36519baab880204.jpg\" style=\"\"/></p><p><img src=\"http://yanxuan.nosdn.127.net/f1c6e84d49f74e228bc57934ec7b7500.jpg\" _src=\"http://yanxuan.nosdn.127.net/f1c6e84d49f74e228bc57934ec7b7500.jpg\" style=\"\"/></p><p><img src=\"http://yanxuan.nosdn.127.net/2f1d0a20e54d3e2e59a44ffe44ebe405.jpg\" _src=\"http://yanxuan.nosdn.127.net/2f1d0a20e54d3e2e59a44ffe44ebe405.jpg\" style=\"\"/></p><p><img src=\"http://yanxuan.nosdn.127.net/a39f2c7580ce5cadc62e8b39d58aca71.jpg\" _src=\"http://yanxuan.nosdn.127.net/a39f2c7580ce5cadc62e8b39d58aca71.jpg\" style=\"\"/></p><p><img src=\"http://yanxuan.nosdn.127.net/c71dc416f04615b634d2b6cd0c4215ee.jpg\" _src=\"http://yanxuan.nosdn.127.net/c71dc416f04615b634d2b6cd0c4215ee.jpg\" style=\"\"/></p><p><img src=\"http://yanxuan.nosdn.127.net/06ac26ed7d870c5c6f0ce3e07c629471.jpg\" _src=\"http://yanxuan.nosdn.127.net/06ac26ed7d870c5c6f0ce3e07c629471.jpg\" style=\"\"/></p><p><img src=\"http://yanxuan.nosdn.127.net/99b180d02726e0213e54dddf4b9b32fd.jpg\" _src=\"http://yanxuan.nosdn.127.net/99b180d02726e0213e54dddf4b9b32fd.jpg\" style=\"\"/></p><p><img src=\"http://yanxuan.nosdn.127.net/97de8d2687052976e51fff40d04af2ce.jpg\" _src=\"http://yanxuan.nosdn.127.net/97de8d2687052976e51fff40d04af2ce.jpg\" style=\"\"/></p><p><img src=\"http://yanxuan.nosdn.127.net/3f527003599be237095995c98039ef87.jpg\" _src=\"http://yanxuan.nosdn.127.net/3f527003599be237095995c98039ef87.jpg\" style=\"\"/></p><p><img src=\"http://yanxuan.nosdn.127.net/ec30289dc1b2beb4b84a08c02a97ef6e.jpg\" _src=\"http://yanxuan.nosdn.127.net/ec30289dc1b2beb4b84a08c02a97ef6e.jpg\" style=\"\"/></p><p><img src=\"http://yanxuan.nosdn.127.net/685da1eaddcd26e8e2a1ff4d5d83f29f.jpg\" _src=\"http://yanxuan.nosdn.127.net/685da1eaddcd26e8e2a1ff4d5d83f29f.jpg\" style=\"\"/></p><p><img src=\"http://yanxuan.nosdn.127.net/2610f487a733a88973d101dcd1766ee1.jpg\" _src=\"http://yanxuan.nosdn.127.net/2610f487a733a88973d101dcd1766ee1.jpg\" style=\"\"/></p><p><img src=\"http://yanxuan.nosdn.127.net/eab3633e648ab2e8412c6801feb6231e.jpg\" _src=\"http://yanxuan.nosdn.127.net/eab3633e648ab2e8412c6801feb6231e.jpg\" style=\"\"/></p><p><img src=\"http://yanxuan.nosdn.127.net/7b6c4f220592ea7d5af0072a816fe946.jpg\" _src=\"http://yanxuan.nosdn.127.net/7b6c4f220592ea7d5af0072a816fe946.jpg\" style=\"\"/></p><p><img src=\"http://yanxuan.nosdn.127.net/310a777685204ece08592a6e2716c6c9.jpg\" _src=\"http://yanxuan.nosdn.127.net/310a777685204ece08592a6e2716c6c9.jpg\" style=\"\"/></p><p><img src=\"http://yanxuan.nosdn.127.net/198239985c74597717e639089ffae25f.jpg\" _src=\"http://yanxuan.nosdn.127.net/198239985c74597717e639089ffae25f.jpg\" style=\"\"/></p><p><img src=\"http://yanxuan.nosdn.127.net/dec6b498c899351fe94d99a6dde0ee79.jpg\" _src=\"http://yanxuan.nosdn.127.net/dec6b498c899351fe94d99a6dde0ee79.jpg\" style=\"\"/></p><p><img src=\"http://yanxuan.nosdn.127.net/516a17ca73846bc871902b298ce38a97.jpg\" _src=\"http://yanxuan.nosdn.127.net/516a17ca73846bc871902b298ce38a97.jpg\" style=\"\"/></p><p><img src=\"http://yanxuan.nosdn.127.net/d8231b81b5ba0e1c244074598c19f003.jpg\" _src=\"http://yanxuan.nosdn.127.net/d8231b81b5ba0e1c244074598c19f003.jpg\" style=\"\"/></p><p><img src=\"http://yanxuan.nosdn.127.net/92c704dcf169e9a177a3c762a6a54a46.jpg\" _src=\"http://yanxuan.nosdn.127.net/92c704dcf169e9a177a3c762a6a54a46.jpg\" style=\"\"/></p><p><img src=\"http://yanxuan.nosdn.127.net/5b9294ad5f78d890453d4a225feed518.jpg\" _src=\"http://yanxuan.nosdn.127.net/5b9294ad5f78d890453d4a225feed518.jpg\" style=\"\"/></p><p><img src=\"http://yanxuan.nosdn.127.net/9bb1b8fdfaa7f895bdd7d5c65c42a59b.jpg\" _src=\"http://yanxuan.nosdn.127.net/9bb1b8fdfaa7f895bdd7d5c65c42a59b.jpg\" style=\"\"/></p><p><img src=\"http://yanxuan.nosdn.127.net/f342e6d6b75dc1f80972feb415fd4e75.jpg\" _src=\"http://yanxuan.nosdn.127.net/f342e6d6b75dc1f80972feb415fd4e75.jpg\" style=\"\"/></p><p><img src=\"http://yanxuan.nosdn.127.net/6c9597cf206066861b3244f634c98e32.jpg\" _src=\"http://yanxuan.nosdn.127.net/6c9597cf206066861b3244f634c98e32.jpg\" style=\"\"/></p><p><img src=\"http://yanxuan.nosdn.127.net/970d4dad7d958293fd41ec1f444684f1.jpg\" _src=\"http://yanxuan.nosdn.127.net/970d4dad7d958293fd41ec1f444684f1.jpg\" style=\"\"/></p><p><img src=\"http://yanxuan.nosdn.127.net/6f93819b03de07abef8b2d94f1d5c84b.jpg\" _src=\"http://yanxuan.nosdn.127.net/6f93819b03de07abef8b2d94f1d5c84b.jpg\" style=\"\"/></p><p><img src=\"http://yanxuan.nosdn.127.net/58c8c56aac61da4ee9fcf34930b76e4e.jpg\" _src=\"http://yanxuan.nosdn.127.net/58c8c56aac61da4ee9fcf34930b76e4e.jpg\" style=\"\"/></p><p><img src=\"http://yanxuan.nosdn.127.net/fb6435ec714189d6ad5053bf12d41db7.jpg\" _src=\"http://yanxuan.nosdn.127.net/fb6435ec714189d6ad5053bf12d41db7.jpg\" style=\"\"/></p><p><img src=\"http://yanxuan.nosdn.127.net/19cc85ae097247d5d868df993de64e7b.jpg\" _src=\"http://yanxuan.nosdn.127.net/19cc85ae097247d5d868df993de64e7b.jpg\" style=\"\"/></p><p><img src=\"http://yanxuan.nosdn.127.net/0ab8e27757cabd39fccdb5fd8ef7b013.jpg\" _src=\"http://yanxuan.nosdn.127.net/0ab8e27757cabd39fccdb5fd8ef7b013.jpg\" style=\"\"/></p><p><img src=\"http://yanxuan.nosdn.127.net/03e6f02f8f77b71a82a05dd1a9705057.jpg\" _src=\"http://yanxuan.nosdn.127.net/03e6f02f8f77b71a82a05dd1a9705057.jpg\" style=\"\"/></p><p><br/></p>', 57, '已上架', '2021-12-20 03:12:15', '2021-12-20 03:12:15', NULL, NULL);
INSERT INTO `goods` VALUES (2, '530253997599', '富安娜欧式提花四件套纯棉床单涤棉被套床品奢华轻奢床上用品秋冬', 'https://kilogod.oss-cn-shenzhen.aliyuncs.com/cloudmall/20211113/16367470499096362416912.jpg_580x580Q90.jpg', 399.00, 7, '<p><img src=\"https://kilogod.oss-cn-shenzhen.aliyuncs.com/cloudmall/20211113/16367471111670733559205.jpg\" alt=\"\" width=\"790\" height=\"1494\" /></p>\n<p><img src=\"https://kilogod.oss-cn-shenzhen.aliyuncs.com/cloudmall/20211113/16367471226426886562488.jpg\" alt=\"\" width=\"790\" height=\"1499\" /></p>\n<p><img src=\"https://kilogod.oss-cn-shenzhen.aliyuncs.com/cloudmall/20211113/16367471326537486897927.jpg\" alt=\"\" width=\"790\" height=\"1481\" /></p>', 20, '已上架', '2021-12-20 03:12:15', '2021-12-20 03:12:15', NULL, NULL);
INSERT INTO `goods` VALUES (3, '4561074298942', ' 【直营】moony腰贴型婴儿纸尿裤 L54片*3宝宝透气超薄尿不湿母婴', 'https://kilogod.oss-cn-shenzhen.aliyuncs.com/cloudmall/20211113/16367472396988728123953.jpg_580x580Q90.jpg', 300.00, 1, '<p><img src=\"https://kilogod.oss-cn-shenzhen.aliyuncs.com/cloudmall/20211113/16367472963964917929095.jpg\" alt=\"\" width=\"790\" height=\"1280\" /></p>\n<p><img src=\"https://kilogod.oss-cn-shenzhen.aliyuncs.com/cloudmall/20211113/16367473062580004313963.jpg\" alt=\"\" width=\"790\" height=\"910\" /></p>\n<p><img src=\"https://kilogod.oss-cn-shenzhen.aliyuncs.com/cloudmall/20211113/16367473138664094807250.jpg\" alt=\"\" width=\"790\" height=\"960\" /></p>\n<p><img src=\"https://kilogod.oss-cn-shenzhen.aliyuncs.com/cloudmall/20211113/16367473215008660858974.jpg\" alt=\"\" width=\"790\" height=\"1260\" /></p>\n<p><img src=\"https://kilogod.oss-cn-shenzhen.aliyuncs.com/cloudmall/20211113/16367473290787375303615.jpg\" alt=\"\" width=\"790\" height=\"1180\" /></p>', 21, '已上架', '2021-12-20 03:12:15', '2021-12-20 03:12:15', NULL, NULL);
INSERT INTO `goods` VALUES (10, '656016581712', '夏春茶2021秋冬季新款POLO领条纹针织衫女设计感小众慵懒风毛衣潮', 'https://kilogod.oss-cn-shenzhen.aliyuncs.com/cloudmall/20211113/16367475097281963874203.jpg_400x400.jpg', 78.00, 2, '<p><img src=\"https://kilogod.oss-cn-shenzhen.aliyuncs.com/cloudmall/20211113/16367475282491868784670.jpg\" alt=\"\" width=\"750\" height=\"978\" /></p>\n<p><img src=\"https://kilogod.oss-cn-shenzhen.aliyuncs.com/cloudmall/20211113/16367475364760243524534.jpg\" alt=\"\" width=\"750\" height=\"819\" /></p>', 303, '已上架', '2021-12-20 03:12:15', '2021-12-20 03:12:15', '', '');
INSERT INTO `goods` VALUES (11, '654315210461', '英爵伦2021冬季新款毛衣男刺绣毛线衣薄款男装秋冬圆领针织打底衫', 'https://kilogod.oss-cn-shenzhen.aliyuncs.com/cloudmall/20211113/16367475688864027662702.jpg_430x430q90.jpg', 100.00, 3, '<p><img src=\"https://kilogod.oss-cn-shenzhen.aliyuncs.com/cloudmall/20211113/16367476013307037597321.jpg\" alt=\"\" width=\"790\" height=\"1299\" /></p>\n<p><img src=\"https://kilogod.oss-cn-shenzhen.aliyuncs.com/cloudmall/20211113/16367476150299530347055.jpg\" alt=\"\" width=\"790\" height=\"1337\" /></p>\n<p><img src=\"https://kilogod.oss-cn-shenzhen.aliyuncs.com/cloudmall/20211113/16367476232312701136795.jpg\" alt=\"\" width=\"790\" height=\"1743\" /></p>', 22, '已上架', '2021-12-20 03:12:15', '2021-12-20 03:12:15', '', '');
INSERT INTO `goods` VALUES (12, '645016222642', '德国刀具套装菜刀菜板二合一厨具套装全套家用宿舍切菜刀砧板组合', 'https://kilogod.oss-cn-shenzhen.aliyuncs.com/cloudmall/20211113/16367478516112776439043.jpg_270x270.jpg', 59.00, 4, '<p><img src=\"https://kilogod.oss-cn-shenzhen.aliyuncs.com/cloudmall/20211113/16367478660918043260048.jpg\" alt=\"\" width=\"790\" height=\"1689\" /></p>\n<p><img src=\"https://kilogod.oss-cn-shenzhen.aliyuncs.com/cloudmall/20211113/16367478735859901307306.jpg\" alt=\"\" width=\"790\" height=\"2205\" /></p>', 289, '已上架', '2021-12-20 03:12:15', '2021-12-20 03:12:15', '', '');
INSERT INTO `goods` VALUES (13, '599490662010', 'CLUSE时尚手表简约女士情侣礼物手表女秋季学生小方块石英手表女', 'https://kilogod.oss-cn-shenzhen.aliyuncs.com/cloudmall/20211113/16367477010725335570044.jpg_580x580Q90.jpg', 668.00, 5, '<p><img src=\"https://kilogod.oss-cn-shenzhen.aliyuncs.com/cloudmall/20211113/16367477293468079128953.jpg\" alt=\"\" width=\"750\" height=\"1071\" /></p>\n<p><img src=\"https://kilogod.oss-cn-shenzhen.aliyuncs.com/cloudmall/20211113/16367477363131920953332.jpg\" alt=\"\" width=\"750\" height=\"1085\" /></p>\n<p>&nbsp;</p>', 18, '已上架', '2021-12-20 03:12:15', '2021-12-20 03:12:15', '', '');
INSERT INTO `goods` VALUES (14, '628815664123', '苏泊尔MT60吸抽油烟机燃气灶套餐家用烟灶消套装热水器三件套组合', 'https://kilogod.oss-cn-shenzhen.aliyuncs.com/cloudmall/20211113/16367479217234931360912.jpg_580x580Q90.jpg', 2899.00, 6, '<p><img src=\"https://kilogod.oss-cn-shenzhen.aliyuncs.com/cloudmall/20211113/16367479459691217284264.jpg\" alt=\"\" width=\"750\" height=\"1280\" /></p>\n<p><img src=\"https://kilogod.oss-cn-shenzhen.aliyuncs.com/cloudmall/20211113/16367479540949557787577.jpg\" alt=\"\" width=\"750\" height=\"1142\" /></p>', 9, '已上架', '2021-12-20 03:12:15', '2021-12-20 03:12:15', '', '');
INSERT INTO `goods` VALUES (16, '528056263932', '广西百香果新鲜包邮5斤大果黄金水果百香果浓浆果酱原浆当季整箱', 'https://kilogod.oss-cn-shenzhen.aliyuncs.com/cloudmall/20211113/16367480043465540228172.jpg_580x580Q90.jpg', 12.90, 8, '<p><img src=\"https://kilogod.oss-cn-shenzhen.aliyuncs.com/cloudmall/20211113/16367480244804002534440.jpg\" alt=\"\" width=\"790\" height=\"640\" /></p>\n<p><img src=\"https://kilogod.oss-cn-shenzhen.aliyuncs.com/cloudmall/20211113/16367480301264970289610.jpg\" alt=\"\" width=\"790\" height=\"667\" /></p>', 20, '已上架', '2021-12-20 03:12:15', '2021-12-20 03:12:15', '', '');
INSERT INTO `goods` VALUES (17, '630659016280', '百年传奇无骨鸭爪无骨派鸭掌鸭爪百年传奇凤爪鸭爪无骨零食整箱', 'https://kilogod.oss-cn-shenzhen.aliyuncs.com/cloudmall/20211113/16367480662367148404569.jpg_580x580Q90.jpg', 20.00, 9, '<p><img src=\"https://kilogod.oss-cn-shenzhen.aliyuncs.com/cloudmall/20211113/16367480839710814416746.jpg\" alt=\"\" width=\"750\" height=\"1125\" /></p>\n<p><img src=\"https://kilogod.oss-cn-shenzhen.aliyuncs.com/cloudmall/20211113/16367480910308133003554.jpg\" alt=\"\" width=\"750\" height=\"729\" /></p>', 10, '已上架', '2021-12-20 03:12:15', '2021-12-20 03:12:15', '', '');
INSERT INTO `goods` VALUES (18, '619691233001', '自嗨锅煲仔饭方便即食网红懒人食品早餐即食自热米饭速食方便米饭', 'https://kilogod.oss-cn-shenzhen.aliyuncs.com/cloudmall/20211113/16367485369786065629622.jpg_580x580Q90.jpg', 90.00, 9, '<p><img src=\"https://kilogod.oss-cn-shenzhen.aliyuncs.com/cloudmall/20211113/16367485609927731653005.jpg\" alt=\"\" width=\"790\" height=\"1939\" /></p>\n<p><img src=\"https://kilogod.oss-cn-shenzhen.aliyuncs.com/cloudmall/20211113/16367485691260412523484.jpg\" alt=\"\" width=\"790\" height=\"1324\" /></p>', 200, '已上架', '2021-12-20 03:12:15', '2021-12-20 03:12:15', '', '');

-- ----------------------------
-- Table structure for integral_record
-- ----------------------------
DROP TABLE IF EXISTS `integral_record`;
CREATE TABLE `integral_record`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `user_id` int(11) NULL DEFAULT NULL COMMENT '用户id',
  `order_id` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '订单号 （支付宝充值时为空）',
  `amount` decimal(10, 2) NULL DEFAULT NULL COMMENT '消费金额',
  `integral` int(11) NULL DEFAULT NULL COMMENT '积分个数',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  `ext1` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '扩展字段',
  `ext2` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '扩展字段',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 45 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '积分记录' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of integral_record
-- ----------------------------
INSERT INTO `integral_record` VALUES (41, 5, '20211225230147937', 1599.00, 1599, '2021-12-25 23:01:48', '2021-12-25 23:01:48', NULL, NULL);
INSERT INTO `integral_record` VALUES (42, 5, '20211225234205848', 100.00, 100, '2021-12-25 23:42:06', '2021-12-25 23:42:06', NULL, NULL);
INSERT INTO `integral_record` VALUES (43, 5, '20211225234345796', 78.00, 78, '2021-12-25 23:43:46', '2021-12-25 23:43:46', NULL, NULL);
INSERT INTO `integral_record` VALUES (44, 5, '20211226020555754', 78.00, 78, '2021-12-26 02:05:56', '2021-12-26 02:05:56', NULL, NULL);

-- ----------------------------
-- Table structure for order_info
-- ----------------------------
DROP TABLE IF EXISTS `order_info`;
CREATE TABLE `order_info`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `user_id` int(11) NULL DEFAULT NULL COMMENT '用户id',
  `order_id` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '订单id',
  `shop_id` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '商品id',
  `price` decimal(10, 2) NULL DEFAULT NULL COMMENT '商品价格',
  `get_time` datetime(0) NULL DEFAULT NULL,
  `sender_id` int(11) NULL DEFAULT NULL,
  `receiver_id` int(11) NULL DEFAULT NULL COMMENT '收货地址id',
  `status` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '订单状态  1:待发货 2:已发货 3:配送中 4:已签收 5:完成',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '下单时间',
  `remark` text CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL COMMENT '备注',
  `ext1` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '1' COMMENT '扩展字段',
  `ext2` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '扩展字段',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 48 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '订单' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of order_info
-- ----------------------------
INSERT INTO `order_info` VALUES (44, 5, '20211225230147937', '594321508536', 1599.00, NULL, NULL, 7, '1', '2021-12-25 23:01:48', NULL, '1', NULL);
INSERT INTO `order_info` VALUES (45, 5, '20211225234205848', '654315210461', 100.00, NULL, NULL, 8, '6', '2021-12-25 23:42:06', NULL, '1', NULL);
INSERT INTO `order_info` VALUES (46, 5, '20211225234345796', '656016581712', 78.00, NULL, NULL, 7, '6', '2021-12-25 23:43:46', NULL, '1', NULL);
INSERT INTO `order_info` VALUES (47, 5, '20211226020555754', '656016581712', 78.00, NULL, NULL, 7, '6', '2021-12-26 02:05:56', NULL, '1', NULL);

-- ----------------------------
-- Table structure for pay_info
-- ----------------------------
DROP TABLE IF EXISTS `pay_info`;
CREATE TABLE `pay_info`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `user_id` int(11) NULL DEFAULT NULL COMMENT '用户id',
  `total_amount` decimal(10, 2) NULL DEFAULT NULL COMMENT '支付金额',
  `receipt_amount` decimal(10, 2) NULL DEFAULT NULL COMMENT '实收金额',
  `buyer_pay_amount` decimal(10, 2) NULL DEFAULT NULL COMMENT '付款金额',
  `trade_no` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '支付宝交易凭证号',
  `out_trade_no` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '支付流水号',
  `subject` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '订单标题',
  `body` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '订单描述',
  `trade_status` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '支付状态 WAIT_BUYER_PAY:交易创建，等待买家付款 TRADE_CLOSED:未付款交易超时关闭，或支付完成后全额退款 TRADE_SUCCESS:	交易支付成功 TRADE_FINISHED:交易结束，不可退款',
  `buyer_id` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '买家支付宝账号',
  `seller_id` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '卖家支付宝用户号',
  `fund_bill_list` text CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL COMMENT '支付金额信息 ',
  `send_pay_date` datetime(0) NULL DEFAULT NULL COMMENT '交易到账时间',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '下单时间',
  `ext1` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '扩展字段',
  `ext2` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '扩展字段',
  `ext3` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '扩展字段',
  `ext4` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '扩展字段',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 15 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '支付订单表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of pay_info
-- ----------------------------
INSERT INTO `pay_info` VALUES (6, 5, 20.00, NULL, NULL, NULL, '202112260024191640449459714', '商城(费用充值)', '商城-202112260024191640449459714', 'WAIT_BUYER_PAY', NULL, NULL, NULL, NULL, '2021-12-26 00:24:20', NULL, NULL, NULL, NULL);
INSERT INTO `pay_info` VALUES (7, 5, 100.00, NULL, NULL, NULL, '202112260025451640449545221', '商城(费用充值)', '商城-202112260025451640449545221', 'WAIT_BUYER_PAY', NULL, NULL, NULL, NULL, '2021-12-26 00:25:45', NULL, NULL, NULL, NULL);
INSERT INTO `pay_info` VALUES (8, 5, 100.00, NULL, NULL, NULL, '202112260026071640449567962', '商城(费用充值)', '商城-202112260026071640449567962', 'WAIT_BUYER_PAY', NULL, NULL, NULL, NULL, '2021-12-26 00:26:08', NULL, NULL, NULL, NULL);
INSERT INTO `pay_info` VALUES (9, 5, 1000.00, NULL, NULL, NULL, '202112260026221640449582483', '商城(费用充值)', '商城-202112260026221640449582483', 'WAIT_BUYER_PAY', NULL, NULL, NULL, NULL, '2021-12-26 00:26:22', NULL, NULL, NULL, NULL);
INSERT INTO `pay_info` VALUES (10, 5, 100.00, NULL, NULL, NULL, '202112260029461640449786627', '商城(费用充值)', '商城-202112260029461640449786627', 'WAIT_BUYER_PAY', NULL, NULL, NULL, NULL, '2021-12-26 00:29:47', NULL, NULL, NULL, NULL);
INSERT INTO `pay_info` VALUES (11, 5, 1000.00, NULL, NULL, NULL, '202112260029571640449797125', '商城(费用充值)', '商城-202112260029571640449797125', 'WAIT_BUYER_PAY', NULL, NULL, NULL, NULL, '2021-12-26 00:29:57', NULL, NULL, NULL, NULL);
INSERT INTO `pay_info` VALUES (12, 5, 1000.00, NULL, NULL, NULL, '202112260030101640449810308', '商城(费用充值)', '商城-202112260030101640449810308', 'WAIT_BUYER_PAY', NULL, NULL, NULL, NULL, '2021-12-26 00:30:10', NULL, NULL, NULL, NULL);
INSERT INTO `pay_info` VALUES (13, 5, 100.00, NULL, NULL, NULL, '202112260206261640455586707', '商城(费用充值)', '商城-202112260206261640455586707', 'WAIT_BUYER_PAY', NULL, NULL, NULL, NULL, '2021-12-26 02:06:27', NULL, NULL, NULL, NULL);
INSERT INTO `pay_info` VALUES (14, 5, 1000.00, NULL, NULL, NULL, '202112260206371640455597193', '商城(费用充值)', '商城-202112260206371640455597193', 'WAIT_BUYER_PAY', NULL, NULL, NULL, NULL, '2021-12-26 02:06:37', NULL, NULL, NULL, NULL);

-- ----------------------------
-- Table structure for pay_refund
-- ----------------------------
DROP TABLE IF EXISTS `pay_refund`;
CREATE TABLE `pay_refund`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `user_id` int(11) NULL DEFAULT NULL COMMENT '用户id',
  `order_id` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '订单id',
  `refund_amount` decimal(10, 2) NULL DEFAULT NULL COMMENT '退款金额',
  `out_trade_no` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '支付流水号',
  `refund_no` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '退款流水号',
  `trade_no` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '支付宝交易凭证号',
  `refund_reason` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '退款原因',
  `buyer_logon_id` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '用户的登录id',
  `buyer_user_id` varchar(28) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '买家在支付宝的用户id',
  `fund_change` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '退款是否发生了资金变化',
  `refund_fee` decimal(10, 2) NULL DEFAULT NULL COMMENT '退款总金额',
  `gmt_refund_pay` datetime(0) NULL DEFAULT NULL COMMENT '退款支付时间',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建退款时间',
  `ext1` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '扩展字段',
  `ext2` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '扩展字段',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '支付退款表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for shop_category
-- ----------------------------
DROP TABLE IF EXISTS `shop_category`;
CREATE TABLE `shop_category`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '分类id',
  `category_name` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '分类名称',
  `category_image_src` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '分类图片',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  `ext1` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '扩展字段',
  `ext2` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '扩展字段',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 10 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '商品分类' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of shop_category
-- ----------------------------
INSERT INTO `shop_category` VALUES (1, '母婴', 'https://kilogod.oss-cn-shenzhen.aliyuncs.com/cloudmall/20211113/16367467071712995137046.jpg_580x580Q90.jpg', '2021-12-20 03:12:15', '2021-12-20 03:12:15', NULL, NULL);
INSERT INTO `shop_category` VALUES (2, '女装', 'https://kilogod.oss-cn-shenzhen.aliyuncs.com/cloudmall/20211113/16367467313588860740463.jpg_Q75.jpg', '2021-12-20 03:12:15', '2021-12-20 03:12:15', NULL, NULL);
INSERT INTO `shop_category` VALUES (3, '男装', 'https://kilogod.oss-cn-shenzhen.aliyuncs.com/cloudmall/20211113/16367467525775781880376.jpg_580x580Q90.jpg', '2021-12-20 03:12:15', '2021-12-20 03:12:15', NULL, NULL);
INSERT INTO `shop_category` VALUES (4, '厨具', 'https://kilogod.oss-cn-shenzhen.aliyuncs.com/cloudmall/20211113/16367467755256127438530.jpg_580x580Q90.jpg', '2021-12-20 03:12:15', '2021-12-20 03:12:15', NULL, NULL);
INSERT INTO `shop_category` VALUES (5, '手表', 'https://kilogod.oss-cn-shenzhen.aliyuncs.com/cloudmall/20211113/16367468009872730324635.jpg_580x580Q90.jpg', '2021-12-20 03:12:15', '2021-12-20 03:12:15', NULL, NULL);
INSERT INTO `shop_category` VALUES (6, '大家电', 'https://kilogod.oss-cn-shenzhen.aliyuncs.com/cloudmall/20211113/16367468224092484694145.jpg_580x580Q90.jpg', '2021-12-20 03:12:15', '2021-12-20 03:12:15', NULL, NULL);
INSERT INTO `shop_category` VALUES (7, '家纺', 'https://kilogod.oss-cn-shenzhen.aliyuncs.com/cloudmall/20211113/16367468564270519703413.jpg_580x580Q90.jpg', '2021-12-20 03:12:15', '2021-12-20 03:12:15', NULL, NULL);
INSERT INTO `shop_category` VALUES (8, '水果', 'https://kilogod.oss-cn-shenzhen.aliyuncs.com/cloudmall/20211113/16367468805963951901270.jpg_580x580Q90.jpg', '2021-12-20 03:12:15', '2021-12-20 03:12:15', NULL, NULL);
INSERT INTO `shop_category` VALUES (9, '食品', 'https://kilogod.oss-cn-shenzhen.aliyuncs.com/cloudmall/20211103/16359525904579010615294.jpg', '2021-12-20 03:12:15', '2021-12-20 03:12:15', '', '');

-- ----------------------------
-- Table structure for shop_image
-- ----------------------------
DROP TABLE IF EXISTS `shop_image`;
CREATE TABLE `shop_image`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '图片id',
  `image_src` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '图片地址',
  `image_type` char(2) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '图片分类',
  `shop_id` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '商品id',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  `ext1` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '扩展字段',
  `ext2` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '扩展字段',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 9 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '商品图片' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for shopcart
-- ----------------------------
DROP TABLE IF EXISTS `shopcart`;
CREATE TABLE `shopcart`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `user_id` int(11) NULL DEFAULT NULL COMMENT '用户id',
  `shop_id` int(11) NULL DEFAULT NULL COMMENT '商品id',
  `shop_name` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '商品名称',
  `image_src` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '商品图片',
  `price` decimal(10, 2) NULL DEFAULT NULL COMMENT '单价',
  `num` int(11) NULL DEFAULT NULL COMMENT '数量',
  `total` decimal(10, 2) NULL DEFAULT NULL COMMENT '总价',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  `ext1` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '扩展字段',
  `ext2` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '扩展字段',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `user_id`(`user_id`, `shop_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 38 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '购物车' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of shopcart
-- ----------------------------
INSERT INTO `shopcart` VALUES (35, 5, 12, '德国刀具套装菜刀菜板二合一厨具套装全套家用宿舍切菜刀砧板组合', 'https://kilogod.oss-cn-shenzhen.aliyuncs.com/cloudmall/20211113/16367478516112776439043.jpg_270x270.jpg', 59.00, 1, 59.00, '2021-12-20 03:12:15', '2021-12-20 03:12:15', NULL, NULL);
INSERT INTO `shopcart` VALUES (36, 5, 3, ' 【直营】moony腰贴型婴儿纸尿裤 L54片*3宝宝透气超薄尿不湿母婴', 'https://kilogod.oss-cn-shenzhen.aliyuncs.com/cloudmall/20211113/16367472396988728123953.jpg_580x580Q90.jpg', 300.00, 1, 300.00, '2021-12-25 23:43:37', '2021-12-25 23:43:37', NULL, NULL);
INSERT INTO `shopcart` VALUES (37, 5, 1, '卡撒天娇家纺长绒棉四件套casa calvin全棉四件套高档欧式床品', 'https://kilogod.oss-cn-shenzhen.aliyuncs.com/cloudmall/20211113/16367469234411418784424.jpg_580x580Q90.jpg', 1599.00, 1, 1599.00, '2021-12-26 02:05:14', '2021-12-26 02:05:14', NULL, NULL);

-- ----------------------------
-- Table structure for sms_log
-- ----------------------------
DROP TABLE IF EXISTS `sms_log`;
CREATE TABLE `sms_log`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `phone` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '手机号码',
  `code` varchar(6) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '验证码',
  `status` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '发送状态  1:成功,0:失败',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `create_by` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '创建人',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  `update_by` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '更新人',
  `ext1` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '扩展字段',
  `ext2` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '扩展字段',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '短信日志记录表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for system_config
-- ----------------------------
DROP TABLE IF EXISTS `system_config`;
CREATE TABLE `system_config`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `config_key` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '键',
  `config_value` text CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL COMMENT '值',
  `config_name` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '名称',
  `config_type` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '类型',
  `remark` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '备注',
  `orderNo` char(3) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '排序号',
  `in_use` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '是否启用',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  `ext1` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '扩展字段',
  `ext2` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '扩展字段',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '系统配置表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for trade_serial
-- ----------------------------
DROP TABLE IF EXISTS `trade_serial`;
CREATE TABLE `trade_serial`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `user_id` int(11) NULL DEFAULT NULL COMMENT '用户id',
  `amount` decimal(10, 2) NULL DEFAULT NULL COMMENT '充值消费金额',
  `order_id` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '订单号 （支付宝充值时为空）',
  `trade_no` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '支付宝交易凭证号  （消费订单时为空）',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '充值消费时间',
  `ext1` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '扩展字段',
  `ext2` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '扩展字段',
  `ext3` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '扩展字段',
  `ext4` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '扩展字段',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 52 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '交易流水' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of trade_serial
-- ----------------------------
INSERT INTO `trade_serial` VALUES (48, 5, 1599.00, '20211225230147937', NULL, '2021-12-25 23:01:48', NULL, NULL, NULL, NULL);
INSERT INTO `trade_serial` VALUES (49, 5, 100.00, '20211225234205848', NULL, '2021-12-25 23:42:06', NULL, NULL, NULL, NULL);
INSERT INTO `trade_serial` VALUES (50, 5, 78.00, '20211225234345796', NULL, '2021-12-25 23:43:46', NULL, NULL, NULL, NULL);
INSERT INTO `trade_serial` VALUES (51, 5, 78.00, '20211226020555754', NULL, '2021-12-26 02:05:56', NULL, NULL, NULL, NULL);

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键用户id',
  `username` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '用户名称',
  `password` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '密码',
  `phone` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '手机号码',
  `sex` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '性别',
  `birthday` date NULL DEFAULT NULL COMMENT '生日',
  `is_vip` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '是否会员',
  `is_agent` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '是否代理',
  `in_use` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '是否启用',
  `role_id` int(11) NULL DEFAULT NULL COMMENT '权限id',
  `amount` decimal(10, 2) NULL DEFAULT NULL COMMENT '储值金额',
  `integral` int(11) NULL DEFAULT NULL COMMENT '积分',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  `ext1` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '扩展字段',
  `ext2` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '扩展字段',
  `ext3` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '扩展字段',
  `ext4` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '扩展字段',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '用户' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1, '王明义', '$2a$10$Bn242nGNR1IloNFEnRC0o.MV0sLq9Gin8lcPAYCqOhoWDwp2TutPm', '18373358891', '1', '2020-11-03', '2', '0', '1', 0, 863553.00, 146269, '2021-12-20 03:12:15', '2021-12-20 03:12:15', NULL, NULL, NULL, NULL);
INSERT INTO `user` VALUES (2, NULL, '$2a$10$kNySxWWuxEZQxmGvpM5S6ew/DanjdsxhR41KM5Em9pr.Jp9bdCUcO', '18373358893', NULL, NULL, '1', '0', '1', 0, 0.00, 0, '2021-12-20 03:12:15', '2021-12-20 03:12:15', NULL, NULL, NULL, NULL);
INSERT INTO `user` VALUES (3, 'mms', '$2a$10$jh6JiqGEEF98l7oyF/KyFu7kVKKNP2KqRCcOr6sfH7kuB4bS/52gq', '18676767676', '1', '2021-05-01', '1', '0', '1', 0, 20000.00, 0, '2021-12-20 03:12:15', '2021-12-20 03:12:15', NULL, NULL, NULL, NULL);
INSERT INTO `user` VALUES (4, '湖名城', '$2a$10$/kT0zPHJYxQZeDLm8PM1XueuW97U3LZKw7hu7IRgnU7W9jFiIGX6m', '18388888888', '1', '2021-11-03', '2', '0', '1', 0, 26005.00, 53995, '2021-12-20 03:12:15', '2021-12-20 03:12:15', NULL, NULL, NULL, NULL);
INSERT INTO `user` VALUES (5, '丽丽', '$2a$10$7UYD4FQ61u4WcpVlfuiEROxqyN/tRsEM8jpqnlFGLH0Xu7pWy1ltK', '18688888888', '0', '2002-02-06', '2', '0', '1', 0, 64957.20, 38241, '2021-12-20 03:12:15', '2021-12-20 03:12:15', NULL, NULL, NULL, NULL);

SET FOREIGN_KEY_CHECKS = 1;

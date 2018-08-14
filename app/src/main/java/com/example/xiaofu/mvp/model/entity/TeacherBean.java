package com.example.xiaofu.mvp.model.entity;

import java.io.Serializable;
import java.util.List;

////////////////////////////////////////////////////////////////////
//                          _ooOoo_                               //
//                         o8888888o                              //
//                         88" . "88                              //
//                         (| ^_^ |)                              //
//                         O\  =  /O                              //
//                      ____/`---'\____                           //
//                    .'  \\|     |//  `.                         //
//                   /  \\|||  :  |||//  \                        //
//                  /  _||||| -:- |||||-  \                       //
//                  |   | \\\  -  /// |   |                       //
//                  | \_|  ''\---/''  |   |                       //
//                  \  .-\__  `-`  ___/-. /                       //
//                ___`. .'  /--.--\  `. . ___                     //
//              ."" '<  `.___\_<|>_/___.'  >'"".                  //
//            | | :  `- \`.;`\ _ /`;.`/ - ` : | |                 //
//            \  \ `-.   \_ __\ /__ _/   .-` /  /                 //
//      ========`-.____`-.___\_____/___.-`____.-'========         //
//                           `=---='                              //
//      ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^        //
//         佛祖保佑       永无BUG     永不修改                     //
////////////////////////////////////////////////////////////////////
public class TeacherBean {
    /**
     * code : 200
     * body : {"result":[{"Description":"云学创始合伙人\n世华智业投资集团董事\n大爱堂书院执行院长\n世华大学长青学院导师","TeacherPic":"https://yunxue-bucket.oss-cn-shanghai.aliyuncs.com/imgurl/teacher/headimg_1512116476817.jpg","Title":"世华大学长青学院导师","TeacherType":[{"typename":"通用管理"},{"typename":"家庭教育"}],"ID":65,"follow":false,"TeacherName":"华创","EnterpriseID":0},{"Description":"石庆敏，人称小石哥。他不是老师，HR学员却遍布全国各地；他的课程和思路并不精彩及\u2018高大上\u2019，却受众多企业老板和HR欢迎。\n小石哥拥有10多年的人力资源管理实战经验，长期在民营企业负责人力资源管理和企业内训工作，深谙民营企业人力资源管理之道；有丰富的人才培养经验和授课经验。","TeacherPic":"https://yunxue-bucket.oss-cn-shanghai.aliyuncs.com/imgurl/teacher/headimg_1512280725434.jpg","Title":"人力资源管理专家","TeacherType":[{"typename":"人力资源"}],"ID":94,"follow":false,"TeacherName":"石庆敏","EnterpriseID":0},{"Description":"北大纵横管理咨询集团高级合伙人\n中华讲师网百强讲师\n合肥财经职业学院客座教授\n丁老师曾多年担任大型企业集团中高层管理人员，在集团和企业组织的人力资源管理模块有着丰富的实战、培训和咨询经验，培训过程中结合实战及管理咨询经验，能够让培训课程做到落地有声，赢得了客户的认同。丁老师授课深入浅出、条例清楚，富有趣味性，感染力强。点评能提纲契领，语言运用准确规范，接受培训的企业或学员都给予了很高的评价。","TeacherPic":"https://yunxue-bucket.oss-cn-shanghai.aliyuncs.com/imgurl/teacher/headimg_1512613647024.jpg","Title":"北大纵横管理咨询集团高级合伙人","TeacherType":[{"typename":"通用管理"},{"typename":"人力资源"}],"ID":121,"follow":false,"TeacherName":"丁当","EnterpriseID":0},{"Description":"国家一级人力资源管理师，企业高级培训师，多年企业营销及管理实践经验，专注职业能力培训研究与实践，在战略管理、商业模式设计、培训开发、薪酬设计、团队建设、领导力提升、组织沟通等管理领域有相对丰富的实践心得和体会。具备员工能力培育、人力资源培训、领导力开发、组织沟通、团队建设等多个领域十余年的专业服务经验。主持完成多项职业能力培育研究的相关课题，著译出版作品20余部，撰写论文30余篇。为国内多家大学及教育机构提供面向企业管理人员、基层员工、MBA等不同层次学员培训课程百余场，录制《人力资源管理》、《销售管理》、《组织行为学》等EMBA网络音视频专业课程十余门，为全国近百家企业提供内训服务支持。","TeacherPic":"https://yunxue-bucket.oss-cn-shanghai.aliyuncs.com/imgurl/teacher/headimg_1513233973448.jpg","Title":"一级人力资源管理师，企业高级培训师","TeacherType":[{"typename":"人力资源"},{"typename":"职场素养"}],"ID":139,"follow":false,"TeacherName":"冯学东","EnterpriseID":0},{"Description":"享受政府特殊津贴的心理教育培训专家；《国家职业资格·心理咨询师》资格认证考试培训专家；\u201c团中央北戴河培训基地《青少年心理健康教育示范性课程体系》特聘专家\u201d\u201c全国青少年心理社会服务联合平台特聘专家\u201d；国家级注册心理咨询师、国家级高级青少年网络指导师，美国ACHE催眠治疗师。","TeacherPic":"https://yunxue-bucket.oss-cn-shanghai.aliyuncs.com/imgurl/teacher/headimg_1511851690403.jpg","Title":"享受政府特殊津贴的心理教育培训专家","TeacherType":[{"typename":"家庭教育"}],"ID":41,"follow":false,"TeacherName":"郭铁军","EnterpriseID":0},{"Description":"<p><span style=\"color: rgb(192, 80, 77);\">微软认证系统工程师\n微软认证应用程序开发专家\n10年Microsoft Office应用开发和培训经验，曾为Intel、美国可口可乐、巴黎欧莱雅、中国移动等上百家跨国企业提供Microsoft Office高级应用公开课或内训服务。<\/span><br/><\/p>","TeacherPic":"https://yunxue-bucket.oss-cn-shanghai.aliyuncs.com/imgurl/teacher/headimg_1511871361739.jpg","Title":"微软认证系统工程师","TeacherType":[{"typename":"职业技能"}],"ID":32,"follow":false,"TeacherName":"张晓兵","EnterpriseID":0},{"Description":"企业执行力落地实战导师\n华创世纪总裁班主讲导师\n九州文化传播公司董事长\n他，一个理论与实践结合的应用者。擅长组织执行、企业管理、团队打造。他深入研究企业成功管理之道，直接帮助企业解决业绩增长、成本控制、团队改变这三大问题，被企业家和学员誉为\u201c企业管理者的指南针\u201d。 他培训和辅导过的企业上千家，参与指导和经营的企业也在快速成长和发展。","TeacherPic":"https://yunxue-bucket.oss-cn-shanghai.aliyuncs.com/imgurl/teacher/headimg_1511849559058.jpg","Title":"企业执行力落地实战导师","TeacherType":[{"typename":"通用管理"}],"ID":33,"follow":false,"TeacherName":"周士杰","EnterpriseID":0},{"Description":"互联网＋整合营销学院院长\n上市公司业绩利润倍增系统创始人\n中国学习卡模式创始人\n中国营销学会副会长\n中国中小企业协会副会长\n20年整合营销实战经验","TeacherPic":"https://yunxue-bucket.oss-cn-shanghai.aliyuncs.com/imgurl/teacher/headimg_1512126634541.jpg","Title":"互联网+整合营销学院院长","TeacherType":[{"typename":"市场营销"},{"typename":"职业技能"}],"ID":92,"follow":false,"TeacherName":"周嵘","EnterpriseID":0},{"Description":"小周情感课堂创始人兼首席咨询师\n国家注册心理咨询师\n国家注册婚姻家庭咨询师\n在线情感私董会创始人\n夫妻沟通密码创始人\n智慧女神社群创始人\n国内知名两性婚恋情感咨询专家\n家庭幸福学导师\n心态激励导师\n婚姻规划师","TeacherPic":"https://yunxue-bucket.oss-cn-shanghai.aliyuncs.com/imgurl/teacher/headimg_1512539780628.jpg","Title":"小周情感课堂创始人兼首席咨询师","TeacherType":[{"typename":"家庭教育"}],"ID":113,"follow":false,"TeacherName":"周之尧","EnterpriseID":0},{"Description":"中国当代著名学者、作家、哲学研究者，现为中国社会科学院哲学研究所研究员，是中国研究哲学家尼采的著名学者之一。\n著有:《尼采:在世纪的转折点上》、《尼采与形而上学》，散文集《守望的距离》、《各自的朝圣路》、《安静》、《善良·丰富·高贵》，纪实作品《妞妞:一个父亲的札记》、《岁月与性情--我的心灵自传》、《偶尔远行》、《宝贝，宝贝》，随感集《人与永恒》、《风中的纸屑》、《碎句与短章》，诗集《忧伤的情欲》，以及《人生哲思录》、《周国平人文讲演录》等，译有《尼采美学文选》、《尼采诗集》、《偶像的黄昏》等。","TeacherPic":"https://yunxue-bucket.oss-cn-shanghai.aliyuncs.com/imgurl/teacher/headimg_1512385586223.jpg","Title":"中国当代著名学者、作家、哲学研究者","TeacherType":[{"typename":"国学人文"},{"typename":"生活方式"}],"ID":111,"follow":false,"TeacherName":"周国平","EnterpriseID":0}]}
     * message : Succes!
     */

    private int code;
    private BodyBean body;
    private String message;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public BodyBean getBody() {
        return body;
    }

    public void setBody(BodyBean body) {
        this.body = body;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public static class BodyBean {
        /**
         * Description : 云学创始合伙人
         世华智业投资集团董事
         大爱堂书院执行院长
         世华大学长青学院导师
         * TeacherPic : https://yunxue-bucket.oss-cn-shanghai.aliyuncs.com/imgurl/teacher/headimg_1512116476817.jpg
         * Title : 世华大学长青学院导师
         * TeacherType : [{"typename":"通用管理"},{"typename":"家庭教育"}]
         * ID : 65
         * follow : false
         * TeacherName : 华创
         * EnterpriseID : 0
         */

        private List<ResultBean> result;

        public List<ResultBean> getResult() {
            return result;
        }

        public void setResult(List<ResultBean> result) {
            this.result = result;
        }

        public static class ResultBean implements Serializable{
            private String Description;
            private String TeacherPic;
            private String Title;
            private int ID;
            private boolean follow;
            private String TeacherName;
            private int EnterpriseID;
            public boolean isSelect = false;

            public boolean isSelect() {
                return isSelect;
            }

            public void setSelect(boolean select) {
                isSelect = select;
            }

            /**
             * typename : 通用管理
             */

            private List<TeacherTypeBean> TeacherType;

            public String getDescription() {
                return Description;
            }

            public void setDescription(String Description) {
                this.Description = Description;
            }

            public String getTeacherPic() {
                return TeacherPic;
            }

            public void setTeacherPic(String TeacherPic) {
                this.TeacherPic = TeacherPic;
            }

            public String getTitle() {
                return Title;
            }

            public void setTitle(String Title) {
                this.Title = Title;
            }

            public int getID() {
                return ID;
            }

            public void setID(int ID) {
                this.ID = ID;
            }

            public boolean isFollow() {
                return follow;
            }

            public void setFollow(boolean follow) {
                this.follow = follow;
            }

            public String getTeacherName() {
                return TeacherName;
            }

            public void setTeacherName(String TeacherName) {
                this.TeacherName = TeacherName;
            }

            public int getEnterpriseID() {
                return EnterpriseID;
            }

            public void setEnterpriseID(int EnterpriseID) {
                this.EnterpriseID = EnterpriseID;
            }

            public List<TeacherTypeBean> getTeacherType() {
                return TeacherType;
            }

            public void setTeacherType(List<TeacherTypeBean> TeacherType) {
                this.TeacherType = TeacherType;
            }

            public static class TeacherTypeBean implements Serializable {
                private String typename;

                public String getTypename() {
                    return typename;
                }

                public void setTypename(String typename) {
                    this.typename = typename;
                }
            }
        }
    }
}

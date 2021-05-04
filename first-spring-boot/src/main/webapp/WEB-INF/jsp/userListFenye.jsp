<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>员工列表页</title>
    <script src="js/vue.js" type="text/javascript" charset="utf-8"></script>
    <script src="js/vue-resource.js" type="text/javascript" charset="utf-8"></script>
</head>
<body>
员工列表页：
<br/>
<br/>
<div id="one">

    名称： <input type="text" v-model="name"/>
    <input type="button" value="添加"/><br/>
    <br/>
    <table border="2" cellspacing="0" width="70%">
        <tr>
            <th>ID</th>
            <td>名称</td>
            <th>时间</th>
            <td>操作</td>
        </tr>
        <tr v-for="user in dataShow" :key="user.id">
            <td>{{user.id}}</td>
            <td v-text="user.name"></td>
            <td>{{user.birdate}}</td>
            <!-- 阻止超级连接执行默认方法用.prevent -->
            <td><a href="" @click.prevent="del(user.id)">删除</a></td>
        </tr>
    </table>


    共{{page}}条
    共{{pageNum}}页&nbsp;
    当前第{{currentPage}}页
    <input type="button" value="上一页" @click="prePage"/>
    <input type="button" value="下一页" @click="nextPage"/>


</div>
<script type="application/javascript">

    var path = '<%=basePath%>';
    <!--配置了根目录，下面的RUL就不用写了-->
    Vue.http.options.root = path;
    var vm = new Vue({
        el: '#one',
        data: {
            name: '',
            list: [],

            //========分页===========
            pageSize: 5,//每页显示的数量
            pageNum: 1,//共几页
            dataShow: "",//当前显示的数据
            currentPage: 0,
            page: 0//总条数
            //=====================

        },
        methods: {
            getUserList() {
                <!--请求里不要加/   因为path带/  也会引起访问跨域-->
                //this.$http.get('/userControl/getUserList.action').then(
                <!--正确定法-->
                this.$http.get('userControl/getUserList.action').then(
                    function (result) {
                        console.log("成功");


                        if (result.body.sta == "1") {

                            //========分页======================
                            this.pageNum = Math.ceil(result.body.list.length / this.pageSize) || 1;
                            for (let i = 0; i < this.pageNum; i++) {
                                this.list[i] = result.body.list.slice(this.pageSize * i, this.pageSize * (i + 1))
                            }
                            this.page = result.body.list.length;
                            this.dataShow = this.list[this.currentPage];
                            //this.list=result.body.list;

                            //========分页======================
                        }


                    },
                    function (result) {
                        console.log("失败");

                    }
                )
            },
            del(id) {

                this.$http.get('userControl/delUser.action?id=' + id).then(
                    function (result) {
                        console.log("成功");


                        if (result.body.sta == "1") {

                            this.getUserList();
                        }
                    },
                    function (result) {
                        console.log("失败");

                    }
                )

            },

            //========分页======================
            // 下一页
            nextPage() {

                if (this.currentPage == this.pageNum - 1) return;
                this.dataShow = this.list[++this.currentPage];
            },

            // 上一页
            prePage() {
                if (this.currentPage == 0) return;
                this.dataShow = this.list[--this.currentPage];
            }
            //==============================

        },

        created() {
            //一进入页面就执行这个方法
            this.getUserList();
        }

    })

</script>


</body>
</html>
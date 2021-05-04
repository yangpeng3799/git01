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
        <tr v-for="user in list" :key="user.id">
            <td>{{user.id}}</td>
            <td v-text="user.name"></td>
            <td>{{user.birdate}}</td>
            <!-- 阻止超级连接执行默认方法用.prevent -->
            <td><a href="" @click.prevent="del(user.id)">删除</a></td>
        </tr>
    </table>
</div>
<script type="application/javascript">

    var path = '<%=basePath%>';
    <!--配置了根目录，下面的RUL就不用写了-->
    Vue.http.options.root = path;
    var vm = new Vue({
        el: '#one',
        data: {
            name: '',
            list: [{id: 1, name: '张大', time: new Date()},
                {id: 2, name: '张二', time: new Date()},
                {id: 3, name: '张三', time: new Date()}
            ]
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

                            this.list = result.body.list;
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

            }

        },
        created() {
            this.getUserList();
        }
    })

</script>


</body>
</html>
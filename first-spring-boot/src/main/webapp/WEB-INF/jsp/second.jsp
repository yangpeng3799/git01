<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2020/9/21
  Time: 16:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title></title>
</head>
<body>
<div id="one">
    <input type="text" v-model="id">
    <input type="text" v-model="name" @keyup.enter="add">
    <input type="button" value="添加" @click="add">
    查询关键字<input type="text" v-model="gjz" v-focus>
    查询关键字<input type="text" v-red="'red'">
    <!--<input type="text" v-model="gjz" v-focus="'red'">-->
    </br>
    <table border="2" cellspacing="0" width="70%">
        <tr>
            <th>id</th>
            <th>name</th>
            <th>时间</th>
            <th>操作</th>
        </tr>
        <tr v-for="user in cha(gjz)" :key="user.id">
            <th>{{user.id}}</th>
            <th v-text="user.name"></th>
            <th>{{user.time}}</th>
            <th @click="delect">删除</th>
        </tr>
    </table>
    {{msg|firstfilter('女','人')|test}}
    {{mgg|secondfilter}}
</div>
<script type="text/javascript" src="js/vue.js"></script>
<script>
    Vue.directive('focus', {
        // 当被绑定的元素插入到 DOM 中时……
        inserted: function (el, binding) {
            // 聚焦元素
            el.focus();
            el.style.color = 'pink';
            //el.style.color=binding.value;
        }
    });

    Vue.directive('red', {
        inserted: function (el, binding) {
            el.focus();
            el.style.color = binding.value;
        }
    });


    Vue.filter('firstfilter', function (msg, arg0, arg1) {
        return msg.replace(/男人/g, arg0 + arg1);
    });
    Vue.filter('test', function (msg) {
        return msg + '~';
    });
    Vue.filter('secondfilter', function (msg) {
        var date = new Date(msg);
        var y = date.getFullYear();
        var m = (date.getMonth()).toString().padStart(2, '0');
        ;
        var d = (date.getDate()).toString().padStart(2, '0');
        ;

        var hh = (date.getHours()).toString().padStart(2, '0');
        var mm = (date.getMinutes()).toString().padStart(2, '0');
        var ss = (date.getSeconds()).toString().padStart(2, '0');
        return `${y}-${m}-${d} ${hh}-${mm}-${ss}`;
    });
    var o = new Vue({
        el: '#one',
        data: {
            id: "",
            name: "",
            gjz: "",
            list: [
                {id: 1, name: 'a', time: new Date()},
                {id: 2, name: 'b', time: new Date()},
                {id: 3, name: 'c', time: new Date()},
                {id: 4, name: 'd', time: new Date()}
            ],
            msg: "魔镜,魔镜,谁是这个世界上最美丽的男人,男人,男人！",
            mgg: new Date()
        },
        methods: {
            add() {
                var tj = {id: this.id, name: this.name, time: new Date()};
                this.list.push(tj);
            },
            delect(id) {
                var i = this.list.findIndex(user => {
                    if (user.id == id) {
                        return true;
                    }
                })
                this.list.splice(i, 1);
            },
            cha(gjz) {
                var newList = [];
                this.list.forEach(user => {
                    if (user.name.indexOf(gjz) != -1) {
                        newList.push(user);
                    }
                })
                return newList;
            }
        }
//				directives : {
//					'red': {
//							inserted: function (el) {
//	    					el.focus();
//						}
//					}
//				}
    });

</script>


</body>
</html>

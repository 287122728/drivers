<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../common/taglibs.jsp" %>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="renderer" content="webkit">

    <%--<link rel="shortcut icon" type="image/x-icon" href="${ctx}/images/icon.ico" media="screen" />--%>
    <%--<link rel="stylesheet" type="text/css" charset="UTF-8" href="${ctx}/css/dhccbs3.min.css">--%>
    <link rel="stylesheet" type="text/css" charset="UTF-8" href="${ctx}/plugins/bootstrap/dist/css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" charset="UTF-8" href="${ctx}/plugins/bootstrap-submenu/dist/css/bootstrap-submenu.min.css">
    <link rel="stylesheet" type="text/css" charset="UTF-8" href="${ctx}/css/index.css">
    <!--[if lt IE 9]>
    <script src="./js/lib/pre/html5shiv.min.js"></script>
    <script src="./js/lib/pre/respond.min.js"></script>
    <![endif]-->
    <title></title>
</head>
<body>
<div class="container-fluid">
    <div id="app">
        <h1>Hello App！</h1>
        <p>
            <!-- use v-link directive for navigation. -->
            <a v-link="{ path: '/foo' }">Go to Foo</a>
            <a v-link="{ path: '/bar' }">Go to Bar</a>
        </p>

        <!-- use router-view element as route outlet -->
        <router-view></router-view>
    </div>
</div>

<script src="${ctx}/plugins/jquery/dist/jquery.min.js" type="text/javascript"></script>
<script src="${ctx}/plugins/bootstrap/dist/js/bootstrap.min.js" type="text/javascript"></script>
<script src="${ctx}/plugins/bootstrap-submenu/dist/js/bootstrap-submenu.min.js" type="text/javascript"></script>
<script src="${ctx}/plugins/vue/dist/vue.min.js" type="text/javascript"></script>
<script src="${ctx}/plugins/vue-router/dist/vue-router.min.js" type="text/javascript"></script>
<script src="${ctx}/js/index.js" type="text/javascript"></script>
<script>
    // Define some components
    var Foo = Vue.extend({
        template: '/1.jsp',

    })

    var Bar = Vue.extend({
        template: '<p>This is bar!</p>'
    })

    // The router needs a root component to render.
    // For demo purposes, we will just use an empty one
    // because we are using the HTML as the app template.
    var App = Vue.extend({})

    // Create a router instance.
    // You can pass in additional options here, but let's
    // keep it simple for now.
    var router = new VueRouter()

    // Define some routes.
    // Each route should map to a component. The "component" can
    // either be an actual component constructor created via
    // Vue.extend(), or just a component options object.
    // We'll talk about nested routes later.
    router.redirect({
        '/foo': '/vue1'
    });
    router.map({
//        '/foo': {
//            component: Foo
//        },
        '/bar': {
            component: Bar
        }
    })

    // Now we can start the app!
    // The router will create an instance of App and mount to
    // the element matching the selector #app.
    router.start(App, '#app')
</script>
</body>

</html>
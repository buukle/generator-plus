(window["webpackJsonp"]=window["webpackJsonp"]||[]).push([["chunk-2d0aa1b9"],{1037:function(t,e,n){"use strict";n.r(e);var r=function(){var t=this,e=t.$createElement,n=t._self._c||e;return n("a-result",{attrs:{isSuccess:!0,content:!1,title:t.email,"sub-title":t.description},scopedSlots:t._u([{key:"extra",fn:function(){return[n("a-button",{attrs:{size:"large",type:"primary"}},[t._v("查看邮箱")]),n("a-button",{staticStyle:{"margin-left":"8px"},attrs:{size:"large"},on:{click:t.goHomeHandle}},[t._v("返回首页")])]},proxy:!0}])})},a=[],o={name:"RegisterResult",data:function(){return{description:"激活邮件已发送到你的邮箱中，邮件有效期为24小时。请及时登录邮箱，点击邮件中的链接激活帐户。",form:{}}},computed:{email:function(){var t=this.form&&this.form.email||"xxx";return"你的账 户：".concat(t," 注册成功")}},created:function(){this.form=this.$route.params},methods:{goHomeHandle:function(){this.$router.push({name:"login"})}}},i=o,s=n("2877"),c=Object(s["a"])(i,r,a,!1,null,"426c6ab1",null);e["default"]=c.exports}}]);
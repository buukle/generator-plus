(window["webpackJsonp"]=window["webpackJsonp"]||[]).push([["chunk-2152ea5a"],{4706:function(t,e,a){"use strict";a("b945")},"6d90":function(t,e,a){"use strict";a.r(e);var s=function(){var t=this,e=t.$createElement,a=t._self._c||e;return a("page-header-wrapper",{scopedSlots:t._u([{key:"content",fn:function(){return[a("div",{staticClass:"page-header-content"},[a("div",{staticClass:"avatar"},[a("a-avatar",{attrs:{size:"large",src:t.currentUser.avatar}})],1),a("div",{staticClass:"content"},[a("div",{staticClass:"content-title"},[a("span",{staticClass:"welcome-text"},[t._v(t._s(t.welcome))])]),a("div",[t._v(t._s(t.user.name)+" | 布壳儿 - buukle")])])])]},proxy:!0},{key:"extraContent",fn:function(){return[a("div",{staticClass:"extra-content"},[a("div",{staticClass:"stat-item"},[a("a-statistic",{attrs:{title:"连接数",value:1}})],1),a("div",{staticClass:"stat-item"},[a("a-statistic",{attrs:{title:"模板数",value:1,suffix:"/ 24"}})],1),a("div",{staticClass:"stat-item"},[a("a-statistic",{attrs:{title:"配置数",value:2}})],1),a("div",{staticClass:"stat-item"},[a("a-statistic",{attrs:{title:"生成日志数",value:2}})],1)])]},proxy:!0}])})},n=[],r=a("5530"),i=a("5880"),c=a("c0d2"),u=a("2af9"),o={name:"workplace",components:{PageHeaderWrapper:c["b"],Radar:u["b"]},data:function(){return{}},computed:Object(r["a"])(Object(r["a"])({},Object(i["mapState"])({nickname:function(t){return t.user.nickname},welcome:function(t){return t.user.welcome}})),{},{currentUser:function(){return{name:"BUUKLE",avatar:""}},userInfo:function(){return this.$store.getters.userInfo}}),created:function(){this.user=this.userInfo,this.avatar=this.userInfo.avatar},mounted:function(){}},l=o,f=(a("4706"),a("2877")),d=Object(f["a"])(l,s,n,!1,null,"df361ef6",null);e["default"]=d.exports},b945:function(t,e,a){}}]);
(window["webpackJsonp"]=window["webpackJsonp"]||[]).push([["chunk-5142bdf8","chunk-2d0b1f68","chunk-2d22294c"],{"0fea":function(t,e,a){"use strict";a.d(e,"a",(function(){return s}));var o=a("b775"),n={user:"/user",role:"/role",permission:"/permission",permissionNoPager:"/permission/no-pager",orgTree:"/org/tree"};function s(t){return Object(o["b"])({url:n.role,method:"get",params:t})}},"21a4":function(t,e,a){"use strict";a.r(e);var o=function(){var t=this,e=t.$createElement,a=t._self._c||e;return a("a-modal",{attrs:{destroyOnClose:!0,width:900,height:600,visible:t.visible,title:t.getTitle(t.initvalue)},model:{value:t.visible,callback:function(e){t.visible=e},expression:"visible"}},[a("div",{staticClass:"main"},[a("a-form-model",{ref:"form",attrs:{layout:t.formLayout,model:t.form,rules:t.rules}},[a("a-form-model-item",{directives:[{name:"show",rawName:"v-show",value:!1,expression:"false"}],attrs:{label:"id",prop:"id","label-col":t.formItemLayout.labelCol,"wrapper-col":t.formItemLayout.wrapperCol}},[a("a-input",{model:{value:t.form.id,callback:function(e){t.$set(t.form,"id",e)},expression:"form.id"}})],1),a("a-form-model-item",{attrs:{label:"模板名称",prop:"name","label-col":t.formItemLayout.labelCol,"wrapper-col":t.formItemLayout.wrapperCol}},[a("a-input",{attrs:{placeholder:"请输入模板名称"},model:{value:t.form.name,callback:function(e){t.$set(t.form,"name",e)},expression:"form.name"}}),a("span",{staticStyle:{color:"grey","font-size":"12px","line-height":"1px"}},[t._v("请按照 A.B.btl 填写,生成文件的时候会截取 B 的值作为文件后缀名 (例如 : Entity.java.btl ,生成的文件是 : 表名大驼峰.java) ")])],1),a("a-form-model-item",{attrs:{label:"工程路径",prop:"path","label-col":t.formItemLayout.labelCol,"wrapper-col":t.formItemLayout.wrapperCol}},[a("a-input",{attrs:{placeholder:"请输入工程路径"},model:{value:t.form.path,callback:function(e){t.$set(t.form,"path",e)},expression:"form.path"}})],1),a("a-form-model-item",{attrs:{label:"包名",prop:"packageInfo","label-col":t.formItemLayout.labelCol,"wrapper-col":t.formItemLayout.wrapperCol}},[a("a-input",{attrs:{placeholder:"请输入包名"},model:{value:t.form.packageInfo,callback:function(e){t.$set(t.form,"packageInfo",e)},expression:"form.packageInfo"}}),a("span",{staticStyle:{color:"grey","font-size":"12px","line-height":"1px"}},[t._v("后端代码使用,前端代码若无包名需求可不填写(模板中使用${packageInfo} 获取该值)")])],1),a("a-form-model-item",{attrs:{label:"模板内容",prop:"name","label-col":t.formItemLayout.labelCol,"wrapper-col":t.formItemLayout.wrapperCol}},[a("a-textarea",{staticStyle:{"background-color":"#e6e6e6",color:"black",border:"0px","margin-top":"25px","-webkit-appearance":"none",padding:"15px"},attrs:{rows:"20",cols:"20",placeholder:"请输入模板内容"},model:{value:t.form.content,callback:function(e){t.$set(t.form,"content",e)},expression:"form.content"}})],1),a("a-form-model-item",{attrs:{label:"备注",prop:"remark","label-col":t.formItemLayout.labelCol,"wrapper-col":t.formItemLayout.wrapperCol}},[a("a-input",{attrs:{placeholder:"请输入备注"},model:{value:t.form.remark,callback:function(e){t.$set(t.form,"remark",e)},expression:"form.remark"}})],1)],1)],1),a("template",{slot:"footer"},[a("a-button",{attrs:{type:"primary"},on:{click:function(e){return t.handleEdit()}}},[t._v(" 提交 ")]),a("a-button",{on:{click:function(e){return t.handleClose()}}},[t._v(" 取消 ")])],1)],2)},n=[],s=a("2410"),r=a.n(s),l=a("b775"),i=a("f64c"),c={labelCol:{span:5},wrapperCol:{span:16}},p={components:{},props:{initvalue:{type:Object,default:null}},watch:{initvalue:function(){if(this.initvalue)for(var t in this.initvalue)this.form[t]=this.initvalue[t];else this.form=r()(this.initForm)}},methods:{getTitle:function(t){var e=this.$createElement;return e("span",t?[" 编辑 ",e("span",{style:"color: red;font-size: 12px;"},[" * 注 : 当前只兼容 beetl 模板语法 "])]:[" 新建 ",e("span",{style:"color: red;font-size: 12px;"},[" * 注 : 当前只兼容 beetl 模板语法 "])])},show:function(){this.visible=!0},handleClose:function(){this.form=r()(this.initForm),this.form.param="",this.visible=!1},handleEdit:function(){var t=this;this.$refs.form.validate((function(e){if(e){t.commonRequest.head.operationTime=Date.now(),t.commonRequest.body=t.form;var a=t.commonRequest;Object(l["b"])({url:"/templates/addOrEdit",method:"post",dataType:"json",data:a}).then((function(e){"S"===e.head.status?(i["a"].success(e.head.msg),t.handleClose(),t.$emit("refresh")):i["a"].error(e.head.msg)})).catch((function(t){console.log(t)}))}}))}},data:function(){return{visible:!1,formLayout:"horizontal",formItemLayout:c,form:{id:null,name:"",path:"",packageInfo:"",content:"",type:"",remark:""},initForm:{id:null,name:"",path:"",packageInfo:"",content:"",type:"",remark:""},rules:{name:[{required:!0,message:"请输入"},{max:50,message:"最多输入50个字符"},{pattern:/^(?!(\s+$))/,message:"输入格式错误"}],path:[{required:!0,message:"请输入"},{max:256,message:"最多输入256个字符"}],url:[{required:!0,message:"请输入"},{max:256,message:"最多输入256个字符"}],username:[{required:!0,message:"请输入"},{max:16,message:"最多输入16个字符"}],password:[{required:!0,message:"请输入"},{max:16,message:"最多输入16个字符"}]},commonRequest:{head:{operationTime:Date.now()},body:{}}}}},m=p,u=a("2877"),d=Object(u["a"])(m,o,n,!1,null,null,null);e["default"]=d.exports},"8de8":function(t,e,a){"use strict";a.r(e);var o=function(){var t=this,e=t.$createElement,a=t._self._c||e;return a("a-card",{attrs:{bordered:!1}},[a("span",[t._v(" 敬请期待 ... ...")])])},n=[],s=(a("b0c0"),a("2af9")),r=a("0fea"),l=a("b775"),i=a("f64c"),c=a("21a4"),p=a("cee9"),m=a("c1df"),u=a.n(m);i["a"].config({duration:3,top:"40px",maxCount:3});var d={name:"TemplatesList",components:{InfoTable:p["default"],STable:s["c"],Ellipsis:s["a"],AddOrEditForm:c["default"]},methods:{refresh:function(){this.$refs.table.refresh(!0)},handleSearch:function(){this.$refs.table.pagination.pageNo=1,this.$refs.table.refresh(!0)},handleEdit:function(t){var e=this;Object(l["b"])({url:"/templates/templatesCrudViewFront?id="+t,method:"post",dataType:"json"}).then((function(t){"S"===t.head.status?(e.initvalue=t.body,e.$refs.AddOrEditForm.show()):i["a"].error(t.head.msg)})).catch((function(t){console.log(t)}))},handleAdd:function(){this.initvalue=null,this.$refs.AddOrEditForm.show()},handleDelete:function(t){var e=this.$refs.table;this.$confirm({title:"确认提示",content:"是否删除该条记录？",okType:"danger",okText:"确认",cancelText:"取消",onOk:function(){Object(l["b"])({url:"/templates/templatesCrudJson?id="+t,method:"post"}).then((function(t){"S"===t.head.status?(i["a"].success("成功!"),e.refresh()):i["a"].error(t.head.msg)}))}})},handleInfo:function(t){var e=this;Object(l["b"])({url:"/templates/templatesCrudViewFront?id="+t,method:"post",dataType:"json"}).then((function(t){"S"===t.head.status?(e.initvalue=t.body,e.$refs.InfoTable.show()):i["a"].error(t.head.msg)})).catch((function(t){console.log(t)}))},handleBan:function(t){0!==t.status?this.$message.info("".concat(t.name," 已停用")):this.$message.error("".concat(t.name," 停用失败"))},onSelectChange:function(t,e){this.selectedRowKeys=t,this.selectedRows=e},toggleAdvanced:function(){this.advanced=!this.advanced},gmtDateFormat:function(t){return u()(t).format("yyyy-MM-DD HH:mm:ss")}},data:function(){var t=this;return this.columns=f,{initvalue:{},visible:!1,confirmLoading:!1,dialogFormVisible:!1,mdl:null,advanced:!1,queryParam:{},loadData:function(e){var a=Object.assign({},e,t.queryParam);return Object(l["b"])({url:"/templates/templatesPageJson",method:"get",params:a}).then((function(t){return t.result}))},selectedRowKeys:[],selectedRows:[]}},filters:{statusFilter:function(t){return h[t].text},statusTypeFilter:function(t){return h[t].status}},created:function(){Object(r["a"])({t:new Date})},computed:{rowSelection:function(){return{selectedRowKeys:this.selectedRowKeys,onChange:this.onSelectChange}}}},f=[{title:"#",width:"5%",scopedSlots:{customRender:"serial"}},{title:"模板名称",width:"40%",dataIndex:"name",scopedSlots:{customRender:"name"},needTotal:!0},{title:"创建时间",width:"15%",dataIndex:"gmtCreated",scopedSlots:{customRender:"gmtCreated"}},{title:"创建者",dataIndex:"creator",width:"5%"},{title:"状态",dataIndex:"status",width:"5%",scopedSlots:{customRender:"status"}},{title:"操作",dataIndex:"action",width:"30%",scopedSlots:{customRender:"action"}}],h={1:{status:"default",text:"创建完成"},2:{status:"processing",text:"审批中"},3:{status:"success",text:"正常"},4:{status:"warning",text:"已禁用"}},g=d,b=a("2877"),v=Object(b["a"])(g,o,n,!1,null,null,null);e["default"]=v.exports},cee9:function(t,e,a){"use strict";a.r(e);var o=function(){var t=this,e=t.$createElement,a=t._self._c||e;return a("a-modal",{attrs:{destroyOnClose:!0,width:900,height:600,visible:t.visible,title:t.getTitle(t.initvalue)},model:{value:t.visible,callback:function(e){t.visible=e},expression:"visible"}},[a("div",{staticClass:"main"},[[a("div",[a("a-row",{attrs:{type:"flex"}},[a("a-col",{staticStyle:{"margin-top":"5px"},attrs:{span:12}},[a("a-col",{attrs:{span:6,align:"right"}},[a("span",[t._v("模板名称:")])]),a("a-col",{staticStyle:{"padding-left":"10px"},attrs:{span:18}},[a("span",[t._v(" "+t._s(t.initvalue.name)+" ")])])],1),a("a-col",{staticStyle:{"margin-top":"5px"},attrs:{span:12}},[a("a-col",{attrs:{span:6,align:"right"}},[a("span",[t._v("工程路径:")])]),a("a-col",{staticStyle:{"padding-left":"10px"},attrs:{span:18}},[a("span",[t._v(" "+t._s(t.initvalue.path)+" ")])])],1),a("a-col",{staticStyle:{"margin-top":"5px"},attrs:{span:12}},[a("a-col",{attrs:{span:6,align:"right"}},[a("span",[t._v("包名:")])]),a("a-col",{staticStyle:{"padding-left":"10px"},attrs:{span:18}},[a("span",[t._v(" "+t._s(t.initvalue.packageInfo)+" ")])])],1),a("a-col",{staticStyle:{"margin-top":"5px"},attrs:{span:12}},[a("a-col",{attrs:{span:6,align:"right"}},[a("span",[t._v("创建者:")])]),a("a-col",{staticStyle:{"padding-left":"10px"},attrs:{span:18}},[a("span",[t._v(" "+t._s(t.initvalue.creator)+" ")])])],1),a("a-col",{staticStyle:{"margin-top":"5px"},attrs:{span:12}},[a("a-col",{attrs:{span:6,align:"right"}},[a("span",[t._v("创建时间:")])]),a("a-col",{staticStyle:{"padding-left":"10px"},attrs:{span:18}},[a("span",[t._v(" "+t._s(t.gmtDateFormat(t.initvalue.gmtCreated))+" ")])])],1),a("a-col",{staticStyle:{"margin-top":"5px"},attrs:{span:12}},[a("a-col",{attrs:{span:6,align:"right"}},[a("span",[t._v("更新者:")])]),a("a-col",{staticStyle:{"padding-left":"10px"},attrs:{span:18}},[a("span",[t._v(" "+t._s(t.initvalue.modifier)+" ")])])],1),a("a-col",{staticStyle:{"margin-top":"5px"},attrs:{span:12}},[a("a-col",{attrs:{span:6,align:"right"}},[a("span",[t._v("更新时间:")])]),a("a-col",{staticStyle:{"padding-left":"10px"},attrs:{span:18}},[a("span",[t._v(" "+t._s(t.gmtDateFormat(t.initvalue.gmtModified))+" ")])])],1),a("a-col",{staticStyle:{"margin-top":"5px"},attrs:{span:24}},[a("a-col",{attrs:{span:3,align:"right"}},[a("span",[t._v("模板内容:")])]),a("a-col",{staticStyle:{"padding-left":"10px"},attrs:{span:21}},[a("a-textarea",{staticStyle:{"background-color":"#e6e6e6",color:"black",border:"0px",cursor:"text","margin-top":"25px","-webkit-appearance":"none","border-radius":"0",padding:"15px"},attrs:{disabled:"",rows:"20",cols:"20",placeholder:""},model:{value:t.initvalue.content,callback:function(e){t.$set(t.initvalue,"content",e)},expression:"initvalue.content"}})],1)],1),a("a-col",{staticStyle:{"margin-top":"5px"},attrs:{span:24}},[a("a-col",{attrs:{span:3,align:"right"}},[a("span",[t._v("备注:")])]),a("a-col",{staticStyle:{"padding-left":"10px"},attrs:{span:21}},[a("span",[t._v(" "+t._s(t.initvalue.remark)+" ")])])],1)],1)],1)]],2),a("template",{slot:"footer"},[a("a-button",{on:{click:function(e){return t.handleClose()}}},[t._v(" 返回 ")])],1)],2)},n=[],s=a("c1df"),r=a.n(s),l={labelCol:{span:5},wrapperCol:{span:16}},i={methods:{getTitle:function(t){var e=this.$createElement;return e("span",[" 详情 ",e("span",{style:"color: red;font-size: 12px;"},[" * 注 : 当前只兼容 beetl 模板语法 "])])},show:function(){this.visible=!0},handleClose:function(){this.visible=!1},gmtDateFormat:function(t){return r()(t).format("yyyy-MM-DD HH:mm:ss")}},props:{initvalue:{type:Object,default:null}},data:function(){return{visible:!1,formItemLayout:l}}},c=i,p=a("2877"),m=Object(p["a"])(c,o,n,!1,null,null,null);e["default"]=m.exports}}]);
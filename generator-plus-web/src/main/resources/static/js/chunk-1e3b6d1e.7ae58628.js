(window["webpackJsonp"]=window["webpackJsonp"]||[]).push([["chunk-1e3b6d1e","chunk-b24d8342","chunk-2d0d064f"],{2702:function(t,e,a){"use strict";a.r(e);var n=function(){var t=this,e=this,a=e.$createElement,n=e._self._c||a;return n("a-card",{attrs:{bordered:!1}},[n("div",{staticClass:"table-page-search-wrapper"},[n("a-form",{attrs:{layout:"inline"}},[n("a-row",{attrs:{gutter:48}},[n("a-col",{attrs:{md:8,sm:24}},[n("a-form-item",{attrs:{label:"id"}},[n("a-input",{attrs:{name:"id",placeholder:""},model:{value:e.queryParam.id,callback:function(t){e.$set(e.queryParam,"id",t)},expression:"queryParam.id"}})],1)],1),n("a-col",{attrs:{md:8,sm:24}},[n("a-form-item",{attrs:{label:"状态"}},[n("a-select",{attrs:{placeholder:"请选择","default-value":"0"},model:{value:e.queryParam.states,callback:function(t){e.$set(e.queryParam,"states",t)},expression:"queryParam.states"}},[n("a-select-option",{attrs:{value:""}},[e._v("全部")]),n("a-select-option",{attrs:{value:"1"}},[e._v("创建完成")]),n("a-select-option",{attrs:{value:"2"}},[e._v("审批中")]),n("a-select-option",{attrs:{value:"3"}},[e._v("正常")]),n("a-select-option",{attrs:{value:"4"}},[e._v("已禁用")])],1)],1)],1),e.advanced?void 0:e._e(),n("a-col",{attrs:{md:e.advanced?24:8,sm:24}},[n("span",{staticClass:"table-page-search-submitButtons",style:e.advanced&&{float:"right",overflow:"hidden"}||{}},[n("a-button",{staticStyle:{"margin-left":"8px"},attrs:{type:"primary"},on:{click:function(t){return e.handleSearch()}}},[e._v("查询")]),n("a-button",{staticStyle:{"margin-left":"8px"},on:{click:function(){return t.queryParam={}}}},[e._v("重置")])],1)])],2)],1)],1),n("s-table",{ref:"table",attrs:{size:"default",rowKey:"id",columns:e.columns,data:e.loadData,alert:!0,rowSelection:e.rowSelection,pagination:{showTotal:function(t){return"共 "+t+" 条记录"}}},scopedSlots:e._u([{key:"serial",fn:function(t,a,s){return n("span",{},[e._v(" "+e._s(s+1)+" ")])}},{key:"status",fn:function(t){return n("span",{},[n("a-badge",{attrs:{status:e._f("statusTypeFilter")(t),text:e._f("statusFilter")(t)}})],1)}},{key:"name",fn:function(t){return n("span",{},[n("ellipsis",{attrs:{length:16,tooltip:""}},[e._v(e._s(t))])],1)}},{key:"gmtCreated",fn:function(t){return n("span",{},[n("ellipsis",{attrs:{length:64,tooltip:""}},[e._v(e._s(e.gmtDateFormat(t)))])],1)}},{key:"action",fn:function(t,a){return n("span",{},[[n("a",{on:{click:function(t){return e.handleDelete(a.id)}}},[e._v("删除")]),e._v("  "),n("a",{on:{click:function(t){return e.handleInfo(a.id)}}},[e._v("详情")]),e._v("  "),6===a.status?n("a",{attrs:{href:a.url,download:"archetype-gen.zip"}},[e._v("下载")]):e._e()]],2)}}])}),n("AddOrEditForm",{ref:"AddOrEditForm",attrs:{initvalue:e.initvalue},on:{refresh:e.refresh}}),n("InfoTable",{ref:"InfoTable",attrs:{initvalue:e.initvalue},on:{refresh:e.refresh}})],1)},s=[],o=(a("b0c0"),a("2af9")),l=a("b775"),i=a("f64c"),r=a("c7f6"),u=a("6890"),c=a("c1df"),d=a.n(c);i["a"].config({duration:3,top:"40px",maxCount:3});var m={name:"ArchetypesExecuteList",components:{InfoTable:u["default"],STable:o["c"],Ellipsis:o["a"],AddOrEditForm:r["default"]},methods:{refresh:function(){this.$refs.table.refresh(!0)},handleSearch:function(){this.$refs.table.pagination.pageNo=1,this.$refs.table.refresh(!0)},handleAdd:function(){this.initvalue={},this.$refs.AddOrEditForm.show()},handleDelete:function(t){var e=this.$refs.table;this.commonRequest.head.operationTime=Date.now(),this.bodyById.id=t,this.commonRequest.body=this.bodyById;var a=this.commonRequest;this.$confirm({title:"确认提示",content:"是否删除该条记录？",okType:"danger",okText:"确认",cancelText:"取消",onOk:function(){Object(l["b"])({url:"/archetypesExecute/deleteById",method:"post",dataType:"json",data:a}).then((function(t){"S"===t.head.status?(i["a"].success("成功!"),e.refresh()):i["a"].error(t.head.msg)}))}})},handleEdit:function(t){var e=this;this.commonRequest.head.operationTime=Date.now(),this.bodyById.id=t,this.commonRequest.body=this.bodyById;var a=this.commonRequest;Object(l["b"])({url:"/archetypesExecute/getById",method:"post",dataType:"json",data:a}).then((function(t){"S"===t.head.status?(e.initvalue=t.body,e.$refs.AddOrEditForm.show()):i["a"].error(t.head.msg)})).catch((function(t){console.log(t)}))},handleInfo:function(t){var e=this;this.commonRequest.head.operationTime=Date.now(),this.bodyById.id=t,this.commonRequest.body=this.bodyById;var a=this.commonRequest;Object(l["b"])({url:"/archetypesExecute/getById",method:"post",dataType:"json",data:a}).then((function(t){"S"===t.head.status?(e.initvalue=t.body,e.$refs.InfoTable.show()):i["a"].error(t.head.msg)})).catch((function(t){console.log(t)}))},handleBan:function(t){0!==t.status?this.$message.info("".concat(t.name," 已停用")):this.$message.error("".concat(t.name," 停用失败"))},onSelectChange:function(t,e){this.selectedRowKeys=t,this.selectedRows=e},toggleAdvanced:function(){this.advanced=!this.advanced},gmtDateFormat:function(t){return d()(t).format("yyyy-MM-DD HH:mm:ss")}},data:function(){var t=this;return this.columns=f,{initvalue:{},visible:!1,confirmLoading:!1,dialogFormVisible:!1,mdl:null,advanced:!1,queryParam:{},commonRequest:{head:{operationTime:Date.now()},body:{}},bodyById:{id:0},loadData:function(e){var a=Object.assign({},e,t.queryParam);t.commonRequest.head.operationTime=Date.now(),t.commonRequest.body=a;var n=t.commonRequest;return Object(l["b"])({url:"/archetypesExecute/getPage",method:"post",dataType:"json",data:n}).then((function(t){return t.result}))},selectedRowKeys:[],selectedRows:[]}},filters:{statusFilter:function(t){return p[t].text},statusTypeFilter:function(t){return p[t].status}},created:function(){},computed:{rowSelection:function(){return{selectedRowKeys:this.selectedRowKeys,onChange:this.onSelectChange}}}},f=[{title:"序号",width:"5%",scopedSlots:{customRender:"serial"}},{title:"archetype名称",width:"25%",dataIndex:"name"},{title:"artifactId",width:"10%",dataIndex:"artifactId"},{title:"groupId",width:"10%",dataIndex:"groupId"},{title:"version",width:"10%",dataIndex:"version"},{title:"创建时间",width:"10%",dataIndex:"gmtCreated",scopedSlots:{customRender:"gmtCreated"}},{title:"执行状态",dataIndex:"status",width:"10%",scopedSlots:{customRender:"status"}},{title:"操作",dataIndex:"action",width:"20%",scopedSlots:{customRender:"action"}}],p={1:{status:"default",text:"创建完成"},2:{status:"processing",text:"审批中"},3:{status:"success",text:"正常"},4:{status:"warning",text:"执行中"},5:{status:"success",text:"执行失败"},6:{status:"success",text:"执行成功"}},h=m,v=a("2877"),y=Object(v["a"])(h,n,s,!1,null,null,null);e["default"]=y.exports},"51f4":function(t,e,a){},6890:function(t,e,a){"use strict";a.r(e);var n=function(){var t=this,e=t.$createElement,a=t._self._c||e;return a("a-modal",{attrs:{destroyOnClose:!0,width:900,height:600,visible:t.visible,title:t.getTitle(t.initvalue)},model:{value:t.visible,callback:function(e){t.visible=e},expression:"visible"}},[a("div",{staticClass:"main"},[[a("div",[a("a-row",{attrs:{type:"flex"}},[a("a-col",{staticStyle:{"margin-top":"5px"},attrs:{span:12}},[a("a-col",{attrs:{span:6,align:"right"}},[a("span",[t._v("名称:")])]),a("a-col",{staticStyle:{"padding-left":"10px"},attrs:{span:18}},[a("span",[t._v(" "+t._s(t.initvalue.name)+" ")])])],1),a("a-col",{staticStyle:{"margin-top":"5px"},attrs:{span:12}},[a("a-col",{attrs:{span:6,align:"right"}},[a("span",[t._v("创建者:")])]),a("a-col",{staticStyle:{"padding-left":"10px"},attrs:{span:18}},[a("span",[t._v(" "+t._s(t.initvalue.creator)+" ")])])],1),a("a-col",{staticStyle:{"margin-top":"5px"},attrs:{span:12}},[a("a-col",{attrs:{span:6,align:"right"}},[a("span",[t._v("创建时间:")])]),a("a-col",{staticStyle:{"padding-left":"10px"},attrs:{span:18}},[a("span",[t._v(" "+t._s(t.gmtDateFormat(t.initvalue.gmtCreated))+" ")])])],1),a("a-col",{staticStyle:{"margin-top":"5px"},attrs:{span:12}},[a("a-col",{attrs:{span:6,align:"right"}},[a("span",[t._v("更新者:")])]),a("a-col",{staticStyle:{"padding-left":"10px"},attrs:{span:18}},[a("span",[t._v(" "+t._s(t.initvalue.modifier)+" ")])])],1),a("a-col",{staticStyle:{"margin-top":"5px"},attrs:{span:12}},[a("a-col",{attrs:{span:6,align:"right"}},[a("span",[t._v("更新时间:")])]),a("a-col",{staticStyle:{"padding-left":"10px"},attrs:{span:18}},[a("span",[t._v(" "+t._s(t.gmtDateFormat(t.initvalue.gmtModified))+" ")])])],1),a("a-col",{staticStyle:{"margin-top":"5px"},attrs:{span:24}},[a("a-col",{attrs:{span:3,align:"right"}},[a("span",[t._v("备注:")])]),a("a-col",{staticStyle:{"padding-left":"10px"},attrs:{span:21}},[a("span",[t._v(" "+t._s(t.initvalue.remark)+" ")])])],1)],1)],1)]],2),a("template",{slot:"footer"},[a("a-button",{on:{click:function(e){return t.handleClose()}}},[t._v(" 返回 ")])],1)],2)},s=[],o=a("c1df"),l=a.n(o),i={labelCol:{span:5},wrapperCol:{span:16}},r={methods:{getTitle:function(t){var e=this.$createElement;return e("span",[" 详情"])},show:function(){this.visible=!0},handleClose:function(){this.visible=!1},gmtDateFormat:function(t){return l()(t).format("yyyy-MM-DD HH:mm:ss")}},props:{initvalue:{type:Object,default:null}},data:function(){return{visible:!1,formItemLayout:i}}},u=r,c=a("2877"),d=Object(c["a"])(u,n,s,!1,null,null,null);e["default"]=d.exports},c7f6:function(t,e,a){"use strict";a.r(e);var n=function(){var t=this,e=t.$createElement,a=t._self._c||e;return a("a-modal",{attrs:{destroyOnClose:!0,width:1080,visible:t.visible,title:t.getTitle(t.initvalue)},model:{value:t.visible,callback:function(e){t.visible=e},expression:"visible"}},[a("div",{staticClass:"main"},[a("a-form-model",{ref:"form",attrs:{layout:t.formLayout,model:t.form,rules:t.rules}},[a("a-form-model-item",{directives:[{name:"show",rawName:"v-show",value:!1,expression:"false"}],attrs:{label:"id",prop:"id","label-col":t.formItemLayout.labelCol,"wrapper-col":t.formItemLayout.wrapperCol}},[a("a-input",{model:{value:t.form.id,callback:function(e){t.$set(t.form,"id",e)},expression:"form.id"}})],1),a("a-form-model-item",{attrs:{label:"名称",prop:"name","label-col":t.formItemLayout.labelCol,"wrapper-col":t.formItemLayout.wrapperCol}},[a("a-input",{attrs:{placeholder:"请输入名称"},model:{value:t.form.name,callback:function(e){t.$set(t.form,"name",e)},expression:"form.name"}})],1)],1)],1),a("template",{slot:"footer"},[a("a-button",{attrs:{type:"primary"},on:{click:function(e){return t.handleEdit()}}},[t._v(" 提交 ")]),a("a-button",{on:{click:function(e){return t.handleClose()}}},[t._v(" 取消 ")])],1)],2)},s=[],o=a("2410"),l=a.n(o),i=a("b775"),r=a("f64c"),u={labelCol:{span:3},wrapperCol:{span:21}},c={components:{},props:{initvalue:{type:Object,default:null}},watch:{initvalue:function(){if(this.initvalue)for(var t in this.initvalue)this.form[t]=this.initvalue[t];else this.form=l()(this.initForm)},visible:function(t,e){if(!t)try{this.form=l()(this.initForm)}catch(a){}}},methods:{getTitle:function(t){var e=this.$createElement;return e("span",t?[" 编辑 "]:[" 新建 "])},show:function(){this.visible=!0},handleClose:function(){this.form=l()(this.initForm),this.form.param="",this.visible=!1},handleEdit:function(){var t=this;this.$refs.form.validate((function(e){if(e){var a=JSON.parse(JSON.stringify(t.form));t.commonRequest.head.operationTime=Date.now(),t.commonRequest.body=a;var n=t.commonRequest;Object(i["b"])({url:"/archetypesExecute/addOrEdit",method:"post",dataType:"json",data:n}).then((function(e){"S"===e.head.status?(r["a"].success(e.head.msg),t.handleClose(),t.$emit("refresh")):r["a"].error(e.head.msg)})).catch((function(t){console.log(t)}))}}))}},data:function(){return{visible:!1,formLayout:"horizontal",formItemLayout:u,datasourcesList:[],form:{id:null,archetypesId:null,auditId:null,applicationCode:null,name:null,url:null,basePackage:null,groupId:null,artifactId:null,version:null,description:null,remark:null,gmtCreated:null,creator:null,creatorTenantId:null,creatorCode:null,gmtModified:null,modifier:null,modifierCode:null,auditStatus:null,status:null,bak01:null,bak02:null,bak03:null,bak04:null,bak05:null,end:""},initForm:{id:null,archetypesId:null,auditId:null,applicationCode:null,name:null,url:null,basePackage:null,groupId:null,artifactId:null,version:null,description:null,remark:null,gmtCreated:null,creator:null,creatorTenantId:null,creatorCode:null,gmtModified:null,modifier:null,modifierCode:null,auditStatus:null,status:null,bak01:null,bak02:null,bak03:null,bak04:null,bak05:null,end:""},rules:{name:[{required:!0,message:"请输入"},{max:50,message:"最多输入50个字符"},{pattern:/^(?!(\s+$))/,message:"输入格式错误"}]},commonRequest:{head:{operationTime:Date.now()},body:{}},bodyById:{id:0}}}},d=c,m=(a("e7ca"),a("2877")),f=Object(m["a"])(d,n,s,!1,null,null,null);e["default"]=f.exports},e7ca:function(t,e,a){"use strict";a("51f4")}}]);
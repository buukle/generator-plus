(window["webpackJsonp"]=window["webpackJsonp"]||[]).push([["chunk-990ef504","chunk-09011f86","chunk-7e4bafcc","chunk-2d0c20de"],{"1f36":function(t,e,a){"use strict";a.r(e);var o=function(){var t=this,e=this,a=e.$createElement,o=e._self._c||a;return o("a-card",{attrs:{bordered:!1}},[o("div",{staticClass:"table-page-search-wrapper"},[o("a-form",{attrs:{layout:"inline"}},[o("a-row",{attrs:{gutter:48}},[o("a-col",{attrs:{md:8,sm:24}},[o("a-form-item",{attrs:{label:"id"}},[o("a-input",{attrs:{name:"id",placeholder:""},model:{value:e.queryParam.id,callback:function(t){e.$set(e.queryParam,"id",t)},expression:"queryParam.id"}})],1)],1),o("a-col",{attrs:{md:8,sm:24}},[o("a-form-item",{attrs:{label:"状态"}},[o("a-select",{attrs:{placeholder:"请选择","default-value":"0"},model:{value:e.queryParam.states,callback:function(t){e.$set(e.queryParam,"states",t)},expression:"queryParam.states"}},[o("a-select-option",{attrs:{value:""}},[e._v("全部")]),o("a-select-option",{attrs:{value:"1"}},[e._v("创建完成")]),o("a-select-option",{attrs:{value:"2"}},[e._v("审批中")]),o("a-select-option",{attrs:{value:"3"}},[e._v("正常")]),o("a-select-option",{attrs:{value:"4"}},[e._v("已禁用")])],1)],1)],1),e.advanced?void 0:e._e(),o("a-col",{attrs:{md:e.advanced?24:8,sm:24}},[o("span",{staticClass:"table-page-search-submitButtons",style:e.advanced&&{float:"right",overflow:"hidden"}||{}},[o("a-button",{attrs:{type:"primary"},on:{click:e.handleAdd}},[e._v("新建")]),o("a-button",{staticStyle:{"margin-left":"8px"},attrs:{type:"primary"},on:{click:function(t){return e.handleSearch()}}},[e._v("查询")]),o("a-button",{staticStyle:{"margin-left":"8px"},on:{click:function(){return t.queryParam={}}}},[e._v("重置")])],1)])],2)],1)],1),o("s-table",{ref:"table",attrs:{size:"default",rowKey:"id",columns:e.columns,data:e.loadData,alert:!0,rowSelection:e.rowSelection,pagination:{showTotal:function(t){return"共 "+t+" 条记录"}}},scopedSlots:e._u([{key:"serial",fn:function(t,a,n){return o("span",{},[e._v(" "+e._s(n+1)+" ")])}},{key:"status",fn:function(t){return o("span",{},[o("a-badge",{attrs:{status:e._f("statusTypeFilter")(t),text:e._f("statusFilter")(t)}})],1)}},{key:"name",fn:function(t){return o("span",{},[o("ellipsis",{attrs:{length:16,tooltip:""}},[e._v(e._s(t))])],1)}},{key:"gmtCreated",fn:function(t){return o("span",{},[o("ellipsis",{attrs:{length:64,tooltip:""}},[e._v(e._s(e.gmtDateFormat(t)))])],1)}},{key:"action",fn:function(t,a){return o("span",{},[[o("a",{on:{click:function(t){return e.handleEdit(a.id)}}},[e._v("编辑")]),e._v("  "),o("a",{on:{click:function(t){return e.handleDelete(a.id)}}},[e._v("删除")]),e._v("  "),o("a",{on:{click:function(t){return e.handleInfo(a.id)}}},[e._v("详情")]),e._v("  "),o("a",{on:{click:function(t){return e.handleGen(a.id,a.url)}}},[e._v("生成")])]],2)}}])}),o("AddOrEditForm",{ref:"AddOrEditForm",attrs:{initvalue:e.initvalue},on:{refresh:e.refresh}}),o("Gen",{ref:"Gen",attrs:{initvalue:e.genvalue},on:{refresh:e.refresh}}),o("InfoTable",{ref:"InfoTable",attrs:{initvalue:e.initvalue},on:{refresh:e.refresh}})],1)},n=[],s=(a("b0c0"),a("2af9")),l=a("b775"),r=a("f64c"),i=a("a6d3"),u=a("6b4f"),c=a("4958"),d=a("c1df"),m=a.n(d);r["a"].config({duration:3,top:"40px",maxCount:3});var f={name:"List",components:{InfoTable:c["default"],STable:s["c"],Ellipsis:s["a"],AddOrEditForm:u["default"],Gen:i["default"]},methods:{refresh:function(){this.$refs.table.refresh(!0)},handleSearch:function(){this.$refs.table.pagination.pageNo=1,this.$refs.table.refresh(!0)},handleAdd:function(){this.initvalue=null,this.$refs.AddOrEditForm.show()},handleDelete:function(t){var e=this.$refs.table;this.commonRequest.head.operationTime=Date.now(),this.bodyById.id=t,this.commonRequest.body=this.bodyById;var a=this.commonRequest;this.$confirm({title:"确认提示",content:"是否删除该条记录？",okType:"danger",okText:"确认",cancelText:"取消",onOk:function(){Object(l["b"])({url:"/archetypes/deleteById",method:"post",dataType:"json",data:a}).then((function(t){"S"===t.head.status?(r["a"].success("成功!"),e.refresh()):r["a"].error(t.head.msg)}))}})},handleGen:function(t,e){var a=this;this.commonRequest.head.operationTime=Date.now(),this.bodyById.id=t,this.commonRequest.body=this.bodyById;var o=this.commonRequest;Object(l["b"])({url:"/archetypes/getLastedLogById",method:"post",dataType:"json",data:o}).then((function(o){a.genvalue={archetypesId:t,archetypeUrl:e},"S"===o.head.status&&(a.genvalue.artifactId=o.body.artifactId,a.genvalue.groupId=o.body.groupId,a.genvalue.version=o.body.version,a.genvalue.basePackage=o.body.basePackage),a.$refs.Gen.show()})).catch((function(){a.genvalue={archetypesId:t,archetypeUrl:e},a.$refs.Gen.show()}))},handleEdit:function(t){var e=this;this.commonRequest.head.operationTime=Date.now(),this.bodyById.id=t,this.commonRequest.body=this.bodyById;var a=this.commonRequest;Object(l["b"])({url:"/archetypes/getById",method:"post",dataType:"json",data:a}).then((function(t){"S"===t.head.status?(e.initvalue=t.body,e.$refs.AddOrEditForm.show()):r["a"].error(t.head.msg)})).catch((function(t){console.log(t)}))},handleInfo:function(t){var e=this;this.commonRequest.head.operationTime=Date.now(),this.bodyById.id=t,this.commonRequest.body=this.bodyById;var a=this.commonRequest;Object(l["b"])({url:"/archetypes/getById",method:"post",dataType:"json",data:a}).then((function(t){"S"===t.head.status?(e.initvalue=t.body,e.$refs.InfoTable.show()):r["a"].error(t.head.msg)})).catch((function(t){console.log(t)}))},handleBan:function(t){0!==t.status?this.$message.info("".concat(t.name," 已停用")):this.$message.error("".concat(t.name," 停用失败"))},onSelectChange:function(t,e){this.selectedRowKeys=t,this.selectedRows=e},toggleAdvanced:function(){this.advanced=!this.advanced},gmtDateFormat:function(t){return m()(t).format("yyyy-MM-DD HH:mm:ss")}},data:function(){var t=this;return this.columns=p,{genvalue:{},initvalue:{},visible:!1,confirmLoading:!1,dialogFormVisible:!1,mdl:null,advanced:!1,queryParam:{},commonRequest:{head:{operationTime:Date.now()},body:{}},bodyById:{id:0},loadData:function(e){var a=Object.assign({},e,t.queryParam);t.commonRequest.head.operationTime=Date.now(),t.commonRequest.body=a;var o=t.commonRequest;return Object(l["b"])({url:"/archetypes/getPage",method:"post",dataType:"json",data:o}).then((function(t){return t.result}))},selectedRowKeys:[],selectedRows:[]}},filters:{statusFilter:function(t){return h[t].text},statusTypeFilter:function(t){return h[t].status}},computed:{rowSelection:function(){return{selectedRowKeys:this.selectedRowKeys,onChange:this.onSelectChange}}}},p=[{title:"序号",width:"5%",scopedSlots:{customRender:"serial"}},{title:"id",dataIndex:"id",width:"5%"},{title:"名称",dataIndex:"name",width:"20%"},{title:"制品",dataIndex:"url",width:"35%"},{title:"创建时间",width:"10%",dataIndex:"gmtCreated",scopedSlots:{customRender:"gmtCreated"}},{title:"状态",dataIndex:"status",width:"5%",scopedSlots:{customRender:"status"}},{title:"操作",dataIndex:"action",width:"20%",scopedSlots:{customRender:"action"}}],h={1:{status:"default",text:"创建完成"},2:{status:"processing",text:"审批中"},3:{status:"success",text:"正常"},4:{status:"warning",text:"已禁用"}},v=f,b=a("2877"),y=Object(b["a"])(v,o,n,!1,null,null,null);e["default"]=y.exports},3726:function(t,e,a){},"375a":function(t,e,a){"use strict";a("3726")},4958:function(t,e,a){"use strict";a.r(e);var o=function(){var t=this,e=t.$createElement,a=t._self._c||e;return a("a-modal",{attrs:{destroyOnClose:!0,width:900,height:600,visible:t.visible,title:t.getTitle(t.initvalue)},model:{value:t.visible,callback:function(e){t.visible=e},expression:"visible"}},[a("div",{staticClass:"main"},[[a("div",[a("a-row",{attrs:{type:"flex"}},[a("a-col",{staticStyle:{"margin-top":"5px"},attrs:{span:12}},[a("a-col",{attrs:{span:6,align:"right"}},[a("span",[t._v("名称:")])]),a("a-col",{staticStyle:{"padding-left":"10px"},attrs:{span:18}},[a("span",[t._v(" "+t._s(t.initvalue.name)+" ")])])],1),a("a-col",{staticStyle:{"margin-top":"5px"},attrs:{span:12}},[a("a-col",{attrs:{span:6,align:"right"}},[a("span",[t._v("制品:")])]),a("a-col",{staticStyle:{"padding-left":"10px"},attrs:{span:18}},[a("span",[t._v(" "+t._s(""==t.initvalue.url?"空":t.initvalue.url)+" ")]),t.initvalue.url?a("div",[a("a",{attrs:{href:t.initvalue.url,target:"_blank"}},[t._v("点击下载")])]):t._e()])],1),a("a-col",{staticStyle:{"margin-top":"5px"},attrs:{span:12}},[a("a-col",{attrs:{span:6,align:"right"}},[a("span",[t._v("创建者:")])]),a("a-col",{staticStyle:{"padding-left":"10px"},attrs:{span:18}},[a("span",[t._v(" "+t._s(t.initvalue.creator)+" ")])])],1),a("a-col",{staticStyle:{"margin-top":"5px"},attrs:{span:12}},[a("a-col",{attrs:{span:6,align:"right"}},[a("span",[t._v("创建时间:")])]),a("a-col",{staticStyle:{"padding-left":"10px"},attrs:{span:18}},[a("span",[t._v(" "+t._s(t.gmtDateFormat(t.initvalue.gmtCreated))+" ")])])],1),a("a-col",{staticStyle:{"margin-top":"5px"},attrs:{span:12}},[a("a-col",{attrs:{span:6,align:"right"}},[a("span",[t._v("更新者:")])]),a("a-col",{staticStyle:{"padding-left":"10px"},attrs:{span:18}},[a("span",[t._v(" "+t._s(t.initvalue.modifier)+" ")])])],1),a("a-col",{staticStyle:{"margin-top":"5px"},attrs:{span:12}},[a("a-col",{attrs:{span:6,align:"right"}},[a("span",[t._v("更新时间:")])]),a("a-col",{staticStyle:{"padding-left":"10px"},attrs:{span:18}},[a("span",[t._v(" "+t._s(t.gmtDateFormat(t.initvalue.gmtModified))+" ")])])],1),a("a-col",{staticStyle:{"margin-top":"5px"},attrs:{span:24}},[a("a-col",{attrs:{span:3,align:"right"}},[a("span",[t._v("备注:")])]),a("a-col",{staticStyle:{"padding-left":"10px"},attrs:{span:21}},[a("span",[t._v(" "+t._s(t.initvalue.remark)+" ")])])],1)],1)],1)]],2),a("template",{slot:"footer"},[a("a-button",{on:{click:function(e){return t.handleClose()}}},[t._v(" 返回 ")])],1)],2)},n=[],s=a("c1df"),l=a.n(s),r={labelCol:{span:5},wrapperCol:{span:16}},i={methods:{getTitle:function(t){var e=this.$createElement;return e("span",[" 详情"])},show:function(){this.visible=!0},handleClose:function(){this.visible=!1},gmtDateFormat:function(t){return l()(t).format("yyyy-MM-DD HH:mm:ss")}},props:{initvalue:{type:Object,default:null}},data:function(){return{visible:!1,formItemLayout:r}}},u=i,c=a("2877"),d=Object(c["a"])(u,o,n,!1,null,null,null);e["default"]=d.exports},"63b7":function(t,e,a){},"6b4f":function(t,e,a){"use strict";a.r(e);var o=function(){var t=this,e=t.$createElement,a=t._self._c||e;return a("a-modal",{attrs:{destroyOnClose:!0,width:1080,visible:t.visible,title:t.getTitle(t.initvalue)},model:{value:t.visible,callback:function(e){t.visible=e},expression:"visible"}},[a("div",{staticClass:"main"},[a("a-form-model",{ref:"form",attrs:{layout:t.formLayout,model:t.form,rules:t.rules}},[a("a-form-model-item",{directives:[{name:"show",rawName:"v-show",value:!1,expression:"false"}],attrs:{label:"id",prop:"id","label-col":t.formItemLayout.labelCol,"wrapper-col":t.formItemLayout.wrapperCol}},[a("a-input",{model:{value:t.form.id,callback:function(e){t.$set(t.form,"id",e)},expression:"form.id"}})],1),a("a-form-model-item",{attrs:{label:"名称",prop:"name","label-col":t.formItemLayout.labelCol,"wrapper-col":t.formItemLayout.wrapperCol}},[a("a-input",{attrs:{placeholder:"请输入名称"},model:{value:t.form.name,callback:function(e){t.$set(t.form,"name",e)},expression:"form.name"}})],1),a("a-form-model-item",{attrs:{label:"请上传制品",prop:"url","label-col":t.formItemLayout.labelCol,"wrapper-col":t.formItemLayout.wrapperCol}},[[a("a-upload-dragger",{attrs:{name:"file",multiple:!1,customRequest:t.customRequest,remove:t.removeFile,"file-list":t.fileList}},[a("p",{staticClass:"ant-upload-drag-icon"},[a("a-icon",{attrs:{type:"inbox"}})],1),a("p",{staticClass:"ant-upload-text"},[t._v(" 点击或拖动文件到此区域上传 ")])])]],2)],1)],1),a("template",{slot:"footer"},[a("a-button",{attrs:{type:"primary"},on:{click:function(e){return t.handleEdit()}}},[t._v(" 提交 ")]),a("a-button",{on:{click:function(e){return t.handleClose()}}},[t._v(" 取消 ")])],1)],2)},n=[],s=(a("a434"),a("b0c0"),a("2410")),l=a.n(s),r=a("b775"),i=a("f64c"),u={labelCol:{span:3},wrapperCol:{span:21}},c={components:{},props:{initvalue:{type:Object,default:null}},watch:{initvalue:function(){if(this.initvalue){if(this.initvalue.url){var t={uid:this.initvalue.url,name:this.initvalue.url,status:"done"};this.fileList.splice(this.fileList.indexOf(t),1),this.fileList.push(t)}for(var e in this.initvalue)this.form[e]=this.initvalue[e]}else this.form=l()(this.initForm)},visible:function(t,e){if(!t)try{this.fileList=[],this.form=l()(this.initForm)}catch(a){}}},methods:{customRequest:function(t){var e=this,a=new FormData;a.append("file",t.file),Object(r["b"])({url:"/app/upload",method:"post",dataType:"json",data:a}).then((function(a){"S"===a.head.status?(e.form.url=a.body,e.fileList=[],e.fileList.push({uid:a.body,name:a.body,status:"done",response:a}),i["a"].success("文件:"+t.file.name+" 上传结果:"+a.head.msg)):i["a"].error(a.head.msg)})).catch((function(){i["a"].error("上传失败!")}))},removeFile:function(t){this.form.url="",this.fileList.splice(this.fileList.indexOf(t),1)},getTitle:function(t){var e=this.$createElement;return e("span",t?[" 编辑 "]:[" 新建 "])},show:function(){this.visible=!0},handleClose:function(){this.form=l()(this.initForm),this.form.param="",this.visible=!1},handleEdit:function(){var t=this;this.$refs.form.validate((function(e){if(e){var a=JSON.parse(JSON.stringify(t.form));t.commonRequest.head.operationTime=Date.now(),t.commonRequest.body=a;var o=t.commonRequest;Object(r["b"])({url:"/archetypes/addOrEdit",method:"post",dataType:"json",data:o}).then((function(e){"S"===e.head.status?(i["a"].success(e.head.msg),t.handleClose(),t.$emit("refresh")):i["a"].error(e.head.msg)})).catch((function(t){console.log(t)}))}}))}},data:function(){return{fileList:[],visible:!1,formLayout:"horizontal",formItemLayout:u,datasourcesList:[],form:{id:null,auditId:null,applicationCode:null,name:null,url:null,description:null,remark:null,gmtCreated:null,creator:null,creatorTenantId:null,creatorCode:null,gmtModified:null,modifier:null,modifierCode:null,auditStatus:null,status:null,bak01:null,bak02:null,bak03:null,bak04:null,bak05:null,end:""},initForm:{id:null,auditId:null,applicationCode:null,name:null,url:null,description:null,remark:null,gmtCreated:null,creator:null,creatorTenantId:null,creatorCode:null,gmtModified:null,modifier:null,modifierCode:null,auditStatus:null,status:null,bak01:null,bak02:null,bak03:null,bak04:null,bak05:null,end:""},rules:{name:[{required:!0,message:"请输入"},{max:50,message:"最多输入50个字符"},{pattern:/^(?!(\s+$))/,message:"输入格式错误"}]},commonRequest:{head:{operationTime:Date.now()},body:{}},bodyById:{id:0}}}},d=c,m=(a("8d90"),a("2877")),f=Object(m["a"])(d,o,n,!1,null,null,null);e["default"]=f.exports},"8d90":function(t,e,a){"use strict";a("63b7")},a6d3:function(t,e,a){"use strict";a.r(e);var o=function(){var t=this,e=t.$createElement,a=t._self._c||e;return a("a-modal",{attrs:{destroyOnClose:!0,width:1080,visible:t.visible,title:"生成"},model:{value:t.visible,callback:function(e){t.visible=e},expression:"visible"}},[a("div",{staticClass:"main"},[a("a-form-model",{ref:"form",attrs:{layout:t.formLayout,model:t.form,rules:t.rules}},[a("a-form-model-item",{directives:[{name:"show",rawName:"v-show",value:!1,expression:"false"}],attrs:{label:"archetypesId",prop:"archetypesId","label-col":t.formItemLayout.labelCol,"wrapper-col":t.formItemLayout.wrapperCol}},[a("a-input",{model:{value:t.form.archetypesId,callback:function(e){t.$set(t.form,"archetypesId",e)},expression:"form.archetypesId"}})],1),a("a-form-model-item",{attrs:{label:"groupId",prop:"groupId","label-col":t.formItemLayout.labelCol,"wrapper-col":t.formItemLayout.wrapperCol}},[a("a-input",{attrs:{placeholder:"请输入 groupId"},model:{value:t.form.groupId,callback:function(e){t.$set(t.form,"groupId",e)},expression:"form.groupId"}})],1),a("a-form-model-item",{attrs:{label:"artifactId",prop:"artifactId","label-col":t.formItemLayout.labelCol,"wrapper-col":t.formItemLayout.wrapperCol}},[a("a-input",{attrs:{placeholder:"请输入 artifactId"},model:{value:t.form.artifactId,callback:function(e){t.$set(t.form,"artifactId",e)},expression:"form.artifactId"}})],1),a("a-form-model-item",{attrs:{label:"version",prop:"version","label-col":t.formItemLayout.labelCol,"wrapper-col":t.formItemLayout.wrapperCol}},[a("a-input",{attrs:{placeholder:"请输入 version"},model:{value:t.form.version,callback:function(e){t.$set(t.form,"version",e)},expression:"form.version"}})],1),a("a-form-model-item",{attrs:{label:"basePackage",prop:"basePackage","label-col":t.formItemLayout.labelCol,"wrapper-col":t.formItemLayout.wrapperCol}},[a("a-input",{attrs:{placeholder:"请输入 basePackage"},model:{value:t.form.basePackage,callback:function(e){t.$set(t.form,"basePackage",e)},expression:"form.basePackage"}})],1),a("a-form-model-item",{attrs:{label:"archetypeUrl",prop:"archetypeUrl","label-col":t.formItemLayout.labelCol,"wrapper-col":t.formItemLayout.wrapperCol}},[a("span",{domProps:{textContent:t._s(t.form.archetypeUrl)}})])],1)],1),a("template",{slot:"footer"},[a("a-button",{attrs:{type:"primary"},on:{click:function(e){return t.handleExecute()}}},[t._v(" 执行 ")]),a("a-button",{on:{click:function(e){return t.handleClose()}}},[t._v(" 取消 ")])],1)],2)},n=[],s=a("2410"),l=a.n(s),r=a("b775"),i=a("f64c"),u={labelCol:{span:3},wrapperCol:{span:21}},c={components:{},props:{initvalue:{type:Object,default:null}},watch:{initvalue:function(){if(this.initvalue)for(var t in this.initvalue)this.form[t]=this.initvalue[t];else this.form=l()(this.initForm)},visible:function(t,e){if(!t)try{this.fileList=[],this.form=l()(this.initForm)}catch(a){}}},methods:{show:function(){this.visible=!0},handleClose:function(){this.form=l()(this.initForm),this.form.param="",this.visible=!1},handleExecute:function(){var t=this;this.$refs.form.validate((function(e){if(e){var a=JSON.parse(JSON.stringify(t.form));t.commonRequest.head.operationTime=Date.now(),t.commonRequest.body=a;var o=t.commonRequest;Object(r["b"])({url:"/archetypes/execute",method:"post",dataType:"json",data:o}).then((function(e){"S"===e.head.status?(i["a"].success(e.head.msg),t.handleClose(),t.$emit("refresh")):i["a"].error(e.head.msg)})).catch((function(t){console.log(t)}))}}))}},data:function(){return{visible:!1,formLayout:"horizontal",formItemLayout:u,datasourcesList:[],form:{archetypesId:null,groupId:null,artifactId:null,version:null,archetypeUrl:null,basePackage:null},initForm:{archetypesId:null,groupId:null,artifactId:null,version:null,archetypeUrl:null,basePackage:null},rules:{groupId:[{required:!0,message:"请输入 groupId"},{max:128,message:"最多输入128个字符"}],artifactId:[{required:!0,message:"请输入 artifactId"},{max:128,message:"最多输入128个字符"}],version:[{required:!0,message:"请输入 version"},{max:128,message:"最多输入128个字符"}],basePackage:[{required:!0,message:"请输入 basePackage"},{max:128,message:"最多输入255个字符"}]},commonRequest:{head:{operationTime:Date.now()},body:{}},bodyById:{id:0}}}},d=c,m=(a("375a"),a("2877")),f=Object(m["a"])(d,o,n,!1,null,null,null);e["default"]=f.exports}}]);
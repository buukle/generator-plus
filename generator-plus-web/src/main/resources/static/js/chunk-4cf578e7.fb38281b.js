(window["webpackJsonp"]=window["webpackJsonp"]||[]).push([["chunk-4cf578e7","chunk-03f33594","chunk-2d0af299"],{"03e8":function(t,e,a){},"0cc3":function(t,e,a){"use strict";a.r(e);var o=function(){var t=this,e=t.$createElement,a=t._self._c||e;return a("a-modal",{attrs:{destroyOnClose:!0,width:900,height:600,visible:t.visible,title:t.getTitle(t.initvalue)},model:{value:t.visible,callback:function(e){t.visible=e},expression:"visible"}},[a("div",{staticClass:"main"},[[a("div",[a("a-row",{attrs:{type:"flex"}},[a("a-col",{staticStyle:{"margin-top":"5px"},attrs:{span:12}},[a("a-col",{attrs:{span:6,align:"right"}},[a("span",[t._v("模板分组:")])]),a("a-col",{staticStyle:{"padding-left":"10px"},attrs:{span:18}},[a("span",[t._v(" "+t._s(t.initvalue.templatesGroupName)+" ")])])],1),a("a-col",{staticStyle:{"margin-top":"5px"},attrs:{span:12}},[a("a-col",{attrs:{span:6,align:"right"}},[a("span",[t._v("模板名称:")])]),a("a-col",{staticStyle:{"padding-left":"10px"},attrs:{span:18}},[a("span",[t._v(" "+t._s(t.initvalue.name)+" ")])])],1),a("a-col",{staticStyle:{"margin-top":"5px"},attrs:{span:12}},[a("a-col",{attrs:{span:6,align:"right"}},[a("span",[t._v("文件名称模式:")])]),a("a-col",{staticStyle:{"padding-left":"10px"},attrs:{span:18}},[a("span",[t._v(" "+t._s(0==t.initvalue.addNameSuffix?"表名大驼峰":1==t.initvalue.addNameSuffix?"模板前中段":"表名大驼峰+模板前段")+" ")])])],1),a("a-col",{staticStyle:{"margin-top":"5px"},attrs:{span:24}},[a("a-col",{attrs:{span:3,align:"right"}},[a("span",[t._v("工程路径:")])]),a("a-col",{staticStyle:{"padding-left":"10px"},attrs:{span:18}},[a("span",[t._v(" "+t._s(t.initvalue.path)+" ")])])],1),a("a-col",{staticStyle:{"margin-top":"5px"},attrs:{span:12}},[a("a-col",{attrs:{span:6,align:"right"}},[a("span",[t._v("表名路径:")])]),a("a-col",{staticStyle:{"padding-left":"10px"},attrs:{span:18}},[a("span",[t._v(" "+t._s(1==t.initvalue.openTablePath?"开启":"关闭")+" ")])])],1),a("a-col",{staticStyle:{"margin-top":"5px"},attrs:{span:12}},[a("a-col",{attrs:{span:6,align:"right"}},[a("span",[t._v("包名:")])]),a("a-col",{staticStyle:{"padding-left":"10px"},attrs:{span:18}},[a("span",[t._v(" "+t._s(t.initvalue.packageInfo)+" ")])])],1),a("a-col",{staticStyle:{"margin-top":"5px"},attrs:{span:12}},[a("a-col",{attrs:{span:6,align:"right"}},[a("span",[t._v("创建者:")])]),a("a-col",{staticStyle:{"padding-left":"10px"},attrs:{span:18}},[a("span",[t._v(" "+t._s(t.initvalue.creator)+" ")])])],1),a("a-col",{staticStyle:{"margin-top":"5px"},attrs:{span:12}},[a("a-col",{attrs:{span:6,align:"right"}},[a("span",[t._v("创建时间:")])]),a("a-col",{staticStyle:{"padding-left":"10px"},attrs:{span:18}},[a("span",[t._v(" "+t._s(t.gmtDateFormat(t.initvalue.gmtCreated))+" ")])])],1),a("a-col",{staticStyle:{"margin-top":"5px"},attrs:{span:12}},[a("a-col",{attrs:{span:6,align:"right"}},[a("span",[t._v("更新者:")])]),a("a-col",{staticStyle:{"padding-left":"10px"},attrs:{span:18}},[a("span",[t._v(" "+t._s(t.initvalue.modifier)+" ")])])],1),a("a-col",{staticStyle:{"margin-top":"5px"},attrs:{span:12}},[a("a-col",{attrs:{span:6,align:"right"}},[a("span",[t._v("更新时间:")])]),a("a-col",{staticStyle:{"padding-left":"10px"},attrs:{span:18}},[a("span",[t._v(" "+t._s(t.gmtDateFormat(t.initvalue.gmtModified))+" ")])])],1),a("a-col",{staticStyle:{"margin-top":"5px"},attrs:{span:24}},[a("a-col",{attrs:{span:3,align:"right"}},[a("span",[t._v("模板内容:")])]),a("a-col",{staticStyle:{"padding-left":"10px"},attrs:{span:21}},[a("a-textarea",{staticStyle:{"background-color":"#e6e6e6",color:"black",border:"0px",cursor:"text","margin-top":"25px","-webkit-appearance":"none","border-radius":"0",padding:"15px"},attrs:{disabled:"",rows:"20",cols:"20",placeholder:""},model:{value:t.initvalue.content,callback:function(e){t.$set(t.initvalue,"content",e)},expression:"initvalue.content"}})],1)],1),a("a-col",{staticStyle:{"margin-top":"5px"},attrs:{span:24}},[a("a-col",{attrs:{span:3,align:"right"}},[a("span",[t._v("备注:")])]),a("a-col",{staticStyle:{"padding-left":"10px"},attrs:{span:21}},[a("span",[t._v(" "+t._s(t.initvalue.remark)+" ")])])],1)],1)],1)]],2),a("template",{slot:"footer"},[a("a-button",{on:{click:function(e){return t.handleClose()}}},[t._v(" 返回 ")])],1)],2)},n=[],s=a("c1df"),l=a.n(s),r={labelCol:{span:5},wrapperCol:{span:16}},i={methods:{getTitle:function(t){var e=this.$createElement;return e("span",[" 详情 ",e("span",{style:"color: red;font-size: 12px;"},[" * 注 : 当前只兼容 beetl 模板语法 "])])},show:function(){this.visible=!0},handleClose:function(){this.visible=!1},gmtDateFormat:function(t){return l()(t).format("yyyy-MM-DD HH:mm:ss")}},props:{initvalue:{type:Object,default:null}},data:function(){return{visible:!1,formItemLayout:r}}},p=i,c=a("2877"),m=Object(c["a"])(p,o,n,!1,null,null,null);e["default"]=m.exports},"12b9":function(t,e,a){"use strict";a("03e8")},"66a2":function(t,e,a){"use strict";a.r(e);var o=function(){var t=this,e=t.$createElement,a=t._self._c||e;return a("a-modal",{attrs:{destroyOnClose:!0,width:900,height:600,visible:t.visible,title:t.getTitle(t.initvalue)},model:{value:t.visible,callback:function(e){t.visible=e},expression:"visible"}},[a("div",{staticClass:"main"},[a("a-form-model",{ref:"form",attrs:{layout:t.formLayout,model:t.form,rules:t.rules}},[a("a-form-model-item",{directives:[{name:"show",rawName:"v-show",value:!1,expression:"false"}],attrs:{label:"id",prop:"id","label-col":t.formItemLayout.labelCol,"wrapper-col":t.formItemLayout.wrapperCol}},[a("a-input",{model:{value:t.form.id,callback:function(e){t.$set(t.form,"id",e)},expression:"form.id"}})],1),a("a-form-model-item",{attrs:{label:"模板分组",prop:"templatesGroupName","label-col":t.formItemLayout.labelCol,"wrapper-col":t.formItemLayout.wrapperCol}},[a("a-select",{attrs:{placeholder:"请选择分组"},on:{change:t.templatesGroupChange},model:{value:t.form.templatesGroupName,callback:function(e){t.$set(t.form,"templatesGroupName",e)},expression:"form.templatesGroupName"}},t._l(t.templatesGroupList,(function(e){return a("a-select-option",{key:e.id,attrs:{value:e.name?e.name:e.id+1,title:e.name}},[t._v(" "+t._s(e.name?e.name:e.id+1)+" ")])})),1),a("a-popover",{attrs:{title:"模板分组变量列表"}},[a("template",{slot:"content"},[a("a-table",{attrs:{columns:t.columnsGroupParam,pagination:!1,"data-source":t.form.templatesGroupParamList,bordered:""},scopedSlots:t._u([{key:"name",fn:function(e){return[a("a",[t._v(t._s(e))])]}}])})],1),a("span",[t._v("模板分组变量列表")]),a("a-icon",{attrs:{type:"question-circle"}})],2)],1),a("a-form-model-item",{attrs:{label:"模板名称",prop:"name","label-col":t.formItemLayout.labelCol,"wrapper-col":t.formItemLayout.wrapperCol}},[a("a-input",{attrs:{placeholder:"请输入模板名称"},model:{value:t.form.name,callback:function(e){t.$set(t.form,"name",e)},expression:"form.name"}}),a("span",{staticStyle:{color:"grey","font-size":"12px","line-height":"1px"}},[t._v(" 请按照模板: "),a("span",{staticStyle:{color:"red","font-size":"12px","line-height":"1px"}},[t._v("A.B.btl")]),t._v(" 填写,生成目标文件时会截取"),a("span",{staticStyle:{color:"red"}},[t._v("B")]),t._v("值作为文件后缀名 ")])],1),a("a-form-model-item",{attrs:{label:"文件名称模式",prop:"addNameSuffix","label-col":t.formItemLayout.labelCol,"wrapper-col":t.formItemLayout.wrapperCol}},[a("a-radio-group",{attrs:{name:"addNameSuffix","default-value":t.form.addNameSuffix},model:{value:t.form.addNameSuffix,callback:function(e){t.$set(t.form,"addNameSuffix",e)},expression:"form.addNameSuffix"}},[a("a-radio",{attrs:{value:"0"}},[t._v(" ①. 表名大驼峰 ")]),a("a-radio",{attrs:{value:"1"}},[t._v(" ②. 模板前中段 ")]),a("a-radio",{attrs:{value:"2"}},[t._v(" ③. ①+② ")]),a("a-popover",{attrs:{title:"说明"}},[a("template",{slot:"content"},[a("span",{staticStyle:{color:"grey","font-size":"12px","line-height":"1px"}},[t._v("举例 -- 模板名称 : QueryDTO.vue.btl 表名:table_example ")]),a("br"),a("span",{staticStyle:{color:"grey","font-size":"12px","line-height":"1px"}},[t._v("生成的文件名为")]),a("br"),a("span",{staticStyle:{color:"grey","font-size":"12px","line-height":"1px"}},[t._v(" ① : "),a("span",{staticStyle:{color:"#2c65a0","font-size":"12px","line-height":"1px"}},[t._v("TableExample")]),t._v(".vue ")]),a("br"),a("span",{staticStyle:{color:"grey","font-size":"12px","line-height":"1px"}},[t._v(" ② : "),a("span",{staticStyle:{color:"red","font-size":"12px","line-height":"1px"}},[t._v("QueryDTO")]),t._v(".vue ")]),a("br"),a("span",{staticStyle:{color:"grey","font-size":"12px","line-height":"1px"}},[t._v(" ③ : "),a("span",{staticStyle:{color:"#2c65a0","font-size":"12px","line-height":"1px"}},[t._v("TableExample")]),a("span",{staticStyle:{color:"red","font-size":"12px","line-height":"1px"}},[t._v("QueryDTO")]),t._v(".vue ")])]),a("a-icon",{attrs:{type:"question-circle"}})],2)],1)],1),a("a-form-model-item",{staticStyle:{"margin-top":"-22px"},attrs:{label:"工程路径",prop:"path","label-col":t.formItemLayout.labelCol,"wrapper-col":t.formItemLayout.wrapperCol}},[a("a-input",{attrs:{placeholder:"请输入工程路径"},model:{value:t.form.path,callback:function(e){t.$set(t.form,"path",e)},expression:"form.path"}}),a("a-form-model-item",{attrs:{label:"表名路径",prop:"openTablePath","label-col":t.formItemLayout.labelCol,"wrapper-col":t.formItemLayout.wrapperCol}},[a("a-radio-group",{attrs:{name:"openTablePath","default-value":t.form.openTablePath},on:{change:t.openTablePathChange},model:{value:t.form.openTablePath,callback:function(e){t.$set(t.form,"openTablePath",e)},expression:"form.openTablePath"}},[a("a-radio",{attrs:{value:"1"}},[t._v(" 开启 ")]),a("a-radio",{attrs:{value:"0"}},[t._v(" 不开启 ")])],1),a("a-popover",{attrs:{title:"说明"}},[a("template",{slot:"content"},[a("span",{staticStyle:{color:"grey","font-size":"12px","line-height":"1px"}},[t._v("工程路径 : "),a("span",{staticStyle:{color:"#2c65a0","font-size":"12px","line-height":"1px"}},[t._v(" buukle-example/src/java")]),t._v(" 表名 : table_example ")]),a("br"),a("span",{staticStyle:{color:"grey","font-size":"12px","line-height":"1px"}},[t._v("生成的文件路径信息:")]),a("br"),a("span",{staticStyle:{color:"grey","font-size":"12px","line-height":"1px"}},[t._v(" 开启后 : "),a("span",{staticStyle:{color:"#2c65a0","font-size":"12px","line-height":"1px"}},[t._v(" buukle-example/src/java")]),a("span",{staticStyle:{color:"red","font-size":"12px","line-height":"1px"}},[t._v("/tableExample")]),t._v("/TableExample.java "),a("br"),t._v(" 不开启 : "),a("span",{staticStyle:{color:"#2c65a0","font-size":"12px","line-height":"1px"}},[t._v(" buukle-example/src/java")]),t._v("/TableExample.java ")])]),a("a-icon",{attrs:{type:"question-circle"}})],2)],1)],1),a("a-form-model-item",{staticStyle:{"margin-top":"-22px"},attrs:{label:"包名",prop:"packageInfo","label-col":t.formItemLayout.labelCol,"wrapper-col":t.formItemLayout.wrapperCol}},[a("a-input",{attrs:{placeholder:"请输入包名",suffix:t.suffix},model:{value:t.form.packageInfo,callback:function(e){t.$set(t.form,"packageInfo",e)},expression:"form.packageInfo"}}),a("span",{staticStyle:{color:"grey","font-size":"12px","line-height":"1px"}},[t._v("无包名需求可不填写(模板中使用${packageInfo} 获取该值)")])],1),a("a-form-model-item",{attrs:{label:"模板内容",prop:"name","label-col":t.formItemLayout.labelCol,"wrapper-col":t.formItemLayout.wrapperCol}},[a("a-popover",{attrs:{title:"全局变量列表"}},[a("template",{slot:"content"},[a("a-table",{attrs:{columns:t.columns,pagination:!1,"data-source":t.data,bordered:""},scopedSlots:t._u([{key:"name",fn:function(e){return[a("a",[t._v(t._s(e))])]}}])})],1),a("span",[t._v("全局变量列表")]),a("a-icon",{attrs:{type:"question-circle"}})],2),a("a-textarea",{staticStyle:{"background-color":"#e6e6e6",color:"black",border:"0px","margin-top":"25px","-webkit-appearance":"none",padding:"15px"},attrs:{rows:"20",cols:"20",placeholder:"请输入模板内容"},model:{value:t.form.content,callback:function(e){t.$set(t.form,"content",e)},expression:"form.content"}})],1),a("a-form-model-item",{attrs:{label:"备注",prop:"remark","label-col":t.formItemLayout.labelCol,"wrapper-col":t.formItemLayout.wrapperCol}},[a("a-input",{attrs:{placeholder:"请输入备注"},model:{value:t.form.remark,callback:function(e){t.$set(t.form,"remark",e)},expression:"form.remark"}})],1)],1)],1),a("template",{slot:"footer"},[a("a-button",{attrs:{type:"primary"},on:{click:function(e){return t.handleEdit()}}},[t._v(" 提交 ")]),a("a-button",{on:{click:function(e){return t.handleClose()}}},[t._v(" 取消 ")])],1)],2)},n=[],s=a("2410"),l=a.n(s),r=a("b775"),i=a("f64c"),p={labelCol:{span:5},wrapperCol:{span:16}},c=[{title:"变量",dataIndex:"name",scopedSlots:{customRender:"name"}},{title:"内容",dataIndex:"mean"}],m=[{title:"变量",dataIndex:"name",scopedSlots:{customRender:"name"}},{title:"内容",dataIndex:"value"}],u=[{name:"${dollar}",mean:'【$】(处理beetl的"$"转义问题,模板需要输出$时,直接${dollar} 取即可)'},{name:"${author}",mean:"【作者】"},{name:"${packageInfo}",mean:"【模板包名】"},{name:"${entity}",mean:"【实体名称(大驼峰)】"},{name:"${entityNameLowerCamelCase}",mean:"【实体名称(小驼峰)】"},{name:"${date}",mean:"【当前日期】"},{name:"${table.comment!}",mean:"【表注释】"},{name:"${table.name}",mean:"【实际表名】"},{name:"${field.comment}",mean:"【字段注释】"},{name:"${field.propertyType}",mean:"【字段类型(java语言)】"},{name:"${field.propertyName}",mean:"【字段名称(小驼峰)】"}],d={components:{},props:{initvalue:{type:Object,default:null}},watch:{initvalue:function(){if(this.initvalue){for(var t in this.initvalue)this.form[t]=this.initvalue[t];"1"===this.form.openTablePath?this.suffix=" .表名小驼峰":this.suffix=""}else this.form=l()(this.initForm)}},methods:{templatesGroupChange:function(t,e){var a=this;this.form.templatesGroupId=e.data.key,this.bodyById.id=e.data.key,this.commonRequest.body=this.bodyById;var o=this.commonRequest;Object(r["b"])({url:"/templatesGroup/getById",method:"post",dataType:"json",data:o}).then((function(t){"S"===t.head.status?a.form.templatesGroupParamList=t.body.paramList:i["a"].error(t.head.msg)})).catch((function(t){console.log(t)}))},getTemplatesGroupList:function(){var t=this,e=this.commonRequest;Object(r["b"])({url:"/templatesGroup/getTemplatesGroupList",method:"post",dataType:"json",data:e}).then((function(e){"S"===e.head.status?t.templatesGroupList=e.body:i["a"].error(e.head.msg)})).catch((function(t){console.log(t)}))},openTablePathChange:function(){"1"===this.form.openTablePath?this.suffix=" .表名小驼峰":this.suffix=""},getTitle:function(t){var e=this.$createElement;return e("span",t?[" 编辑 ",e("span",{style:"color: red;font-size: 12px;"},[" * 注 : 当前只兼容 beetl 模板语法 "])]:[" 新建 ",e("span",{style:"color: red;font-size: 12px;"},[" * 注 : 当前只兼容 beetl 模板语法 "])])},show:function(){this.visible=!0,this.getTemplatesGroupList()},handleClose:function(){this.form=l()(this.initForm),this.form.param="",this.visible=!1},handleEdit:function(){var t=this;this.$refs.form.validate((function(e){if(e){t.commonRequest.head.operationTime=Date.now(),t.commonRequest.body=t.form;var a=t.commonRequest;Object(r["b"])({url:"/templates/addOrEdit",method:"post",dataType:"json",data:a}).then((function(e){"S"===e.head.status?(i["a"].success(e.head.msg),t.handleClose(),t.$emit("refresh")):i["a"].error(e.head.msg)})).catch((function(t){console.log(t)}))}}))}},data:function(){return{data:u,columns:c,columnsGroupParam:m,visible:!1,suffix:"",formLayout:"horizontal",formItemLayout:p,templatesGroupList:[],form:{id:null,templatesGroupId:"",templatesGroupName:"",templatesGroupParamList:"",name:"",path:"",openTablePath:"",useOriginalName:"",addNameSuffix:"",packageInfo:"",content:"",type:"",remark:""},initForm:{id:null,templatesGroupId:"",templatesGroupName:"",templatesGroupParamList:"",name:"",path:"",openTablePath:"",useOriginalName:"",addNameSuffix:"",packageInfo:"",content:"",type:"",remark:""},rules:{name:[{required:!0,message:"请输入"},{max:50,message:"最多输入50个字符"},{pattern:/^(?!(\s+$))/,message:"输入格式错误"}],path:[{required:!0,message:"请输入"},{max:256,message:"最多输入256个字符"}],url:[{required:!0,message:"请输入"},{max:256,message:"最多输入256个字符"}],username:[{required:!0,message:"请输入"},{max:16,message:"最多输入16个字符"}],openTablePath:[{required:!0,message:"请选择"}],addNameSuffix:[{required:!0,message:"请选择"}],password:[{required:!0,message:"请输入"},{max:16,message:"最多输入16个字符"}],templatesGroupName:[{required:!0,message:"请输入模板分组"},{max:50,message:"请输入模板分组"}]},commonRequest:{head:{operationTime:Date.now()},body:{}},bodyById:{id:0}}}},f=d,h=(a("12b9"),a("2877")),v=Object(h["a"])(f,o,n,!1,null,null,null);e["default"]=v.exports},"7f69":function(t,e,a){"use strict";a.r(e);var o=function(){var t=this,e=t.$createElement,a=t._self._c||e;return a("a-row",{staticStyle:{"background-color":"white"},attrs:{type:"flex"}},[a("a-col",{staticStyle:{"padding-top":"10px","padding-left":"10px"},attrs:{span:3}},[a("a-tree",{attrs:{"tree-data":t.templatesGroupTree,"show-line":!0,selectedKeys:t.selectedKeys},on:{expand:t.onExpand,select:t.onSelect},scopedSlots:t._u([{key:"title",fn:function(e){var o=e.key,n=e.title;return[a("a-dropdown",{attrs:{trigger:["contextmenu"]},scopedSlots:t._u([{key:"overlay",fn:function(){return[a("a-menu",{on:{click:function(e){var a=e.key;return t.onContextMenuClick(o,a)}}},[a("a-menu-item",{key:"1"},[t._v("复制分组(带模板)")]),a("a-menu-item",{key:"2"},[t._v("查看分组变量")])],1)]},proxy:!0}],null,!0)},[a("span",[t._v(t._s(n))])])]}}])})],1),a("a-col",{staticStyle:{"padding-top":"10px","padding-left":"10px"},attrs:{span:21}},[a("div",{staticClass:"table-page-search-wrapper"},[a("a-form",{attrs:{layout:"inline"}},[a("a-row",{attrs:{gutter:48}},[a("a-input",{attrs:{type:"hidden",name:"templatesGroupId",placeholder:""},model:{value:t.queryParam.templatesGroupId,callback:function(e){t.$set(t.queryParam,"templatesGroupId",e)},expression:"queryParam.templatesGroupId"}}),a("a-col",{attrs:{md:8,sm:24}},[a("a-form-item",{attrs:{label:"模板名称"}},[a("a-input",{attrs:{name:"name",placeholder:""},model:{value:t.queryParam.name,callback:function(e){t.$set(t.queryParam,"name",e)},expression:"queryParam.name"}})],1)],1),a("a-col",{attrs:{md:8,sm:24}},[a("a-form-item",{attrs:{label:"状态"}},[a("a-select",{attrs:{placeholder:"请选择","default-value":"0"},model:{value:t.queryParam.states,callback:function(e){t.$set(t.queryParam,"states",e)},expression:"queryParam.states"}},[a("a-select-option",{attrs:{value:""}},[t._v("全部")]),a("a-select-option",{attrs:{value:"1"}},[t._v("创建完成")]),a("a-select-option",{attrs:{value:"2"}},[t._v("审批中")]),a("a-select-option",{attrs:{value:"3"}},[t._v("正常")]),a("a-select-option",{attrs:{value:"4"}},[t._v("已禁用")])],1)],1)],1),t.advanced?void 0:t._e(),a("a-col",{attrs:{md:t.advanced?24:8,sm:24}},[a("span",{staticClass:"table-page-search-submitButtons",style:t.advanced&&{float:"right",overflow:"hidden"}||{}},[a("a-button",{attrs:{type:"primary"},on:{click:t.handleAdd}},[t._v("新建")]),a("a-button",{staticStyle:{"margin-left":"8px"},attrs:{type:"primary"},on:{click:function(e){return t.handleSearch()}}},[t._v("查询")]),a("a-button",{staticStyle:{"margin-left":"8px"},on:{click:function(e){return t.handleReset()}}},[t._v("重置")])],1)])],2)],1)],1),a("s-table",{ref:"table",attrs:{size:"default",rowKey:"id",columns:t.columns,data:t.loadData,alert:!0,rowSelection:t.rowSelection,pagination:{showTotal:function(t){return"共 "+t+" 条记录"}}},scopedSlots:t._u([{key:"serial",fn:function(e,o,n){return a("span",{},[t._v(" "+t._s(n+1)+" ")])}},{key:"status",fn:function(e){return a("span",{},[a("a-badge",{attrs:{status:t._f("statusTypeFilter")(e),text:t._f("statusFilter")(e)}})],1)}},{key:"name",fn:function(e){return a("span",{},[a("ellipsis",{attrs:{length:64,tooltip:""}},[t._v(t._s(e))])],1)}},{key:"gmtCreated",fn:function(e){return a("span",{},[a("ellipsis",{attrs:{length:64,tooltip:""}},[t._v(t._s(t.gmtDateFormat(e)))])],1)}},{key:"action",fn:function(e,o){return a("span",{},[[a("a",{on:{click:function(e){return t.handleEdit(o.id)}}},[t._v("编辑")]),t._v("  "),a("a",{on:{click:function(e){return t.handleDelete(o.id)}}},[t._v("删除")]),t._v("  "),a("a",{on:{click:function(e){return t.handleInfo(o.id)}}},[t._v("详情")]),t._v("  ")]],2)}}])}),a("AddOrEditForm",{ref:"AddOrEditForm",attrs:{initvalue:t.initvalue},on:{refresh:t.refresh}}),a("InfoTable",{ref:"InfoTable",attrs:{initvalue:t.initvalue},on:{refresh:t.refresh}})],1)],1)},n=[],s=(a("99af"),a("d81d"),a("b0c0"),a("2af9")),l=a("b775"),r=a("f64c"),i=a("66a2"),p=a("0cc3"),c=a("c1df"),m=a.n(c);r["a"].config({duration:3,top:"40px",maxCount:3});var u={mounted:function(){this.getTemplatesGroupTree()},name:"list",components:{InfoTable:p["default"],STable:s["c"],Ellipsis:s["a"],AddOrEditForm:i["default"]},methods:{onContextMenuClick:function(t,e){console.log("treeKey: ".concat(t,", menuKey: ").concat(e))},handleReset:function(){this.queryParam={},this.queryParam.templatesGroupId=null,this.selectedKeys=[]},getTemplatesGroupTree:function(){var t=this;this.commonRequest.head.operationTime=Date.now();var e=this.commonRequest;Object(l["b"])({url:"/templatesGroup/getTemplatesGroupList",method:"post",dataType:"json",data:e}).then((function(e){if("S"===e.head.status){var a=e.body.map((function(t){return{title:t.name,key:t.id}})),o={title:"全部模板分组",key:""};o.children=a,t.templatesGroupTree=[o]}else r["a"].error(e.head.msg)})).catch((function(t){console.log(t)}))},onExpand:function(t){console.log("onExpand",t)},onSelect:function(t,e){this.queryParam={},this.queryParam.templatesGroupId=t[0],this.selectedKeys=t,this.$refs.table.refresh(!0)},refresh:function(){this.$refs.table.refresh(!0)},handleSearch:function(){this.$refs.table.pagination.pageNo=1,this.$refs.table.refresh(!0)},handleAdd:function(){this.initvalue={},this.$refs.AddOrEditForm.show()},handleDelete:function(t){var e=this.$refs.table;this.commonRequest.head.operationTime=Date.now(),this.bodyById.id=t,this.commonRequest.body=this.bodyById;var a=this.commonRequest;this.$confirm({title:"确认提示",content:"是否删除该条记录？",okType:"danger",okText:"确认",cancelText:"取消",onOk:function(){Object(l["b"])({url:"/templates/deleteById",method:"post",dataType:"json",data:a}).then((function(t){"S"===t.head.status?(r["a"].success("成功!"),e.refresh()):r["a"].error(t.head.msg)}))}})},handleEdit:function(t){var e=this;this.commonRequest.head.operationTime=Date.now(),this.bodyById.id=t,this.commonRequest.body=this.bodyById;var a=this.commonRequest;Object(l["b"])({url:"/templates/getById",method:"post",dataType:"json",data:a}).then((function(t){"S"===t.head.status?(e.initvalue=t.body,e.$refs.AddOrEditForm.show()):r["a"].error(t.head.msg)})).catch((function(t){console.log(t)}))},handleInfo:function(t){var e=this;this.commonRequest.head.operationTime=Date.now(),this.bodyById.id=t,this.commonRequest.body=this.bodyById;var a=this.commonRequest;Object(l["b"])({url:"/templates/getById",method:"post",dataType:"json",data:a}).then((function(t){"S"===t.head.status?(e.initvalue=t.body,e.$refs.InfoTable.show()):r["a"].error(t.head.msg)})).catch((function(t){console.log(t)}))},handleBan:function(t){0!==t.status?this.$message.info("".concat(t.name," 已停用")):this.$message.error("".concat(t.name," 停用失败"))},onSelectChange:function(t,e){this.selectedRowKeys=t,this.selectedRows=e},toggleAdvanced:function(){this.advanced=!this.advanced},gmtDateFormat:function(t){return m()(t).format("yyyy-MM-DD HH:mm:ss")}},data:function(){var t=this;return this.columns=d,{initvalue:{},visible:!1,confirmLoading:!1,dialogFormVisible:!1,mdl:null,advanced:!1,queryParam:{},commonRequest:{head:{operationTime:Date.now()},body:{}},bodyById:{id:0},templatesGroupTree:[],selectedKeys:[],loadData:function(e){var a=Object.assign({},e,t.queryParam);t.commonRequest.head.operationTime=Date.now(),t.commonRequest.body=a;var o=t.commonRequest;return Object(l["b"])({url:"/templates/getPage",method:"post",dataType:"json",data:o}).then((function(t){return t.result}))},selectedRowKeys:[],selectedRows:[]}},filters:{statusFilter:function(t){return f[t].text},statusTypeFilter:function(t){return f[t].status}},computed:{rowSelection:function(){return{selectedRowKeys:this.selectedRowKeys,onChange:this.onSelectChange}}}},d=[{title:"序号",width:"5%",scopedSlots:{customRender:"serial"}},{title:"模板名称",width:"35%",dataIndex:"name",scopedSlots:{customRender:"name"},needTotal:!0},{title:"创建时间",width:"20%",dataIndex:"gmtCreated",scopedSlots:{customRender:"gmtCreated"}},{title:"创建者",dataIndex:"creator",width:"10%"},{title:"状态",dataIndex:"status",width:"10%",scopedSlots:{customRender:"status"}},{title:"操作",dataIndex:"action",width:"20%",scopedSlots:{customRender:"action"}}],f={1:{status:"default",text:"创建完成"},2:{status:"processing",text:"审批中"},3:{status:"success",text:"正常"},4:{status:"warning",text:"已禁用"}},h=u,v=a("2877"),y=Object(v["a"])(h,o,n,!1,null,null,null);e["default"]=y.exports}}]);
(window["webpackJsonp"]=window["webpackJsonp"]||[]).push([["chunk-1f561ce0"],{"21a4":function(e,a,t){"use strict";t.r(a);var o=function(){var e=this,a=e.$createElement,t=e._self._c||a;return t("a-modal",{attrs:{destroyOnClose:!0,width:900,height:600,visible:e.visible,title:e.getTitle(e.initvalue)},model:{value:e.visible,callback:function(a){e.visible=a},expression:"visible"}},[t("div",{staticClass:"main"},[t("a-form-model",{ref:"form",attrs:{layout:e.formLayout,model:e.form,rules:e.rules}},[t("a-form-model-item",{directives:[{name:"show",rawName:"v-show",value:!1,expression:"false"}],attrs:{label:"id",prop:"id","label-col":e.formItemLayout.labelCol,"wrapper-col":e.formItemLayout.wrapperCol}},[t("a-input",{model:{value:e.form.id,callback:function(a){e.$set(e.form,"id",a)},expression:"form.id"}})],1),t("a-form-model-item",{attrs:{label:"模板名称",prop:"name","label-col":e.formItemLayout.labelCol,"wrapper-col":e.formItemLayout.wrapperCol}},[t("a-input",{attrs:{placeholder:"请输入模板名称"},model:{value:e.form.name,callback:function(a){e.$set(e.form,"name",a)},expression:"form.name"}}),t("span",{staticStyle:{color:"grey","font-size":"12px","line-height":"1px"}},[e._v(" 请按照模板: "),t("span",{staticStyle:{color:"red","font-size":"12px","line-height":"1px"}},[e._v("A.B.btl")]),e._v(" 填写,生成目标文件时会截取"),t("span",{staticStyle:{color:"red"}},[e._v("B")]),e._v("值作为文件后缀名 ")]),t("a-form-model-item",{attrs:{label:"前段追加",prop:"addNameSuffix","label-col":e.formItemLayout.labelCol,"wrapper-col":e.formItemLayout.wrapperCol}},[t("a-radio-group",{attrs:{name:"addNameSuffix","default-value":e.form.addNameSuffix},model:{value:e.form.addNameSuffix,callback:function(a){e.$set(e.form,"addNameSuffix",a)},expression:"form.addNameSuffix"}},[t("a-radio",{attrs:{value:"1"}},[e._v(" 开启 ")]),t("a-radio",{attrs:{value:"0"}},[e._v(" 不开启 ")])],1),t("a-popover",{attrs:{title:"说明"}},[t("template",{slot:"content"},[t("span",{staticStyle:{color:"grey","font-size":"12px","line-height":"1px"}},[e._v("开启后,模板名称前段(A)会追加到生成文件名尾部,例如-- ")]),t("span",{staticStyle:{color:"grey","font-size":"12px","line-height":"1px"}},[e._v("模板名称 : QueryDTO.java.btl 表名:table_example ")]),t("br"),t("span",{staticStyle:{color:"grey","font-size":"12px","line-height":"1px"}},[e._v("生成的文件名为")]),t("br"),t("span",{staticStyle:{color:"grey","font-size":"12px","line-height":"1px"}},[e._v(" 开启后 : "),t("span",{staticStyle:{color:"#2c65a0","font-size":"12px","line-height":"1px"}},[e._v("TableExample")]),t("span",{staticStyle:{color:"red","font-size":"12px","line-height":"1px"}},[e._v("QueryDTO")]),e._v(".vue "),t("br"),e._v(" 不开启 : "),t("span",{staticStyle:{color:"#2c65a0","font-size":"12px","line-height":"1px"}},[e._v("TableExample")]),e._v(".vue ")])]),t("a-icon",{attrs:{type:"question-circle"}})],2)],1)],1),t("a-form-model-item",{staticStyle:{"margin-top":"-22px"},attrs:{label:"工程路径",prop:"path","label-col":e.formItemLayout.labelCol,"wrapper-col":e.formItemLayout.wrapperCol}},[t("a-input",{attrs:{placeholder:"请输入工程路径"},model:{value:e.form.path,callback:function(a){e.$set(e.form,"path",a)},expression:"form.path"}}),t("a-form-model-item",{attrs:{label:"表名路径",prop:"openTablePath","label-col":e.formItemLayout.labelCol,"wrapper-col":e.formItemLayout.wrapperCol}},[t("a-radio-group",{attrs:{name:"openTablePath","default-value":e.form.openTablePath},model:{value:e.form.openTablePath,callback:function(a){e.$set(e.form,"openTablePath",a)},expression:"form.openTablePath"}},[t("a-radio",{attrs:{value:"1"}},[e._v(" 开启 ")]),t("a-radio",{attrs:{value:"0"}},[e._v(" 不开启 ")])],1),t("a-popover",{attrs:{title:"说明"}},[t("template",{slot:"content"},[t("span",{staticStyle:{color:"grey","font-size":"12px","line-height":"1px"}},[e._v("工程路径 : "),t("span",{staticStyle:{color:"#2c65a0","font-size":"12px","line-height":"1px"}},[e._v(" buukle-example/src/java")]),e._v(" 表名 : table_example ")]),t("br"),t("span",{staticStyle:{color:"grey","font-size":"12px","line-height":"1px"}},[e._v("生成的文件路径信息:")]),t("br"),t("span",{staticStyle:{color:"grey","font-size":"12px","line-height":"1px"}},[e._v(" 开启后 : "),t("span",{staticStyle:{color:"#2c65a0","font-size":"12px","line-height":"1px"}},[e._v(" buukle-example/src/java")]),t("span",{staticStyle:{color:"red","font-size":"12px","line-height":"1px"}},[e._v("/tableExample")]),e._v("/TableExample.java "),t("br"),e._v(" 不开启 : "),t("span",{staticStyle:{color:"#2c65a0","font-size":"12px","line-height":"1px"}},[e._v(" buukle-example/src/java")]),e._v("/TableExample.java ")])]),t("a-icon",{attrs:{type:"question-circle"}})],2)],1)],1),t("a-form-model-item",{staticStyle:{"margin-top":"-22px"},attrs:{label:"包名",prop:"packageInfo","label-col":e.formItemLayout.labelCol,"wrapper-col":e.formItemLayout.wrapperCol}},[t("a-input",{attrs:{placeholder:"请输入包名"},model:{value:e.form.packageInfo,callback:function(a){e.$set(e.form,"packageInfo",a)},expression:"form.packageInfo"}}),t("span",{staticStyle:{color:"grey","font-size":"12px","line-height":"1px"}},[e._v("后端代码使用,前端代码若无包名需求可不填写(模板中使用${packageInfo} 获取该值)")])],1),t("a-form-model-item",{attrs:{label:"模板内容",prop:"name","label-col":e.formItemLayout.labelCol,"wrapper-col":e.formItemLayout.wrapperCol}},[t("a-popover",{attrs:{title:"支持的变量列表"}},[t("template",{slot:"content"},[t("a-table",{attrs:{columns:e.columns,"data-source":e.data,bordered:""},scopedSlots:e._u([{key:"name",fn:function(a){return[t("a",[e._v(e._s(a))])]}}])})],1),t("span",[e._v("支持的变量列表")]),t("a-icon",{attrs:{type:"question-circle"}})],2),t("a-textarea",{staticStyle:{"background-color":"#e6e6e6",color:"black",border:"0px","margin-top":"25px","-webkit-appearance":"none",padding:"15px"},attrs:{rows:"20",cols:"20",placeholder:"请输入模板内容"},model:{value:e.form.content,callback:function(a){e.$set(e.form,"content",a)},expression:"form.content"}})],1),t("a-form-model-item",{attrs:{label:"备注",prop:"remark","label-col":e.formItemLayout.labelCol,"wrapper-col":e.formItemLayout.wrapperCol}},[t("a-input",{attrs:{placeholder:"请输入备注"},model:{value:e.form.remark,callback:function(a){e.$set(e.form,"remark",a)},expression:"form.remark"}})],1)],1)],1),t("template",{slot:"footer"},[t("a-button",{attrs:{type:"primary"},on:{click:function(a){return e.handleEdit()}}},[e._v(" 提交 ")]),t("a-button",{on:{click:function(a){return e.handleClose()}}},[e._v(" 取消 ")])],1)],2)},l=[],r=t("2410"),n=t.n(r),i=t("b775"),s=t("f64c"),m={labelCol:{span:5},wrapperCol:{span:16}},p=[{title:"变量",dataIndex:"name",scopedSlots:{customRender:"name"}},{title:"内容",dataIndex:"mean"}],c=[{name:"${author}",mean:"作者"},{name:"${packageInfo}",mean:"模板包名"},{name:"${entity}",mean:"实体名称(大驼峰)"},{name:"${entityNameLowerCamelCase}",mean:"实体名称(小驼峰)"}],f={components:{},props:{initvalue:{type:Object,default:null}},watch:{initvalue:function(){if(this.initvalue)for(var e in this.initvalue)this.form[e]=this.initvalue[e];else this.form=n()(this.initForm)}},methods:{getTitle:function(e){var a=this.$createElement;return a("span",e?[" 编辑 ",a("span",{style:"color: red;font-size: 12px;"},[" * 注 : 当前只兼容 beetl 模板语法 "])]:[" 新建 ",a("span",{style:"color: red;font-size: 12px;"},[" * 注 : 当前只兼容 beetl 模板语法 "])])},show:function(){this.visible=!0},handleClose:function(){this.form=n()(this.initForm),this.form.param="",this.visible=!1},handleEdit:function(){var e=this;this.$refs.form.validate((function(a){if(a){e.commonRequest.head.operationTime=Date.now(),e.commonRequest.body=e.form;var t=e.commonRequest;Object(i["b"])({url:"/templates/addOrEdit",method:"post",dataType:"json",data:t}).then((function(a){"S"===a.head.status?(s["a"].success(a.head.msg),e.handleClose(),e.$emit("refresh")):s["a"].error(a.head.msg)})).catch((function(e){console.log(e)}))}}))}},data:function(){return{data:c,columns:p,visible:!1,formLayout:"horizontal",formItemLayout:m,form:{id:null,name:"",path:"",openTablePath:"",addNameSuffix:"",packageInfo:"",content:"",type:"",remark:""},initForm:{id:null,name:"",path:"",openTablePath:"",addNameSuffix:"",packageInfo:"",content:"",type:"",remark:""},rules:{name:[{required:!0,message:"请输入"},{max:50,message:"最多输入50个字符"},{pattern:/^(?!(\s+$))/,message:"输入格式错误"}],path:[{required:!0,message:"请输入"},{max:256,message:"最多输入256个字符"}],url:[{required:!0,message:"请输入"},{max:256,message:"最多输入256个字符"}],username:[{required:!0,message:"请输入"},{max:16,message:"最多输入16个字符"}],openTablePath:[{required:!0,message:"请选择"}],addNameSuffix:[{required:!0,message:"请选择"}],password:[{required:!0,message:"请输入"},{max:16,message:"最多输入16个字符"}]},commonRequest:{head:{operationTime:Date.now()},body:{}}}}},u=f,d=(t("5ec4"),t("2877")),h=Object(d["a"])(u,o,l,!1,null,null,null);a["default"]=h.exports},"5ec4":function(e,a,t){"use strict";t("9487")},9487:function(e,a,t){}}]);
(window["webpackJsonp"]=window["webpackJsonp"]||[]).push([["chunk-2d0b1f68"],{"21a4":function(e,a,o){"use strict";o.r(a);var t=function(){var e=this,a=e.$createElement,o=e._self._c||a;return o("a-modal",{attrs:{destroyOnClose:!0,width:900,height:600,visible:e.visible,title:e.getTitle(e.initvalue)},model:{value:e.visible,callback:function(a){e.visible=a},expression:"visible"}},[o("div",{staticClass:"main"},[o("a-form-model",{ref:"form",attrs:{layout:e.formLayout,model:e.form,rules:e.rules}},[o("a-form-model-item",{directives:[{name:"show",rawName:"v-show",value:!1,expression:"false"}],attrs:{label:"id",prop:"id","label-col":e.formItemLayout.labelCol,"wrapper-col":e.formItemLayout.wrapperCol}},[o("a-input",{model:{value:e.form.id,callback:function(a){e.$set(e.form,"id",a)},expression:"form.id"}})],1),o("a-form-model-item",{attrs:{label:"模板名称",prop:"name","label-col":e.formItemLayout.labelCol,"wrapper-col":e.formItemLayout.wrapperCol}},[o("a-input",{attrs:{placeholder:"请输入模板名称"},model:{value:e.form.name,callback:function(a){e.$set(e.form,"name",a)},expression:"form.name"}}),o("span",{staticStyle:{color:"grey","font-size":"12px","line-height":"1px"}},[e._v("请按照 A.B.btl 填写,生成文件的时候会截取 B 的值作为文件后缀名 (例如 : Entity.java.btl ,生成的文件是 : 表名大驼峰.java) ")])],1),o("a-form-model-item",{attrs:{label:"工程路径",prop:"path","label-col":e.formItemLayout.labelCol,"wrapper-col":e.formItemLayout.wrapperCol}},[o("a-input",{attrs:{placeholder:"请输入工程路径"},model:{value:e.form.path,callback:function(a){e.$set(e.form,"path",a)},expression:"form.path"}})],1),o("a-form-model-item",{attrs:{label:"包名",prop:"packageInfo","label-col":e.formItemLayout.labelCol,"wrapper-col":e.formItemLayout.wrapperCol}},[o("a-input",{attrs:{placeholder:"请输入包名"},model:{value:e.form.packageInfo,callback:function(a){e.$set(e.form,"packageInfo",a)},expression:"form.packageInfo"}}),o("span",{staticStyle:{color:"grey","font-size":"12px","line-height":"1px"}},[e._v("后端代码使用,前端代码若无包名需求可不填写(模板中使用${packageInfo} 获取该值)")])],1),o("a-form-model-item",{attrs:{label:"模板内容",prop:"name","label-col":e.formItemLayout.labelCol,"wrapper-col":e.formItemLayout.wrapperCol}},[o("a-textarea",{staticStyle:{"background-color":"#e6e6e6",color:"black",border:"0px","margin-top":"25px","-webkit-appearance":"none",padding:"15px"},attrs:{rows:"20",cols:"20",placeholder:"请输入模板内容"},model:{value:e.form.content,callback:function(a){e.$set(e.form,"content",a)},expression:"form.content"}})],1),o("a-form-model-item",{attrs:{label:"备注",prop:"remark","label-col":e.formItemLayout.labelCol,"wrapper-col":e.formItemLayout.wrapperCol}},[o("a-input",{attrs:{placeholder:"请输入备注"},model:{value:e.form.remark,callback:function(a){e.$set(e.form,"remark",a)},expression:"form.remark"}})],1)],1)],1),o("template",{slot:"footer"},[o("a-button",{attrs:{type:"primary"},on:{click:function(a){return e.handleEdit()}}},[e._v(" 提交 ")]),o("a-button",{on:{click:function(a){return e.handleClose()}}},[e._v(" 取消 ")])],1)],2)},r=[],l=o("2410"),n=o.n(l),s=o("b775"),i=o("f64c"),m={labelCol:{span:5},wrapperCol:{span:16}},p={components:{},props:{initvalue:{type:Object,default:null}},watch:{initvalue:function(){if(this.initvalue)for(var e in this.initvalue)this.form[e]=this.initvalue[e];else this.form=n()(this.initForm)}},methods:{getTitle:function(e){var a=this.$createElement;return a("span",e?[" 编辑 ",a("span",{style:"color: red;font-size: 12px;"},[" * 注 : 当前只兼容 beetl 模板语法 "])]:[" 新建 ",a("span",{style:"color: red;font-size: 12px;"},[" * 注 : 当前只兼容 beetl 模板语法 "])])},show:function(){this.visible=!0},handleClose:function(){this.form=n()(this.initForm),this.form.param="",this.visible=!1},handleEdit:function(){var e=this;this.$refs.form.validate((function(a){if(a){e.commonRequest.head.operationTime=Date.now(),e.commonRequest.body=e.form;var o=e.commonRequest;Object(s["b"])({url:"/templates/addOrEdit",method:"post",dataType:"json",data:o}).then((function(a){"S"===a.head.status?(i["a"].success(a.head.msg),e.handleClose(),e.$emit("refresh")):i["a"].error(a.head.msg)})).catch((function(e){console.log(e)}))}}))}},data:function(){return{visible:!1,formLayout:"horizontal",formItemLayout:m,form:{id:null,name:"",path:"",packageInfo:"",content:"",type:"",remark:""},initForm:{id:null,name:"",path:"",packageInfo:"",content:"",type:"",remark:""},rules:{name:[{required:!0,message:"请输入"},{max:50,message:"最多输入50个字符"},{pattern:/^(?!(\s+$))/,message:"输入格式错误"}],path:[{required:!0,message:"请输入"},{max:256,message:"最多输入256个字符"}],url:[{required:!0,message:"请输入"},{max:256,message:"最多输入256个字符"}],username:[{required:!0,message:"请输入"},{max:16,message:"最多输入16个字符"}],password:[{required:!0,message:"请输入"},{max:16,message:"最多输入16个字符"}]},commonRequest:{head:{operationTime:Date.now()},body:{}}}}},c=p,f=o("2877"),u=Object(f["a"])(c,t,r,!1,null,null,null);a["default"]=u.exports}}]);
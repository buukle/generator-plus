(window["webpackJsonp"]=window["webpackJsonp"]||[]).push([["chunk-d5407b90"],{"046b":function(e,t,a){"use strict";a.r(t);var l=function(){var e=this,t=e.$createElement,a=e._self._c||t;return a("a-modal",{attrs:{destroyOnClose:!0,width:1080,visible:e.visible,title:e.getTitle(e.initvalue)},model:{value:e.visible,callback:function(t){e.visible=t},expression:"visible"}},[a("div",{staticClass:"main"},[a("a-form-model",{ref:"form",attrs:{layout:e.formLayout,model:e.form,rules:e.rules}},[a("a-form-model-item",{directives:[{name:"show",rawName:"v-show",value:!1,expression:"false"}],attrs:{label:"id",prop:"id","label-col":e.formItemLayout.labelCol,"wrapper-col":e.formItemLayout.wrapperCol}},[a("a-input",{model:{value:e.form.id,callback:function(t){e.$set(e.form,"id",t)},expression:"form.id"}})],1),a("a-form-model-item",{attrs:{label:"名称",prop:"name","label-col":e.formItemLayout.labelCol,"wrapper-col":e.formItemLayout.wrapperCol}},[a("a-input",{attrs:{placeholder:"请输入名称"},model:{value:e.form.name,callback:function(t){e.$set(e.form,"name",t)},expression:"form.name"}})],1),a("a-form-model-item",{attrs:{label:"自定义分组变量",prop:"paramList","label-col":e.formItemLayout.labelCol,"wrapper-col":e.formItemLayout.wrapperCol}},[e._l(e.form.paramList,(function(t,l){return a("a-form-item",e._b({key:l,attrs:{required:!1}},"a-form-item",e.formItemLayout,!1),[e._v(" ("),a("span",{domProps:{innerHTML:e._s(l+1)}}),e._v(") "),a("a-input",{staticStyle:{width:"30%","margin-right":"8px"},attrs:{"addon-before":"变量名",placeholder:"name"},model:{value:t.name,callback:function(a){e.$set(t,"name",a)},expression:"k.name"}}),a("a-input",{staticStyle:{width:"30%","margin-right":"8px"},attrs:{"addon-before":"变量值",placeholder:"value"},model:{value:t.value,callback:function(a){e.$set(t,"value",a)},expression:"k.value"}}),e.form.paramList.length>0?a("a-icon",{staticClass:"dynamic-delete-button",attrs:{type:"minus-circle-o"},on:{click:function(){return e.remove(t)}}}):e._e()],1)})),a("a-form-item",e._b({},"a-form-item",e.formItemLayout,!1),[a("a-button",{staticStyle:{width:"60%"},attrs:{type:"dashed"},on:{click:e.add}},[a("a-icon",{attrs:{type:"plus"}}),e._v(" 添加分组变量 ")],1)],1)],2)],1)],1),a("template",{slot:"footer"},[a("a-button",{attrs:{type:"primary"},on:{click:function(t){return e.handleEdit()}}},[e._v(" 提交 ")]),a("a-button",{on:{click:function(t){return e.handleClose()}}},[e._v(" 取消 ")])],1)],2)},o=[],r=(a("a434"),a("b0c0"),a("2410")),n=a.n(r),i=a("b775"),s=a("f64c"),m={components:{},props:{initvalue:{type:Object,default:null}},watch:{initvalue:function(){if(this.initvalue)for(var e in this.initvalue)this.form[e]=this.initvalue[e];else this.form=n()(this.initForm)},visible:function(e,t){if(!e)try{this.form=n()(this.initForm)}catch(a){}}},methods:{remove:function(e){for(var t=this.form.paramList.length,a=0;a<t;a++)this.form.paramList[a]==e&&this.form.paramList.splice(a,1)},add:function(){this.form.paramList.push({name:"",value:""})},getTitle:function(e){var t=this.$createElement;return t("span",e?[" 编辑 "]:[" 新建 "])},show:function(){this.visible=!0},handleClose:function(){this.form=n()(this.initForm),this.form.param="",this.visible=!1},handleEdit:function(){var e=this;this.$refs.form.validate((function(t){if(t){for(var a=!0,l=0;l<e.form.paramList.length;l++)""===e.form.paramList[l].name&&(s["a"].error("请填写 [自定义分组变量] 第"+(l+1)+'行 "变量名"'),a=!1),""===e.form.paramList[l].value&&(s["a"].error("请填写 [自定义分组变量] 第"+(l+1)+'行 "变量值"'),a=!1);if(a){var o=JSON.parse(JSON.stringify(e.form));e.commonRequest.head.operationTime=Date.now(),e.commonRequest.body=o;var r=e.commonRequest;Object(i["b"])({url:"/templatesGroup/addOrEdit",method:"post",dataType:"json",data:r}).then((function(t){"S"===t.head.status?(s["a"].success(t.head.msg),e.handleClose(),e.$emit("refresh")):s["a"].error(t.head.msg)})).catch((function(e){console.log(e)}))}}}))}},data:function(){return{formItemLayout:{labelCol:{xs:{span:24},sm:{span:4}},wrapperCol:{xs:{span:24},sm:{span:20}}},visible:!1,formLayout:"horizontal",datasourcesList:[],form:{paramList:[],id:null,auditId:null,applicationCode:null,name:null,description:null,remark:null,gmtCreated:null,creator:null,creatorTenantId:null,creatorCode:null,gmtModified:null,modifier:null,modifierCode:null,auditStatus:null,status:null,bak01:null,bak02:null,bak03:null,bak04:null,bak05:null,end:""},initForm:{paramList:[],id:null,auditId:null,applicationCode:null,name:null,description:null,remark:null,gmtCreated:null,creator:null,creatorTenantId:null,creatorCode:null,gmtModified:null,modifier:null,modifierCode:null,auditStatus:null,status:null,bak01:null,bak02:null,bak03:null,bak04:null,bak05:null,end:""},rules:{name:[{required:!0,message:"请输入"},{max:50,message:"最多输入50个字符"},{pattern:/^(?!(\s+$))/,message:"输入格式错误"}]},commonRequest:{head:{operationTime:Date.now()},body:{}},bodyById:{id:0}}}},u=m,d=(a("81a0"),a("2877")),c=Object(d["a"])(u,l,o,!1,null,null,null);t["default"]=c.exports},"736a":function(e,t,a){},"81a0":function(e,t,a){"use strict";a("736a")}}]);
(window["webpackJsonp"]=window["webpackJsonp"]||[]).push([["chunk-5912cc92"],{"35c9":function(e,t,a){"use strict";a.r(t);var o=function(){var e=this,t=e.$createElement,a=e._self._c||t;return a("a-modal",{attrs:{destroyOnClose:!0,width:1080,visible:e.visible,title:e.getTitle(e.initvalue)},model:{value:e.visible,callback:function(t){e.visible=t},expression:"visible"}},[a("div",{staticClass:"main"},[a("a-form-model",{ref:"form",attrs:{layout:e.formLayout,model:e.form,rules:e.rules}},[a("a-form-model-item",{directives:[{name:"show",rawName:"v-show",value:!1,expression:"false"}],attrs:{label:"id",prop:"id","label-col":e.formItemLayout.labelCol,"wrapper-col":e.formItemLayout.wrapperCol}},[a("a-input",{model:{value:e.form.id,callback:function(t){e.$set(e.form,"id",t)},expression:"form.id"}})],1),a("span",{staticStyle:{"font-size":"15px","font-weight":"1000",color:"#827f7f"}},[e._v(" 基础配置 ")]),a("div",{staticClass:"line-border"},[a("a-form-model-item",{attrs:{label:"配置名称",prop:"name","label-col":e.formItemLayout.labelCol,"wrapper-col":e.formItemLayout.wrapperCol}},[a("a-input",{attrs:{placeholder:"请输入配置名称"},model:{value:e.form.name,callback:function(t){e.$set(e.form,"name",t)},expression:"form.name"}})],1)],1),a("span",{staticStyle:{"font-size":"15px","font-weight":"1000",color:"#827f7f"}},[e._v(" 连接配置 ")]),a("div",{staticClass:"line-border"},[a("a-form-model-item",{attrs:{label:"选择连接",prop:"datasourcesName","label-col":e.formItemLayout.labelCol,"wrapper-col":e.formItemLayout.wrapperCol}},[a("a-select",{attrs:{placeholder:"请选择连接"},on:{change:e.datasourcesChange},model:{value:e.form.datasourcesName,callback:function(t){e.$set(e.form,"datasourcesName",t)},expression:"form.datasourcesName"}},e._l(e.datasourcesList,(function(t){return a("a-select-option",{key:t.id,attrs:{value:t.name?t.name:t.id+1,title:t.name}},[e._v(" "+e._s(t.name?t.name:t.id+1)+" ")])})),1)],1),a("a-form-model-item",{attrs:{label:"选择表名",prop:"tables","label-col":e.formItemLayout.labelCol,"wrapper-col":e.formItemLayout.wrapperCol}},e._l(e.form.tableList,(function(t){return a("label",{key:t.name,attrs:{value:t.name}},[a("div",{staticStyle:{float:"left","margin-right":"25px"}},[a("input",{directives:[{name:"model",rawName:"v-model",value:e.form.tables,expression:"form.tables"}],attrs:{type:"checkbox"},domProps:{value:t.name,checked:Array.isArray(e.form.tables)?e._i(e.form.tables,t.name)>-1:e.form.tables},on:{change:function(a){var o=e.form.tables,r=a.target,s=!!r.checked;if(Array.isArray(o)){var l=t.name,i=e._i(o,l);r.checked?i<0&&e.$set(e.form,"tables",o.concat([l])):i>-1&&e.$set(e.form,"tables",o.slice(0,i).concat(o.slice(i+1)))}else e.$set(e.form,"tables",s)}}}),e._v(" "+e._s(t.name)+" ")])])})),0)],1),a("span",{staticStyle:{"font-size":"15px","font-weight":"1000",color:"#827f7f"}},[e._v(" 生成配置 ")]),a("div",{staticClass:"line-border"},[a("a-form-model-item",{attrs:{label:"模板分组",prop:"templatesGroupName","label-col":e.formItemLayout.labelCol,"wrapper-col":e.formItemLayout.wrapperCol}},[a("a-select",{attrs:{placeholder:"请选择模板分组"},on:{change:e.templatesGroupChange},model:{value:e.form.templatesGroupName,callback:function(t){e.$set(e.form,"templatesGroupName",t)},expression:"form.templatesGroupName"}},e._l(e.templatesGroupList,(function(t){return a("a-select-option",{key:t.id,attrs:{value:t.name?t.name:t.id+1,title:t.name}},[e._v(" "+e._s(t.name?t.name:t.id+1)+" ")])})),1)],1),a("a-form-model-item",{attrs:{label:"选择模板",prop:"templateIds","label-col":e.formItemLayout.labelCol,"wrapper-col":e.formItemLayout.wrapperCol}},e._l(e.form.templatesList,(function(t){return a("label",{key:t.name,attrs:{value:t.name}},[a("div",{staticStyle:{float:"left","margin-right":"25px"}},[a("input",{directives:[{name:"model",rawName:"v-model",value:e.form.templateIds,expression:"form.templateIds"}],attrs:{type:"checkbox"},domProps:{value:t.id,checked:Array.isArray(e.form.templateIds)?e._i(e.form.templateIds,t.id)>-1:e.form.templateIds},on:{change:function(a){var o=e.form.templateIds,r=a.target,s=!!r.checked;if(Array.isArray(o)){var l=t.id,i=e._i(o,l);r.checked?i<0&&e.$set(e.form,"templateIds",o.concat([l])):i>-1&&e.$set(e.form,"templateIds",o.slice(0,i).concat(o.slice(i+1)))}else e.$set(e.form,"templateIds",s)}}}),e._v(" "+e._s(t.name)+" ")])])})),0)],1),a("span",{staticStyle:{"font-size":"15px","font-weight":"1000",color:"#827f7f"}},[e._v(" 本地配置 ")]),a("div",{staticClass:"line-border"},[a("a-form-model-item",{attrs:{label:"脚本内容",prop:"dirLocation","label-col":e.formItemLayout.labelCol,"wrapper-col":e.formItemLayout.wrapperCol}},[a("a-textarea",{staticStyle:{"background-color":"black",color:"wheat",width:"100%",height:"140px"},attrs:{name:"dirLocation",placeholder:"请输入解压源码包之后,把源码copy进项目结构的脚本",autocomplete:"off"},model:{value:e.form.dirLocation,callback:function(t){e.$set(e.form,"dirLocation",t)},expression:"form.dirLocation"}}),a("span",{staticStyle:{color:"grey","font-size":"12px","line-height":"1px"}},[e._v("该脚本期望的逻辑实现为:解压源码包之后,执行该脚本将源码copy进正确的项目结构目录中. 脚本内容会生成bat脚本文件一并打包到最终的压缩包里.")])],1),a("a-form-model-item",{attrs:{label:"示例脚本","label-col":e.formItemLayout.labelCol,"wrapper-col":e.formItemLayout.wrapperCol}},[a("div",{staticStyle:{background:"white",padding:"5px"},attrs:{"wrapper-col":e.formItemLayout.wrapperCol}},[a("a-card",{staticStyle:{width:"100%"},attrs:{title:"",bordered:!1}},[a("p",[e._v("@echo off")]),a("p",[e._v('echo "starting copy resource code ..."')]),a("p",[e._v("xcopy *.* C:\\Users\\elvin\\Desktop\\11\\buukle-generator\\ /s /e /c /y /h /r")]),a("p",[e._v('echo "resource code copy finished !"')]),a("p",[e._v("pause")])])],1)])],1),a("span",{staticStyle:{"font-size":"15px","font-weight":"1000",color:"#827f7f"}},[e._v(" 其他配置 ")]),a("div",{staticClass:"line-border"},[a("a-form-model-item",{attrs:{label:"备注",prop:"remark","label-col":e.formItemLayout.labelCol,"wrapper-col":e.formItemLayout.wrapperCol}},[a("a-textarea",{staticStyle:{width:"100%",height:"140px"},attrs:{name:"remark",placeholder:"remark",autocomplete:"off"},model:{value:e.form.remark,callback:function(t){e.$set(e.form,"remark",t)},expression:"form.remark"}})],1)],1)],1)],1),a("template",{slot:"footer"},[a("a-button",{attrs:{type:"primary"},on:{click:function(t){return e.handleEdit()}}},[e._v(" 提交 ")]),a("a-button",{on:{click:function(t){return e.handleClose()}}},[e._v(" 取消 ")])],1)],2)},r=[],s=(a("a15b"),a("2410")),l=a.n(s),i=a("b775"),m=a("f64c"),n={labelCol:{span:3},wrapperCol:{span:21}},c={components:{},props:{initvalue:{type:Object,default:null}},watch:{initvalue:function(){if(this.initvalue)for(var e in this.initvalue)this.form[e]=this.initvalue[e];else this.form=l()(this.initForm)},visible:function(e,t){if(!e)try{this.form=l()(this.initForm)}catch(a){}}},methods:{templatesGroupChange:function(e,t){var a=this,o=this.commonRequest;this.form.templatesGroupId=t.data.key,this.bodyByGroupId.templatesGroupId=t.data.key,o.body=this.bodyByGroupId,Object(i["b"])({url:"/templates/getTemplatesByGroupId",method:"post",dataType:"json",data:o}).then((function(e){"S"===e.head.status?(a.form.templatesList=e.body,a.form.templateIds=[]):(a.form.templatesList={},a.form.templateIds=[],m["a"].error(e.head.msg))})).catch((function(e){console.log(e)}))},getTemplatesGroupList:function(){var e=this,t=this.commonRequest;Object(i["b"])({url:"/templatesGroup/getTemplatesGroupList",method:"post",dataType:"json",data:t}).then((function(t){"S"===t.head.status?e.templatesGroupList=t.body:m["a"].error(t.head.msg)})).catch((function(e){console.log(e)}))},datasourcesChange:function(e,t){var a=this,o=this.commonRequest;this.form.datasourcesId=t.data.key,this.bodyById.id=t.data.key,o.body=this.bodyById,Object(i["b"])({url:"/datasources/getTablesListById",method:"post",dataType:"json",data:o}).then((function(e){"S"===e.head.status?(a.form.tableList=e.body,a.form.tables=[]):(a.form.tableList={},a.form.tables=[],m["a"].error(e.head.msg))})).catch((function(e){console.log(e)}))},getDatasourcesList:function(){var e=this,t=this.commonRequest;Object(i["b"])({url:"/datasources/getDatasourcesForConfigure",method:"post",dataType:"json",data:t}).then((function(t){"S"===t.head.status?e.datasourcesList=t.body:m["a"].error(t.head.msg)})).catch((function(e){console.log(e)}))},getTitle:function(e){var t=this.$createElement;return t("span",e?[" 编辑 "]:[" 新建 "])},show:function(){this.visible=!0,this.getDatasourcesList(),this.getTemplatesGroupList()},handleClose:function(){this.form=l()(this.initForm),this.form.param="",this.visible=!1},handleEdit:function(){var e=this;this.$refs.form.validate((function(t){if(t){var a=JSON.parse(JSON.stringify(e.form));a.tables=a.tables.join(","),a.templateIds=a.templateIds.join(","),e.commonRequest.head.operationTime=Date.now(),e.commonRequest.body=a;var o=e.commonRequest;Object(i["b"])({url:"/configures/addOrEdit",method:"post",dataType:"json",data:o}).then((function(t){"S"===t.head.status?(m["a"].success(t.head.msg),e.handleClose(),e.$emit("refresh")):m["a"].error(t.head.msg)})).catch((function(e){console.log(e)}))}}))}},data:function(){return{visible:!1,formLayout:"horizontal",formItemLayout:n,datasourcesList:[],templatesGroupList:[],form:{id:null,name:"",datasourcesId:"",datasourcesName:"",tables:[],templateIds:[],tableList:{},templatesGroupId:"",templatesGroupName:"",templatesList:{},basePackage:"",dirLocation:"",bak01:"",remark:""},initForm:{id:null,name:"",datasourcesId:"",datasourcesName:"",tables:[],templatesGroupId:"",templatesGroupName:"",templateIds:[],tableList:{},templatesList:{},basePackage:"",dirLocation:"",bak01:"",remark:""},rules:{name:[{required:!0,message:"请输入"},{max:50,message:"最多输入50个字符"},{pattern:/^(?!(\s+$))/,message:"输入格式错误"}],datasourcesName:[{required:!0,message:"请选择"}],templatesGroupName:[{required:!0,message:"请选择"}],tables:[{required:!0,message:"请选择表名(选择前请先选择正确的连接)"}],templateIds:[{required:!0,message:"请选择模板(选择前请先选择正确的模板分组)"}],dirLocation:[{required:!0,message:"请输入脚本"}]},commonRequest:{head:{operationTime:Date.now()},body:{}},bodyById:{id:0},bodyByGroupId:{templatesGroupId:0}}}},p=c,d=(a("f5ab"),a("2877")),u=Object(d["a"])(p,o,r,!1,null,null,null);t["default"]=u.exports},dc1c:function(e,t,a){},f5ab:function(e,t,a){"use strict";a("dc1c")}}]);